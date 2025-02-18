package org.apache.commons.lang3.math;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.math.BigDecimal;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import java.math.RoundingMode;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.junit.jupiter.api.Disabled;

class NumberUtilsBaseRockGeneratedFtcgTest {

    //BaseRock generated method id: ${testCompare}, hash: E6806C454F59122B6ACCDF6B60BC8C0D
    @Test
    void testCompare() {
        assertEquals(0, NumberUtils.compare(5, 5));
        assertEquals(-1, NumberUtils.compare(3, 7));
        assertEquals(1, NumberUtils.compare(9, 2));
    }

    //BaseRock generated method id: ${testCreateBigDecimal}, hash: 2A7EE5B103529417B0D9EF4F79440C6B
    @Test
    void testCreateBigDecimal() {
        assertEquals(new BigDecimal("123.45"), NumberUtils.createBigDecimal("123.45"));
        assertNull(NumberUtils.createBigDecimal(null));
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigDecimal(""));
    }

    //BaseRock generated method id: ${testCreateBigInteger}, hash: C98193CF38B88C0FF36F84962836A894
    @Test
    void testCreateBigInteger() {
        assertEquals(BigInteger.valueOf(123), NumberUtils.createBigInteger("123"));
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

    //BaseRock generated method id: ${testIsCreatable}, hash: ECD46D890828E88EF6E376196B70712B
    @Test
    void testIsCreatable() {
        assertTrue(NumberUtils.isCreatable("123"));
        assertTrue(NumberUtils.isCreatable("-123.45"));
        assertFalse(NumberUtils.isCreatable("abc"));
    }

    //BaseRock generated method id: ${testIsDigits}, hash: 0F416ECCCF55EAFD99D4208878FE4794
    @Test
    void testIsDigits() {
        assertTrue(NumberUtils.isDigits("123"));
        assertFalse(NumberUtils.isDigits("12.3"));
        assertFalse(NumberUtils.isDigits("abc"));
    }

    //BaseRock generated method id: ${testIsParsable}, hash: 664810F17DEA29CC0377D19C65780FFB
    @Test
    void testIsParsable() {
        assertTrue(NumberUtils.isParsable("123"));
        assertTrue(NumberUtils.isParsable("-123.45"));
        assertFalse(NumberUtils.isParsable("abc"));
    }

    //BaseRock generated method id: ${testMax}, hash: 133CEE43985B6753AD0A4971131B16AD
    @Test
    void testMax() {
        assertEquals(5, NumberUtils.max(1, 5, 3));
        assertEquals(5.5, NumberUtils.max(1.1, 5.5, 3.3));
    }

    //BaseRock generated method id: ${testMin}, hash: 258573D3BAAAB4C06443DD174FDF79BC
    @Test
    void testMin() {
        assertEquals(1, NumberUtils.min(1, 5, 3));
        assertEquals(1.1, NumberUtils.min(1.1, 5.5, 3.3));
    }

    //BaseRock generated method id: ${testToByte}, hash: D838901818F6E2E0B72207F69586B2EF
    @Test
    void testToByte() {
        assertEquals((byte) 123, NumberUtils.toByte("123"));
        assertEquals((byte) 0, NumberUtils.toByte("abc"));
    }

    //BaseRock generated method id: ${testToDouble}, hash: 7162CAB7DCF2113DF86BCA608CC8307D
    @Test
    void testToDouble() {
        assertEquals(123.45, NumberUtils.toDouble("123.45"));
        assertEquals(0.0, NumberUtils.toDouble("abc"));
    }

    //BaseRock generated method id: ${testToFloat}, hash: 95B4C6B0F9487C79B07F0F5A3AE6CBAA
    @Test
    void testToFloat() {
        assertEquals(123.45f, NumberUtils.toFloat("123.45"));
        assertEquals(0.0f, NumberUtils.toFloat("abc"));
    }

    //BaseRock generated method id: ${testToInt}, hash: 0AA861F4AD040D4FB3F19983B74E141A
    @Test
    void testToInt() {
        assertEquals(123, NumberUtils.toInt("123"));
        assertEquals(0, NumberUtils.toInt("abc"));
    }

    //BaseRock generated method id: ${testToLong}, hash: C9A5AEF684AE48E966B1E2E1DD361436
    @Test
    void testToLong() {
        assertEquals(123L, NumberUtils.toLong("123"));
        assertEquals(0L, NumberUtils.toLong("abc"));
    }

    //BaseRock generated method id: ${testToScaledBigDecimal}, hash: D3312A61C8465775B0E5BF5441B5002D
    @Test
    void testToScaledBigDecimal() {
        assertEquals(new BigDecimal("123.46"), NumberUtils.toScaledBigDecimal("123.456", 2, RoundingMode.HALF_UP));
    }

    //BaseRock generated method id: ${testToShort}, hash: 4F4C8B11EEC5AA62B9B331704FA7508C
    @Test
    void testToShort() {
        assertEquals((short) 123, NumberUtils.toShort("123"));
        assertEquals((short) 0, NumberUtils.toShort("abc"));
    }
}
