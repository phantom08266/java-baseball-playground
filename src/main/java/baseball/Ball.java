package baseball;

import java.util.Objects;

public class Ball {

    private final int position;
    private final GameBall gameBall;

    public Ball(int position, GameBall gameBall) {
        this.position = position;
        this.gameBall = gameBall;
    }

    public GameStatus play(Ball userBall) {
        if (this.isBall(userBall)) {
            return GameStatus.BALL;
        }
        if (this.equals(userBall)) {
            return GameStatus.STRIKE;
        }
        return GameStatus.NOTING;
    }

    private boolean isBall(Ball userBall) {
        return !isSamePosition(userBall) && gameBall.isSameBall(userBall.gameBall);
    }

    private boolean isSamePosition(Ball userBall) {
        return this.position == userBall.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return position == ball.position && gameBall.equals(ball.gameBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, gameBall);
    }
}
