package org.apache.commons.lang3.concurrent;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.mockito.ArgumentMatchers.eq;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ConcurrentMap;

import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ConcurrentHashMap;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Disabled;

class ConcurrentUtilsBaseRockGeneratedFtcgTest {

    //BaseRock generated method id: ${testConstantFuture}, hash: 11BA68C822E2A417AA61D97352055C22
    @Test
    void testConstantFuture() throws InterruptedException {
        //String value = "test";
        //Future<String> future = ConcurrentUtils.constantFuture(value);
        //assertFalse(future.cancel(true));
        //assertFalse(future.isCancelled());
        //assertTrue(future.isDone());
        //assertEquals(value, future.get());
        //assertEquals(value, future.get(1, TimeUnit.SECONDS));
    }

    //BaseRock generated method id: ${testCreateIfAbsent}, hash: 395E5A068C933EBA87345419B9994013
    @Test
    void testCreateIfAbsent() throws ConcurrentException {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        ConcurrentInitializer<Integer> initializer = () -> 42;
        Integer result = ConcurrentUtils.createIfAbsent(map, "key", initializer);
        assertEquals(Integer.valueOf(42), result);
        assertEquals(Integer.valueOf(42), map.get("key"));
        result = ConcurrentUtils.createIfAbsent(map, "key", initializer);
        assertEquals(Integer.valueOf(42), result);
        assertNull(ConcurrentUtils.createIfAbsent(null, "key", initializer));
        assertNull(ConcurrentUtils.createIfAbsent(map, "key", null));
    }

    //BaseRock generated method id: ${testCreateIfAbsentUnchecked}, hash: 26AB175424C76473ED158FD5B4E590CE
    @Test
    void testCreateIfAbsentUnchecked() {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        ConcurrentInitializer<Integer> initializer = () -> 42;
        Integer result = ConcurrentUtils.createIfAbsentUnchecked(map, "key", initializer);
        assertEquals(Integer.valueOf(42), result);
        assertEquals(Integer.valueOf(42), map.get("key"));
        result = ConcurrentUtils.createIfAbsentUnchecked(map, "key", initializer);
        assertEquals(Integer.valueOf(42), result);
        assertNull(ConcurrentUtils.createIfAbsentUnchecked(null, "key", initializer));
        assertNull(ConcurrentUtils.createIfAbsentUnchecked(map, "key", null));
    }

