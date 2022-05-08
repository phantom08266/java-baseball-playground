package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BaseBallNumberMakerTest {

    private BaseBallNumberMaker baseBallNumberMaker;
    private Set<Integer> randomGameNumber;

    @BeforeEach
    void init() {
        baseBallNumberMaker = new BaseBallNumberMaker();
        randomGameNumber = baseBallNumberMaker.createRandomGameNumber();
    }

    @Test
    @DisplayName("0이 포함되어있으면 안된다.")
    void test() {
        assertThat(randomGameNumber).doesNotContain(0);
    }

    @Test
    @DisplayName("야구게임 숫자는 3자리다")
    void test2() {
        assertThat(randomGameNumber).hasSize(3);
    }
}