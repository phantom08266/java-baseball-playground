package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    private Ball computerBall;

    @BeforeEach
    void setup() {
        computerBall = new Ball(1, new GameBall(3));
    }

    @Test
    @DisplayName("게임 값 포함, 위치가 일치하면 1 Strike")
    void test1() {
        Ball userBall = new Ball(1, new GameBall(3));

        assertThat(computerBall.play(userBall)).isEqualTo(GameStatus.STRIKE);
    }


    @Test
    @DisplayName("게임 값은 포함, 위치 불일치 하면 1 ball")
    void test2() {
        Ball userBall = new Ball(2, new GameBall(3));

        assertThat(computerBall.play(userBall)).isEqualTo(GameStatus.BALL);
    }

    @Test
    @DisplayName("게임 값 포함안함, 위치 불일치 하면 noting")
    void test3() {
        Ball userBall = new Ball(2, new GameBall(4));

        assertThat(computerBall.play(userBall)).isEqualTo(GameStatus.NOTING);
    }
}
