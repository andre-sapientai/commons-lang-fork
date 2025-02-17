package org.apache.commons.lang3.reflect;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ConstructorUtilsCursorTest {

    // Test classes
    private static class TestClass {
        private final String value;
        private final int number;

        public TestClass() {
            this.value = "default";
            this.number = 0;
        }

        public TestClass(String value) {
            this.value = value;
            this.number = 0;
        }

        public TestClass(String value, int number) {
            this.value = value;
            this.number = number;
        }

        public String getValue() {
            return value;
        }

        public int getNumber() {
            return number;
        }
    }

    private static class PrivateClass {
        private PrivateClass() {}
    }

    @Test
    void testGetAccessibleConstructor() {
        Constructor<TestClass> constructor = ConstructorUtils.getAccessibleConstructor(
            TestClass.class, String.class, int.class);
        
        assertNotNull(constructor);
        assertEquals(2, constructor.getParameterCount());
    }

    @Test
    void testGetAccessibleConstructorWithNonexistentConstructor() {
        Constructor<TestClass> constructor = ConstructorUtils.getAccessibleConstructor(
            TestClass.class, Double.class);
        
        assertNull(constructor);
    }

    @Test
    void testGetMatchingAccessibleConstructor() {
        Constructor<TestClass> constructor = ConstructorUtils.getMatchingAccessibleConstructor(
            TestClass.class, String.class, Integer.TYPE);
        
        assertNotNull(constructor);
        assertEquals(2, constructor.getParameterCount());
    }

    @Test
    void testInvokeConstructor() throws Exception {
        TestClass instance = ConstructorUtils.invokeConstructor(
            TestClass.class, "test", 42);
        
        assertNotNull(instance);
        assertEquals("test", instance.getValue());
        assertEquals(42, instance.getNumber());
    }

    @Test
    void testInvokeConstructorWithNullArgs() throws Exception {
        TestClass instance = ConstructorUtils.invokeConstructor(TestClass.class, (Object[]) null);
        
        assertNotNull(instance);
        assertEquals("default", instance.getValue());
        assertEquals(0, instance.getNumber());
    }

    @Test
    void testInvokeExactConstructor() throws Exception {
        TestClass instance = ConstructorUtils.invokeExactConstructor(
            TestClass.class, "test", 42);
        
        assertNotNull(instance);
        assertEquals("test", instance.getValue());
        assertEquals(42, instance.getNumber());
    }

    @Test
    void testInvokeConstructorWithNoSuchMethod() {
        assertThrows(NoSuchMethodException.class, () -> 
            ConstructorUtils.invokeConstructor(TestClass.class, 42.0));
    }

    @Test
    void testPrivateConstructor() {
        assertThrows(NoSuchMethodException.class, () ->
            ConstructorUtils.invokeConstructor(PrivateClass.class));
    }

    @Test
    void testNullClass() {
        assertThrows(NullPointerException.class, () ->
            ConstructorUtils.getAccessibleConstructor(null));
    }
} 