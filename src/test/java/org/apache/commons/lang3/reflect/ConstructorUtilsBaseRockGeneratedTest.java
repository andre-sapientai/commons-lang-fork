package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.ConstructorUtils;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.MethodSource;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Constructor;
import org.junit.jupiter.params.provider.Arguments;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ArrayUtils;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class ConstructorUtilsBaseRockGeneratedTest {

    //BaseRock generated method id: ${testGetAccessibleConstructor}, hash: 0AB79A35F67CAD473841F632FBE06723
    @Test
    void testGetAccessibleConstructor() {
        Constructor<String> constructor = ConstructorUtils.getAccessibleConstructor(String.class, String.class);
        assertNotNull(constructor);
        assertEquals(String.class, constructor.getDeclaringClass());
        Constructor<PrivateClass> privateConstructor = ConstructorUtils.getAccessibleConstructor(PrivateClass.class);
        assertNull(privateConstructor);
    }

    //BaseRock generated method id: ${testGetMatchingAccessibleConstructor}, hash: 4CF147FA831FD0FF560E64E3CCE2C74F
    @Test
    void testGetMatchingAccessibleConstructor() {
        Constructor<String> constructor = ConstructorUtils.getMatchingAccessibleConstructor(String.class, String.class);
        assertNotNull(constructor);
        assertEquals(String.class, constructor.getDeclaringClass());
        Constructor<PrivateClass> privateConstructor = ConstructorUtils.getMatchingAccessibleConstructor(PrivateClass.class);
        assertNull(privateConstructor);
    }

    //BaseRock generated method id: ${testInvokeConstructor}, hash: D9D0EBF36AD6068F8CB6B895DA54D904
    @ParameterizedTest
    @MethodSource("provideTestData")
    void testInvokeConstructor(Class<?> cls, Object[] args, Class<?>[] parameterTypes) throws Exception {
        Object result = ConstructorUtils.invokeConstructor(cls, args, parameterTypes);
        assertNotNull(result);
        assertEquals(cls, result.getClass());
    }

    //BaseRock generated method id: ${testInvokeExactConstructor}, hash: 7446852E164FCFCF363B4AF860C56394
    @ParameterizedTest
    @MethodSource("provideTestData")
    void testInvokeExactConstructor(Class<?> cls, Object[] args, Class<?>[] parameterTypes) throws Exception {
        Object result = ConstructorUtils.invokeExactConstructor(cls, args, parameterTypes);
        assertNotNull(result);
        assertEquals(cls, result.getClass());
    }

    //BaseRock generated method id: ${testInvokeConstructorWithNoSuchMethodException}, hash: CFA919BA36D3C735245F2A5BE3E130EF
    @Test
    void testInvokeConstructorWithNoSuchMethodException() {
        assertThrows(NoSuchMethodException.class, () -> ConstructorUtils.invokeConstructor(String.class, 1));
    }

    //BaseRock generated method id: ${testInvokeExactConstructorWithNoSuchMethodException}, hash: A3569A4D23CC9719D86A848808A45FF1
    @Test
    void testInvokeExactConstructorWithNoSuchMethodException() {
        assertThrows(NoSuchMethodException.class, () -> ConstructorUtils.invokeExactConstructor(String.class, 1));
    }

    //BaseRock generated method id: ${testInvokeConstructorWithNullClass}, hash: FD0C82ACB8FFD89F27837CE4AD1D7750
    @Test
    void testInvokeConstructorWithNullClass() {
        assertThrows(IllegalArgumentException.class, () -> ConstructorUtils.invokeConstructor(null, new Object[] {}));
    }

    //BaseRock generated method id: ${testInvokeExactConstructorWithNullClass}, hash: 64E07C40BAE4B155BB854E2E60AE21BB
    @Test
    void testInvokeExactConstructorWithNullClass() {
        assertThrows(IllegalArgumentException.class, () -> ConstructorUtils.invokeExactConstructor(null, new Object[] {}));
    }

    //BaseRock generated method id: ${testGetAccessibleConstructorWithNullClass}, hash: B4259DF26285A0F0E788F1372FC9F0D3
    @Test
    void testGetAccessibleConstructorWithNullClass() {
        assertThrows(NullPointerException.class, () -> ConstructorUtils.getAccessibleConstructor(null, String.class));
    }

    //BaseRock generated method id: ${testGetMatchingAccessibleConstructorWithNullClass}, hash: F683E3077281A4935F56C9147F77441D
    @Test
    void testGetMatchingAccessibleConstructorWithNullClass() {
        assertThrows(NullPointerException.class, () -> ConstructorUtils.getMatchingAccessibleConstructor(null, String.class));
    }

    //BaseRock generated method id: ${testInvokeConstructorWithVarArgs}, hash: 3216B7F1F80D01EEAA42DEA5EB0E3CAF
    @Test
    void testInvokeConstructorWithVarArgs() throws Exception {
        String[] args = new String[] { "a", "b", "c" };
        String result = ConstructorUtils.invokeConstructor(String.class, (Object) args);
        assertEquals("abc", result);
    }

    //BaseRock generated method id: ${testInvokeExactConstructorWithVarArgs}, hash: 6FB4367A70677CED24BADD98ADA7D4F8
    @Test
    void testInvokeExactConstructorWithVarArgs() throws Exception {
        String[] args = new String[] { "a", "b", "c" };
        assertThrows(NoSuchMethodException.class, () -> ConstructorUtils.invokeExactConstructor(String.class, (Object) args));
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(Arguments.of(String.class, new Object[] { "test" }, new Class<?>[] { String.class }), Arguments.of(Integer.class, new Object[] { 1 }, new Class<?>[] { int.class }), Arguments.of(Object.class, new Object[] {}, new Class<?>[] {}));
    }

    private static class PrivateClass {

        private PrivateClass() {
        }
    }
}
