package study;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.IterableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    void sizeTest() {
        int actual = numbers.size();
        assertThat(actual).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void contains(int number) {
        assertThat(numbers).contains(number);
    }

    @DisplayName("값이 존재하면 ture, 없으면 false를 검증한다")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "6:false", "0:false"}, delimiter = ':')
    void eachValueTest(int input, boolean expected) {
        boolean contains = numbers.contains(input);
        assertThat(contains).isEqualTo(expected);
    }


}
