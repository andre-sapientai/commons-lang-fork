package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.lang.reflect.AccessibleObject;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ArraySorter;
import java.util.HashSet;
import java.util.Set;
import java.lang.reflect.Field;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Comparator;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.apache.commons.lang3.Validate;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.ObjectUtils;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class HashCodeBuilderBaseRockGeneratedTest {

    private HashCodeBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new HashCodeBuilder();
    }

    //BaseRock generated method id: ${testDefaultConstructor}, hash: EA194DF773B86DC8368F869C93BC58D5
    @Test
    void testDefaultConstructor() {
        assertEquals(17, builder.toHashCode());
    }

    //BaseRock generated method id: ${testCustomConstructor}, hash: 7C1B74B69C66ABAF5C6E1EFC42435D7E
    @Test
    void testCustomConstructor() {
        builder = new HashCodeBuilder(41, 47);
        assertEquals(41, builder.toHashCode());
    }

    //BaseRock generated method id: ${testInvalidConstructorArguments}, hash: 55ADA0075B1A75E0A12E7E75DBA4B67B
    @Test
    void testInvalidConstructorArguments() {
        assertThrows(IllegalArgumentException.class, () -> new HashCodeBuilder(2, 47));
        assertThrows(IllegalArgumentException.class, () -> new HashCodeBuilder(41, 2));
    }

    //BaseRock generated method id: ${testAppendBoolean}, hash: C52B7B099789D048CB4094DB5D372BE6
    @Test
    void testAppendBoolean() {
        assertEquals(17 * 37 + 0, builder.append(true).toHashCode());
        assertEquals((17 * 37 + 0) * 37 + 1, builder.append(false).toHashCode());
    }

    //BaseRock generated method id: ${testAppendBooleanArray}, hash: 5D19EFFDA22BA547CB28D3F736C9BD57
    @Test
    void testAppendBooleanArray() {
        boolean[] array = { true, false, true };
        builder.append(array);
        assertEquals(((17 * 37 + 0) * 37 + 1) * 37 + 0, builder.toHashCode());
    }

    //BaseRock generated method id: ${testAppendByte}, hash: 29A86ED4B3A6D3CDBF9AF430F7A81277
    @Test
    void testAppendByte() {
        assertEquals(17 * 37 + 123, builder.append((byte) 123).toHashCode());
    }

    //BaseRock generated method id: ${testAppendByteArray}, hash: 945D06B31EA24FB09315FF14010DF763
    @Test
    void testAppendByteArray() {
        byte[] array = { 1, 2, 3 };
        builder.append(array);
        assertEquals(((17 * 37 + 1) * 37 + 2) * 37 + 3, builder.toHashCode());
    }

    //BaseRock generated method id: ${testAppendChar}, hash: 28A682FCE7513F5079E86606B9E94623
    @Test
    void testAppendChar() {
        assertEquals(17 * 37 + 'a', builder.append('a').toHashCode());
    }

    //BaseRock generated method id: ${testAppendCharArray}, hash: 639BF8AAC6CF04E1FD55BE5067711801
    @Test
    void testAppendCharArray() {
        char[] array = { 'a', 'b', 'c' };
        builder.append(array);
        assertEquals(((17 * 37 + 'a') * 37 + 'b') * 37 + 'c', builder.toHashCode());
    }

    //BaseRock generated method id: ${testAppendDouble}, hash: 6DF632777FF7F55F0CE8C08BF39401AE
    @Test
    void testAppendDouble() {
        double value = 123.456;
        long bits = Double.doubleToLongBits(value);
        int expected = 17 * 37 + (int) (bits ^ (bits >>> 32));
        assertEquals(expected, builder.append(value).toHashCode());
    }

    //BaseRock generated method id: ${testAppendDoubleArray}, hash: C0048AE9611874C3BEC732FD7F8A23D4
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

    //BaseRock generated method id: ${testAppendFloat}, hash: 88C5E14EB5A5AB7FB4F918922FC48BDF
    @Test
    void testAppendFloat() {
        float value = 123.456f;
        assertEquals(17 * 37 + Float.floatToIntBits(value), builder.append(value).toHashCode());
    }

    //BaseRock generated method id: ${testAppendFloatArray}, hash: ACBE7B43DDE62CB3E6F39014BC91A0F5
    @Test
    void testAppendFloatArray() {
        float[] array = { 1.0f, 2.0f, 3.0f };
        builder.append(array);
        int expected = ((17 * 37 + Float.floatToIntBits(1.0f)) * 37 + Float.floatToIntBits(2.0f)) * 37 + Float.floatToIntBits(3.0f);
        assertEquals(expected, builder.toHashCode());
    }

    //BaseRock generated method id: ${testAppendInt}, hash: A6E92359E8F0F29547AD60E018191FF5
    @Test
    void testAppendInt() {
        assertEquals(17 * 37 + 123, builder.append(123).toHashCode());
    }

    //BaseRock generated method id: ${testAppendIntArray}, hash: 12F0540FC78FF1329C42FD7773D448ED
    @Test
    void testAppendIntArray() {
        int[] array = { 1, 2, 3 };
        builder.append(array);
        assertEquals(((17 * 37 + 1) * 37 + 2) * 37 + 3, builder.toHashCode());
    }

    //BaseRock generated method id: ${testAppendLong}, hash: AA0B6675107119CED47D3AF026B93EF8
    @Test
    void testAppendLong() {
        long value = 123456789L;
        assertEquals(17 * 37 + (int) (value ^ (value >>> 32)), builder.append(value).toHashCode());
    }

    //BaseRock generated method id: ${testAppendLongArray}, hash: 8F6B30D42015F4E8677DF8BF203802DF
    @Test
    void testAppendLongArray() {
        long[] array = { 1L, 2L, 3L };
        builder.append(array);
        int expected = ((17 * 37 + (int) (1L ^ (1L >>> 32))) * 37 + (int) (2L ^ (2L >>> 32))) * 37 + (int) (3L ^ (3L >>> 32));
        assertEquals(expected, builder.toHashCode());
    }

    //BaseRock generated method id: ${testAppendObject}, hash: 90E922B28637B7BF51483C10065D1055
    @Test
    void testAppendObject() {
        Object obj = "test";
        assertEquals(17 * 37 + obj.hashCode(), builder.append(obj).toHashCode());
    }

    //BaseRock generated method id: ${testAppendObjectArray}, hash: 7F033F481EE9BC24A78709045CB3897F
    @Test
    void testAppendObjectArray() {
        Object[] array = { "a", "b", "c" };
        builder.append(array);
        int expected = ((17 * 37 + "a".hashCode()) * 37 + "b".hashCode()) * 37 + "c".hashCode();
        assertEquals(expected, builder.toHashCode());
    }

    //BaseRock generated method id: ${testAppendShort}, hash: 87766BA7790299D9EDDA379E751A96C7
    @Test
    void testAppendShort() {
        assertEquals(17 * 37 + 123, builder.append((short) 123).toHashCode());
    }

    //BaseRock generated method id: ${testAppendShortArray}, hash: A4504BEADDC14DA2FF58E54C06F7DE71
    @Test
    void testAppendShortArray() {
        short[] array = { 1, 2, 3 };
        builder.append(array);
        assertEquals(((17 * 37 + 1) * 37 + 2) * 37 + 3, builder.toHashCode());
    }

    //BaseRock generated method id: ${testAppendSuper}, hash: 4C7998A4E7CE67FFB65C836D9875EE94
    @Test
    void testAppendSuper() {
        int superHashCode = 42;
        assertEquals(17 * 37 + superHashCode, builder.appendSuper(superHashCode).toHashCode());
    }

    //BaseRock generated method id: ${testBuild}, hash: FE04EA310C61B967890D269C9D5D2AB4
    @Test
    void testBuild() {
        assertEquals(Integer.valueOf(17), builder.build());
    }

    //BaseRock generated method id: ${testEquals}, hash: 9EF1E0C9094DBB5CB710B409B1E28260
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

    //BaseRock generated method id: ${testHashCode}, hash: EECCBC50D0158682DA8D92F624C81D78
    @Test
    void testHashCode() {
        assertEquals(17, builder.hashCode());
    }

    //BaseRock generated method id: ${testReflectionHashCode}, hash: 4C0CB1F1804668BFBD7EE436F1AFBFA1
    @Test
    void testReflectionHashCode() {
        TestObject obj = new TestObject(1, "test");
        int hashCode = HashCodeBuilder.reflectionHashCode(obj);
        assertNotEquals(0, hashCode);
    }

    //BaseRock generated method id: ${testReflectionHashCodeWithTransients}, hash: DC1AA753D7C5FCD6F5B55BC65F3E6ED6
    @Test
    void testReflectionHashCodeWithTransients() {
        TestObject obj = new TestObject(1, "test");
        int hashCode1 = HashCodeBuilder.reflectionHashCode(obj, false);
        int hashCode2 = HashCodeBuilder.reflectionHashCode(obj, true);
        assertNotEquals(hashCode1, hashCode2);
    }

    //BaseRock generated method id: ${testReflectionHashCodeWithExcludes}, hash: 221D258EAD1E876432443E7B933ABDDE
    @Test
    void testReflectionHashCodeWithExcludes() {
        TestObject obj = new TestObject(1, "test");
        int hashCode1 = HashCodeBuilder.reflectionHashCode(obj);
        int hashCode2 = HashCodeBuilder.reflectionHashCode(obj, null, "intValue");
        assertNotEquals(hashCode1, hashCode2);
    }

    //BaseRock generated method id: ${testParameterizedConstructor}, hash: A19976641F0F26AB803F5C966287AC42
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
