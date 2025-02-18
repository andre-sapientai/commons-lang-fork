package org.apache.commons.lang3.reflect;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Constructor;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Disabled;

class ConstructorUtilsBaseRockGeneratedFtcgTest {

    //BaseRock generated method id: ${testGetAccessibleConstructor}, hash: 3480E47AE9B943B1DA96A163CD1C9007
    @Test
    void testGetAccessibleConstructor() throws NoSuchMethodException {
        Class<String> cls = String.class;
        Class<?>[] parameterTypes = { char[].class };
        Constructor<String> constructor = cls.getDeclaredConstructor(parameterTypes);
        Constructor<String> result = ConstructorUtils.getAccessibleConstructor(cls, parameterTypes);
        assertEquals(constructor, result);
    }

    //BaseRock generated method id: ${testGetAccessibleConstructorWithNullClass}, hash: B4259DF26285A0F0E788F1372FC9F0D3
    @Test
    void testGetAccessibleConstructorWithNullClass() {
        assertThrows(NullPointerException.class, () -> ConstructorUtils.getAccessibleConstructor(null, String.class));
    }

    //BaseRock generated method id: ${testGetAccessibleConstructorWithNoSuchMethod}, hash: AC34F497A192BA49A2C31EE1CF6434E0
    @Test
    void testGetAccessibleConstructorWithNoSuchMethod() {
        assertNull(ConstructorUtils.getAccessibleConstructor(String.class, Integer.class));
    }

    //BaseRock generated method id: ${testGetAccessibleConstructorWithConstructor}, hash: 182B0B3791EEB0E0C5A831AD9CFE4E2E
    @Test
    void testGetAccessibleConstructorWithConstructor() throws NoSuchMethodException {
        Constructor<String> constructor = String.class.getDeclaredConstructor();
        Constructor<String> result = ConstructorUtils.getAccessibleConstructor(constructor);
        assertEquals(constructor, result);
    }

    //BaseRock generated method id: ${testGetAccessibleConstructorWithNullConstructor}, hash: B45CC2F309A696985BAC5D3EE5B5EF42
    @Test
    void testGetAccessibleConstructorWithNullConstructor() {
        assertThrows(NullPointerException.class, () -> ConstructorUtils.getAccessibleConstructor((Constructor<String>) null));
    }

    //BaseRock generated method id: ${testGetMatchingAccessibleConstructor}, hash: BB785A6FFBA4CB443CB859364D051D57
    @Test
    void testGetMatchingAccessibleConstructor() {
        Constructor<String> result = ConstructorUtils.getMatchingAccessibleConstructor(String.class, char[].class);
        assertNotNull(result);
        assertEquals(1, result.getParameterCount());
        assertEquals(char[].class, result.getParameterTypes()[0]);
    }

    //BaseRock generated method id: ${testGetMatchingAccessibleConstructorWithNullClass}, hash: F683E3077281A4935F56C9147F77441D
    @Test
    void testGetMatchingAccessibleConstructorWithNullClass() {
        assertThrows(NullPointerException.class, () -> ConstructorUtils.getMatchingAccessibleConstructor(null, String.class));
    }

    //BaseRock generated method id: ${testGetMatchingAccessibleConstructorWithNoMatch}, hash: 0E3B3715FFCE4875B76A60599DE8E571
    @Test
    void testGetMatchingAccessibleConstructorWithNoMatch() {
        assertNull(ConstructorUtils.getMatchingAccessibleConstructor(String.class, Integer.class));
    }

    //BaseRock generated method id: ${testInvokeConstructor}, hash: 4D15B447CB8D23BA85E1CB896F79A6FF
    @Test
    void testInvokeConstructor() throws Exception {
        String result = ConstructorUtils.invokeConstructor(String.class, new Object[] { 'a', 'b', 'c' });
        assertEquals("abc", result);
    }

    //BaseRock generated method id: ${testInvokeConstructorWithNullClass}, hash: 785118C17FD57CF2D2ED16063F83054A
    @Test
    void testInvokeConstructorWithNullClass() {
        assertThrows(NullPointerException.class, () -> ConstructorUtils.invokeConstructor(null, new Object[] {}));
    }

    //BaseRock generated method id: ${testInvokeConstructorWithNoSuchMethod}, hash: C417C513259C18173A0601F30C8AF4FE
    @Test
    void testInvokeConstructorWithNoSuchMethod() {
        assertThrows(NoSuchMethodException.class, () -> ConstructorUtils.invokeConstructor(String.class, new Object[] { 1, 2, 3 }));
    }

    //BaseRock generated method id: ${testInvokeConstructorWithParameterTypes}, hash: 2A26568E4EB16AEEA8024A939F7C36D6
    @Test
    void testInvokeConstructorWithParameterTypes() throws Exception {
        String result = ConstructorUtils.invokeConstructor(String.class, new Object[] { 'a', 'b', 'c' }, new Class<?>[] { char[].class });
        assertEquals("abc", result);
    }

    //BaseRock generated method id: ${testInvokeExactConstructor}, hash: 4A10D004C81C95F3C0B213A94B3B9CB4
    @Test
    void testInvokeExactConstructor() throws Exception {
        String result = ConstructorUtils.invokeExactConstructor(String.class, new Object[] { 'a', 'b', 'c' });
        assertEquals("abc", result);
    }

    //BaseRock generated method id: ${testInvokeExactConstructorWithNullClass}, hash: 21EEA48CCB203C7FE59D03E79A4B8533
    @Test
    void testInvokeExactConstructorWithNullClass() {
        assertThrows(NullPointerException.class, () -> ConstructorUtils.invokeExactConstructor(null, new Object[] {}));
    }

    //BaseRock generated method id: ${testInvokeExactConstructorWithNoSuchMethod}, hash: E4463043508116824831F7DAACA8B6B0
    @Test
    void testInvokeExactConstructorWithNoSuchMethod() {
        assertThrows(NoSuchMethodException.class, () -> ConstructorUtils.invokeExactConstructor(String.class, new Object[] { 1, 2, 3 }));
    }

    //BaseRock generated method id: ${testInvokeExactConstructorWithParameterTypes}, hash: 49D34CD4C3097035FED8B5DB24D740DA
    @Test
    void testInvokeExactConstructorWithParameterTypes() throws Exception {
        String result = ConstructorUtils.invokeExactConstructor(String.class, new Object[] { 'a', 'b', 'c' }, new Class<?>[] { char[].class });
        assertEquals("abc", result);
    }

    //BaseRock generated method id: ${testIsAccessible}, hash: CCCB9E89015AD1B3377A5DF576931F2E
    @ParameterizedTest
    @CsvSource({ "java.lang.String, true", "java.lang.reflect.Method, false", "java.util.ArrayList, true" })
    void testIsAccessible(String className, boolean expected) throws Exception {
        Class<?> cls = Class.forName(className);
        boolean result = (boolean) ConstructorUtils.class.getDeclaredMethod("isAccessible", Class.class).invoke(null, cls);
        assertEquals(expected, result);
    }

    //BaseRock generated method id: ${testDeprecatedConstructor}, hash: 296088CA664A32155BCDFAE4151BEB05
    @Test
    void testDeprecatedConstructor() {
        assertDoesNotThrow(() -> new ConstructorUtils());
    }
}
