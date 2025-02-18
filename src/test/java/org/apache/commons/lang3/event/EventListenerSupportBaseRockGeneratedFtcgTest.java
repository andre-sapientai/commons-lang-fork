package org.apache.commons.lang3.event;

import java.io.ObjectOutputStream;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Method;

import static org.mockito.Mockito.*;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import java.util.EventListener;
import org.junit.jupiter.params.ParameterizedTest;
import org.apache.commons.lang3.ArrayUtils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ObjectInputStream;
import java.io.ByteArrayOutputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.junit.jupiter.api.Disabled;

class EventListenerSupportBaseRockGeneratedFtcgTest {

    private EventListenerSupport<EventListener> eventListenerSupport;

    private EventListener mockListener;

    @BeforeEach
    void setUp() {
        eventListenerSupport = EventListenerSupport.create(EventListener.class);
        mockListener = mock(EventListener.class);
    }

    //BaseRock generated method id: ${testCreateWithValidInterface}, hash: 1E533E6148D660E417C9878D0A115178
    @Test
    void testCreateWithValidInterface() {
        assertNotNull(eventListenerSupport);
    }

    //BaseRock generated method id: ${testCreateWithNullInterface}, hash: BF12080810C8D92B737ABC31452FA032
    @Test
    void testCreateWithNullInterface() {
        assertThrows(NullPointerException.class, () -> EventListenerSupport.create(null));
    }

    //BaseRock generated method id: ${testCreateWithNonInterface}, hash: 7EFD4601D62B907DE342F4F7DDF53EF2
    @ParameterizedTest
    @ValueSource(classes = { String.class, Integer.class, Object.class })
    void testCreateWithNonInterface(Class<?> clazz) {
        assertThrows(IllegalArgumentException.class, () -> EventListenerSupport.create(clazz));
    }

    //BaseRock generated method id: ${testAddListener}, hash: 72AAE11F197B3F926057FD0957713204
    @Test
    void testAddListener() {
        eventListenerSupport.addListener(mockListener);
        assertEquals(1, eventListenerSupport.getListenerCount());
    }

    //BaseRock generated method id: ${testAddListenerWithDuplicate}, hash: 2F6DC17082C5CFD6FBDDA988B65B33D2
    @Test
    void testAddListenerWithDuplicate() {
        eventListenerSupport.addListener(mockListener);
        eventListenerSupport.addListener(mockListener);
        assertEquals(1, eventListenerSupport.getListenerCount());
    }

    //BaseRock generated method id: ${testAddListenerAllowingDuplicate}, hash: C0CCCD56B73F1A7D0F04DE7BD6E040E8
    @Test
    void testAddListenerAllowingDuplicate() {
        eventListenerSupport.addListener(mockListener, true);
        eventListenerSupport.addListener(mockListener, true);
        assertEquals(2, eventListenerSupport.getListenerCount());
    }

    //BaseRock generated method id: ${testAddNullListener}, hash: F4A07F91BADA000A4A1664BE0C429FB2
    @Test
    void testAddNullListener() {
        assertThrows(NullPointerException.class, () -> eventListenerSupport.addListener(null));
    }

    //BaseRock generated method id: ${testRemoveListener}, hash: 0ADF72BF7ADE751C6CE44A67382923D6
    @Test
    void testRemoveListener() {
        eventListenerSupport.addListener(mockListener);
        eventListenerSupport.removeListener(mockListener);
        assertEquals(0, eventListenerSupport.getListenerCount());
    }

    //BaseRock generated method id: ${testRemoveNonExistentListener}, hash: 01D9165FEECAE18FA04AB07EDC8A9DC9
    @Test
    void testRemoveNonExistentListener() {
        eventListenerSupport.removeListener(mockListener);
        assertEquals(0, eventListenerSupport.getListenerCount());
    }

    //BaseRock generated method id: ${testRemoveNullListener}, hash: 3EBECE1C8E411981D3E7E2C2A138EAEF
    @Test
    void testRemoveNullListener() {
        assertThrows(NullPointerException.class, () -> eventListenerSupport.removeListener(null));
    }

    //BaseRock generated method id: ${testGetListeners}, hash: 991C77C2C5D704BBABB2152A58199E03
    @Test
    void testGetListeners() {
        eventListenerSupport.addListener(mockListener);
        EventListener[] listeners = eventListenerSupport.getListeners();
        assertEquals(1, listeners.length);
        assertSame(mockListener, listeners[0]);
    }

    //BaseRock generated method id: ${testFire}, hash: 7C1D1CF04CD227F3EACF3E3A80AAA12C
    @Test
    void testFire() throws Exception {
        EventListener proxy = eventListenerSupport.fire();
        assertNotNull(proxy);
        assertTrue(java.lang.reflect.Proxy.isProxyClass(proxy.getClass()));
    }

    //BaseRock generated method id: ${testProxyInvocationHandler}, hash: ADFEB07EA0225277A0AB0E9C59427341
    @Test
    void testProxyInvocationHandler() throws Exception {
        eventListenerSupport.addListener(mockListener);
        EventListener proxy = eventListenerSupport.fire();
        Method testMethod = EventListener.class.getDeclaredMethods()[0];
        proxy.getClass().getMethod(testMethod.getName()).invoke(proxy);
        verify(mockListener, times(1)).getClass().getMethod(testMethod.getName()).invoke(mockListener);
    }

    //BaseRock generated method id: ${testSerializationDeserialization}, hash: BCE4D31F1D7DD5717158B631F6E0F72F
    @Test
    void testSerializationDeserialization() throws IOException, ClassNotFoundException {
        eventListenerSupport.addListener(mockListener);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(eventListenerSupport);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            EventListenerSupport<EventListener> deserializedSupport = (EventListenerSupport<EventListener>) ois.readObject();
            assertEquals(eventListenerSupport.getListenerCount(), deserializedSupport.getListenerCount());
        }
    }

    //BaseRock generated method id: ${testProxyInvocationHandlerWithExceptionHandling}, hash: 1A2E243E5ED1C9BF18BC80AC28F367CA
    @Test
    void testProxyInvocationHandlerWithExceptionHandling() throws Exception {
        EventListener exceptionThrowingListener = mock(EventListener.class);
        doThrow(new RuntimeException("Test exception")).when(exceptionThrowingListener).getClass().getMethod("toString").invoke(exceptionThrowingListener);
        eventListenerSupport.addListener(exceptionThrowingListener);
        EventListener proxy = eventListenerSupport.fire();
        assertDoesNotThrow(() -> proxy.toString());
    }

    //BaseRock generated method id: ${testInitializeTransientFields}, hash: C5D2E5BB62D6BEF8B06F66E5226809A6
    @Test
    void testInitializeTransientFields() throws Exception {
        EventListenerSupport<EventListener> support = new EventListenerSupport<>(EventListener.class);
        assertNotNull(support.fire());
        assertEquals(0, support.getListeners().length);
    }

    //BaseRock generated method id: ${testArrayUtilsUsage}, hash: B934842F6728227AB9A63A36626B9D4F
    @Test
    void testArrayUtilsUsage() {
        EventListener[] emptyArray = eventListenerSupport.getListeners();
        assertTrue(ArrayUtils.isEmpty(emptyArray));
    }
}
