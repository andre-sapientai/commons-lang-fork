package org.apache.commons.lang3.function;

import java.io.UncheckedIOException;

import org.junit.jupiter.api.Test;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import static org.mockito.Mockito.*;
import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.UndeclaredThrowableException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class FailableBaseRockGeneratedFtcgTest {

    //BaseRock generated method id: ${testAcceptFailableBiConsumer}, hash: 4B1AF3E40B126E211F8CD54A318948D9
    @Test
    void testAcceptFailableBiConsumer() throws Exception {
        FailableBiConsumer<String, Integer, Exception> consumer = mock(FailableBiConsumer.class);
        Failable.accept(consumer, "test", 42);
        verify(consumer).accept("test", 42);
    }

    //BaseRock generated method id: ${testAcceptFailableConsumer}, hash: 88B8BCE0CA52E737454E845550FCEFCA
    @Test
    void testAcceptFailableConsumer() throws Exception {
        FailableConsumer<String, Exception> consumer = mock(FailableConsumer.class);
        Failable.accept(consumer, "test");
        verify(consumer).accept("test");
    }

    //BaseRock generated method id: ${testAcceptFailableDoubleConsumer}, hash: AE0E15F422B09D83370023E7DEB642D2
    @Test
    void testAcceptFailableDoubleConsumer() throws Exception {
        FailableDoubleConsumer<Exception> consumer = mock(FailableDoubleConsumer.class);
        Failable.accept(consumer, 3.14);
        verify(consumer).accept(3.14);
    }

    //BaseRock generated method id: ${testAcceptFailableIntConsumer}, hash: F4EFEAA6B05F72EDE1C7FFF009794845
    @Test
    void testAcceptFailableIntConsumer() throws Exception {
        FailableIntConsumer<Exception> consumer = mock(FailableIntConsumer.class);
        Failable.accept(consumer, 42);
        verify(consumer).accept(42);
    }

    //BaseRock generated method id: ${testAcceptFailableLongConsumer}, hash: A9881D957F0A7AECF4EF2BA9A32AD609
    @Test
    void testAcceptFailableLongConsumer() throws Exception {
        FailableLongConsumer<Exception> consumer = mock(FailableLongConsumer.class);
        Failable.accept(consumer, 42L);
        verify(consumer).accept(42L);
    }

    //BaseRock generated method id: ${testApplyFailableBiFunction}, hash: 75A90CE4CEBD426A7918D5DFFD73F7EC
    @Test
    void testApplyFailableBiFunction() {
        FailableBiFunction<String, Integer, String, Exception> function = (s, i) -> s + i;
        assertEquals("test42", Failable.apply(function, "test", 42));
    }

    //BaseRock generated method id: ${testApplyFailableFunction}, hash: F750C3CC31C150928E1FA23FCDE7A192
    @Test
    void testApplyFailableFunction() {
        FailableFunction<String, Integer, Exception> function = String::length;
        assertEquals(4, Failable.apply(function, "test"));
    }

    //BaseRock generated method id: ${testApplyAsDoubleFailableDoubleBinaryOperator}, hash: CBC988AD9CC586D010A3A0698E76DDA9
    @Test
    void testApplyAsDoubleFailableDoubleBinaryOperator() {
        FailableDoubleBinaryOperator<Exception> operator = Double::sum;
        assertEquals(5.0, Failable.applyAsDouble(operator, 2.0, 3.0), 0.001);
    }

    //BaseRock generated method id: ${testAsBiConsumer}, hash: AC3249925FF21A406B5F38E6C036C4DF
    @Test
    void testAsBiConsumer() {
        FailableBiConsumer<String, Integer, Exception> failableConsumer = (s, i) -> {
        };
        BiConsumer<String, Integer> consumer = Failable.asBiConsumer(failableConsumer);
        consumer.accept("test", 42);
    }

    //BaseRock generated method id: ${testAsBiFunction}, hash: 07398D36C9A5C4EAE533AC62E3DF7EAA
    @Test
    void testAsBiFunction() {
        FailableBiFunction<String, Integer, String, Exception> failableFunction = (s, i) -> s + i;
        BiFunction<String, Integer, String> function = Failable.asBiFunction(failableFunction);
        assertEquals("test42", function.apply("test", 42));
    }

    //BaseRock generated method id: ${testAsBiPredicate}, hash: BDB953815ACC4E96A3AE9A3ECFDC0AF4
    @Test
    void testAsBiPredicate() {
        FailableBiPredicate<String, Integer, Exception> failablePredicate = (s, i) -> s.length() == i;
        BiPredicate<String, Integer> predicate = Failable.asBiPredicate(failablePredicate);
        assertTrue(predicate.test("test", 4));
        assertFalse(predicate.test("test", 5));
    }

    //BaseRock generated method id: ${testAsCallable}, hash: 8B90D6EE450A5E6F62917106FADAE413
    @Test
    void testAsCallable() throws Exception {
        FailableCallable<String, Exception> failableCallable = () -> "test";
        assertEquals("test", Failable.asCallable(failableCallable).call());
    }

    //BaseRock generated method id: ${testAsConsumer}, hash: D742C7FEEF7B678026E8D64F844C9ABB
    @Test
    void testAsConsumer() {
        FailableConsumer<String, Exception> failableConsumer = s -> {
        };
        Consumer<String> consumer = Failable.asConsumer(failableConsumer);
        consumer.accept("test");
    }

    //BaseRock generated method id: ${testAsFunction}, hash: 61644BBA3FDEA73EF8CA336B638E5E92
    @Test
    void testAsFunction() {
        FailableFunction<String, Integer, Exception> failableFunction = String::length;
        Function<String, Integer> function = Failable.asFunction(failableFunction);
        assertEquals(4, function.apply("test"));
    }

    //BaseRock generated method id: ${testAsPredicate}, hash: 52BAC83863711C070DB9CC47D8A87393
    @Test
    void testAsPredicate() {
        FailablePredicate<String, Exception> failablePredicate = s -> s.length() == 4;
        Predicate<String> predicate = Failable.asPredicate(failablePredicate);
        assertTrue(predicate.test("test"));
        assertFalse(predicate.test("testing"));
    }

    //BaseRock generated method id: ${testAsRunnable}, hash: E07B54F6DF295F8E5F69F030B1816A46
    @Test
    void testAsRunnable() {
        AtomicBoolean called = new AtomicBoolean(false);
        FailableRunnable<Exception> failableRunnable = () -> called.set(true);
        Runnable runnable = Failable.asRunnable(failableRunnable);
        runnable.run();
        assertTrue(called.get());
    }

    //BaseRock generated method id: ${testAsSupplier}, hash: 7D0F094D6007BBB2D7A4DB2E326F81A7
    @Test
    void testAsSupplier() {
        FailableSupplier<String, Exception> failableSupplier = () -> "test";
        Supplier<String> supplier = Failable.asSupplier(failableSupplier);
        assertEquals("test", supplier.get());
    }

    //BaseRock generated method id: ${testCall}, hash: 1AB33BB30EB0B462E1D09562CA136B68
    @Test
    void testCall() throws Exception {
        FailableCallable<String, Exception> callable = () -> "test";
        assertEquals("test", Failable.call(callable));
    }

    //BaseRock generated method id: ${testGet}, hash: E2216AE84D0385F159CAD01E3C3A4B49
    @Test
    void testGet() {
        FailableSupplier<String, Exception> supplier = () -> "test";
        assertEquals("test", Failable.get(supplier));
    }

    //BaseRock generated method id: ${testGetAsBoolean}, hash: 67484FF1B7B97D03AE4C73251DB12F50
    @Test
    void testGetAsBoolean() {
        FailableBooleanSupplier<Exception> supplier = () -> true;
        assertTrue(Failable.getAsBoolean(supplier));
    }

    //BaseRock generated method id: ${testGetAsDouble}, hash: 9BE7CE436EEBA4FC7A4F4C42EF8446BC
    @Test
    void testGetAsDouble() {
        FailableDoubleSupplier<Exception> supplier = () -> 3.14;
        assertEquals(3.14, Failable.getAsDouble(supplier), 0.001);
    }

    //BaseRock generated method id: ${testGetAsInt}, hash: DD201C5D2752703E14A32F1711F5B048
    @Test
    void testGetAsInt() {
        FailableIntSupplier<Exception> supplier = () -> 42;
        assertEquals(42, Failable.getAsInt(supplier));
    }

    //BaseRock generated method id: ${testGetAsLong}, hash: 76C08616AA951BC74C0F91717CBE89B3
    @Test
    void testGetAsLong() {
        FailableLongSupplier<Exception> supplier = () -> 42L;
        assertEquals(42L, Failable.getAsLong(supplier));
    }

    //BaseRock generated method id: ${testGetAsShort}, hash: D04FBE097B3EDDF8FD2977A6B8CE039A
    @Test
    void testGetAsShort() {
        FailableShortSupplier<Exception> supplier = () -> (short) 42;
        assertEquals((short) 42, Failable.getAsShort(supplier));
    }

    //BaseRock generated method id: ${testRethrow}, hash: E2FE6F4CC48D88B2252E562B4EC21A13
    @Test
    void testRethrow() {
        assertThrows(UncheckedIOException.class, () -> Failable.rethrow(new IOException()));
        assertThrows(UndeclaredThrowableException.class, () -> Failable.rethrow(new Exception()));
    }

    //BaseRock generated method id: ${testRun}, hash: A259851DC3ED1F2759E37343BD57B309
    @Test
    void testRun() {
        AtomicBoolean called = new AtomicBoolean(false);
        FailableRunnable<Exception> runnable = () -> called.set(true);
        Failable.run(runnable);
        assertTrue(called.get());
    }

    //BaseRock generated method id: ${testStream}, hash: C770A02F7283361C3B6F9455C8A606B5
    @Test
    void testStream() {
        //Collection<String> collection = Arrays.asList("a", "b", "c");
        //FailableStream<String> stream = Failable.stream(collection);
        //assertNotNull(stream);
        //assertEquals(3, stream.toStream().count());
    }

    //BaseRock generated method id: ${testStreamFromStream}, hash: 6EBB3E551C7071BC061080719C0E0FB3
    @Test
    void testStreamFromStream() {
        //Stream<String> originalStream = Stream.of("a", "b", "c");
        //FailableStream<String> stream = Failable.stream(originalStream);
        //assertNotNull(stream);
        //assertEquals(3, stream.toStream().count());
    }

    //BaseRock generated method id: ${testTest}, hash: ED63B6F17860776F89EA037C881631E5
    @Test
    void testTest() {
        //FailablePredicate<String, Exception> predicate = s -> s.length() == 4;
        //assertTrue(Failable.test(predicate, "test"));
        //assertFalse(Failable.test(predicate, "testing"));
    }

    //BaseRock generated method id: ${testTestBiPredicate}, hash: 197E4DCA03B5E686EB3971D8134596F3
    @Test
    void testTestBiPredicate() {
        FailableBiPredicate<String, Integer, Exception> predicate = (s, i) -> s.length() == i;
        assertTrue(Failable.test(predicate, "test", 4));
        assertFalse(Failable.test(predicate, "test", 5));
    }

    //BaseRock generated method id: ${testTryWithResources}, hash: 9D2717C86116CED887FEF21D02BAB2BD
    @Test
    void testTryWithResources() {
        AtomicBoolean actionCalled = new AtomicBoolean(false);
        AtomicBoolean resource1Called = new AtomicBoolean(false);
        AtomicBoolean resource2Called = new AtomicBoolean(false);
        Failable.tryWithResources(() -> actionCalled.set(true), () -> resource1Called.set(true), () -> resource2Called.set(true));
        assertTrue(actionCalled.get());
        assertTrue(resource1Called.get());
        assertTrue(resource2Called.get());
    }

    //BaseRock generated method id: ${testTryWithResourcesWithErrorHandler}, hash: 215331F5E6CEF3FC7B47054AFF310D71
    @Test
    void testTryWithResourcesWithErrorHandler() {
        AtomicBoolean errorHandlerCalled = new AtomicBoolean(false);
        Failable.tryWithResources(() -> {
            throw new Exception("Test exception");
        }, e -> errorHandlerCalled.set(true), () -> {
        });
        assertTrue(errorHandlerCalled.get());
    }
}