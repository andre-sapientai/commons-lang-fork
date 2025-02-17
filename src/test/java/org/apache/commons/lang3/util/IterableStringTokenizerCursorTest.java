package org.apache.commons.lang3.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class IterableStringTokenizerCursorTest {

    @Test
    public void testDefaultConstructor() {
        final String input = "a b c";
        final IterableStringTokenizer tokenizer = new IterableStringTokenizer(input);
        
        List<String> tokens = tokenizer.toList();
        assertEquals(Arrays.asList("a", "b", "c"), tokens);
    }

    @Test
    public void testConstructorWithDelimiter() {
        final String input = "a,b,c";
        final IterableStringTokenizer tokenizer = new IterableStringTokenizer(input, ",");
        
        List<String> tokens = tokenizer.toList();
        assertEquals(Arrays.asList("a", "b", "c"), tokens);
    }

    @Test
    public void testConstructorWithDelimiterAndReturnDelims() {
        final String input = "a,b,c";
        final IterableStringTokenizer tokenizer = new IterableStringTokenizer(input, ",", true);
        
        List<String> tokens = tokenizer.toList();
        assertEquals(Arrays.asList("a", ",", "b", ",", "c"), tokens);
    }

    @Test
    public void testNullInput() {
        assertThrows(NullPointerException.class, () -> new IterableStringTokenizer(null));
    }

    @Test
    public void testEmptyInput() {
        final IterableStringTokenizer tokenizer = new IterableStringTokenizer("");
        
        List<String> tokens = tokenizer.toList();
        assertEquals(0, tokens.size());
    }

    @Test
    public void testToArray() {
        final String input = "a b c";
        final IterableStringTokenizer tokenizer = new IterableStringTokenizer(input);
        
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, tokenizer.toArray());
    }

    @Test
    public void testToStream() {
        final String input = "a b c";
        final IterableStringTokenizer tokenizer = new IterableStringTokenizer(input);
        
        List<String> tokens = tokenizer.toStream().collect(Collectors.toList());
        assertEquals(Arrays.asList("a", "b", "c"), tokens);
    }

    @Test
    public void testMultipleDelimiters() {
        final String input = "a,b;c:d";
        final IterableStringTokenizer tokenizer = new IterableStringTokenizer(input, ",;:");
        
        List<String> tokens = tokenizer.toList();
        assertEquals(Arrays.asList("a", "b", "c", "d"), tokens);
    }

    @Test
    public void testIterator() {
        final String input = "a b c";
        final IterableStringTokenizer tokenizer = new IterableStringTokenizer(input);
        
        assertNotNull(tokenizer.iterator());
        StringBuilder result = new StringBuilder();
        for (String token : tokenizer) {
            result.append(token);
        }
        assertEquals("abc", result.toString());
    }
} 