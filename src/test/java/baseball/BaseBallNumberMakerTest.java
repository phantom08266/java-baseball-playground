package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class BaseBallNumberMakerTest {

    private BaseBallNumberMaker baseBallNumberMaker;
    private String randomGameNumber;

    @BeforeEach
    void init() {
        baseBallNumberMaker = new BaseBallNumberMaker();
        randomGameNumber = baseBallNumberMaker.createRandomGameNumber();
    }

    @Test
    @DisplayName("0이 포함되어있으면 안된다.")
    void test() {
        assertThat(randomGameNumber).doesNotContain("0");
    }

    @Test
    @DisplayName("야구 랜던값은 111 ~ 999범위를 가진다")
    void test2() {
        assertThat(randomGameNumber).isLessThanOrEqualTo("999");
        assertThat(randomGameNumber).isGreaterThanOrEqualTo("111");
    }

    @Test
    @DisplayName("야구게임 숫자는 3자리다")
    void test3() {
        assertThat(randomGameNumber).hasSize(3);
    }
}