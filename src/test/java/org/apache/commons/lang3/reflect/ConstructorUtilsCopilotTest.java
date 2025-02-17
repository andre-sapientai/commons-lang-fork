package org.apache.commons.lang3.reflect;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class ConstructorUtilsCopilotTest {

    @Test
    void testGetAccessibleConstructor() {
        Constructor<String> constructor = ConstructorUtils.getAccessibleConstructor(String.class, String.class);
        assertNotNull(constructor);
        assertEquals(String.class, constructor.getDeclaringClass());

        Constructor<PrivateClass> privateConstructor = ConstructorUtils.getAccessibleConstructor(PrivateClass.class);
        assertNull(privateConstructor);
    }

    @Test
    void testGetMatchingAccessibleConstructor() {
        Constructor<String> constructor = ConstructorUtils.getMatchingAccessibleConstructor(String.class, String.class);
        assertNotNull(constructor);
        assertEquals(String.class, constructor.getDeclaringClass());

        Constructor<PrivateClass> privateConstructor = ConstructorUtils.getMatchingAccessibleConstructor(PrivateClass.class);
        assertNull(privateConstructor);
    }

    /*@ParameterizedTest
    @MethodSource("provideTestData")
    void testInvokeConstructor(Class<?> cls, Object[] args, Class<?>[] parameterTypes) throws Exception {
        Object result = ConstructorUtils.invokeConstructor(cls, args, parameterTypes);
        assertNotNull(result);
        assertEquals(cls, result.getClass());
    }*/

    /*@ParameterizedTest
    @MethodSource("provideTestData")
    void testInvokeExactConstructor(Class<?> cls, Object[] args, Class<?>[] parameterTypes) throws Exception {
        Object result = ConstructorUtils.invokeExactConstructor(cls, args, parameterTypes);
        assertNotNull(result);
        assertEquals(cls, result.getClass());
    }*/

    @Test
    void testInvokeConstructorWithNoSuchMethodException() {
        assertThrows(NoSuchMethodException.class, () -> ConstructorUtils.invokeConstructor(String.class, 1));
    }

    @Test
    void testInvokeExactConstructorWithNoSuchMethodException() {
        assertThrows(NoSuchMethodException.class, () -> ConstructorUtils.invokeExactConstructor(String.class, 1));
    }

    @Test
    void testInvokeConstructorWithNullClass() {
        assertThrows(IllegalArgumentException.class, () -> ConstructorUtils.invokeConstructor(null, new Object[] {}));
    }

    @Test
    void testInvokeExactConstructorWithNullClass() {
        assertThrows(IllegalArgumentException.class, () -> ConstructorUtils.invokeExactConstructor(null, new Object[] {}));
    }

    @Test
    void testGetAccessibleConstructorWithNullClass() {
        assertThrows(NullPointerException.class, () -> ConstructorUtils.getAccessibleConstructor(null, String.class));
    }

    @Test
    void testGetMatchingAccessibleConstructorWithNullClass() {
        assertThrows(NullPointerException.class, () -> ConstructorUtils.getMatchingAccessibleConstructor(null, String.class));
    }

    @Test
    void testInvokeConstructorWithVarArgs() throws Exception {
        String[] args = new String[] { "a", "b", "c" };
        String result = ConstructorUtils.invokeConstructor(String.class, (Object) args);
        assertEquals("abc", result);
    }

    @Test
    void testInvokeExactConstructorWithVarArgs() throws Exception {
        String[] args = new String[] { "a", "b", "c" };
        assertThrows(NoSuchMethodException.class, () -> ConstructorUtils.invokeExactConstructor(String.class, (Object) args));
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(String.class, new Object[] { "test" }, new Class<?>[] { String.class }),
                Arguments.of(Integer.class, new Object[] { 1 }, new Class<?>[] { int.class }),
                Arguments.of(Object.class, new Object[] {}, new Class<?>[] {})
        );
    }

    private static class PrivateClass {
        private PrivateClass() {
        }
    }
}