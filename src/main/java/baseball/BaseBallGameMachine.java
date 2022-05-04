package baseball;

import java.util.Arrays;
import java.util.stream.Stream;

public class BaseBallGameMachine {

    private BaseBallNumberMaker baseBallNumberMaker;

    public BaseBallGameMachine(BaseBallNumberMaker baseBallNumberMaker) {
        this.baseBallNumberMaker = baseBallNumberMaker;
    }

    public boolean validation(String userInputGameNumber) {
        String randomGameNumber = baseBallNumberMaker.createRandomGameNumber();
        System.out.println("컴퓨터 숫자 : "+ randomGameNumber);
        if (randomGameNumber.equals(userInputGameNumber)) return true;

        checkBallGameNumber(userInputGameNumber, randomGameNumber);
        checkStrikeGameNumber(userInputGameNumber, randomGameNumber);
        System.out.println();

        return false;
    }

    private void checkStrikeGameNumber(String userNumber, String machineNumber) {
        char[] userNumbers = userNumber.toCharArray();
        char[] machineNumbers = machineNumber.toCharArray();
        int loopCount = userNumber.length();

        long strikeCount = Stream.iterate(0, i -> i + 1).limit(loopCount)
                .filter(i -> userNumbers[i] == machineNumbers[i])
                .count();

        System.out.print(String.format("%d스트라이크", strikeCount));
    }

    private void checkBallGameNumber(String userNumber, String machineNumber) {

        long ballCount = userNumber.chars()
                .mapToObj(c -> (char) c)
                .filter(item -> machineNumber.contains(item.toString()))
                .count();

        System.out.print(String.format("%d볼 ", ballCount));
    }
}
