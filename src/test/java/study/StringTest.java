package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1"); // 순서, 갯수 안봄. 오로지 값의 존재유무만 파악

    }

    @Test
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1"); // 순서, 갯수, 값 완전 일치해야함.
    }


    @Test
    void subString() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    void chatAt() {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("특정 위치 문자를 가져올때 범위를 벗어나면 [StringIndexOutOfBoundsException]예외가 발생한다.")
    void chatAt_exception() {
        assertThatThrownBy(() -> "abc".charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("4");
    }
}
