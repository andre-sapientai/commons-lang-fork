package org.apache.commons.lang3.builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class CompareToBuilderCursorTest {

    @Test
    void testBasicComparisons() {
        // Test integers
        assertTrue(new CompareToBuilder().append(1, 2).toComparison() < 0);
        assertTrue(new CompareToBuilder().append(2, 1).toComparison() > 0);
        assertEquals(0, new CompareToBuilder().append(1, 1).toComparison());

        // Test strings
        assertTrue(new CompareToBuilder().append("a", "b").toComparison() < 0);
        assertTrue(new CompareToBuilder().append("b", "a").toComparison() > 0);
        assertEquals(0, new CompareToBuilder().append("a", "a").toComparison());
    }

    @Test
    void testNullComparisons() {
        // null vs non-null
        assertTrue(new CompareToBuilder().append(null, "abc").toComparison() < 0);
        assertTrue(new CompareToBuilder().append("abc", null).toComparison() > 0);
        
        // null vs null
        assertEquals(0, new CompareToBuilder().append(Optional.ofNullable(null), null).toComparison());
    }

    @Test
    void testArrayComparisons() {
        // Test int array comparisons
        int[] intArray1 = {1, 2, 3};
        int[] intArray2 = {1, 2, 4};
        int[] intArray3 = {1, 2, 3};
        
        assertTrue(new CompareToBuilder().append(intArray1, intArray2).toComparison() < 0);
        assertTrue(new CompareToBuilder().append(intArray2, intArray1).toComparison() > 0);
        assertEquals(0, new CompareToBuilder().append(intArray1, intArray3).toComparison());
        
        // Test different array types to avoid ambiguity
        byte[] byteArray1 = {1, 2, 3};
        byte[] byteArray2 = {1, 2, 4};
        assertTrue(new CompareToBuilder().append(byteArray1, byteArray2).toComparison() < 0);
        
        long[] longArray1 = {1L, 2L, 3L};
        long[] longArray2 = {1L, 2L, 4L};
        assertTrue(new CompareToBuilder().append(longArray1, longArray2).toComparison() < 0);
        
        double[] doubleArray1 = {1.0, 2.0, 3.0};
        double[] doubleArray2 = {1.0, 2.0, 4.0};
        assertTrue(new CompareToBuilder().append(doubleArray1, doubleArray2).toComparison() < 0);
    }

    @Test
    void testMultipleComparisons() {
        CompareToBuilder builder = new CompareToBuilder()
            .append(1, 1)      // Equal
            .append("a", "a")  // Equal
            .append(true, true); // Equal
        assertEquals(0, builder.toComparison());

        builder = new CompareToBuilder()
            .append(1, 1)      // Equal
            .append("a", "b")  // Less than
            .append(true, true); // Not checked due to previous comparison
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testPrimitiveTypes() {
        // boolean
        assertTrue(new CompareToBuilder().append(false, true).toComparison() < 0);
        assertTrue(new CompareToBuilder().append(true, false).toComparison() > 0);
        
        // char
        assertTrue(new CompareToBuilder().append('a', 'b').toComparison() < 0);
        assertTrue(new CompareToBuilder().append('b', 'a').toComparison() > 0);
        
        // byte
        assertTrue(new CompareToBuilder().append((byte)1, (byte)2).toComparison() < 0);
        
        // short
        assertTrue(new CompareToBuilder().append((short)1, (short)2).toComparison() < 0);
        
        // float
        assertTrue(new CompareToBuilder().append(1.0f, 2.0f).toComparison() < 0);
        
        // double
        assertTrue(new CompareToBuilder().append(1.0, 2.0).toComparison() < 0);
    }

    @Test
    void testReflectionCompare() {
        TestObject o1 = new TestObject(1, "a");
        TestObject o2 = new TestObject(2, "b");
        TestObject o3 = new TestObject(1, "a");

        assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0);
        assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0);
        assertEquals(0, CompareToBuilder.reflectionCompare(o1, o3));
    }

    // Helper class for reflection tests
    private static class TestObject {
        private final int num;
        private final String str;

        TestObject(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }
}