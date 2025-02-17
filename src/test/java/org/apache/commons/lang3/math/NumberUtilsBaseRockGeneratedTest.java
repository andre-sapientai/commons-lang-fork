package org.apache.commons.lang3.math;

import org.apache.commons.lang3.math.NumberUtils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.apache.commons.lang3.Validate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;
import java.math.RoundingMode;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class NumberUtilsBaseRockGeneratedTest {

    //BaseRock generated method id: ${testCompare}, hash: 623C1950F2163C9FE1B7F2D5A13FADF7
    @Test
    void testCompare() {
        assertEquals(0, NumberUtils.compare(5, 5));
        assertEquals(-1, NumberUtils.compare(3, 7));
        assertEquals(1, NumberUtils.compare(9, 2));
        assertEquals(0, NumberUtils.compare(5L, 5L));
        assertEquals(-1, NumberUtils.compare(3L, 7L));
        assertEquals(1, NumberUtils.compare(9L, 2L));
        assertEquals(0, NumberUtils.compare((short) 5, (short) 5));
        assertEquals(-1, NumberUtils.compare((short) 3, (short) 7));
        assertEquals(1, NumberUtils.compare((short) 9, (short) 2));
        assertEquals(0, NumberUtils.compare((byte) 5, (byte) 5));
        assertEquals(-1, NumberUtils.compare((byte) 3, (byte) 7));
        assertEquals(1, NumberUtils.compare((byte) 9, (byte) 2));
    }

    //BaseRock generated method id: ${testCreateBigDecimal}, hash: 11093216C063C448C10306E3EA4C1583
    @Test
    void testCreateBigDecimal() {
        assertEquals(BigDecimal.valueOf(123.45), NumberUtils.createBigDecimal("123.45"));
        assertNull(NumberUtils.createBigDecimal(null));
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigDecimal(""));
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigDecimal("  "));
    }

    //BaseRock generated method id: ${testCreateBigInteger}, hash: 8F3FF60026D5D3B2CAE5A139942D4486
    @Test
    void testCreateBigInteger() {
        assertEquals(BigInteger.valueOf(123), NumberUtils.createBigInteger("123"));
        assertEquals(BigInteger.valueOf(-123), NumberUtils.createBigInteger("-123"));
        assertEquals(BigInteger.valueOf(255), NumberUtils.createBigInteger("0xFF"));
        assertNull(NumberUtils.createBigInteger(null));
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigInteger(""));
    }

    //BaseRock generated method id: ${testCreateDouble}, hash: 50E598EEE6826D52F533917899123D63
    @Test
    void testCreateDouble() {
        assertEquals(123.45, NumberUtils.createDouble("123.45"));
        assertNull(NumberUtils.createDouble(null));
    }

    //BaseRock generated method id: ${testCreateFloat}, hash: 70152576EAEAA63D33DBF877F6FA9F3C
    @Test
    void testCreateFloat() {
        assertEquals(123.45f, NumberUtils.createFloat("123.45"));
        assertNull(NumberUtils.createFloat(null));
    }

    //BaseRock generated method id: ${testCreateInteger}, hash: C56ED5E579895FEE6F82C55B0C5C1573
    @Test
    void testCreateInteger() {
        assertEquals(123, NumberUtils.createInteger("123"));
        assertNull(NumberUtils.createInteger(null));
    }

    //BaseRock generated method id: ${testCreateLong}, hash: B312AFA4411BF9570432AC440AE69918
    @Test
    void testCreateLong() {
        assertEquals(123L, NumberUtils.createLong("123"));
        assertNull(NumberUtils.createLong(null));
    }

    //BaseRock generated method id: ${testCreateNumber}, hash: FB52C14AE9747DF06693C1BF58C6050E
    @ParameterizedTest
    @CsvSource({ "123, 123", "123.45, 123.45", "0xFF, 255", "-123, -123", "1.23e2, 123.0" })
    void testCreateNumber(String input, Number expected) {
        assertEquals(expected, NumberUtils.createNumber(input));
    }

    //BaseRock generated method id: ${testCreateNumberWithNull}, hash: 79CC12E93B7DFEDF3FFA0B7786857FE1
    @Test
    void testCreateNumberWithNull() {
        assertNull(NumberUtils.createNumber(null));
    }

    //BaseRock generated method id: ${testIsCreatable}, hash: B30B223E85DDC5D2BB96CE6F76B5A955
    @ParameterizedTest
    @ValueSource(strings = { "123", "123.45", "0xFF", "-123", "1.23e2" })
    void testIsCreatable(String input) {
        assertTrue(NumberUtils.isCreatable(input));
    }

    //BaseRock generated method id: ${testIsNotCreatable}, hash: 6023CCE1159C9B3481CF83A4BEAC84EC
    @ParameterizedTest
    @ValueSource(strings = { "", "abc", "12a", "1.2.3" })
    void testIsNotCreatable(String input) {
        assertFalse(NumberUtils.isCreatable(input));
    }

    //BaseRock generated method id: ${testIsDigits}, hash: 0F416ECCCF55EAFD99D4208878FE4794
    @Test
    void testIsDigits() {
        assertTrue(NumberUtils.isDigits("123"));
        assertFalse(NumberUtils.isDigits("12.3"));
        assertFalse(NumberUtils.isDigits("abc"));
    }

    //BaseRock generated method id: ${testIsParsable}, hash: E34969A463FDFF7D8B549BCF49F80247
    @Test
    void testIsParsable() {
        assertTrue(NumberUtils.isParsable("123"));
        assertTrue(NumberUtils.isParsable("123.45"));
        assertFalse(NumberUtils.isParsable("123."));
        assertFalse(NumberUtils.isParsable("abc"));
    }

    //BaseRock generated method id: ${testMax}, hash: 0A8894A6EB5E16BD1463684AAFB33A10
    @Test
    void testMax() {
        assertEquals(9, NumberUtils.max(1, 5, 9));
        assertEquals(9L, NumberUtils.max(1L, 5L, 9L));
        assertEquals(9.0f, NumberUtils.max(1.0f, 5.0f, 9.0f));
        assertEquals(9.0, NumberUtils.max(1.0, 5.0, 9.0));
        assertEquals((short) 9, NumberUtils.max((short) 1, (short) 5, (short) 9));
        assertEquals((byte) 9, NumberUtils.max((byte) 1, (byte) 5, (byte) 9));
    }

    //BaseRock generated method id: ${testMin}, hash: 57A80B5C9F21DC1E7E107553698605FD
    @Test
    void testMin() {
        assertEquals(1, NumberUtils.min(1, 5, 9));
        assertEquals(1L, NumberUtils.min(1L, 5L, 9L));
        assertEquals(1.0f, NumberUtils.min(1.0f, 5.0f, 9.0f));
        assertEquals(1.0, NumberUtils.min(1.0, 5.0, 9.0));
        assertEquals((short) 1, NumberUtils.min((short) 1, (short) 5, (short) 9));
        assertEquals((byte) 1, NumberUtils.min((byte) 1, (byte) 5, (byte) 9));
    }

    //BaseRock generated method id: ${testToByte}, hash: A6CDE071CDADCF9405D98143596C9AE9
    @Test
    void testToByte() {
        assertEquals((byte) 123, NumberUtils.toByte("123"));
        assertEquals((byte) 0, NumberUtils.toByte("abc"));
        assertEquals((byte) -1, NumberUtils.toByte("abc", (byte) -1));
    }

    //BaseRock generated method id: ${testToDouble}, hash: 85BC4D3311E02C4C93EBBBA943BF2CF9
    @Test
    void testToDouble() {
        assertEquals(123.45, NumberUtils.toDouble("123.45"));
        assertEquals(0.0, NumberUtils.toDouble("abc"));
        assertEquals(-1.0, NumberUtils.toDouble("abc", -1.0));
    }

    //BaseRock generated method id: ${testToFloat}, hash: 9352B496A90B55B57E7BC1DB3980975D
    @Test
    void testToFloat() {
        assertEquals(123.45f, NumberUtils.toFloat("123.45"));
        assertEquals(0.0f, NumberUtils.toFloat("abc"));
        assertEquals(-1.0f, NumberUtils.toFloat("abc", -1.0f));
    }

    //BaseRock generated method id: ${testToInt}, hash: 4B7D466E2A8CFD6B579B51D9B8F86CEA
    @Test
    void testToInt() {
        assertEquals(123, NumberUtils.toInt("123"));
        assertEquals(0, NumberUtils.toInt("abc"));
        assertEquals(-1, NumberUtils.toInt("abc", -1));
    }

    //BaseRock generated method id: ${testToLong}, hash: E63B270AB41F9300F5DB5B78202F35D5
    @Test
    void testToLong() {
        assertEquals(123L, NumberUtils.toLong("123"));
        assertEquals(0L, NumberUtils.toLong("abc"));
        assertEquals(-1L, NumberUtils.toLong("abc", -1L));
    }

    //BaseRock generated method id: ${testToShort}, hash: 03D7C396E578996D3BAD534ADC1242D5
    @Test
    void testToShort() {
        assertEquals((short) 123, NumberUtils.toShort("123"));
        assertEquals((short) 0, NumberUtils.toShort("abc"));
        assertEquals((short) -1, NumberUtils.toShort("abc", (short) -1));
    }

    //BaseRock generated method id: ${testToScaledBigDecimal}, hash: 98C690C1AFBF75FBF22992E797BE9DF5
    @Test
    void testToScaledBigDecimal() {
        assertEquals(new BigDecimal("123.46"), NumberUtils.toScaledBigDecimal("123.456", 2, RoundingMode.HALF_UP));
        assertEquals(BigDecimal.ZERO, NumberUtils.toScaledBigDecimal((String) null));
    }
}
