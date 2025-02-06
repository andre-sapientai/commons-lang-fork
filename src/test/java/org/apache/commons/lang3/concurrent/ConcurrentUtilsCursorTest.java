package org.apache.commons.lang3.concurrent;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

class ConcurrentUtilsCursorTest {

    @Test
    void testConstantFuture() {
        String value = "test";
        Future<String> future = ConcurrentUtils.constantFuture(value);

        assertNotNull(future);
        assertFalse(future.isCancelled());
        assertTrue(future.isDone());
        try {
            assertEquals(value, future.get());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void testCreateIfAbsent() throws ConcurrentException {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        String key = "testKey";

        ConcurrentInitializer<Integer> initializer = () -> 42;

        Integer result = ConcurrentUtils.createIfAbsent(map, key, initializer);
        assertEquals(Integer.valueOf(42), result);
        assertEquals(Integer.valueOf(42), map.get(key));

        // Test with null map
        assertNull(ConcurrentUtils.createIfAbsent(null, key, initializer));

        // Test with null initializer
        assertNull(ConcurrentUtils.createIfAbsent(map, key, null));
    }

    @Test
    void testCreateIfAbsentUnchecked() {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        String key = "testKey";

        ConcurrentInitializer<Integer> initializer = () -> 42;

        Integer result = ConcurrentUtils.createIfAbsentUnchecked(map, key, initializer);
        assertEquals(Integer.valueOf(42), result);
        assertEquals(Integer.valueOf(42), map.get(key));
    }

    @Test
    void testExtractCause() {
        // Test with null
        assertNull(ConcurrentUtils.extractCause(null));

        // Test with ExecutionException having null cause
        ExecutionException ex = new ExecutionException("Test", null);
        assertNull(ConcurrentUtils.extractCause(ex));

        // Test with checked exception cause
        Exception cause = new Exception("Test cause");
        ex = new ExecutionException(cause);
        ConcurrentException extracted = ConcurrentUtils.extractCause(ex);
        assertNotNull(extracted);
        assertEquals(cause, extracted.getCause());
    }

    @Test
    void testInitialize() throws ConcurrentException {
        ConcurrentInitializer<String> initializer = () -> "test";
        assertEquals("test", ConcurrentUtils.initialize(initializer));

        // Test with null
        assertNull(ConcurrentUtils.initialize(null));
    }

    @Test
    void testInitializeUnchecked() {
        ConcurrentInitializer<String> initializer = () -> "test";
        assertEquals("test", ConcurrentUtils.initializeUnchecked(initializer));

        // Test with null
        assertNull(ConcurrentUtils.initializeUnchecked(null));
    }

    @Test
    void testPutIfAbsent() {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        String key = "testKey";
        Integer value = 42;

        Integer result = ConcurrentUtils.putIfAbsent(map, key, value);
        assertEquals(value, result);
        assertEquals(value, map.get(key));

        // Test with existing value
        Integer newValue = 43;
        result = ConcurrentUtils.putIfAbsent(map, key, newValue);
        assertEquals(value, result);  // Should return original value
        assertEquals(value, map.get(key));  // Map should retain original value

        // Test with null map
        assertNull(ConcurrentUtils.putIfAbsent(null, key, value));
    }

    @Test
    void testHandleCause() {
        // Test with null
        assertDoesNotThrow(() -> ConcurrentUtils.handleCause(null));

        // Test with ExecutionException having null cause
        ExecutionException ex = new ExecutionException("Test", null);
        ExecutionException finalEx = ex;
        assertDoesNotThrow(() -> ConcurrentUtils.handleCause(finalEx));

        // Test with checked exception cause
        Exception cause = new Exception("Test cause");
        ex = new ExecutionException(cause);
        ExecutionException finalEx1 = ex;
        assertThrows(ConcurrentException.class, () -> ConcurrentUtils.handleCause(finalEx1));
    }

    @Test
    void testHandleCauseUnchecked() {
        // Test with null
        assertDoesNotThrow(() -> ConcurrentUtils.handleCauseUnchecked(null));

        // Test with ExecutionException having null cause
        ExecutionException ex = new ExecutionException("Test", null);
        ExecutionException finalEx = ex;
        assertDoesNotThrow(() -> ConcurrentUtils.handleCauseUnchecked(finalEx));

        // Test with checked exception cause
        Exception cause = new Exception("Test cause");
        ex = new ExecutionException(cause);
        ExecutionException finalEx1 = ex;
        assertThrows(ConcurrentRuntimeException.class, () -> ConcurrentUtils.handleCauseUnchecked(finalEx1));
    }
}