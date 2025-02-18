package org.apache.commons.lang3.builder;

import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import org.junit.jupiter.api.Disabled;

class HashCodeBuilderBaseRockGeneratedFtcgTest {

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

    //BaseRock generated method id: ${testAppendBoolean}, hash: DAB84E32AA73AEF34B1D16059BBE72E1
    @Test
    void testAppendBoolean() {
        assertEquals(1216, builder.append(true).toHashCode());
        assertEquals(45017, builder.append(false).toHashCode());
    }

    //BaseRock generated method id: ${testAppendBooleanArray}, hash: AB7A666859BB47E9B8C2CAB93EA420ED
    @Test
    void testAppendBooleanArray() {
        boolean[] array = { true, false, true };
        assertEquals(1666630, builder.append(array).toHashCode());
    }

    //BaseRock generated method id: ${testAppendByte}, hash: 7A541010DC7F11DBDACC56E437981982
    @Test
    void testAppendByte() {
        assertEquals(666, builder.append((byte) 5).toHashCode());
    }

    //BaseRock generated method id: ${testAppendByteArray}, hash: 4FAD8F6485CA15FF483C8478D5CFF13F
    @Test
    void testAppendByteArray() {
        byte[] array = { 1, 2, 3 };
        assertEquals(24627, builder.append(array).toHashCode());
    }

    //BaseRock generated method id: ${testAppendChar}, hash: 199C026EDE71857489678F260A4F9943
    @Test
    void testAppendChar() {
        assertEquals(715, builder.append('a').toHashCode());
    }

    //BaseRock generated method id: ${testAppendCharArray}, hash: 964AF43822C9CED5A757291497419CA9
    @Test
    void testAppendCharArray() {
        char[] array = { 'a', 'b', 'c' };
        assertEquals(26409, builder.append(array).toHashCode());
    }

    //BaseRock generated method id: ${testAppendDouble}, hash: 0FFF2B34FE76E0C568BC1C70768042AD
    @Test
    void testAppendDouble() {
        assertEquals(-1756719843, builder.append(3.14).toHashCode());
    }

    //BaseRock generated method id: ${testAppendDoubleArray}, hash: 300A4E0AE8A8F8BA4892F76EC391E0D4
    @Test
    void testAppendDoubleArray() {
        double[] array = { 1.0, 2.0, 3.0 };
        assertEquals(-1924506030, builder.append(array).toHashCode());
    }

    //BaseRock generated method id: ${testAppendFloat}, hash: C1964B5E6528D94AC57D66A7E16ADCB9
    @Test
    void testAppendFloat() {
        assertEquals(1078523331, builder.append(3.14f).toHashCode());
    }

    //BaseRock generated method id: ${testAppendFloatArray}, hash: 4FF9BDED0DA5E978338FB8191C085DF2
    @Test
    void testAppendFloatArray() {
        float[] array = { 1.0f, 2.0f, 3.0f };
        assertEquals(-1266264817, builder.append(array).toHashCode());
    }

    //BaseRock generated method id: ${testAppendInt}, hash: 48624B52B6D7636E5C0D33DD994873D9
    @Test
    void testAppendInt() {
        assertEquals(666, builder.append(5).toHashCode());
    }

    //BaseRock generated method id: ${testAppendIntArray}, hash: 404A87821A03392B89C98B14025FF19E
    @Test
    void testAppendIntArray() {
        int[] array = { 1, 2, 3 };
        assertEquals(24627, builder.append(array).toHashCode());
    }

    //BaseRock generated method id: ${testAppendLong}, hash: BDBB493AE471BFD14AC04B821DC551EC
    @Test
    void testAppendLong() {
        assertEquals(666, builder.append(5L).toHashCode());
    }

    //BaseRock generated method id: ${testAppendLongArray}, hash: 8B8382088576346FD96C9757DBECB35B
    @Test
    void testAppendLongArray() {
        long[] array = { 1L, 2L, 3L };
        assertEquals(24627, builder.append(array).toHashCode());
    }

    //BaseRock generated method id: ${testAppendObject}, hash: 2EE8A2A3553C1872E99A927A3E369CDB
    @Test
    void testAppendObject() {
        assertEquals(884, builder.append("test").toHashCode());
    }

    //BaseRock generated method id: ${testAppendObjectArray}, hash: 696AF09D345E91EAB6CAA21A7B843A82
    @Test
    void testAppendObjectArray() {
        Object[] array = { "a", "b", "c" };
        assertEquals(28462, builder.append(array).toHashCode());
    }

