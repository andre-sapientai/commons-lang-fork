package org.apache.commons.lang3.builder;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class EqualsBuilderCursorTest {

    @Test
    void testBasicEquality() {
        assertTrue(new EqualsBuilder()
                .append(1, 1)
                .append("foo", "foo")
                .append(true, true)
                .isEquals());
    }

    @Test
    void testBasicInequality() {
        assertFalse(new EqualsBuilder()
                .append(1, 2)
                .isEquals());

        assertFalse(new EqualsBuilder()
                .append("foo", "bar")
                .isEquals());

        assertFalse(new EqualsBuilder()
                .append(true, false)
                .isEquals());
    }

    @Test
    void testArrayEquality() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {1, 2, 4};

        assertTrue(new EqualsBuilder().append(array1, array2).isEquals());
        assertFalse(new EqualsBuilder().append(array1, array3).isEquals());
    }

    @Test
    void testNullHandling() {
        assertTrue(new EqualsBuilder().append(Optional.ofNullable(null), null).isEquals());
        assertFalse(new EqualsBuilder().append(null, "foo").isEquals());
        assertFalse(new EqualsBuilder().append("foo", null).isEquals());
    }

    @Test
    void testMultiDimensionalArrays() {
        int[][] array1 = {{1, 2}, {3, 4}};
        int[][] array2 = {{1, 2}, {3, 4}};
        int[][] array3 = {{1, 2}, {3, 5}};

        assertTrue(new EqualsBuilder().append(array1, array2).isEquals());
        assertFalse(new EqualsBuilder().append(array1, array3).isEquals());
    }

    @Test
    void testReflectionEquality() {
        TestObject obj1 = new TestObject(1, "foo");
        TestObject obj2 = new TestObject(1, "foo");
        TestObject obj3 = new TestObject(2, "foo");

        assertTrue(EqualsBuilder.reflectionEquals(obj1, obj2));
        assertFalse(EqualsBuilder.reflectionEquals(obj1, obj3));
    }

    @Test
    void testReset() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(1, 2); // This will set isEquals to false
        assertFalse(builder.isEquals());

        builder.reset();
        assertTrue(builder.isEquals()); // After reset, isEquals should be true

        builder.append(1, 1);
        assertTrue(builder.isEquals()); // Should still work normally after reset
    }

    @Test
    void testAppendSuper() {
        assertTrue(new EqualsBuilder()
                .appendSuper(true)
                .append(1, 1)
                .isEquals());

        assertFalse(new EqualsBuilder()
                .appendSuper(false)
                .append(1, 1)
                .isEquals());
    }

    // Helper class for reflection tests
    private static class TestObject {
        private final int number;
        private final String text;

        TestObject(int number, String text) {
            this.number = number;
            this.text = text;
        }
    }
}
