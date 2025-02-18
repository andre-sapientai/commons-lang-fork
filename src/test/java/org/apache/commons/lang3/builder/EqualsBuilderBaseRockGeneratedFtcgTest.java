package org.apache.commons.lang3.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.junit.jupiter.api.Disabled;

class EqualsBuilderBaseRockGeneratedFtcgTest {

    private EqualsBuilder equalsBuilder;

    @BeforeEach
    void setUp() {
        equalsBuilder = new EqualsBuilder();
    }

    //BaseRock generated method id: ${testReflectionEquals}, hash: 4296F449EDA40A470D0B83B34A5AC55E
    @Test
    void testReflectionEquals() {
        TestObject obj1 = new TestObject(1, "test");
        TestObject obj2 = new TestObject(1, "test");
        TestObject obj3 = new TestObject(2, "test");
        assertTrue(EqualsBuilder.reflectionEquals(obj1, obj2));
        assertFalse(EqualsBuilder.reflectionEquals(obj1, obj3));
    }

    //BaseRock generated method id: ${testReflectionEqualsWithExcludes}, hash: D372C168249C13A3CE186FB7D6BAB6BD
    @Test
    void testReflectionEqualsWithExcludes() {
        TestObject obj1 = new TestObject(1, "test");
        TestObject obj2 = new TestObject(2, "test");
        assertTrue(EqualsBuilder.reflectionEquals(obj1, obj2, "id"));
    }

    //BaseRock generated method id: ${testAppendSuper}, hash: 00E0A4E377ACE69B4294DE6E33AD0729
    @Test
    void testAppendSuper() {
        assertTrue(equalsBuilder.appendSuper(true).isEquals());
        assertFalse(equalsBuilder.appendSuper(false).isEquals());
    }

    //BaseRock generated method id: ${testAppendBoolean}, hash: 96DA72B70C2FDBCC284928158543283E
    @ParameterizedTest
    @CsvSource({ "true, true, true", "false, false, true", "true, false, false", "false, true, false" })
    void testAppendBoolean(boolean lhs, boolean rhs, boolean expected) {
        assertEquals(expected, equalsBuilder.append(lhs, rhs).isEquals());
    }

    //BaseRock generated method id: ${testAppendBooleanArray}, hash: 584D4BC4EF9D766DC40D9B87D565B225
    @Test
    void testAppendBooleanArray() {
        boolean[] array1 = { true, false, true };
        boolean[] array2 = { true, false, true };
        boolean[] array3 = { true, true, false };
        assertTrue(equalsBuilder.append(array1, array2).isEquals());
        assertFalse(equalsBuilder.append(array1, array3).isEquals());
    }

    //BaseRock generated method id: ${testAppendLong}, hash: 103CAEFBFC5655C2C24EFD06430796FF
    @ParameterizedTest
    @CsvSource({ "1, 1, true", "1, 2, false" })
    void testAppendLong(long lhs, long rhs, boolean expected) {
        assertEquals(expected, equalsBuilder.append(lhs, rhs).isEquals());
    }

    //BaseRock generated method id: ${testAppendLongArray}, hash: 71E130365F9CC96DCB04560C5378A7F7
    @Test
    void testAppendLongArray() {
        long[] array1 = { 1L, 2L, 3L };
        long[] array2 = { 1L, 2L, 3L };
        long[] array3 = { 1L, 2L, 4L };
        assertTrue(equalsBuilder.append(array1, array2).isEquals());
        assertFalse(equalsBuilder.append(array1, array3).isEquals());
    }

    //BaseRock generated method id: ${testAppendObjectArray}, hash: 5F8F7D9D8CD540FA609FBF66CD6FF68A
    @Test
    void testAppendObjectArray() {
        Object[] array1 = { "a", "b", "c" };
        Object[] array2 = { "a", "b", "c" };
        Object[] array3 = { "a", "b", "d" };
        assertTrue(equalsBuilder.append(array1, array2).isEquals());
        assertFalse(equalsBuilder.append(array1, array3).isEquals());
    }

    //BaseRock generated method id: ${testAppendObject}, hash: 3F8BE6A0F0129CBFBF8FF2A274BE848F
    @Test
    void testAppendObject() {
        Object obj1 = new TestObject(1, "test");
        Object obj2 = new TestObject(1, "test");
        Object obj3 = new TestObject(2, "test");
        assertTrue(equalsBuilder.append(obj1, obj2).isEquals());
        assertFalse(equalsBuilder.append(obj1, obj3).isEquals());
    }

    //BaseRock generated method id: ${testReflectionAppend}, hash: 0343090689EBA8B19E4D4B04246A168B
    @Test
    void testReflectionAppend() throws Exception {
        TestObject obj1 = new TestObject(1, "test");
        TestObject obj2 = new TestObject(1, "test");
        TestObject obj3 = new TestObject(2, "test");
        assertTrue(equalsBuilder.reflectionAppend(obj1, obj2).isEquals());
        assertFalse(equalsBuilder.reflectionAppend(obj1, obj3).isEquals());
    }

    //BaseRock generated method id: ${testSetTestRecursive}, hash: B6B08033E52E403B988EB22D2268A1A4
    @Test
    void testSetTestRecursive() {
        equalsBuilder.setTestRecursive(true);
        TestObject obj1 = new TestObject(1, "test");
        TestObject obj2 = new TestObject(1, "test");
        assertTrue(equalsBuilder.append(obj1, obj2).isEquals());
    }

    //BaseRock generated method id: ${testSetTestTransients}, hash: 7569B346CB8F90D7B36F2DE14A24CB0F
    @Test
    void testSetTestTransients() {
        equalsBuilder.setTestTransients(true);
        TestObjectWithTransient obj1 = new TestObjectWithTransient(1, "test");
        TestObjectWithTransient obj2 = new TestObjectWithTransient(1, "test");
        assertTrue(equalsBuilder.reflectionAppend(obj1, obj2).isEquals());
    }

    //BaseRock generated method id: ${testReset}, hash: B5A2A973A0227167340E50D6BD88750D
    @Test
    void testReset() {
        equalsBuilder.append(1, 2);
        assertFalse(equalsBuilder.isEquals());
        equalsBuilder.reset();
        assertTrue(equalsBuilder.isEquals());
    }

    //BaseRock generated method id: ${testIsRegistered}, hash: C3809737AF2B7E246C5F365514A7DE2A
    @Test
    void testIsRegistered() {
        Object obj1 = new TestObject(1, "test");
        Object obj2 = new TestObject(1, "test");
        assertFalse(EqualsBuilder.isRegistered(obj1, obj2));
        EqualsBuilder.getRegistry().add(EqualsBuilder.getRegisterPair(obj1, obj2));
        assertTrue(EqualsBuilder.isRegistered(obj1, obj2));
    }

    private static class TestObject {

        private int id;

        private String name;

        TestObject(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private static class TestObjectWithTransient {

        private int id;

        private transient String name;

        TestObjectWithTransient(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
