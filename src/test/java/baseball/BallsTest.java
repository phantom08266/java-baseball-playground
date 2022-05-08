package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

    private Balls balls;

    @BeforeEach
    void setup() {
        balls = new Balls(Arrays.asList(1,2,3));
    }

    @Test
    @DisplayName("컴퓨터가 가지고있는 값에 위치, 값 둘다 일치하지 않을 경우 Noting")
    void test1() {
        assertThat(balls.play(new Ball(1,new GameBall(4))))
            .isEqualTo(GameStatus.NOTING);
    }

    @Test
    @DisplayName("컴퓨터가 가지고있는 값에 위치일치 값 불일치 할 경우 Ball")
    void test2() {
        assertThat(balls.play(new Ball(1,new GameBall(2))))
            .isEqualTo(GameStatus.BALL);
    }

    @Test
    @DisplayName("컴퓨터가 가지고 있는 값에 위치, 값 일치할 경우 Strike")
    void test3() {
        assertThat(balls.play(new Ball(1,new GameBall(1))))
            .isEqualTo(GameStatus.STRIKE);
    }

    @Test
    @DisplayName("사용자가 중복된 값을 입력했을 경우 예외발생")
    void test4() {
        assertThatThrownBy(() -> balls.play(Arrays.asList(4,4,6)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1스트라이크일 경우 결과값도 1스트라이크이면 성공한다.")
    void test5() {
        assertThat(balls.play(Arrays.asList(1,5,6)).getStrikeCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("1볼일 경우 결과값도 1볼이면 성공한다.")
    void test6() {
        assertThat(balls.play(Arrays.asList(4,3,6)).getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("3스트라이크일 경우 결과값도 3스트라이크이면 성공한다.")
    void test7() {
        assertThat(balls.play(Arrays.asList(1,2,3)).getStrikeCount()).isEqualTo(3);
        assertThat(balls.play(Arrays.asList(1,2,3)).isEndGame()).isTrue();
    }

}
