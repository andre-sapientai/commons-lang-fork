package org.apache.commons.lang3.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class HashCodeBuilderCursorTest {

    private static class TestObject {
        private final String str;
        private final int num;
        private final boolean flag;

        TestObject(String str, int num, boolean flag) {
            this.str = str;
            this.num = num;
            this.flag = flag;
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                .append(str)
                .append(num)
                .append(flag)
                .toHashCode();
        }
    }

    private static class TestObjectWithArray {
        private final int[] numbers;
        private final String[] strings;

        TestObjectWithArray(int[] numbers, String[] strings) {
            this.numbers = numbers;
            this.strings = strings;
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder()
                .append(numbers)
                .append(strings)
                .toHashCode();
        }
    }

    @Test
    void testBasicHashCode() {
        TestObject obj1 = new TestObject("test", 123, true);
        TestObject obj2 = new TestObject("test", 123, true);
        TestObject obj3 = new TestObject("different", 456, false);

        // Same objects should have same hash code
        assertEquals(obj1.hashCode(), obj2.hashCode());
        
        // Different objects should have different hash codes
        assertNotEquals(obj1.hashCode(), obj3.hashCode());
    }

    @Test
    void testArrayHashCode() {
        TestObjectWithArray obj1 = new TestObjectWithArray(
            new int[]{1, 2, 3},
            new String[]{"a", "b", "c"}
        );
        TestObjectWithArray obj2 = new TestObjectWithArray(
            new int[]{1, 2, 3},
            new String[]{"a", "b", "c"}
        );
        TestObjectWithArray obj3 = new TestObjectWithArray(
            new int[]{4, 5, 6},
            new String[]{"x", "y", "z"}
        );

        // Same arrays should have same hash code
        assertEquals(obj1.hashCode(), obj2.hashCode());
        
        // Different arrays should have different hash codes
        assertNotEquals(obj1.hashCode(), obj3.hashCode());
    }

    @Test
    void testAppendSuper() {
        int superHashCode = 123456;
        int hashCode = new HashCodeBuilder(17, 37)
            .appendSuper(superHashCode)
            .append("test")
            .toHashCode();

        // Hash code should be different from super hash code
        assertNotEquals(superHashCode, hashCode);
        
        // Same builder with same inputs should produce same hash code
        int hashCode2 = new HashCodeBuilder(17, 37)
            .appendSuper(superHashCode)
            .append("test")
            .toHashCode();
        assertEquals(hashCode, hashCode2);
    }

    @Test
    void testPrimitiveTypes() {
        HashCodeBuilder builder = new HashCodeBuilder(17, 37);
        
        // Test all primitive types
        int hashCode = builder
            .append(true)        // boolean
            .append((byte) 1)    // byte
            .append('a')         // char
            .append(2.0d)        // double
            .append(3.0f)        // float
            .append(4)           // int
            .append(5L)          // long
            .append((short) 6)   // short
            .toHashCode();

        // Same values should produce same hash code
        int hashCode2 = new HashCodeBuilder(17, 37)
            .append(true)
            .append((byte) 1)
            .append('a')
            .append(2.0d)
            .append(3.0f)
            .append(4)
            .append(5L)
            .append((short) 6)
            .toHashCode();

        assertEquals(hashCode, hashCode2);
    }

    @Test
    void testArrayTypes() {
        HashCodeBuilder builder = new HashCodeBuilder(17, 37);
        
        // Test all array types
        int hashCode = builder
            .append(new boolean[]{true, false})
            .append(new byte[]{1, 2})
            .append(new char[]{'a', 'b'})
            .append(new double[]{1.0, 2.0})
            .append(new float[]{3.0f, 4.0f})
            .append(new int[]{5, 6})
            .append(new long[]{7L, 8L})
            .append(new short[]{9, 10})
            .append(new String[]{"test1", "test2"})
            .toHashCode();

        // Same arrays should produce same hash code
        int hashCode2 = new HashCodeBuilder(17, 37)
            .append(new boolean[]{true, false})
            .append(new byte[]{1, 2})
            .append(new char[]{'a', 'b'})
            .append(new double[]{1.0, 2.0})
            .append(new float[]{3.0f, 4.0f})
            .append(new int[]{5, 6})
            .append(new long[]{7L, 8L})
            .append(new short[]{9, 10})
            .append(new String[]{"test1", "test2"})
            .toHashCode();

        assertEquals(hashCode, hashCode2);
    }

    @Test
    void testNullValues() {
        int hashCode1 = new HashCodeBuilder(17, 37)
            .append((Object) null)
            .append((String) null)
            .append((int[]) null)
            .append((Object[]) null)
            .toHashCode();

        int hashCode2 = new HashCodeBuilder(17, 37)
            .append((Object) null)
            .append((String) null)
            .append((int[]) null)
            .append((Object[]) null)
            .toHashCode();

        // Null values should produce consistent hash codes
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    void testReflectionHashCode() {
        TestObject obj1 = new TestObject("test", 123, true);
        TestObject obj2 = new TestObject("test", 123, true);
        TestObject obj3 = new TestObject("different", 456, false);

        int hashCode1 = HashCodeBuilder.reflectionHashCode(obj1);
        int hashCode2 = HashCodeBuilder.reflectionHashCode(obj2);
        int hashCode3 = HashCodeBuilder.reflectionHashCode(obj3);

        // Same objects should have same reflection hash code
        assertEquals(hashCode1, hashCode2);
        
        // Different objects should have different reflection hash codes
        assertNotEquals(hashCode1, hashCode3);
    }

    @Test
    void testReflectionHashCodeWithExclusions() {
        TestObject obj = new TestObject("test", 123, true);

        int hashCode1 = HashCodeBuilder.reflectionHashCode(obj, "str");
        int hashCode2 = HashCodeBuilder.reflectionHashCode(obj, "num");

        // Different exclusions should produce different hash codes
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void testInvalidConstruction() {
        // Test even initial number
        assertThrows(IllegalArgumentException.class, 
            () -> new HashCodeBuilder(2, 37));

        // Test even multiplier
        assertThrows(IllegalArgumentException.class, 
            () -> new HashCodeBuilder(17, 2));
    }

    @Test
    void testBuilder() {
        HashCodeBuilder builder = new HashCodeBuilder(17, 37);
        Integer hashCode = builder.build();
        
        // Build should return same value as toHashCode
        assertEquals(builder.toHashCode(), hashCode.intValue());
    }

    @Test
    void testEquals() {
        HashCodeBuilder builder1 = new HashCodeBuilder(17, 37).append("test");
        HashCodeBuilder builder2 = new HashCodeBuilder(17, 37).append("test");
        HashCodeBuilder builder3 = new HashCodeBuilder(17, 37).append("different");

        // Same builders should be equal
        assertEquals(builder1, builder2);
        
        // Different builders should not be equal
        assertNotEquals(builder1, builder3);
        
        // Builder should not be equal to null or other types
        assertNotEquals(builder1, null);
        assertNotEquals(builder1, "test");
    }
} 