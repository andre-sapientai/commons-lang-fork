package org.apache.commons.lang3.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class HashCodeBuilderCopilotTest {

    private HashCodeBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new HashCodeBuilder();
    }

    @Test
    void testDefaultConstructor() {
        assertEquals(17, builder.toHashCode());
    }

    @Test
    void testCustomConstructor() {
        builder = new HashCodeBuilder(41, 47);
        assertEquals(41, builder.toHashCode());
    }

    @Test
    void testInvalidConstructorArguments() {
        assertThrows(IllegalArgumentException.class, () -> new HashCodeBuilder(2, 47));
        assertThrows(IllegalArgumentException.class, () -> new HashCodeBuilder(41, 2));
    }

    void testAppendBoolean() {
        assertEquals(17 * 37 + 0, builder.append(true).toHashCode());
        assertEquals((17 * 37 + 0) * 37 + 1, builder.append(false).toHashCode());
    }

    @Test
    void testAppendBooleanArray() {
        boolean[] array = { true, false, true };
        builder.append(array);
        assertEquals(((17 * 37 + 0) * 37 + 1) * 37 + 0, builder.toHashCode());
    }

    @Test
    void testAppendByte() {
        assertEquals(17 * 37 + 123, builder.append((byte) 123).toHashCode());
    }

    @Test
    void testAppendByteArray() {
        byte[] array = { 1, 2, 3 };
        builder.append(array);
        assertEquals(((17 * 37 + 1) * 37 + 2) * 37 + 3, builder.toHashCode());
    }

    @Test
    void testAppendChar() {
        assertEquals(17 * 37 + 'a', builder.append('a').toHashCode());
    }

    @Test
    void testAppendCharArray() {
        char[] array = { 'a', 'b', 'c' };
        builder.append(array);
        assertEquals(((17 * 37 + 'a') * 37 + 'b') * 37 + 'c', builder.toHashCode());
    }

    @Test
    void testAppendDouble() {
        double value = 123.456;
        long bits = Double.doubleToLongBits(value);
        int expected = 17 * 37 + (int) (bits ^ (bits >>> 32));
        assertEquals(expected, builder.append(value).toHashCode());
    }

    @Test
    void testAppendDoubleArray() {
        double[] array = { 1.0, 2.0, 3.0 };
        builder.append(array);
        long bits1 = Double.doubleToLongBits(1.0);
        long bits2 = Double.doubleToLongBits(2.0);
        long bits3 = Double.doubleToLongBits(3.0);
        int expected = (((17 * 37 + (int) (bits1 ^ (bits1 >>> 32))) * 37 + (int) (bits2 ^ (bits2 >>> 32))) * 37 + (int) (bits3 ^ (bits3 >>> 32)));
        assertEquals(expected, builder.toHashCode());
    }

    @Test
    void testAppendFloat() {
        float value = 123.456f;
        assertEquals(17 * 37 + Float.floatToIntBits(value), builder.append(value).toHashCode());
    }

    @Test
    void testAppendFloatArray() {
        float[] array = { 1.0f, 2.0f, 3.0f };
        builder.append(array);
        int expected = ((17 * 37 + Float.floatToIntBits(1.0f)) * 37 + Float.floatToIntBits(2.0f)) * 37 + Float.floatToIntBits(3.0f);
        assertEquals(expected, builder.toHashCode());
    }

    @Test
    void testAppendInt() {
        assertEquals(17 * 37 + 123, builder.append(123).toHashCode());
    }

    @Test
    void testAppendIntArray() {
        int[] array = { 1, 2, 3 };
        builder.append(array);
        assertEquals(((17 * 37 + 1) * 37 + 2) * 37 + 3, builder.toHashCode());
    }

    @Test
    void testAppendLong() {
        long value = 123456789L;
        assertEquals(17 * 37 + (int) (value ^ (value >>> 32)), builder.append(value).toHashCode());
    }

    @Test
    void testAppendLongArray() {
        long[] array = { 1L, 2L, 3L };
        builder.append(array);
        int expected = ((17 * 37 + (int) (1L ^ (1L >>> 32))) * 37 + (int) (2L ^ (2L >>> 32))) * 37 + (int) (3L ^ (3L >>> 32));
        assertEquals(expected, builder.toHashCode());
    }

    @Test
    void testAppendObject() {
        Object obj = "test";
        assertEquals(17 * 37 + obj.hashCode(), builder.append(obj).toHashCode());
    }

    @Test
    void testAppendObjectArray() {
        Object[] array = { "a", "b", "c" };
        builder.append(array);
        int expected = ((17 * 37 + "a".hashCode()) * 37 + "b".hashCode()) * 37 + "c".hashCode();
        assertEquals(expected, builder.toHashCode());
    }

    @Test
    void testAppendShort() {
        assertEquals(17 * 37 + 123, builder.append((short) 123).toHashCode());
    }

    @Test
    void testAppendShortArray() {
        short[] array = { 1, 2, 3 };
        builder.append(array);
        assertEquals(((17 * 37 + 1) * 37 + 2) * 37 + 3, builder.toHashCode());
    }

    @Test
    void testAppendSuper() {
        int superHashCode = 42;
        assertEquals(17 * 37 + superHashCode, builder.appendSuper(superHashCode).toHashCode());
    }

    @Test
    void testBuild() {
        assertEquals(Integer.valueOf(17), builder.build());
    }

    @Test
    void testEquals() {
        HashCodeBuilder builder1 = new HashCodeBuilder(17, 37);
        HashCodeBuilder builder2 = new HashCodeBuilder(17, 37);
        HashCodeBuilder builder3 = new HashCodeBuilder(17, 39);
        assertTrue(builder1.equals(builder1));
        assertTrue(builder1.equals(builder2));
        assertFalse(builder1.equals(builder3));
        assertFalse(builder1.equals(null));
        assertFalse(builder1.equals("not a HashCodeBuilder"));
    }

    @Test
    void testHashCode() {
        assertEquals(17, builder.hashCode());
    }

    @Test
    void testReflectionHashCode() {
        TestObject obj = new TestObject(1, "test");
        int hashCode = HashCodeBuilder.reflectionHashCode(obj);
        assertNotEquals(0, hashCode);
    }

    @Test
    void testReflectionHashCodeWithTransients() {
        TestObject obj = new TestObject(1, "test");
        int hashCode1 = HashCodeBuilder.reflectionHashCode(obj, false);
        int hashCode2 = HashCodeBuilder.reflectionHashCode(obj, true);
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void testReflectionHashCodeWithExcludes() {
        TestObject obj = new TestObject(1, "test");
        int hashCode1 = HashCodeBuilder.reflectionHashCode(obj);
        int hashCode2 = HashCodeBuilder.reflectionHashCode(obj, null, "intValue");
        assertNotEquals(hashCode1, hashCode2);
    }

    @ParameterizedTest
    @CsvSource({ "17,37", "41,47" })
    void testParameterizedConstructor(int initialOddNumber, int multiplierOddNumber) {
        builder = new HashCodeBuilder(initialOddNumber, multiplierOddNumber);
        assertEquals(initialOddNumber, builder.toHashCode());
    }

    private static class TestObject {

        private int intValue;

        private String stringValue;

        private transient double transientValue;

        TestObject(int intValue, String stringValue) {
            this.intValue = intValue;
            this.stringValue = stringValue;
            this.transientValue = 3.14;
        }
    }
}