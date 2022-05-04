package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class BaseBallNumberMaker {

    public static final int GAME_NUMBER_COUNT = 3;
    private int MAX = 9;
    private int MIN = 1;

    public String createRandomGameNumber() {
        Set<Integer> gameNumbers = new HashSet();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        while (true) {
            int num = threadLocalRandom.nextInt(MIN, MAX);
            gameNumbers.add(num);
            if (gameNumbers.size() == GAME_NUMBER_COUNT) break;
        }
        return gameNumbers.toString().replaceAll("[ ]", "");
    }
}
