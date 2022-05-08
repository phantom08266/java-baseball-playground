package baseball;

public class GameResult {

    private int strikeCount;
    private int ballCount;

    private final int GAME_END_VALIE = 3;

    public void report(GameStatus play) {
        switch (play){
            case STRIKE:
                strikeCount++;
                break;
            case BALL:
                ballCount++;
                break;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isEndGame() {
        return strikeCount == GAME_END_VALIE;
    }
}
