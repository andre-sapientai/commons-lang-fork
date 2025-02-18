package org.apache.commons.lang3.util;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.NoSuchElementException;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.junit.jupiter.api.Disabled;

class IterableStringTokenizerBaseRockGeneratedFtcgTest {

    //BaseRock generated method id: ${testConstructorWithOnlyString}, hash: C8A533067963D4FA22BCB27591F9B500
    @Test
    void testConstructorWithOnlyString() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("a b c");
        List<String> tokens = tokenizer.toList();
        assertEquals(3, tokens.size());
        assertEquals(Arrays.asList("a", "b", "c"), tokens);
    }

    //BaseRock generated method id: ${testConstructorWithStringAndDelimiter}, hash: 80BBA76A4876C8CE16427DBB9E109D82
    @Test
    void testConstructorWithStringAndDelimiter() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("a,b,c", ",");
        List<String> tokens = tokenizer.toList();
        assertEquals(3, tokens.size());
        assertEquals(Arrays.asList("a", "b", "c"), tokens);
    }

    //BaseRock generated method id: ${testConstructorWithStringDelimiterAndReturnDelims}, hash: E0770990322771131B670E5C95FA00CD
    @Test
    void testConstructorWithStringDelimiterAndReturnDelims() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("a,b,c", ",", true);
        List<String> tokens = tokenizer.toList();
        assertEquals(5, tokens.size());
        assertEquals(Arrays.asList("a", ",", "b", ",", "c"), tokens);
    }

    //BaseRock generated method id: ${testIterator}, hash: FEF09FB5C118EAA97C893EA0BB438A29
    @Test
    void testIterator() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("a b c");
        Iterator<String> iterator = tokenizer.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());
        assertFalse(iterator.hasNext());
    }

    //BaseRock generated method id: ${testIteratorWithEmptyString}, hash: 05F1DB1D78A5EFBF54A775029B6264BC
    @Test
    void testIteratorWithEmptyString() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("");
        Iterator<String> iterator = tokenizer.iterator();
        assertFalse(iterator.hasNext());
    }

    //BaseRock generated method id: ${testIteratorThrowsNoSuchElementException}, hash: 26FA2B17B9A4C8E0C718311B9B960D37
    @Test
    void testIteratorThrowsNoSuchElementException() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("a");
        Iterator<String> iterator = tokenizer.iterator();
        iterator.next();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    //BaseRock generated method id: ${testToArray}, hash: E62CFCF1DAAC558318B853D87390CED3
    @Test
    void testToArray() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("a b c");
        String[] array = tokenizer.toArray();
        assertArrayEquals(new String[] { "a", "b", "c" }, array);
    }

    //BaseRock generated method id: ${testToArrayWithEmptyString}, hash: 1B107E7170D2D684F365365A128F3DC8
    @Test
    void testToArrayWithEmptyString() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("");
        String[] array = tokenizer.toArray();
        assertArrayEquals(new String[0], array);
    }

    //BaseRock generated method id: ${testToList}, hash: E37AC27DF2FC5DAEFB71E8F69B0F70A8
    @Test
    void testToList() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("a b c");
        List<String> list = tokenizer.toList();
        assertEquals(Arrays.asList("a", "b", "c"), list);
    }

    //BaseRock generated method id: ${testToListWithEmptyString}, hash: 3813E1B385F0071F098F63A200C79846
    @Test
    void testToListWithEmptyString() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("");
        List<String> list = tokenizer.toList();
        assertTrue(list.isEmpty());
    }

    //BaseRock generated method id: ${testToStream}, hash: FA53FFFFC5953A264507655AAE1469EC
    @Test
    void testToStream() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("a b c");
        List<String> streamResult = tokenizer.toStream().collect(Collectors.toList());
        assertEquals(Arrays.asList("a", "b", "c"), streamResult);
    }

    //BaseRock generated method id: ${testToStreamWithEmptyString}, hash: 6FB44C7631A04C5343DA4DCFA2FE3405
    @Test
    void testToStreamWithEmptyString() {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("");
        List<String> streamResult = tokenizer.toStream().collect(Collectors.toList());
        assertTrue(streamResult.isEmpty());
    }

    //BaseRock generated method id: ${testTokenizerWithDifferentInputs}, hash: 156F1D64A6C8055F907C2DF264304D8B
    @ParameterizedTest
    @CsvSource({ "a b c, ' ', false, a, b, c", "a,b,c, ',', false, a, b, c", "a,b,c, ',', true, a, ',', b, ',', c" })
    void testTokenizerWithDifferentInputs(String input, String delim, boolean returnDelims, String... expected) {
        IterableStringTokenizer tokenizer = new IterableStringTokenizer(input, delim, returnDelims);
        assertArrayEquals(expected, tokenizer.toArray());
    }
}
