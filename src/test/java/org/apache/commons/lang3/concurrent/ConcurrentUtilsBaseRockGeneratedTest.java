package org.apache.commons.lang3.concurrent;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ConcurrentHashMap;
import org.mockito.MockedStatic;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.atLeast;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.Mockito.mockStatic;
import org.junit.jupiter.api.Disabled;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class ConcurrentUtilsBaseRockGeneratedTest {

    //BaseRock generated method id: ${checkedExceptionTest}, hash: 2315D15DF3F1A532DBC07402A2644E7F
    @Test()
    void checkedExceptionTest() {
        //Arrange Statement(s)
        Throwable throwable = new Throwable();
        //Act Statement(s)
        Throwable result = ConcurrentUtils.checkedException(throwable);
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, equalTo(throwable)));
    }

    //BaseRock generated method id: ${constantFutureTest}, hash: FC0AF802B8B53F4C2B7781EFEB05A70B
    @Test()
    void constantFutureTest() {
        //Arrange Statement(s)
        Object object = new Object();
        //Act Statement(s)
        Future result = ConcurrentUtils.constantFuture(object);
        //Assert statement(s)
        //TODO: Please implement equals method in ConstantFuture for verification of the entire object or you need to adjust respective assertion statements
        assertAll("result", () -> assertThat(result, is(notNullValue())));
    }

    //BaseRock generated method id: ${createIfAbsentWhenInitIsNull}, hash: 3024AE6C5BB35CDEE3E0D39612B30768
    @Test()
    void createIfAbsentWhenInitIsNull() throws ConcurrentException {
        /* Branches:
         * (map == null) : false
         * (init == null) : true
         */
        //Arrange Statement(s)
        ConcurrentMap<Object, Object> objectObjectMap = new ConcurrentHashMap<>();
        Object object = new Object();
        ConcurrentInitializer<Object> concurrentInitializer = null;
        //Act Statement(s)
        Object result = ConcurrentUtils.createIfAbsent(objectObjectMap, object, concurrentInitializer);
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, is(nullValue())));
    }

    //BaseRock generated method id: ${createIfAbsentWhenValueIsNull}, hash: 2CA8E721ED4D77C145A8FDFD5B7BE324
    @Disabled()
    @Test()
    void createIfAbsentWhenValueIsNull() throws ConcurrentException {
        /* Branches:
         * (map == null) : false
         * (init == null) : false
         * (value == null) : true
         */
        //Arrange Statement(s)
        try (MockedStatic<ConcurrentUtils> concurrentUtils = mockStatic(ConcurrentUtils.class, CALLS_REAL_METHODS)) {
            Object object = new Object();
            Object object2 = new Object();
            concurrentUtils.when(() -> ConcurrentUtils.putIfAbsent((ConcurrentMap) any(), eq(object2), eq((Object) null))).thenReturn(object);
            ConcurrentMap<Object, Object> objectObjectMap = new ConcurrentHashMap<>();
            objectObjectMap.put(object2, (Object) null);
            AtomicInitializer<Object> atomicInitializer = new AtomicInitializer<>();
            //Act Statement(s)
            Object result = ConcurrentUtils.createIfAbsent(objectObjectMap, object2, atomicInitializer);
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, equalTo(object));
                concurrentUtils.verify(() -> ConcurrentUtils.putIfAbsent((ConcurrentMap) any(), eq(object2), eq((Object) null)), atLeast(1));
            });
        }
    }

    //BaseRock generated method id: ${createIfAbsentWhenValueIsNotNull}, hash: B6A10CE2803F39B6BD01C13696262963
    @Test()
    void createIfAbsentWhenValueIsNotNull() throws ConcurrentException {
        /* Branches:
         * (map == null) : false
         * (init == null) : false
         * (value == null) : false
         */
        //Arrange Statement(s)
        Object object = new Object();
        Object object2 = new Object();
        ConcurrentMap<Object, Object> objectObjectMap = new ConcurrentHashMap<>();
        objectObjectMap.put(object, object2);
        AtomicInitializer<Object> atomicInitializer = new AtomicInitializer<>();
        //Act Statement(s)
        Object result = ConcurrentUtils.createIfAbsent(objectObjectMap, object, atomicInitializer);
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, equalTo(object2)));
    }

    //BaseRock generated method id: ${createIfAbsentUncheckedTest}, hash: 9F3ECCC72A5A79C4EF934645E6BD6912
    @Test()
    void createIfAbsentUncheckedTest() {
        //Arrange Statement(s)
        try (MockedStatic<ConcurrentUtils> concurrentUtils = mockStatic(ConcurrentUtils.class, CALLS_REAL_METHODS)) {
            Object object = new Object();
            Object object2 = new Object();
            AtomicInitializer<Object> atomicInitializer = new AtomicInitializer<>();
            concurrentUtils.when(() -> ConcurrentUtils.createIfAbsent((ConcurrentMap) any(), eq(object2), eq(atomicInitializer))).thenReturn(object);
            ConcurrentMap<Object, Object> objectObjectMap = new ConcurrentHashMap<>();
            //Act Statement(s)
            Object result = ConcurrentUtils.createIfAbsentUnchecked(objectObjectMap, object2, atomicInitializer);
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, equalTo(object));
                concurrentUtils.verify(() -> ConcurrentUtils.createIfAbsent((ConcurrentMap) any(), eq(object2), eq(atomicInitializer)), atLeast(1));
            });
        }
    }

    //BaseRock generated method id: ${createIfAbsentUncheckedWhenCaughtConcurrentExceptionThrowsConcurrentRuntimeException}, hash: BCCBFE2E4AE25E5BE5226AA2CEC79E5A
    @Disabled()
    @Test()
    void createIfAbsentUncheckedWhenCaughtConcurrentExceptionThrowsConcurrentRuntimeException() {
        /* Branches:
         * (catch-exception (ConcurrentException)) : true
         *
         * TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
        //Arrange Statement(s)
        try (MockedStatic<ConcurrentUtils> concurrentUtils = mockStatic(ConcurrentUtils.class, CALLS_REAL_METHODS)) {
            Object object = new Object();
            Object object2 = new Object();
            AtomicInitializer<Object> atomicInitializer = new AtomicInitializer<>();
            concurrentUtils.when(() -> ConcurrentUtils.createIfAbsent((ConcurrentMap) any(), eq(object2), eq(atomicInitializer))).thenReturn(object);
            ConcurrentMap<Object, Object> objectObjectMap = new ConcurrentHashMap<>();
            //Act Statement(s)
            final ConcurrentRuntimeException result = assertThrows(ConcurrentRuntimeException.class, () -> {
                ConcurrentUtils.createIfAbsentUnchecked(objectObjectMap, object2, atomicInitializer);
            });
            Throwable throwable = new Throwable();
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, is(notNullValue()));
                assertThat(result.getCause(), is(instanceOf(throwable.getClass())));
                concurrentUtils.verify(() -> ConcurrentUtils.createIfAbsent((ConcurrentMap) any(), eq(object2), eq(atomicInitializer)), atLeast(1));
            });
        }
    }

    //BaseRock generated method id: ${extractCauseWhenExGetCauseIsNull}, hash: 63F9D09D9A9B0CFCFEE3E2E9FCCF766D
    @Test()
    void extractCauseWhenExGetCauseIsNull() {
        /* Branches:
         * (ex == null) : false
         * (ex.getCause() == null) : true
         */
        //Arrange Statement(s)
        ExecutionException executionException = new ExecutionException((Throwable) null);
        //Act Statement(s)
        ConcurrentException result = ConcurrentUtils.extractCause(executionException);
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, is(nullValue())));
    }

    //BaseRock generated method id: ${extractCauseWhenExGetCauseIsNotNull}, hash: 2DB26162E44754B086862320B73F0CB4
    @Test()
    void extractCauseWhenExGetCauseIsNotNull() {
        /* Branches:
         * (ex == null) : false
         * (ex.getCause() == null) : false
         */
        //Arrange Statement(s)
        Throwable throwable = new Throwable();
        ExecutionException executionException = new ExecutionException("message1", throwable);
        //Act Statement(s)
        ConcurrentException result = ConcurrentUtils.extractCause(executionException);
        //Assert statement(s)
        //TODO: Please implement equals method in ConcurrentException for verification of the entire object or you need to adjust respective assertion statements
        assertAll("result", () -> assertThat(result, is(notNullValue())));
    }

    //BaseRock generated method id: ${extractCauseUncheckedWhenExGetCauseIsNull}, hash: 2A1DD99F8E1FA3AFB0B07243CB21FE69
    @Test()
    void extractCauseUncheckedWhenExGetCauseIsNull() {
        /* Branches:
         * (ex == null) : false
         * (ex.getCause() == null) : true
         */
        //Arrange Statement(s)
        ExecutionException executionException = new ExecutionException((Throwable) null);
        //Act Statement(s)
        ConcurrentRuntimeException result = ConcurrentUtils.extractCauseUnchecked(executionException);
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, is(nullValue())));
    }

    //BaseRock generated method id: ${extractCauseUncheckedWhenExGetCauseIsNotNull}, hash: 739D324AB737D472336BAEFA9296F259
    @Test()
    void extractCauseUncheckedWhenExGetCauseIsNotNull() {
        /* Branches:
         * (ex == null) : false
         * (ex.getCause() == null) : false
         */
        //Arrange Statement(s)
        Throwable throwable = new Throwable();
        ExecutionException executionException = new ExecutionException("message1", throwable);
        //Act Statement(s)
        ConcurrentRuntimeException result = ConcurrentUtils.extractCauseUnchecked(executionException);
        //Assert statement(s)
        //TODO: Please implement equals method in ConcurrentRuntimeException for verification of the entire object or you need to adjust respective assertion statements
        assertAll("result", () -> assertThat(result, is(notNullValue())));
    }

    //BaseRock generated method id: ${handleCauseWhenCauseIsNotNullThrowsConcurrentException}, hash: EAB6D5CF74CB46E1D5D3AFA868B7A57A
    @Disabled()
    @Test()
    void handleCauseWhenCauseIsNotNullThrowsConcurrentException() throws ConcurrentException {
        /* Branches:
         * (cause != null) : true
         */
        //Arrange Statement(s)
        try (MockedStatic<ConcurrentUtils> concurrentUtils = mockStatic(ConcurrentUtils.class, CALLS_REAL_METHODS)) {
            Throwable throwable = new Throwable();
            ConcurrentException concurrentException = new ConcurrentException(throwable);
            Throwable throwable2 = new Throwable();
            ExecutionException executionException = new ExecutionException(throwable2);
            concurrentUtils.when(() -> ConcurrentUtils.extractCause(executionException)).thenThrow(concurrentException);
            //Act Statement(s)
            final ConcurrentException result = assertThrows(ConcurrentException.class, () -> {
                ConcurrentUtils.handleCause(executionException);
            });
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, equalTo(concurrentException));
                concurrentUtils.verify(() -> ConcurrentUtils.extractCause(executionException), atLeast(1));
            });
        }
    }

    //BaseRock generated method id: ${handleCauseWhenCauseIsNull}, hash: DF8C62B7461EA2A8FFA2F544D3EF27CE
    @Test()
    void handleCauseWhenCauseIsNull() throws ConcurrentException {
        /* Branches:
         * (cause != null) : false
         */
        //Arrange Statement(s)
        try (MockedStatic<ConcurrentUtils> concurrentUtils = mockStatic(ConcurrentUtils.class, CALLS_REAL_METHODS)) {
            Throwable throwable = new Throwable();
            ExecutionException executionException = new ExecutionException(throwable);
            concurrentUtils.when(() -> ConcurrentUtils.extractCause(executionException)).thenReturn(null);
            //Act Statement(s)
            ConcurrentUtils.handleCause(executionException);
            //Assert statement(s)
            assertAll("result", () -> concurrentUtils.verify(() -> ConcurrentUtils.extractCause(executionException), atLeast(1)));
        }
    }

    //BaseRock generated method id: ${handleCauseUncheckedWhenCauseIsNotNullThrowsConcurrentRuntimeException}, hash: 6D11E589D62B02BB5D5F950A36413746
    @Test()
    void handleCauseUncheckedWhenCauseIsNotNullThrowsConcurrentRuntimeException() {
        /* Branches:
         * (cause != null) : true
         */
        //Arrange Statement(s)
        try (MockedStatic<ConcurrentUtils> concurrentUtils = mockStatic(ConcurrentUtils.class, CALLS_REAL_METHODS)) {
            Throwable throwable = new Throwable();
            ConcurrentRuntimeException concurrentRuntimeException = new ConcurrentRuntimeException(throwable);
            Throwable throwable2 = new Throwable();
            ExecutionException executionException = new ExecutionException(throwable2);
            concurrentUtils.when(() -> ConcurrentUtils.extractCauseUnchecked(executionException)).thenThrow(concurrentRuntimeException);
            //Act Statement(s)
            final ConcurrentRuntimeException result = assertThrows(ConcurrentRuntimeException.class, () -> {
                ConcurrentUtils.handleCauseUnchecked(executionException);
            });
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, equalTo(concurrentRuntimeException));
                concurrentUtils.verify(() -> ConcurrentUtils.extractCauseUnchecked(executionException), atLeast(1));
            });
        }
    }

    //BaseRock generated method id: ${handleCauseUncheckedWhenCauseIsNull}, hash: BA3874525D79214FEE03076EF7F5FE29
    @Test()
    void handleCauseUncheckedWhenCauseIsNull() {
        /* Branches:
         * (cause != null) : false
         */
        //Arrange Statement(s)
        try (MockedStatic<ConcurrentUtils> concurrentUtils = mockStatic(ConcurrentUtils.class, CALLS_REAL_METHODS)) {
            Throwable throwable = new Throwable();
            ExecutionException executionException = new ExecutionException(throwable);
            concurrentUtils.when(() -> ConcurrentUtils.extractCauseUnchecked(executionException)).thenReturn(null);
            //Act Statement(s)
            ConcurrentUtils.handleCauseUnchecked(executionException);
            //Assert statement(s)
            assertAll("result", () -> concurrentUtils.verify(() -> ConcurrentUtils.extractCauseUnchecked(executionException), atLeast(1)));
        }
    }

    //BaseRock generated method id: ${initializeWhenInitializerIsNotNull}, hash: 6A0C4FE8736FEF6088E9432310F93EF1
    @Test()
    void initializeWhenInitializerIsNotNull() throws ConcurrentException {
        /* Branches:
         * (initializer != null) : true
         */
        //Arrange Statement(s)
        AtomicInitializer<Object> atomicInitializer = new AtomicInitializer<>();
        //Act Statement(s)
        Object result = ConcurrentUtils.initialize(atomicInitializer);
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, is(nullValue())));
    }

    //BaseRock generated method id: ${initializeWhenInitializerIsNull}, hash: B10D8B7EEC6FFE6D99C33501B8899BA3
    @Test()
    void initializeWhenInitializerIsNull() throws ConcurrentException {
        /* Branches:
         * (initializer != null) : false
         */
        //Arrange Statement(s)
        ConcurrentInitializer<Object> concurrentInitializer = null;
        //Act Statement(s)
        Object result = ConcurrentUtils.initialize(concurrentInitializer);
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, is(nullValue())));
    }

    //BaseRock generated method id: ${initializeUncheckedTest}, hash: 0DEBF2557420D4BD49B78B051E672847
    @Test()
    void initializeUncheckedTest() {
        //Arrange Statement(s)
        try (MockedStatic<ConcurrentUtils> concurrentUtils = mockStatic(ConcurrentUtils.class, CALLS_REAL_METHODS)) {
            Object object = new Object();
            AtomicInitializer<Object> atomicInitializer = new AtomicInitializer<>();
            concurrentUtils.when(() -> ConcurrentUtils.initialize(atomicInitializer)).thenReturn(object);
            //Act Statement(s)
            Object result = ConcurrentUtils.initializeUnchecked(atomicInitializer);
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, equalTo(object));
                concurrentUtils.verify(() -> ConcurrentUtils.initialize(atomicInitializer), atLeast(1));
            });
        }
    }

    //BaseRock generated method id: ${initializeUncheckedWhenCaughtConcurrentExceptionThrowsConcurrentRuntimeException}, hash: F3D514A31B66092D7033935993116DFA
    @Disabled()
    @Test()
    void initializeUncheckedWhenCaughtConcurrentExceptionThrowsConcurrentRuntimeException() {
        /* Branches:
         * (catch-exception (ConcurrentException)) : true
         *
         * TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
        //Arrange Statement(s)
        try (MockedStatic<ConcurrentUtils> concurrentUtils = mockStatic(ConcurrentUtils.class, CALLS_REAL_METHODS)) {
            Object object = new Object();
            AtomicInitializer<Object> atomicInitializer = new AtomicInitializer<>();
            concurrentUtils.when(() -> ConcurrentUtils.initialize(atomicInitializer)).thenReturn(object);
            //Act Statement(s)
            final ConcurrentRuntimeException result = assertThrows(ConcurrentRuntimeException.class, () -> {
                ConcurrentUtils.initializeUnchecked(atomicInitializer);
            });
            Throwable throwable = new Throwable();
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, is(notNullValue()));
                assertThat(result.getCause(), is(instanceOf(throwable.getClass())));
                concurrentUtils.verify(() -> ConcurrentUtils.initialize(atomicInitializer), atLeast(1));
            });
        }
    }

    //BaseRock generated method id: ${putIfAbsentWhenMapIsNull}, hash: 2319EBF11FD89DE761A3445271A3CBB9
    @Test()
    void putIfAbsentWhenMapIsNull() {
        /* Branches:
         * (map == null) : true
         */
        //Arrange Statement(s)
        ConcurrentMap<Object, Object> concurrentMap = null;
        Object object = new Object();
        Object object2 = new Object();
        //Act Statement(s)
        Object result = ConcurrentUtils.putIfAbsent(concurrentMap, object, object2);
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, is(nullValue())));
    }

    //BaseRock generated method id: ${putIfAbsentWhenResultIsNull}, hash: FA97CEBDBE8B87BFC83CD6C26E37CDBF
    @Test()
    void putIfAbsentWhenResultIsNull() {
        /* Branches:
         * (map == null) : false
         * (result != null) : false
         */
        //Arrange Statement(s)
        ConcurrentMap<Object, Object> objectObjectMap = new ConcurrentHashMap<>();
        Object object = new Object();
        Object object2 = new Object();
        //Act Statement(s)
        Object result = ConcurrentUtils.putIfAbsent(objectObjectMap, object, object2);
        ConcurrentMap<Object, Object> objectObjectObjectObjectMapMap = new ConcurrentHashMap<>();
        objectObjectObjectObjectMapMap.put(object, object2);
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(object2));
            assertThat(objectObjectMap, equalTo(objectObjectObjectObjectMapMap));
        });
    }
}
