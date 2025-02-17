package org.apache.commons.lang3.tuple;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.MockedStatic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class MutableTripleCopilotTest {

    @Test
    void testEmptyArray() {
        MutableTriple<Object, Object, Object>[] result = MutableTriple.emptyArray();
        assertAll("result", () -> assertThat(result.length, equalTo(0)));
    }

    @Test
    void testOf() {
        Object left = new Object();
        Object middle = new Object();
        Object right = new Object();
        MutableTriple<Object, Object, Object> result = MutableTriple.of(left, middle, right);
        MutableTriple<Object, Object, Object> expected = new MutableTriple<>(left, middle, right);
        assertAll("result", () -> assertThat(result, equalTo(expected)));
    }

    @Test
    void testOfNonNull() {
        try (MockedStatic<MutableTriple> mockedStatic = mockStatic(MutableTriple.class, CALLS_REAL_METHODS)) {
            MutableTriple<Object, Object, Object> expected = new MutableTriple<>();
            Object left = new Object();
            Object middle = new Object();
            Object right = new Object();
            mockedStatic.when(() -> MutableTriple.of(left, middle, right)).thenReturn(expected);
            MutableTriple<Object, Object, Object> result = MutableTriple.ofNonNull(left, middle, right);
            assertAll("result", () -> {
                assertThat(result, equalTo(expected));
                mockedStatic.verify(() -> MutableTriple.of(left, middle, right), atLeast(1));
            });
        }
    }

    @Test
    void testGetLeft() {
        Object left = new Object();
        Object middle = new Object();
        Object right = new Object();
        MutableTriple<Object, Object, Object> target = new MutableTriple<>(left, middle, right);
        Object result = target.getLeft();
        assertAll("result", () -> assertThat(result, equalTo(left)));
    }

    @Test
    void testGetMiddle() {
        Object left = new Object();
        Object middle = new Object();
        Object right = new Object();
        MutableTriple<Object, Object, Object> target = new MutableTriple<>(left, middle, right);
        Object result = target.getMiddle();
        assertAll("result", () -> assertThat(result, equalTo(middle)));
    }

    @Test
    void testGetRight() {
        Object left = new Object();
        Object middle = new Object();
        Object right = new Object();
        MutableTriple<Object, Object, Object> target = new MutableTriple<>(left, middle, right);
        Object result = target.getRight();
        assertAll("result", () -> assertThat(result, equalTo(right)));
    }

    @Test
    void testSetLeft() {
        Object left = new Object();
        Object middle = new Object();
        Object right = new Object();
        MutableTriple<Object, Object, Object> target = new MutableTriple<>(left, middle, right);
        Object newLeft = new Object();
        target.setLeft(newLeft);
        assertAll("result", () -> assertThat(target.getLeft(), equalTo(newLeft)));
    }

    @Test
    void testSetMiddle() {
        Object left = new Object();
        Object middle = new Object();
        Object right = new Object();
        MutableTriple<Object, Object, Object> target = new MutableTriple<>(left, middle, right);
        Object newMiddle = new Object();
        target.setMiddle(newMiddle);
        assertAll("result", () -> assertThat(target.getMiddle(), equalTo(newMiddle)));
    }

    @Test
    void testSetRight() {
        Object left = new Object();
        Object middle = new Object();
        Object right = new Object();
        MutableTriple<Object, Object, Object> target = new MutableTriple<>(left, middle, right);
        Object newRight = new Object();
        target.setRight(newRight);
        assertAll("result", () -> assertThat(target.getRight(), equalTo(newRight)));
    }
}