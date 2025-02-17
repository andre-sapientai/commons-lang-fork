package org.apache.commons.lang3.function;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.MockedStatic;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.Callable;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class FailableCopilotTest {

    @Test
    void testAccept() throws Throwable {
        FailableConsumer<Object, Throwable> consumer = mock(FailableConsumer.class);
        Object obj = new Object();
        Failable.accept(consumer, obj);
        verify(consumer).accept(obj);
    }

    @Test
    void testApply() throws Throwable {
        FailableFunction<Object, Object, Throwable> function = mock(FailableFunction.class);
        Object obj = new Object();
        when(function.apply(obj)).thenReturn(obj);
        assertEquals(obj, Failable.apply(function, obj));
    }

    @Test
    void testGet() throws Throwable {
        FailableSupplier<Object, Throwable> supplier = mock(FailableSupplier.class);
        Object obj = new Object();
        when(supplier.get()).thenReturn(obj);
        assertEquals(obj, Failable.get(supplier));
    }

    @Test
    void testRun() throws Throwable {
        FailableRunnable<Throwable> runnable = mock(FailableRunnable.class);
        Failable.run(runnable);
        verify(runnable).run();
    }

    @Test
    void testTryWithResources() throws Throwable {
        FailableRunnable<Throwable> action = mock(FailableRunnable.class);
        FailableRunnable<Throwable> resource = mock(FailableRunnable.class);
        Failable.tryWithResources(action, resource);
        verify(action).run();
        verify(resource).run();
    }

    @Test
    void testRethrow() {
        Throwable throwable = new Throwable();
        assertThrows(UndeclaredThrowableException.class, () -> Failable.rethrow(throwable));
    }

    @Test
    void testRethrowIOException() {
        IOException ioException = new IOException();
        assertThrows(UncheckedIOException.class, () -> Failable.rethrow(ioException));
    }

    @Test
    void testAsFunction() {
        FailableFunction<Object, Object, Throwable> failableFunction = FailableFunction.identity();
        Function<Object, Object> function = Failable.asFunction(failableFunction);
        assertNotNull(function);
    }

    @Test
    void testAsConsumer() {
        FailableConsumer<Object, Throwable> failableConsumer = FailableConsumer.nop();
        Consumer<Object> consumer = Failable.asConsumer(failableConsumer);
        assertNotNull(consumer);
    }

    /*@Test
    void testAsSupplier() {
        FailableSupplier<Object, Throwable> failableSupplier = new FailableSupplier();
        Supplier<Object> supplier = Failable.asSupplier(failableSupplier);
        assertNotNull(supplier);
    }*/

    @Test
    void testAsRunnable() {
        FailableRunnable<Throwable> failableRunnable = mock(FailableRunnable.class);
        Runnable runnable = Failable.asRunnable(failableRunnable);
        assertNotNull(runnable);
    }

    @Test
    void testAsCallable() {
        FailableCallable<Object, Throwable> failableCallable = mock(FailableCallable.class);
        Callable<Object> callable = Failable.asCallable(failableCallable);
        assertNotNull(callable);
    }
}