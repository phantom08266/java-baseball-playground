package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    private final List<Ball> gameBalls;
    private final int GAME_NUMBER_COUNT = 3;

    public Balls(List<Integer> numbers) {
        gameBalls = createBall(numbers);
    }

    private List<Ball> createBall(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            balls.add(new Ball(i + 1, new GameBall(numbers.get(i))));
        }
        return balls;
    }

    public GameStatus play(Ball gameBall) {
        return gameBalls.stream()
            .map(ball -> ball.play(gameBall))
            .filter(status -> !status.isNoting())
            .findFirst()
            .orElse(GameStatus.NOTING);
    }

    public GameResult play(List<Integer> userNumbers) {
        validDuplicateUserNumber(userNumbers);
        List<Ball> userBalls = createBall(userNumbers);
        GameResult result = new GameResult();
        for (Ball userBall : userBalls) {
            result.report(play(userBall));
        }
        return result;
    }

    private void validDuplicateUserNumber(List<Integer> userNumbers) {
        Set<Integer> userNumberSet = new LinkedHashSet<>(userNumbers);

        if (userNumberSet.size() != GAME_NUMBER_COUNT) {
            throw new IllegalArgumentException("중복되지 않는 값을 입력하세요");
        }
    }
}
