package baseball;

import java.util.concurrent.ThreadLocalRandom;

public class BaseBallNumberMaker {

    private int MAX = 9;
    private int MIN = 1;

    public String createRandomGameNumber() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int loopCount = 3;
        int count = 0;
        StringBuilder numbers = new StringBuilder();
        while (count < loopCount) {
            numbers.append(threadLocalRandom.nextInt(MIN, MAX));
            count++;
        }
        return numbers.toString();
    }
}