    //BaseRock generated method id: ${testAppendShort}, hash: 654EA1B47122ADC9733A9C1CD2CE0B33
    @Test
    void testAppendShort() {
        assertEquals(666, builder.append((short) 5).toHashCode());
    }

    //BaseRock generated method id: ${testAppendShortArray}, hash: 9BACD17C888E7BEBA0C1279BA64FF4D4
    @Test
    void testAppendShortArray() {
        short[] array = { 1, 2, 3 };
        assertEquals(24627, builder.append(array).toHashCode());
    }

    //BaseRock generated method id: ${testAppendSuper}, hash: 4AEF172D7ABC4E3AD26BB9B4742BE606
    @Test
    void testAppendSuper() {
        assertEquals(666, builder.appendSuper(5).toHashCode());
    }

    //BaseRock generated method id: ${testToHashCode}, hash: 40A739D9C57632A4487DD928C1727740
    @Test
    void testToHashCode() {
        builder.append(1).append("test").append(true);
        assertEquals(1064382, builder.toHashCode());
    }

    //BaseRock generated method id: ${testBuild}, hash: E52B9826B296484D745018D1F30CE383
    @Test
    void testBuild() {
        builder.append(1).append("test").append(true);
        assertEquals(Integer.valueOf(1064382), builder.build());
    }

    //BaseRock generated method id: ${testEquals}, hash: FDC88836124A82724D3BA00EAC1198F3
    @Test
    void testEquals() {
        HashCodeBuilder builder1 = new HashCodeBuilder().append(1).append("test");
        HashCodeBuilder builder2 = new HashCodeBuilder().append(1).append("test");
        HashCodeBuilder builder3 = new HashCodeBuilder().append(2).append("test");
        assertEquals(builder1, builder2);
        assertNotEquals(builder1, builder3);
        assertNotEquals(builder1, null);
        assertNotEquals(builder1, "not a HashCodeBuilder");
    }

    //BaseRock generated method id: ${testHashCode}, hash: 36825FE5DFB4C052EBEE48C99B568596
    @Test
    void testHashCode() {
        builder.append(1).append("test").append(true);
        assertEquals(1064382, builder.hashCode());
    }

    //BaseRock generated method id: ${testReflectionHashCode}, hash: F6D08802B9199FC953005F99F99D229C
    @Test
    void testReflectionHashCode() {
        TestObject obj = new TestObject(1, "test", true);
        int hashCode = HashCodeBuilder.reflectionHashCode(obj);
        assertNotEquals(0, hashCode);
    }

    //BaseRock generated method id: ${testReflectionHashCodeWithTransients}, hash: E1F0BE6E31635904989F0C0B6236CA52
    @Test
    void testReflectionHashCodeWithTransients() {
        TestObject obj = new TestObject(1, "test", true);
        int hashCode = HashCodeBuilder.reflectionHashCode(obj, true);
        assertNotEquals(0, hashCode);
    }

    //BaseRock generated method id: ${testReflectionHashCodeWithExclusions}, hash: 76BF7598F4D61D0DD8E08D4B9C56008A
    @Test
    void testReflectionHashCodeWithExclusions() {
        TestObject obj = new TestObject(1, "test", true);
        int hashCode = HashCodeBuilder.reflectionHashCode(obj, "strField");
        assertNotEquals(0, hashCode);
    }

    //BaseRock generated method id: ${testIsRegistered}, hash: 2E0FF8C37778C128FC8FA08A87A207FE
    @Test
    void testIsRegistered() throws Exception {
        TestObject obj = new TestObject(1, "test", true);
        assertFalse(HashCodeBuilder.isRegistered(obj));
        Field registryField = HashCodeBuilder.class.getDeclaredField("REGISTRY");
        registryField.setAccessible(true);
        ThreadLocal<Set<IDKey>> registry = (ThreadLocal<Set<IDKey>>) registryField.get(null);
        registry.get().add(new IDKey(obj));
        assertTrue(HashCodeBuilder.isRegistered(obj));
        registry.get().clear();
    }

    private static class TestObject {

        private int intField;

        private String strField;

        private transient boolean boolField;

        TestObject(int intField, String strField, boolean boolField) {
            this.intField = intField;
            this.strField = strField;
            this.boolField = boolField;
        }
    }
}
