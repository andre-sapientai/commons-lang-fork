package org.apache.commons.lang3.event;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventListenerSupportCursorTest {

    private EventListenerSupport<TestListener> listeners;
    private TestListener testListener;
    private List<String> receivedEvents;

    // Test interface
    interface TestListener {
        void onEvent(String data);
    }

    @BeforeEach
    public void setUp() {
        listeners = EventListenerSupport.create(TestListener.class);
        receivedEvents = new ArrayList<>();
        testListener = data -> receivedEvents.add(data);
    }

    @Test
    public void testAddAndRemoveListener() {
        listeners.addListener(testListener);
        assertEquals(1, listeners.getListenerCount());

        listeners.removeListener(testListener);
        assertEquals(0, listeners.getListenerCount());
    }

    @Test
    public void testAddDuplicateListener() {
        listeners.addListener(testListener);
        listeners.addListener(testListener);
        assertEquals(1, listeners.getListenerCount(), "Duplicate listener should not be added by default");

        listeners.addListener(testListener, true);
        assertEquals(2, listeners.getListenerCount(), "Duplicate listener should be added when explicitly allowed");
    }

    @Test
    public void testFireEvent() {
        List<String> receivedEvents = new ArrayList<>();
        TestListener listener = data -> receivedEvents.add(data);

        listeners.addListener(listener);
        listeners.fire().onEvent("test event");

        assertEquals(1, receivedEvents.size());
        assertEquals("test event", receivedEvents.get(0));
    }

    @Test
    public void testMultipleListeners() {
        List<String> events1 = new ArrayList<>();
        List<String> events2 = new ArrayList<>();

        TestListener listener1 = data -> events1.add(data);
        TestListener listener2 = data -> events2.add(data);

        listeners.addListener(listener1);
        listeners.addListener(listener2);

        listeners.fire().onEvent("test event");

        assertEquals(1, events1.size());
        assertEquals(1, events2.size());
        assertEquals("test event", events1.get(0));
        assertEquals("test event", events2.get(0));
    }

    @Test
    public void testNullListener() {
        assertThrows(NullPointerException.class, () -> listeners.addListener(null));
        assertThrows(NullPointerException.class, () -> listeners.removeListener(null));
    }

    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        // Create a serializable listener
        TestListener serializableListener = new SerializableTestListener();

        listeners.addListener(serializableListener);

        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(listeners);
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            @SuppressWarnings("unchecked")
            EventListenerSupport<TestListener> deserializedListeners =
                    (EventListenerSupport<TestListener>) ois.readObject();

            assertEquals(1, deserializedListeners.getListenerCount());
        }
    }

    @Test
    public void testNonSerializableListenerDropped() throws IOException, ClassNotFoundException {
        // Add both serializable and non-serializable listeners
        TestListener serializableListener = new SerializableTestListener();

        listeners.addListener(serializableListener);
        listeners.addListener(data -> {}); // Non-serializable lambda

        assertEquals(2, listeners.getListenerCount());

        // Serialize and deserialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(listeners);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            @SuppressWarnings("unchecked")
            EventListenerSupport<TestListener> deserializedListeners =
                    (EventListenerSupport<TestListener>) ois.readObject();

            assertEquals(1, deserializedListeners.getListenerCount(),
                    "Non-serializable listener should be dropped");
        }
    }

    // Separate class for serializable listener
    private static class SerializableTestListener implements TestListener, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public void onEvent(String data) {
            // Do nothing
        }
    }
}