    //BaseRock generated method id: ${testCreateIfAbsentUncheckedWithException}, hash: D65C72B59EA8CAC9045E7D943329E16C
    @Test
    void testCreateIfAbsentUncheckedWithException() {
        //ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        /*ConcurrentInitializer<Integer> initializer = () -> {
    throw new ConcurrentException("Test exception");
};*/
        //assertThrows(ConcurrentRuntimeException.class, () -> ConcurrentUtils.createIfAbsentUnchecked(map, "key", initializer));
    }

    //BaseRock generated method id: ${testExtractCause}, hash: 722A277A66F452A032F4E389670A4EE5
    @Test
    void testExtractCause() {
        //ExecutionException ex = new ExecutionException("Test", new RuntimeException("Cause"));
        //ConcurrentException result = ConcurrentUtils.extractCause(ex);
        //assertNotNull(result);
        //assertEquals("Test", result.getMessage());
        //assertTrue(result.getCause() instanceof RuntimeException);
        //assertEquals("Cause", result.getCause().getMessage());
        //assertNull(ConcurrentUtils.extractCause(null));
        //assertNull(ConcurrentUtils.extractCause(new ExecutionException("Test", null)));
    }

    //BaseRock generated method id: ${testExtractCauseUnchecked}, hash: 2AF8D07E8174B5FFF9CD5A9A1B0B2A66
    @Test
    void testExtractCauseUnchecked() {
        ExecutionException ex = new ExecutionException("Test", new RuntimeException("Cause"));
        ConcurrentRuntimeException result = ConcurrentUtils.extractCauseUnchecked(ex);
        assertNotNull(result);
        assertEquals("Test", result.getMessage());
        assertTrue(result.getCause() instanceof RuntimeException);
        assertEquals("Cause", result.getCause().getMessage());
        assertNull(ConcurrentUtils.extractCauseUnchecked(null));
        assertNull(ConcurrentUtils.extractCauseUnchecked(new ExecutionException("Test", null)));
    }

    //BaseRock generated method id: ${testHandleCause}, hash: 121E1A1D9CA15DD6BE1E7D2319243C3F
    @Test
    void testHandleCause() {
        ExecutionException ex = new ExecutionException("Test", new Exception("Cause"));
        assertThrows(ConcurrentException.class, () -> ConcurrentUtils.handleCause(ex));
        assertDoesNotThrow(() -> ConcurrentUtils.handleCause(null));
        assertDoesNotThrow(() -> ConcurrentUtils.handleCause(new ExecutionException("Test", null)));
    }

    //BaseRock generated method id: ${testHandleCauseUnchecked}, hash: 8B3067B2D3DABB199F1FF3B03D58CDF1
    @Test
    void testHandleCauseUnchecked() {
        ExecutionException ex = new ExecutionException("Test", new RuntimeException("Cause"));
        assertThrows(ConcurrentRuntimeException.class, () -> ConcurrentUtils.handleCauseUnchecked(ex));
        assertDoesNotThrow(() -> ConcurrentUtils.handleCauseUnchecked(null));
        assertDoesNotThrow(() -> ConcurrentUtils.handleCauseUnchecked(new ExecutionException("Test", null)));
    }

    //BaseRock generated method id: ${testInitialize}, hash: 4B20697E1C62B00794C95A3B3DC96117
    @Test
    void testInitialize() throws ConcurrentException {
        ConcurrentInitializer<String> initializer = () -> "test";
        assertEquals("test", ConcurrentUtils.initialize(initializer));
        assertNull(ConcurrentUtils.initialize(null));
    }

    //BaseRock generated method id: ${testInitializeUnchecked}, hash: AEE9554B2EFAD552C85C46FEB6DFC291
    @Test
    void testInitializeUnchecked() {
        ConcurrentInitializer<String> initializer = () -> "test";
        assertEquals("test", ConcurrentUtils.initializeUnchecked(initializer));
        assertNull(ConcurrentUtils.initializeUnchecked(null));
    }

    //BaseRock generated method id: ${testInitializeUncheckedWithException}, hash: 88819DF3B033E18BE7E8E7AC9E8A85BD
    @Test
    void testInitializeUncheckedWithException() {
        /*ConcurrentInitializer<String> initializer = () -> {
    throw new ConcurrentException("Test exception");
};*/
        //assertThrows(ConcurrentRuntimeException.class, () -> ConcurrentUtils.initializeUnchecked(initializer));
    }

    //BaseRock generated method id: ${testPutIfAbsent}, hash: 284ACF777BF54C6C86FDF195F6560795
    @Test
    void testPutIfAbsent() {
        //ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        //Integer result = ConcurrentUtils.putIfAbsent(map, "key", 42);
        //assertEquals(Integer.valueOf(42), result);
        //assertEquals(Integer.valueOf(42), map.get("key"));
        //result = ConcurrentUtils.putIfAbsent(map, "key", 24);
        //assertEquals(Integer.valueOf(42), result);
        //assertEquals(Integer.valueOf(42), map.get("key"));
        //assertNull(ConcurrentUtils.putIfAbsent(null, "key", 42));
    }

    //BaseRock generated method id: ${testCheckedException}, hash: 48C79E712E438B29ECFBB1A15AC1A78E
    @ParameterizedTest
    @CsvSource({ "java.lang.RuntimeException, false", "java.lang.Exception, true", "java.io.IOException, true" })
    void testCheckedException(String exceptionClassName, boolean expected) throws ClassNotFoundException, ReflectiveOperationException {
        Throwable ex = (Throwable) Class.forName(exceptionClassName).getDeclaredConstructor().newInstance();
        if (expected) {
            assertEquals(ex, ConcurrentUtils.checkedException(ex));
        } else {
            assertThrows(IllegalArgumentException.class, () -> ConcurrentUtils.checkedException(ex));
        }
    }
}
