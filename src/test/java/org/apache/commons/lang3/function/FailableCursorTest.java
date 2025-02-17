package org.apache.commons.lang3.function;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class FailableCursorTest {

    @Test
    void testAccept() {
        final List<Integer> list = new ArrayList<>();
        // Test successful consumer
        Failable.accept((Integer i) -> list.add(i), 1);
        assertEquals(Arrays.asList(1), list);

        // Test null consumer
        assertDoesNotThrow(() -> Failable.accept((FailableConsumer<Integer, Throwable>) null, 1));
    }

    @Test
    void testAcceptBiConsumer() {
        final List<String> list = new ArrayList<>();
        // Test successful bi-consumer
        Failable.accept((Integer i, String s) -> list.add(s + i), 1, "Number: ");
        assertEquals(Arrays.asList("Number: 1"), list);

        // Test null bi-consumer
        assertDoesNotThrow(() -> Failable.accept((FailableBiConsumer<Integer, String, Throwable>) null, 1, "Test"));
    }

    @Test
    void testApply() {
        // Test successful function
        assertEquals(2, Failable.apply((Integer i) -> i + 1, 1));

        // Test function throwing checked exception
        assertThrows(UndeclaredThrowableException.class, 
            () -> Failable.apply((Integer i) -> { throw new Exception("test"); }, 1));
    }

    @Test
    void testApplyBiFunction() {
        // Test successful bi-function
        assertEquals(3, Failable.apply((Integer i, Integer j) -> i + j, 1, 2));

        // Test bi-function throwing checked exception
        assertThrows(UndeclaredThrowableException.class, 
            () -> Failable.apply((Integer i, Integer j) -> { throw new Exception("test"); }, 1, 2));
    }

    @Test
    void testAsBiConsumer() {
        final List<String> list = new ArrayList<>();
        // Convert FailableBiConsumer to BiConsumer
        Failable.asBiConsumer((Integer i, String s) -> list.add(s + i)).accept(1, "Number: ");
        assertEquals(Arrays.asList("Number: 1"), list);
    }

    @Test
    void testAsConsumer() {
        final List<Integer> list = new ArrayList<>();
        // Convert FailableConsumer to Consumer
        Failable.asConsumer((Integer i) -> list.add(i)).accept(1);
        assertEquals(Arrays.asList(1), list);
    }

    @Test
    void testAsFunction() {
        // Convert FailableFunction to Function
        assertEquals(2, Failable.asFunction((Integer i) -> i + 1).apply(1));
    }

    @Test
    void testAsBiFunction() {
        // Convert FailableBiFunction to BiFunction
        assertEquals(3, Failable.asBiFunction((Integer i, Integer j) -> i + j).apply(1, 2));
    }

    @Test
    void testAsRunnable() {
        final AtomicReference<String> value = new AtomicReference<>();
        // Convert FailableRunnable to Runnable
        Failable.asRunnable(() -> value.set("executed")).run();
        assertEquals("executed", value.get());
    }

    @Test
    void testAsSupplier() {
        // Convert FailableSupplier to Supplier
        assertEquals("test", Failable.asSupplier(() -> "test").get());
    }

    @Test
    void testRethrow() {
        // Test rethrowing RuntimeException
        RuntimeException runtimeEx = new RuntimeException("test");
        assertThrows(RuntimeException.class, () -> Failable.rethrow(runtimeEx));

        // Test rethrowing IOException as UncheckedIOException
        IOException ioEx = new IOException("test");
        assertThrows(UncheckedIOException.class, () -> Failable.rethrow(ioEx));

        // Test rethrowing checked Exception as UndeclaredThrowableException
        Exception checkedException = new Exception("test");
        assertThrows(UndeclaredThrowableException.class, () -> Failable.rethrow(checkedException));
    }

    @Test
    void testTryWithResources() {
        final List<String> executionOrder = new ArrayList<>();
        
        // Test successful execution
        Failable.tryWithResources(
            () -> executionOrder.add("action"),
            () -> executionOrder.add("resource1"),
            () -> executionOrder.add("resource2")
        );
        assertEquals(Arrays.asList("action", "resource1", "resource2"), executionOrder);

        // Test with exception in action
        executionOrder.clear();
        assertThrows(UndeclaredThrowableException.class, () ->
            Failable.tryWithResources(
                () -> { throw new Exception("action failed"); },
                () -> executionOrder.add("resource1"),
                () -> executionOrder.add("resource2")
            )
        );
        assertEquals(Arrays.asList("resource1", "resource2"), executionOrder);

        // Test with custom error handler
        executionOrder.clear();
        final AtomicReference<Throwable> caughtException = new AtomicReference<>();
        Failable.tryWithResources(
            () -> { throw new Exception("test"); },
            (ex) -> caughtException.set(ex),
            () -> executionOrder.add("resource")
        );
        assertNotNull(caughtException.get());
        assertEquals("test", caughtException.get().getMessage());
        assertEquals(Arrays.asList("resource"), executionOrder);
    }

    @Test
    void testStream() {
        // Test stream operations
        List<Integer> result = new ArrayList<>();
        Failable.stream(Arrays.asList(1, 2, 3))
            .filter(i -> i > 1)
            .forEach(result::add);
        assertEquals(Arrays.asList(2, 3), result);

        // Test stream with exception
        assertThrows(UndeclaredThrowableException.class, () ->
            Failable.stream(Arrays.asList(1, 2, 3))
                .filter(i -> { throw new Exception("test"); })
                .forEach(result::add)
        );
    }

    @Test
    void testNullChecks() {
        // Test null checks for various methods
        assertThrows(NullPointerException.class, () -> Failable.rethrow(null));
        
        assertDoesNotThrow(() -> Failable.run(null));
        assertDoesNotThrow(() -> Failable.accept(null, "test"));
        assertDoesNotThrow(() -> Failable.accept(null, 1, "test"));
    }
} 