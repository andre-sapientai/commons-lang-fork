package org.apache.commons.lang3.tuple;

import java.util.Arrays;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class MutableTripleBaseRockGeneratedFtcgTest {

    //BaseRock generated method id: ${testEmptyArray}, hash: 35D08CFFDC9E5B5E368F366A1471EDC8
    @Test
    void testEmptyArray() {
        MutableTriple<?, ?, ?>[] emptyArray = MutableTriple.emptyArray();
        assertEquals(0, emptyArray.length);
    }

    //BaseRock generated method id: ${testOf}, hash: 4B06B1BC1A2A1B4574D96F23EEB3174D
    @Test
    void testOf() {
        MutableTriple<String, Integer, Double> triple = MutableTriple.of("Left", 10, 3.14);
        assertEquals("Left", triple.getLeft());
        assertEquals(10, triple.getMiddle());
        assertEquals(3.14, triple.getRight());
    }

    //BaseRock generated method id: ${testOfNonNull}, hash: 030241A5BEC0326109E53C7C8AA22647
    @Test
    void testOfNonNull() {
        MutableTriple<String, Integer, Double> triple = MutableTriple.ofNonNull("Left", 10, 3.14);
        assertEquals("Left", triple.getLeft());
        assertEquals(10, triple.getMiddle());
        assertEquals(3.14, triple.getRight());
    }

    //BaseRock generated method id: ${testOfNonNullWithNullValues}, hash: 07D7ED3FA1C71FC640B865C73549C0ED
    @Test
    void testOfNonNullWithNullValues() {
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull(null, 10, 3.14));
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull("Left", null, 3.14));
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull("Left", 10, null));
    }

    //BaseRock generated method id: ${testDefaultConstructor}, hash: 11E0A0C68675E40D4FF736A6396F8262
    @Test
    void testDefaultConstructor() {
        MutableTriple<String, Integer, Double> triple = new MutableTriple<>();
        assertNull(triple.getLeft());
        assertNull(triple.getMiddle());
        assertNull(triple.getRight());
    }

    //BaseRock generated method id: ${testParameterizedConstructor}, hash: 43B00679D90FC3F98D2D455A5A850838
    @Test
    void testParameterizedConstructor() {
        MutableTriple<String, Integer, Double> triple = new MutableTriple<>("Left", 10, 3.14);
        assertEquals("Left", triple.getLeft());
        assertEquals(10, triple.getMiddle());
        assertEquals(3.14, triple.getRight());
    }

    //BaseRock generated method id: ${testGetters}, hash: 055A5751A630C194450DB002B54A48DE
    @Test
    void testGetters() {
        MutableTriple<String, Integer, Double> triple = new MutableTriple<>("Left", 10, 3.14);
        assertEquals("Left", triple.getLeft());
        assertEquals(10, triple.getMiddle());
        assertEquals(3.14, triple.getRight());
    }

    //BaseRock generated method id: ${testSetters}, hash: 9A874B55AB89CB21D280B161E332DE2B
    @Test
    void testSetters() {
        MutableTriple<String, Integer, Double> triple = new MutableTriple<>();
        triple.setLeft("New Left");
        triple.setMiddle(20);
        triple.setRight(6.28);
        assertEquals("New Left", triple.getLeft());
        assertEquals(20, triple.getMiddle());
        assertEquals(6.28, triple.getRight());
    }

    //BaseRock generated method id: ${testSettersWithDifferentValues}, hash: 1637457D34C995891BB11192EF9A6F28
    @ParameterizedTest
    @CsvSource({ "Left, 10, 3.14, NewLeft, 10, 3.14", "Left, 10, 3.14, Left, 20, 3.14", "Left, 10, 3.14, Left, 10, 6.28" })
    void testSettersWithDifferentValues(String initialLeft, int initialMiddle, double initialRight, String newLeft, int newMiddle, double newRight) {
        MutableTriple<String, Integer, Double> triple = new MutableTriple<>(initialLeft, initialMiddle, initialRight);
        triple.setLeft(newLeft);
        triple.setMiddle(newMiddle);
        triple.setRight(newRight);
        assertEquals(newLeft, triple.getLeft());
        assertEquals(newMiddle, triple.getMiddle());
        assertEquals(newRight, triple.getRight());
    }

    //BaseRock generated method id: ${testToString}, hash: 5050E4680846F5D487FB487718908635
    @Test
    void testToString() {
        MutableTriple<String, Integer, Double> triple = new MutableTriple<>("Left", 10, 3.14);
        assertEquals("(Left,10,3.14)", triple.toString());
    }

    //BaseRock generated method id: ${testCompareTo}, hash: F7F03A04A19CD56DF137ACF10924AE50
    @Test
    void testCompareTo() {
        MutableTriple<String, Integer, Double> triple1 = new MutableTriple<>("A", 1, 1.0);
        MutableTriple<String, Integer, Double> triple2 = new MutableTriple<>("B", 2, 2.0);
        MutableTriple<String, Integer, Double> triple3 = new MutableTriple<>("A", 1, 1.0);
        assertTrue(triple1.compareTo(triple2) < 0);
        assertTrue(triple2.compareTo(triple1) > 0);
        assertEquals(0, triple1.compareTo(triple3));
    }

    //BaseRock generated method id: ${testEquals}, hash: 7C77433413733F461FBF42B4BAA3D2B2
    @Test
    void testEquals() {
        MutableTriple<String, Integer, Double> triple1 = new MutableTriple<>("Left", 10, 3.14);
        MutableTriple<String, Integer, Double> triple2 = new MutableTriple<>("Left", 10, 3.14);
        MutableTriple<String, Integer, Double> triple3 = new MutableTriple<>("Right", 20, 6.28);
        assertEquals(triple1, triple2);
        assertNotEquals(triple1, triple3);
        assertNotEquals(triple1, null);
        assertNotEquals(triple1, "Not a triple");
    }

    //BaseRock generated method id: ${testHashCode}, hash: A4AAF42339A48A7E569DF02CEC8DD873
    @Test
    void testHashCode() {
        MutableTriple<String, Integer, Double> triple1 = new MutableTriple<>("Left", 10, 3.14);
        MutableTriple<String, Integer, Double> triple2 = new MutableTriple<>("Left", 10, 3.14);
        MutableTriple<String, Integer, Double> triple3 = new MutableTriple<>("Right", 20, 6.28);
        assertEquals(triple1.hashCode(), triple2.hashCode());
        assertNotEquals(triple1.hashCode(), triple3.hashCode());
    }

    //BaseRock generated method id: ${testEmptyArrayConstant}, hash: 1848495E0D05AFC70753EB1DD4500D6C
    @Test
    void testEmptyArrayConstant() {
        assertEquals(0, MutableTriple.EMPTY_ARRAY.length);
        assertTrue(Arrays.equals(new MutableTriple[0], MutableTriple.EMPTY_ARRAY));
    }
}
