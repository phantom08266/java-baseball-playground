package baseball;

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
        if (this.isNoting(userBall)) {
            return GameStatus.NOTING;
        }
        return GameStatus.STRIKE;
    }

    private boolean isNoting(Ball userBall) {
        return !isSamePosition(userBall) && !gameBall.isSameBall(userBall.gameBall);
    }

    private boolean isBall(Ball userBall) {
        return !isSamePosition(userBall) && gameBall.isSameBall(userBall.gameBall);
    }

    private boolean isSamePosition(Ball userBall) {
        return this.position == userBall.position;
    }
}
