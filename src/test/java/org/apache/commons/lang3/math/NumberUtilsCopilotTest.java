package org.apache.commons.lang3.math;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class NumberUtilsCopilotTest {

    @Test
    void testCompare() {
        assertEquals(0, NumberUtils.compare(5, 5));
        assertEquals(-1, NumberUtils.compare(3, 7));
        assertEquals(1, NumberUtils.compare(9, 2));
        assertEquals(0, NumberUtils.compare(5L, 5L));
        assertEquals(1, NumberUtils.compare(9L, 2L));
        assertEquals(0, NumberUtils.compare((short) 5, (short) 5));
        assertEquals(-1, NumberUtils.compare((short) 3, (short) 7));
        assertEquals(1, NumberUtils.compare((short) 9, (short) 2));
        assertEquals(0, NumberUtils.compare((byte) 5, (byte) 5));
        assertEquals(-1, NumberUtils.compare((byte) 3, (byte) 7));
        assertEquals(1, NumberUtils.compare((byte) 9, (byte) 2));
    }

    @Test
    void testCreateBigDecimal() {
        assertEquals(BigDecimal.valueOf(123.45), NumberUtils.createBigDecimal("123.45"));
        assertNull(NumberUtils.createBigDecimal(null));
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigDecimal(""));
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigDecimal("  "));
    }

    @Test
    void testCreateBigInteger() {
        assertEquals(BigInteger.valueOf(123), NumberUtils.createBigInteger("123"));
        assertEquals(BigInteger.valueOf(-123), NumberUtils.createBigInteger("-123"));
        assertEquals(BigInteger.valueOf(255), NumberUtils.createBigInteger("0xFF"));
        assertNull(NumberUtils.createBigInteger(null));
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigInteger(""));
    }

    @Test
    void testCreateDouble() {
        assertEquals(123.45, NumberUtils.createDouble("123.45"));
        assertNull(NumberUtils.createDouble(null));
    }

    @Test
    void testCreateFloat() {
        assertEquals(123.45f, NumberUtils.createFloat("123.45"));
        assertNull(NumberUtils.createFloat(null));
    }

    @Test
    void testCreateInteger() {
        assertEquals(123, NumberUtils.createInteger("123"));
        assertNull(NumberUtils.createInteger(null));
    }

    @Test
    void testCreateLong() {
        assertEquals(123L, NumberUtils.createLong("123"));
        assertNull(NumberUtils.createLong(null));
    }

    @ParameterizedTest
    @CsvSource({ "123, 123", "123.45, 123.45", "0xFF, 255", "-123, -123", "1.23e2, 123.0" })
    void testCreateNumber(String input, Number expected) {
        assertEquals(expected, NumberUtils.createNumber(input));
    }

    @Test
    void testCreateNumberWithNull() {
        assertNull(NumberUtils.createNumber(null));
    }

    @ParameterizedTest
    @ValueSource(strings = { "123", "123.45", "0xFF", "-123", "1.23e2" })
    void testIsCreatable(String input) {
        assertTrue(NumberUtils.isCreatable(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "abc", "12a", "1.2.3" })
    void testIsNotCreatable(String input) {
        assertFalse(NumberUtils.isCreatable(input));
    }

    @Test
    void testIsDigits() {
        assertTrue(NumberUtils.isDigits("123"));
        assertFalse(NumberUtils.isDigits("12.3"));
        assertFalse(NumberUtils.isDigits("abc"));
    }

    @Test
    void testIsParsable() {
        assertTrue(NumberUtils.isParsable("123"));
        assertTrue(NumberUtils.isParsable("123.45"));
        assertFalse(NumberUtils.isParsable("123."));
        assertFalse(NumberUtils.isParsable("abc"));
    }

    @Test
    void testMax() {
        assertEquals(9, NumberUtils.max(1, 5, 9));
        assertEquals(9L, NumberUtils.max(1L, 5L, 9L));
        assertEquals(9.0f, NumberUtils.max(1.0f, 5.0f, 9.0f));
        assertEquals(9.0, NumberUtils.max(1.0, 5.0, 9.0));
        assertEquals((short) 9, NumberUtils.max((short) 1, (short) 5, (short) 9));
        assertEquals((byte) 9, NumberUtils.max((byte) 1, (byte) 5, (byte) 9));
    }

    @Test
    void testMin() {
        assertEquals(1, NumberUtils.min(1, 5, 9));
        assertEquals(1L, NumberUtils.min(1L, 5L, 9L));
        assertEquals(1.0f, NumberUtils.min(1.0f, 5.0f, 9.0f));
        assertEquals(1.0, NumberUtils.min(1.0, 5.0, 9.0));
        assertEquals((short) 1, NumberUtils.min((short) 1, (short) 5, (short) 9));
        assertEquals((byte) 1, NumberUtils.min((byte) 1, (byte) 5, (byte) 9));
    }

    @Test
    void testToByte() {
        assertEquals((byte) 123, NumberUtils.toByte("123"));
        assertEquals((byte) 0, NumberUtils.toByte("abc"));
        assertEquals((byte) -1, NumberUtils.toByte("abc", (byte) -1));
    }

    @Test
    void testToDouble() {
        assertEquals(123.45, NumberUtils.toDouble("123.45"));
        assertEquals(0.0, NumberUtils.toDouble("abc"));
        assertEquals(-1.0, NumberUtils.toDouble("abc", -1.0));
    }

    @Test
    void testToFloat() {
        assertEquals(123.45f, NumberUtils.toFloat("123.45"));
        assertEquals(0.0f, NumberUtils.toFloat("abc"));
        assertEquals(-1.0f, NumberUtils.toFloat("abc", -1.0f));
    }

    @Test
    void testToInt() {
        assertEquals(123, NumberUtils.toInt("123"));
        assertEquals(0, NumberUtils.toInt("abc"));
        assertEquals(-1, NumberUtils.toInt("abc", -1));
    }

    @Test
    void testToLong() {
        assertEquals(123L, NumberUtils.toLong("123"));
        assertEquals(0L, NumberUtils.toLong("abc"));
        assertEquals(-1L, NumberUtils.toLong("abc", -1L));
    }

    @Test
    void testToShort() {
        assertEquals((short) 123, NumberUtils.toShort("123"));
        assertEquals((short) 0, NumberUtils.toShort("abc"));
        assertEquals((short) -1, NumberUtils.toShort("abc", (short) -1));
    }

    @Test
    void testToScaledBigDecimal() {
        assertEquals(new BigDecimal("123.46"), NumberUtils.toScaledBigDecimal("123.456", 2, RoundingMode.HALF_UP));
        assertEquals(BigDecimal.ZERO, NumberUtils.toScaledBigDecimal((String) null));
    }
}