// File: src/test/java/org/apache/commons/lang3/event/EventListenerSupportTest.java

package org.apache.commons.lang3.event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.lang.reflect.InvocationHandler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventListenerSupportCopilotTest {

    private EventListenerSupport<TestListener> eventListenerSupport;
    private TestListener mockListener;

    @BeforeEach
    void setUp() {
        eventListenerSupport = EventListenerSupport.create(TestListener.class);
        mockListener = mock(TestListener.class);
    }

    @Test
    void testCreate() {
        assertNotNull(eventListenerSupport);
        assertEquals(0, eventListenerSupport.getListenerCount());
    }

    @Test
    void testAddListener() {
        eventListenerSupport.addListener(mockListener);
        assertEquals(1, eventListenerSupport.getListenerCount());
    }

    @Test
    void testAddListenerWithDuplicates() {
        eventListenerSupport.addListener(mockListener);
        eventListenerSupport.addListener(mockListener, true);
        assertEquals(2, eventListenerSupport.getListenerCount());
        eventListenerSupport.addListener(mockListener, false);
        assertEquals(2, eventListenerSupport.getListenerCount());
    }

    @Test
    void testRemoveListener() {
        eventListenerSupport.addListener(mockListener);
        assertEquals(1, eventListenerSupport.getListenerCount());
        eventListenerSupport.removeListener(mockListener);
        assertEquals(0, eventListenerSupport.getListenerCount());
    }

    @Test
    void testGetListeners() {
        eventListenerSupport.addListener(mockListener);
        TestListener[] listeners = eventListenerSupport.getListeners();
        assertEquals(1, listeners.length);
        assertSame(mockListener, listeners[0]);
    }

    @Test
    void testFire() {
        eventListenerSupport.addListener(mockListener);
        TestListener proxy = eventListenerSupport.fire();
        proxy.onEvent("test");
        verify(mockListener).onEvent("test");
    }

    @Test
    void testFireWithMultipleListeners() {
        TestListener mockListener2 = mock(TestListener.class);
        eventListenerSupport.addListener(mockListener);
        eventListenerSupport.addListener(mockListener2);
        TestListener proxy = eventListenerSupport.fire();
        proxy.onEvent("test");
        verify(mockListener).onEvent("test");
        verify(mockListener2).onEvent("test");
    }

    @Disabled
    @Test
    void testFireWithExceptionHandling() throws Exception {
        TestListener exceptionThrowingListener = mock(TestListener.class);
        doThrow(new RuntimeException("Test exception")).when(exceptionThrowingListener).onEvent(anyString());
        eventListenerSupport.addListener(exceptionThrowingListener);
        eventListenerSupport.addListener(mockListener);
        TestListener proxy = eventListenerSupport.fire();
        assertDoesNotThrow(() -> proxy.onEvent("test"));
        verify(exceptionThrowingListener).onEvent("test");
        verify(mockListener).onEvent("test");
    }

    @Test
    void testSerializationDeserialization() throws IOException, ClassNotFoundException {
        eventListenerSupport.addListener(new SerializableTestListener());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(eventListenerSupport);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            EventListenerSupport<TestListener> deserializedSupport = (EventListenerSupport<TestListener>) ois.readObject();
            assertEquals(1, deserializedSupport.getListenerCount());
            assertTrue(deserializedSupport.getListeners()[0] instanceof SerializableTestListener);
        }
    }

    @ParameterizedTest
    @ValueSource(classes = { String.class, Integer.class, Object.class })
    void testCreateWithInvalidInterface(Class<?> invalidClass) {
        assertThrows(IllegalArgumentException.class, () -> EventListenerSupport.create(invalidClass));
    }

    @Disabled
    @Test
    void testCustomExceptionHandler() throws Exception {
       /* FailableConsumer<Throwable, IllegalAccessException> customHandler = mock(FailableConsumer.class);
        EventListenerSupport<TestListener> supportWithCustomHandler = new EventListenerSupport<TestListener>(TestListener.class) {
            @Override
            protected InvocationHandler createInvocationHandler() {
                return new ProxyInvocationHandler(customHandler);
            }
        };
        TestListener exceptionThrowingListener = mock(TestListener.class);
        RuntimeException testException = new RuntimeException("Test exception");
        doThrow(testException).when(exceptionThrowingListener).onEvent(anyString());
        supportWithCustomHandler.addListener(exceptionThrowingListener);
        supportWithCustomHandler.fire().onEvent("test");
        verify(customHandler).accept(testException);*/
    }

    private interface TestListener {
        void onEvent(String event);
    }

    private static class SerializableTestListener implements TestListener, Serializable {
        @Override
        public void onEvent(String event) {
            // Do nothing
        }
    }
}