package org.apache.commons.lang3.builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompareToBuilderCopilotTest {

    @Test
    void testAppendBoolean() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, false);
        assertTrue(builder.toComparison() > 0);
    }

    @Test
    void testAppendBooleanArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new boolean[]{true, false}, new boolean[]{true, true});
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendByte() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append((byte) 1, (byte) 2);
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendByteArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new byte[]{1, 2}, new byte[]{1, 3});
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendChar() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append('a', 'b');
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendCharArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new char[]{'a', 'b'}, new char[]{'a', 'c'});
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendDouble() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1.0, 2.0);
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendDoubleArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new double[]{1.0, 2.0}, new double[]{1.0, 3.0});
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendFloat() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1.0f, 2.0f);
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendFloatArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new float[]{1.0f, 2.0f}, new float[]{1.0f, 3.0f});
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendInt() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1, 2);
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendIntArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new int[]{1, 2}, new int[]{1, 3});
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendLong() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1L, 2L);
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendLongArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new long[]{1L, 2L}, new long[]{1L, 3L});
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendObject() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append("a", "b");
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendObjectArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new String[]{"a", "b"}, new String[]{"a", "c"});
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendShort() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append((short) 1, (short) 2);
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendShortArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new short[]{1, 2}, new short[]{1, 3});
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testAppendSuper() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.appendSuper(-1);
        assertTrue(builder.toComparison() < 0);
    }

    @Test
    void testReflectionCompare() {
        class TestClass {
            int a;
            String b;

            TestClass(int a, String b) {
                this.a = a;
                this.b = b;
            }
        }

        TestClass obj1 = new TestClass(1, "a");
        TestClass obj2 = new TestClass(2, "b");
        assertTrue(CompareToBuilder.reflectionCompare(obj1, obj2) < 0);
    }
}