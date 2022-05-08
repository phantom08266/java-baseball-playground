package baseball;

public enum GameStatus {
    STRIKE,
    BALL,
    NOTING
    ;

    public boolean isNoting() {
        return this == GameStatus.NOTING;
    }
}
