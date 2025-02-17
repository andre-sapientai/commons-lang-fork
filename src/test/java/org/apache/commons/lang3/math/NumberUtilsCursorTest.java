package org.apache.commons.lang3.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class NumberUtilsCursorTest {

    @Test
    public void testCreateNumber() {
        // Test integer values
        assertEquals(Integer.valueOf(123), NumberUtils.createNumber("123"));
        assertEquals(Long.valueOf(12345678901L), NumberUtils.createNumber("12345678901"));
        
        // Test decimal values
        assertEquals(Double.valueOf(123.45), NumberUtils.createNumber("123.45"));
        assertEquals(Float.valueOf(123.45f), NumberUtils.createNumber("123.45f"));
        
        // Test scientific notation
        assertEquals(Double.valueOf(1.2345e2), NumberUtils.createNumber("1.2345e2"));
        
        // Test hex values
        assertEquals(Integer.valueOf(255), NumberUtils.createNumber("0xFF"));
        assertEquals(Integer.valueOf(255), NumberUtils.createNumber("#FF"));
        
        // Test null and empty
        assertNull(NumberUtils.createNumber(null));
        assertThrows(NumberFormatException.class, () -> NumberUtils.createNumber(""));
        
        // Test invalid formats
        assertThrows(NumberFormatException.class, () -> NumberUtils.createNumber("abc"));
    }

    @Test
    public void testIsCreatable() {
        // Test valid numbers
        assertTrue(NumberUtils.isCreatable("123"));
        assertTrue(NumberUtils.isCreatable("-123"));
        assertTrue(NumberUtils.isCreatable("123.45"));
        assertTrue(NumberUtils.isCreatable("0xFF"));
        assertTrue(NumberUtils.isCreatable("#FF"));
        assertTrue(NumberUtils.isCreatable("1.2345e2"));
        
        // Test invalid numbers
        assertFalse(NumberUtils.isCreatable(null));
        assertFalse(NumberUtils.isCreatable(""));
        assertFalse(NumberUtils.isCreatable("abc"));
        assertFalse(NumberUtils.isCreatable("12.34.56"));
    }

    @Test
    public void testToScaledBigDecimal() {
        // Test BigDecimal scaling
        assertEquals(new BigDecimal("123.45"), 
            NumberUtils.toScaledBigDecimal("123.45", 2, RoundingMode.HALF_EVEN));
        assertEquals(new BigDecimal("123.46"), 
            NumberUtils.toScaledBigDecimal("123.456", 2, RoundingMode.HALF_EVEN));
        
        // Test null values
        assertEquals(BigDecimal.ZERO, NumberUtils.toScaledBigDecimal((String) null));
        assertEquals(BigDecimal.ZERO, NumberUtils.toScaledBigDecimal((Double) null));
        assertEquals(BigDecimal.ZERO, NumberUtils.toScaledBigDecimal((Float) null));
    }

    @Test
    public void testCompare() {
        // Test int comparison
        assertEquals(0, NumberUtils.compare(123, 123));
        assertEquals(-1, NumberUtils.compare(123, 124));
        assertEquals(1, NumberUtils.compare(124, 123));
        
        // Test long comparison
        assertEquals(0, NumberUtils.compare(123L, 123L));
        assertEquals(-1, NumberUtils.compare(123L, 124L));
        assertEquals(1, NumberUtils.compare(124L, 123L));
    }

    @Test
    public void testMinMax() {
        // Test min
        assertEquals(1, NumberUtils.min(1, 2, 3));
        assertEquals(1L, NumberUtils.min(1L, 2L, 3L));
        assertEquals(1.0f, NumberUtils.min(1.0f, 2.0f, 3.0f));
        assertEquals(1.0, NumberUtils.min(1.0, 2.0, 3.0));
        
        // Test max
        assertEquals(3, NumberUtils.max(1, 2, 3));
        assertEquals(3L, NumberUtils.max(1L, 2L, 3L));
        assertEquals(3.0f, NumberUtils.max(1.0f, 2.0f, 3.0f));
        assertEquals(3.0, NumberUtils.max(1.0, 2.0, 3.0));
    }

    @Test
    public void testCreateBigDecimal() {
        // Test valid decimal strings
        assertEquals(new BigDecimal("123.45"), NumberUtils.createBigDecimal("123.45"));
        
        // Test null and empty
        assertNull(NumberUtils.createBigDecimal(null));
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigDecimal(""));
        
        // Test invalid formats
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigDecimal("abc"));
    }

    @Test
    public void testCreateBigInteger() {
        // Test valid integer strings
        assertEquals(BigInteger.valueOf(123), NumberUtils.createBigInteger("123"));
        assertEquals(BigInteger.valueOf(-123), NumberUtils.createBigInteger("-123"));
        assertEquals(BigInteger.valueOf(255), NumberUtils.createBigInteger("0xFF"));
        assertEquals(BigInteger.valueOf(255), NumberUtils.createBigInteger("#FF"));
        
        // Test null and empty
        assertNull(NumberUtils.createBigInteger(null));
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigInteger(""));
        
        // Test invalid formats
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigInteger("abc"));
    }
} 