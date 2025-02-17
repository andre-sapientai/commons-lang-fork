package org.apache.commons.lang3.tuple;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class MutableTripleCursorTest {

    @Test
    void testEmptyArray() {
        // Test empty array singleton
        MutableTriple<?, ?, ?>[] empty = MutableTriple.EMPTY_ARRAY;
        assertEquals(0, empty.length);
        
        // Test empty array method
        MutableTriple<String, Integer, Boolean>[] typedEmpty = MutableTriple.emptyArray();
        assertEquals(0, typedEmpty.length);
    }

    @Test
    void testOf() {
        // Test factory method with values
        MutableTriple<String, Integer, Boolean> triple = MutableTriple.of("test", 123, true);
        assertEquals("test", triple.getLeft());
        assertEquals(Integer.valueOf(123), triple.getMiddle());
        assertEquals(Boolean.TRUE, triple.getRight());
        
        // Test factory method with nulls
        MutableTriple<String, Integer, Boolean> nullTriple = MutableTriple.of(null, null, null);
        assertNull(nullTriple.getLeft());
        assertNull(nullTriple.getMiddle());
        assertNull(nullTriple.getRight());
    }

    @Test
    void testOfNonNull() {
        // Test factory method with non-null values
        MutableTriple<String, Integer, Boolean> triple = MutableTriple.ofNonNull("test", 123, true);
        assertEquals("test", triple.getLeft());
        assertEquals(Integer.valueOf(123), triple.getMiddle());
        assertEquals(Boolean.TRUE, triple.getRight());
        
        // Test factory method with null values - should throw NullPointerException
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull(null, 123, true));
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull("test", null, true));
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull("test", 123, null));
    }

    @Test
    void testDefaultConstructor() {
        MutableTriple<String, Integer, Boolean> triple = new MutableTriple<>();
        assertNull(triple.getLeft());
        assertNull(triple.getMiddle());
        assertNull(triple.getRight());
    }

    @Test
    void testParameterizedConstructor() {
        MutableTriple<String, Integer, Boolean> triple = new MutableTriple<>("test", 123, true);
        assertEquals("test", triple.getLeft());
        assertEquals(Integer.valueOf(123), triple.getMiddle());
        assertEquals(Boolean.TRUE, triple.getRight());
    }

    @Test
    void testGettersAndSetters() {
        MutableTriple<String, Integer, Boolean> triple = new MutableTriple<>();
        
        // Test setters
        triple.setLeft("test");
        triple.setMiddle(123);
        triple.setRight(true);
        
        // Test getters
        assertEquals("test", triple.getLeft());
        assertEquals(Integer.valueOf(123), triple.getMiddle());
        assertEquals(Boolean.TRUE, triple.getRight());
        
        // Test changing values
        triple.setLeft("new test");
        triple.setMiddle(456);
        triple.setRight(false);
        
        assertEquals("new test", triple.getLeft());
        assertEquals(Integer.valueOf(456), triple.getMiddle());
        assertEquals(Boolean.FALSE, triple.getRight());
    }

    @Test
    void testMutability() {
        MutableTriple<StringBuilder, Integer, Boolean> triple = 
            new MutableTriple<>(new StringBuilder("test"), 123, true);
        
        // Test mutable left object
        triple.getLeft().append(" modified");
        assertEquals("test modified", triple.getLeft().toString());
        
        // Test changing references
        triple.setLeft(new StringBuilder("new test"));
        triple.setMiddle(456);
        triple.setRight(false);
        
        assertEquals("new test", triple.getLeft().toString());
        assertEquals(Integer.valueOf(456), triple.getMiddle());
        assertEquals(Boolean.FALSE, triple.getRight());
    }

    @Test
    void testToString() {
        MutableTriple<String, Integer, Boolean> triple = MutableTriple.of("test", 123, true);
        assertEquals("(test,123,true)", triple.toString());
        
        MutableTriple<String, Integer, Boolean> nullTriple = MutableTriple.of(null, null, null);
        assertEquals("(null,null,null)", nullTriple.toString());
    }

    @Test
    void testEquals() {
        MutableTriple<String, Integer, Boolean> triple1 = MutableTriple.of("test", 123, true);
        MutableTriple<String, Integer, Boolean> triple2 = MutableTriple.of("test", 123, true);
        MutableTriple<String, Integer, Boolean> triple3 = MutableTriple.of("different", 456, false);
        
        // Test equality
        assertTrue(triple1.equals(triple1)); // same object
        assertTrue(triple1.equals(triple2)); // equal objects
        assertFalse(triple1.equals(triple3)); // different objects
        assertFalse(triple1.equals(null)); // null
        assertFalse(triple1.equals("not a triple")); // different type
        
        // Test with null values
        MutableTriple<String, Integer, Boolean> tripleWithNulls1 = MutableTriple.of(null, null, null);
        MutableTriple<String, Integer, Boolean> tripleWithNulls2 = MutableTriple.of(null, null, null);
        assertTrue(tripleWithNulls1.equals(tripleWithNulls2));
    }

    @Test
    void testHashCode() {
        MutableTriple<String, Integer, Boolean> triple1 = MutableTriple.of("test", 123, true);
        MutableTriple<String, Integer, Boolean> triple2 = MutableTriple.of("test", 123, true);
        MutableTriple<String, Integer, Boolean> triple3 = MutableTriple.of("different", 456, false);
        
        // Equal objects should have equal hash codes
        assertEquals(triple1.hashCode(), triple2.hashCode());
        
        // Different objects should have different hash codes
        assertNotEquals(triple1.hashCode(), triple3.hashCode());
        
        // Test with null values
        MutableTriple<String, Integer, Boolean> tripleWithNulls1 = MutableTriple.of(null, null, null);
        MutableTriple<String, Integer, Boolean> tripleWithNulls2 = MutableTriple.of(null, null, null);
        assertEquals(tripleWithNulls1.hashCode(), tripleWithNulls2.hashCode());
    }

    @Test
    void testCompareTo() {
        MutableTriple<String, Integer, Boolean> triple1 = MutableTriple.of("a", 1, true);
        MutableTriple<String, Integer, Boolean> triple2 = MutableTriple.of("b", 2, false);
        
        // Test natural ordering
        assertTrue(triple1.compareTo(triple2) < 0);
        assertTrue(triple2.compareTo(triple1) > 0);
        assertEquals(0, triple1.compareTo(triple1));
        
        // Test with null values
        MutableTriple<String, Integer, Boolean> tripleWithNulls = MutableTriple.of(null, null, null);
        assertTrue(tripleWithNulls.compareTo(triple1) < 0);
        assertTrue(triple1.compareTo(tripleWithNulls) > 0);
    }
} 