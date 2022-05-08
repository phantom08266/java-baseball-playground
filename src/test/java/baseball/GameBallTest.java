package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameBallTest {

    @Test
    @DisplayName("게임 값은 1~9까지 값을 가진다.")
    void test1() {
        assertThat(new GameBall(1).getGameNumber()).isEqualTo(1);
        assertThat(new GameBall(9).getGameNumber()).isEqualTo(9);
    }

    @Test
    @DisplayName("게임 값이 1~9 범위를 벗어나면 예외가 발생한다.")
    void test2() {
        assertThatThrownBy(() -> new GameBall(0))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new GameBall(10))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
