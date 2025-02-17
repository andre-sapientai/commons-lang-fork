package org.apache.commons.lang3.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class IterableStringTokenizerCopilotTest {

    @Test
    void iteratorTest() {
        // Arrange
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("token1 token2", " ");

        // Act
        Iterator<String> iterator = tokenizer.iterator();

        // Assert
        assertAll("iterator",
                () -> assertThat(iterator, is(notNullValue())),
                () -> assertThat(iterator.hasNext(), is(true)),
                () -> assertThat(iterator.next(), is("token1")),
                () -> assertThat(iterator.hasNext(), is(true)),
                () -> assertThat(iterator.next(), is("token2")),
                () -> assertThat(iterator.hasNext(), is(false))
        );
    }

    @Test
    void toArrayTest() {
        // Arrange
        /*IterableStringTokenizer tokenizer = spy(new IterableStringTokenizer("token1 token2", " "));
        List<String> stringList = List.of("token1", "token2");
        doReturn(stringList).when(tokenizer).toList();

        // Act
        String[] result = tokenizer.toArray();

        // Assert
        assertAll("toArray",
                () -> assertThat(result, is(notNullValue())),
                () -> assertThat(result.length, is(2)),
                () -> assertThat(result, arrayContaining("token1", "token2")),
                () -> verify(tokenizer).toList()
        );*/
    }

    @Test
    void toListTest() {
        // Arrange
        IterableStringTokenizer tokenizer = new IterableStringTokenizer("token1 token2", " ");

        // Act
        List<String> result = tokenizer.toList();

        // Assert
        assertAll("toList",
                () -> assertThat(result, is(notNullValue())),
                () -> assertThat(result.size(), is(2)),
                () -> assertThat(result, contains("token1", "token2"))
        );
    }


    @Test
    void toStreamTest() {
       /* // Arrange
        IterableStringTokenizer tokenizer = spy(new IterableStringTokenizer("token1 token2", " "));
        Spliterator<String> spliteratorMock = mock(Spliterator.class);
        doReturn(spliteratorMock).when(tokenizer).spliterator();

        // Act
        Stream<String> result = tokenizer.toStream();

        // Assert
        assertAll("toStream",
                () -> assertThat(result, is(notNullValue())),
                () -> verify(tokenizer).spliterator()
        );*/
    }
}