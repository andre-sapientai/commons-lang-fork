package org.apache.commons.lang3.builder;

//Here is a test class for the `EqualsBuilder` class. This test class covers various scenarios to ensure the `EqualsBuilder` works as expected.
// File: src/test/java/org/apache/commons/lang3/builder/EqualsBuilderTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class EqualsBuilderCopilotTest {

    @Test
    void testAppendBoolean() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(true, false);
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendBooleanArray() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(new boolean[]{true, false}, new boolean[]{true, true});
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendByte() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append((byte) 1, (byte) 2);
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendByteArray() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(new byte[]{1, 2}, new byte[]{1, 3});
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendChar() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append('a', 'b');
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendCharArray() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(new char[]{'a', 'b'}, new char[]{'a', 'c'});
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendDouble() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(1.0, 2.0);
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendDoubleArray() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(new double[]{1.0, 2.0}, new double[]{1.0, 3.0});
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendFloat() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(1.0f, 2.0f);
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendFloatArray() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(new float[]{1.0f, 2.0f}, new float[]{1.0f, 3.0f});
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendInt() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(1, 2);
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendIntArray() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(new int[]{1, 2}, new int[]{1, 3});
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendLong() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(1L, 2L);
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendLongArray() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(new long[]{1L, 2L}, new long[]{1L, 3L});
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendObject() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append("a", "b");
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendObjectArray() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(new String[]{"a", "b"}, new String[]{"a", "c"});
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendShort() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append((short) 1, (short) 2);
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendShortArray() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(new short[]{1, 2}, new short[]{1, 3});
        assertFalse(builder.isEquals());
    }

    @Test
    void testAppendSuper() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.appendSuper(false);
        assertFalse(builder.isEquals());
    }

    @Test
    void testReflectionEquals() {
        class TestClass {
            int a;
            String b;

            TestClass(int a, String b) {
                this.a = a;
                this.b = b;
            }
        }

        TestClass obj1 = new TestClass(1, "a");
        TestClass obj2 = new TestClass(1, "a");
        TestClass obj3 = new TestClass(2, "b");

        assertTrue(EqualsBuilder.reflectionEquals(obj1, obj2));
        assertFalse(EqualsBuilder.reflectionEquals(obj1, obj3));
    }

    @Test
    void testSetBypassReflectionClasses() {
        EqualsBuilder builder = new EqualsBuilder();
        List<Class<?>> classes = new ArrayList<>();
        classes.add(String.class);
        builder.setBypassReflectionClasses(classes);
        assertEquals(classes, builder.setBypassReflectionClasses(classes).bypassReflectionClasses);
    }

    @Test
    void testSetEquals() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.setEquals(false);
        assertFalse(builder.isEquals());
    }

    @Test
    void testSetExcludeFields() {
        EqualsBuilder builder = new EqualsBuilder();
        String[] fields = {"field1", "field2"};
        builder.setExcludeFields(fields);
        assertArrayEquals(fields, builder.setExcludeFields(fields).excludeFields);
    }

    @Test
    void testSetReflectUpToClass() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.setReflectUpToClass(Object.class);
        assertEquals(Object.class, builder.setReflectUpToClass(Object.class).reflectUpToClass);
    }

    @Test
    void testSetTestRecursive() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.setTestRecursive(true);
        assertTrue(builder.setTestRecursive(true).testRecursive);
    }

    @Test
    void testSetTestTransients() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.setTestTransients(true);
        assertTrue(builder.setTestTransients(true).testTransients);
    }
}
