// File: src/test/java/org/apache/commons/lang3/concurrent/ConcurrentUtilsTest.java

package org.apache.commons.lang3.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConcurrentUtilsCopilotTest {

    @Test
    void testCheckedException() {
        Throwable throwable = new Exception("Checked Exception");
        assertEquals(throwable, ConcurrentUtils.checkedException(throwable));
    }

    @Test
    void testCheckedExceptionWithUnchecked() {
        Throwable throwable = new RuntimeException("Unchecked Exception");
        assertThrows(IllegalArgumentException.class, () -> ConcurrentUtils.checkedException(throwable));
    }

    @Test
    void testConstantFuture() throws Exception {
        String value = "test";
        Future<String> future = ConcurrentUtils.constantFuture(value);
        assertEquals(value, future.get());
        assertTrue(future.isDone());
        assertFalse(future.isCancelled());
    }

    @Test
    void testCreateIfAbsentWhenMapIsNull() throws ConcurrentException {
        ConcurrentMap<Object, Object> map = null;
        Object key = new Object();
        ConcurrentInitializer<Object> initializer = mock(ConcurrentInitializer.class);
        assertNull(ConcurrentUtils.createIfAbsent(map, key, initializer));
    }

    @Test
    void testCreateIfAbsentWhenInitIsNull() throws ConcurrentException {
        ConcurrentMap<Object, Object> map = new ConcurrentHashMap<>();
        Object key = new Object();
        ConcurrentInitializer<Object> initializer = null;
        assertNull(ConcurrentUtils.createIfAbsent(map, key, initializer));
    }

    @Test
    void testCreateIfAbsentWhenValueIsNull() throws ConcurrentException {
        ConcurrentMap<Object, Object> map = new ConcurrentHashMap<>();
        Object key = new Object();
        ConcurrentInitializer<Object> initializer = mock(ConcurrentInitializer.class);
        when(initializer.get()).thenReturn(null);
        assertNull(ConcurrentUtils.createIfAbsent(map, key, initializer));
    }

    @Test
    void testCreateIfAbsentWhenValueIsNotNull() throws ConcurrentException {
        ConcurrentMap<Object, Object> map = new ConcurrentHashMap<>();
        Object key = new Object();
        Object value = new Object();
        ConcurrentInitializer<Object> initializer = mock(ConcurrentInitializer.class);
        when(initializer.get()).thenReturn(value);
        assertEquals(value, ConcurrentUtils.createIfAbsent(map, key, initializer));
    }

    @Test
    void testCreateIfAbsentUnchecked() throws ConcurrentException {
        ConcurrentMap<Object, Object> map = new ConcurrentHashMap<>();
        Object key = new Object();
        Object value = new Object();
        ConcurrentInitializer<Object> initializer = mock(ConcurrentInitializer.class);
        when(initializer.get()).thenReturn(value);
        assertEquals(value, ConcurrentUtils.createIfAbsentUnchecked(map, key, initializer));
    }

    @Test
    void testExtractCauseWhenExGetCauseIsNull() {
        ExecutionException executionException = new ExecutionException((Throwable) null);
        assertNull(ConcurrentUtils.extractCause(executionException));
    }

    @Test
    void testExtractCauseWhenExGetCauseIsNotNull() {
        Throwable throwable = new Throwable();
        ExecutionException executionException = new ExecutionException("message", throwable);
        ConcurrentException result = ConcurrentUtils.extractCause(executionException);
        assertNotNull(result);
        assertEquals(throwable, result.getCause());
    }

    @Test
    void testExtractCauseUncheckedWhenExGetCauseIsNull() {
        ExecutionException executionException = new ExecutionException((Throwable) null);
        assertNull(ConcurrentUtils.extractCauseUnchecked(executionException));
    }

    @Test
    void testExtractCauseUncheckedWhenExGetCauseIsNotNull() {
        Throwable throwable = new Throwable();
        ExecutionException executionException = new ExecutionException("message", throwable);
        ConcurrentRuntimeException result = ConcurrentUtils.extractCauseUnchecked(executionException);
        assertNotNull(result);
        assertEquals(throwable, result.getCause());
    }

    @Test
    void testHandleCauseWhenCauseIsNotNull() {
        Throwable throwable = new Throwable();
        ExecutionException executionException = new ExecutionException(throwable);
        ConcurrentException concurrentException = assertThrows(ConcurrentException.class, () -> ConcurrentUtils.handleCause(executionException));
        assertEquals(throwable, concurrentException.getCause());
    }

    @Test
    void testHandleCauseWhenCauseIsNull() throws ConcurrentException {
        ExecutionException executionException = new ExecutionException((Throwable) null);
        ConcurrentUtils.handleCause(executionException);
    }

    @Test
    void testHandleCauseUncheckedWhenCauseIsNotNull() {
        Throwable throwable = new Throwable();
        ExecutionException executionException = new ExecutionException(throwable);
        ConcurrentRuntimeException concurrentRuntimeException = assertThrows(ConcurrentRuntimeException.class, () -> ConcurrentUtils.handleCauseUnchecked(executionException));
        assertEquals(throwable, concurrentRuntimeException.getCause());
    }

    @Test
    void testHandleCauseUncheckedWhenCauseIsNull() {
        ExecutionException executionException = new ExecutionException((Throwable) null);
        ConcurrentUtils.handleCauseUnchecked(executionException);
    }

    @Test
    void testInitializeWhenInitializerIsNotNull() throws ConcurrentException {
        ConcurrentInitializer<Object> initializer = mock(ConcurrentInitializer.class);
        Object value = new Object();
        when(initializer.get()).thenReturn(value);
        assertEquals(value, ConcurrentUtils.initialize(initializer));
    }

    @Test
    void testInitializeWhenInitializerIsNull() throws ConcurrentException {
        ConcurrentInitializer<Object> initializer = null;
        assertNull(ConcurrentUtils.initialize(initializer));
    }

    @Test
    void testInitializeUnchecked() throws ConcurrentException {
        ConcurrentInitializer<Object> initializer = mock(ConcurrentInitializer.class);
        Object value = new Object();
        when(initializer.get()).thenReturn(value);
        assertEquals(value, ConcurrentUtils.initializeUnchecked(initializer));
    }

    @Test
    void testPutIfAbsentWhenMapIsNull() {
        ConcurrentMap<Object, Object> map = null;
        Object key = new Object();
        Object value = new Object();
        assertNull(ConcurrentUtils.putIfAbsent(map, key, value));
    }

    @Test
    void testPutIfAbsentWhenResultIsNull() {
        ConcurrentMap<Object, Object> map = new ConcurrentHashMap<>();
        Object key = new Object();
        Object value = new Object();
        assertEquals(value, ConcurrentUtils.putIfAbsent(map, key, value));
    }

    @Test
    void testPutIfAbsentWhenResultIsNotNull() {
        ConcurrentMap<Object, Object> map = new ConcurrentHashMap<>();
        Object key = new Object();
        Object value = new Object();
        map.put(key, value);
        assertEquals(value, ConcurrentUtils.putIfAbsent(map, key, new Object()));
    }
}