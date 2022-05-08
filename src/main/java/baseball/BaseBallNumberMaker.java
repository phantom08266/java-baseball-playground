package baseball;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class BaseBallNumberMaker {

    public static final int GAME_NUMBER_COUNT = 3;
    private int MAX = 9;
    private int MIN = 1;

    public Set<Integer> createRandomGameNumber() {
        Set<Integer> gameNumbers = new LinkedHashSet();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        boolean loop = true;
        while (loop) {
            int num = threadLocalRandom.nextInt(MIN, MAX);
            gameNumbers.add(num);
            loop = !checkGameNumberSize(gameNumbers);
        }
        return gameNumbers;
    }

    private boolean checkGameNumberSize(Set<Integer> gameNumbers) {
        if (gameNumbers.size() == GAME_NUMBER_COUNT) {
            return true;
        }
        return false;
    }
}
