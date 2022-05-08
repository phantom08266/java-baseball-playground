package baseball;

import java.util.Objects;

public class GameBall {

    private final int gameNumber;

    public GameBall(int num) {
        if (num < 1 || num > 9) {
            throw new IllegalArgumentException("게임 숫자는 1~9까지의 값을 가집니다.");
        }
        this.gameNumber = num;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public boolean isSameBall(GameBall gameBall) {
        return this.gameNumber == gameBall.gameNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameBall gameBall = (GameBall) o;
        return gameNumber == gameBall.gameNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameNumber);
    }
}
