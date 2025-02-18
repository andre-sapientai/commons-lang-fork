package org.apache.commons.lang3.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Comparator;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.junit.jupiter.api.Disabled;

class CompareToBuilderBaseRockGeneratedFtcgTest {

    private CompareToBuilder compareToBuilder;

    @BeforeEach
    void setUp() {
        compareToBuilder = new CompareToBuilder();
    }

    //BaseRock generated method id: ${testAppendBoolean}, hash: 376521A4C126588E932623B3A986EA3D
    @Test
    void testAppendBoolean() {
        assertEquals(0, compareToBuilder.append(true, true).toComparison());
        assertEquals(1, compareToBuilder.append(true, false).toComparison());
        assertEquals(-1, compareToBuilder.append(false, true).toComparison());
    }

    //BaseRock generated method id: ${testAppendBooleanArray}, hash: 06C1475D4CD05B3426C94CF8D1D9F2D4
    @Test
    void testAppendBooleanArray() {
        boolean[] arr1 = { true, false, true };
        boolean[] arr2 = { true, false, true };
        boolean[] arr3 = { true, true, false };
        boolean[] arr4 = { true, false };
        assertEquals(0, compareToBuilder.append(arr1, arr2).toComparison());
        assertEquals(-1, compareToBuilder.append(arr1, arr3).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, arr4).toComparison());
        assertEquals(-1, compareToBuilder.append(null, arr1).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, null).toComparison());
        assertEquals(0, compareToBuilder.append((boolean[]) null, null).toComparison());
    }

    //BaseRock generated method id: ${testAppendByte}, hash: 3F2D1A00BE1CCC88D0CA28E14332E0F1
    @ParameterizedTest
    @CsvSource({ "1, 2, -1", "2, 1, 1", "1, 1, 0" })
    void testAppendByte(byte lhs, byte rhs, int expected) {
        assertEquals(expected, compareToBuilder.append(lhs, rhs).toComparison());
    }

    //BaseRock generated method id: ${testAppendByteArray}, hash: BEC6B80D78673E732B84F6694AA551AC
    @Test
    void testAppendByteArray() {
        byte[] arr1 = { 1, 2, 3 };
        byte[] arr2 = { 1, 2, 3 };
        byte[] arr3 = { 1, 3, 2 };
        byte[] arr4 = { 1, 2 };
        assertEquals(0, compareToBuilder.append(arr1, arr2).toComparison());
        assertEquals(-1, compareToBuilder.append(arr1, arr3).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, arr4).toComparison());
        assertEquals(-1, compareToBuilder.append(null, arr1).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, null).toComparison());
        assertEquals(0, compareToBuilder.append((byte[]) null, null).toComparison());
    }

    //BaseRock generated method id: ${testAppendChar}, hash: 44FF8B42C23B956FE3D651908F322641
    @ParameterizedTest
    @CsvSource({ "a, b, -1", "b, a, 1", "a, a, 0" })
    void testAppendChar(char lhs, char rhs, int expected) {
        assertEquals(expected, compareToBuilder.append(lhs, rhs).toComparison());
    }

    //BaseRock generated method id: ${testAppendCharArray}, hash: 77A9CA6CC6D9B5773E084934CF8C6D0C
    @Test
    void testAppendCharArray() {
        char[] arr1 = { 'a', 'b', 'c' };
        char[] arr2 = { 'a', 'b', 'c' };
        char[] arr3 = { 'a', 'c', 'b' };
        char[] arr4 = { 'a', 'b' };
        assertEquals(0, compareToBuilder.append(arr1, arr2).toComparison());
        assertEquals(-1, compareToBuilder.append(arr1, arr3).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, arr4).toComparison());
        assertEquals(-1, compareToBuilder.append(null, arr1).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, null).toComparison());
        assertEquals(0, compareToBuilder.append((char[]) null, null).toComparison());
    }

    //BaseRock generated method id: ${testAppendDouble}, hash: F76E2DD7A372FC997071135BDF4FF8DC
    @ParameterizedTest
    @CsvSource({ "1.0, 2.0, -1", "2.0, 1.0, 1", "1.0, 1.0, 0" })
    void testAppendDouble(double lhs, double rhs, int expected) {
        assertEquals(expected, compareToBuilder.append(lhs, rhs).toComparison());
    }

    //BaseRock generated method id: ${testAppendDoubleArray}, hash: 865F56E1B145BF7B31A0B17F6539E9A4
    @Test
    void testAppendDoubleArray() {
        double[] arr1 = { 1.0, 2.0, 3.0 };
        double[] arr2 = { 1.0, 2.0, 3.0 };
        double[] arr3 = { 1.0, 3.0, 2.0 };
        double[] arr4 = { 1.0, 2.0 };
        assertEquals(0, compareToBuilder.append(arr1, arr2).toComparison());
        assertEquals(-1, compareToBuilder.append(arr1, arr3).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, arr4).toComparison());
        assertEquals(-1, compareToBuilder.append(null, arr1).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, null).toComparison());
        assertEquals(0, compareToBuilder.append((double[]) null, null).toComparison());
    }

    //BaseRock generated method id: ${testAppendFloat}, hash: 89DD9CF25C25FA379FE1DBF597695DB7
    @ParameterizedTest
    @CsvSource({ "1.0, 2.0, -1", "2.0, 1.0, 1", "1.0, 1.0, 0" })
    void testAppendFloat(float lhs, float rhs, int expected) {
        assertEquals(expected, compareToBuilder.append(lhs, rhs).toComparison());
    }

    //BaseRock generated method id: ${testAppendFloatArray}, hash: 6F7893CE9A897540412AA915E4F4B010
    @Test
    void testAppendFloatArray() {
        float[] arr1 = { 1.0f, 2.0f, 3.0f };
        float[] arr2 = { 1.0f, 2.0f, 3.0f };
        float[] arr3 = { 1.0f, 3.0f, 2.0f };
        float[] arr4 = { 1.0f, 2.0f };
        assertEquals(0, compareToBuilder.append(arr1, arr2).toComparison());
        assertEquals(-1, compareToBuilder.append(arr1, arr3).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, arr4).toComparison());
        assertEquals(-1, compareToBuilder.append(null, arr1).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, null).toComparison());
        assertEquals(0, compareToBuilder.append((float[]) null, null).toComparison());
    }

    //BaseRock generated method id: ${testAppendInt}, hash: E559F2A9C96285C5A529BCA8E9990EF3
    @ParameterizedTest
    @CsvSource({ "1, 2, -1", "2, 1, 1", "1, 1, 0" })
    void testAppendInt(int lhs, int rhs, int expected) {
        assertEquals(expected, compareToBuilder.append(lhs, rhs).toComparison());
    }

    //BaseRock generated method id: ${testAppendIntArray}, hash: 8FFB25251A564B8542BF4B67429B0D6D
    @Test
    void testAppendIntArray() {
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 1, 2, 3 };
        int[] arr3 = { 1, 3, 2 };
        int[] arr4 = { 1, 2 };
        assertEquals(0, compareToBuilder.append(arr1, arr2).toComparison());
        assertEquals(-1, compareToBuilder.append(arr1, arr3).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, arr4).toComparison());
        assertEquals(-1, compareToBuilder.append(null, arr1).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, null).toComparison());
        assertEquals(0, compareToBuilder.append((int[]) null, null).toComparison());
    }

    //BaseRock generated method id: ${testAppendLong}, hash: 80A5AEF2C70BC45BF56023B39F16D4A2
    @ParameterizedTest
    @CsvSource({ "1, 2, -1", "2, 1, 1", "1, 1, 0" })
    void testAppendLong(long lhs, long rhs, int expected) {
        assertEquals(expected, compareToBuilder.append(lhs, rhs).toComparison());
    }

    //BaseRock generated method id: ${testAppendLongArray}, hash: 1C82877E0ABD063D7341BB9C582889F4
    @Test
    void testAppendLongArray() {
        long[] arr1 = { 1L, 2L, 3L };
        long[] arr2 = { 1L, 2L, 3L };
        long[] arr3 = { 1L, 3L, 2L };
        long[] arr4 = { 1L, 2L };
        assertEquals(0, compareToBuilder.append(arr1, arr2).toComparison());
        assertEquals(-1, compareToBuilder.append(arr1, arr3).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, arr4).toComparison());
        assertEquals(-1, compareToBuilder.append(null, arr1).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, null).toComparison());
        assertEquals(0, compareToBuilder.append((long[]) null, null).toComparison());
    }

    //BaseRock generated method id: ${testAppendObject}, hash: 9EE8A34EFD53E5E150EF853A71AE1A89
    @Test
    void testAppendObject() {
        String str1 = "abc";
        String str2 = "def";
        assertEquals(-1, compareToBuilder.append(str1, str2).toComparison());
        assertEquals(1, compareToBuilder.append(str2, str1).toComparison());
        assertEquals(0, compareToBuilder.append(str1, str1).toComparison());
        assertEquals(-1, compareToBuilder.append(null, str1).toComparison());
        assertEquals(1, compareToBuilder.append(str1, null).toComparison());
        assertEquals(0, compareToBuilder.append((Object) null, null).toComparison());
    }

    //BaseRock generated method id: ${testAppendObjectWithComparator}, hash: B85DA9696585D4046ED41DC8DF6491D8
    @Test
    void testAppendObjectWithComparator() {
        String str1 = "abc";
        String str2 = "def";
        Comparator<String> comparator = String::compareTo;
        assertEquals(-1, compareToBuilder.append(str1, str2, comparator).toComparison());
        assertEquals(1, compareToBuilder.append(str2, str1, comparator).toComparison());
        assertEquals(0, compareToBuilder.append(str1, str1, comparator).toComparison());
        assertEquals(-1, compareToBuilder.append(null, str1, comparator).toComparison());
        assertEquals(1, compareToBuilder.append(str1, null, comparator).toComparison());
        assertEquals(0, compareToBuilder.append((Object) null, null, comparator).toComparison());
    }

    //BaseRock generated method id: ${testAppendObjectArray}, hash: B0B40F669490CF042D1156799C716C84
    @Test
    void testAppendObjectArray() {
        Object[] arr1 = { "a", "b", "c" };
        Object[] arr2 = { "a", "b", "c" };
        Object[] arr3 = { "a", "c", "b" };
        Object[] arr4 = { "a", "b" };
        assertEquals(0, compareToBuilder.append(arr1, arr2).toComparison());
        assertEquals(-1, compareToBuilder.append(arr1, arr3).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, arr4).toComparison());
        assertEquals(-1, compareToBuilder.append(null, arr1).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, null).toComparison());
        assertEquals(0, compareToBuilder.append((Object[]) null, null).toComparison());
    }

    //BaseRock generated method id: ${testAppendObjectArrayWithComparator}, hash: 26A4FD4991D1ADBEF507081D16F8011C
    @Test
    void testAppendObjectArrayWithComparator() {
        Object[] arr1 = { "a", "b", "c" };
        Object[] arr2 = { "a", "b", "c" };
        Object[] arr3 = { "a", "c", "b" };
        Object[] arr4 = { "a", "b" };
        Comparator<Object> comparator = (o1, o2) -> o1.toString().compareTo(o2.toString());
        assertEquals(0, compareToBuilder.append(arr1, arr2, comparator).toComparison());
        assertEquals(-1, compareToBuilder.append(arr1, arr3, comparator).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, arr4, comparator).toComparison());
        assertEquals(-1, compareToBuilder.append(null, arr1, comparator).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, null, comparator).toComparison());
        assertEquals(0, compareToBuilder.append((Object[]) null, null, comparator).toComparison());
    }

    //BaseRock generated method id: ${testAppendShort}, hash: 92091B8373895C217A18EC45440441FE
    @ParameterizedTest
    @CsvSource({ "1, 2, -1", "2, 1, 1", "1, 1, 0" })
    void testAppendShort(short lhs, short rhs, int expected) {
        assertEquals(expected, compareToBuilder.append(lhs, rhs).toComparison());
    }

    //BaseRock generated method id: ${testAppendShortArray}, hash: EF8EC312703CCD42BAE810D9B7BF6226
    @Test
    void testAppendShortArray() {
        short[] arr1 = { 1, 2, 3 };
        short[] arr2 = { 1, 2, 3 };
        short[] arr3 = { 1, 3, 2 };
        short[] arr4 = { 1, 2 };
        assertEquals(0, compareToBuilder.append(arr1, arr2).toComparison());
        assertEquals(-1, compareToBuilder.append(arr1, arr3).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, arr4).toComparison());
        assertEquals(-1, compareToBuilder.append(null, arr1).toComparison());
        assertEquals(1, compareToBuilder.append(arr1, null).toComparison());
        assertEquals(0, compareToBuilder.append((short[]) null, null).toComparison());
    }

    //BaseRock generated method id: ${testAppendSuper}, hash: 750DD60976F87B618725105739C529C7
    @Test
    void testAppendSuper() {
        assertEquals(0, compareToBuilder.appendSuper(0).toComparison());
        assertEquals(-1, compareToBuilder.appendSuper(-1).toComparison());
        assertEquals(1, compareToBuilder.appendSuper(1).toComparison());
    }

    //BaseRock generated method id: ${testBuild}, hash: 09B861CF846FF55A18E13ACAB50E85E5
    @Test
    void testBuild() {
        compareToBuilder.append(1, 2);
        assertEquals(Integer.valueOf(-1), compareToBuilder.build());
    }

    //BaseRock generated method id: ${testToComparison}, hash: D065037D61FE22A714042F6D86212500
    @Test
    void testToComparison() {
        compareToBuilder.append(1, 2);
        assertEquals(-1, compareToBuilder.toComparison());
    }

    //BaseRock generated method id: ${testReflectionCompare}, hash: A43807BF8A8C55792C8AC8F2F53C2EAB
    @Test
    void testReflectionCompare() throws Exception {
        TestObject o1 = new TestObject(1, "a");
        TestObject o2 = new TestObject(2, "b");
        TestObject o3 = new TestObject(1, "a");
        assertEquals(-1, CompareToBuilder.reflectionCompare(o1, o2));
        assertEquals(1, CompareToBuilder.reflectionCompare(o2, o1));
        assertEquals(0, CompareToBuilder.reflectionCompare(o1, o3));
    }

    //BaseRock generated method id: ${testReflectionCompareEx}, hash: 62204158C57466F9FAE7D930B092A7E7
    @Test
    void testReflectionCompareEx() {
        TestObject o1 = new TestObject(1, "a");
        Object o2 = new Object();
        assertThrows(ClassCastException.class, () -> CompareToBuilder.reflectionCompare(o1, o2));
    }

    private static class TestObject {

        private final int num;

        private final String str;

        TestObject(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }
}
