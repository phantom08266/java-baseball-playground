package baseball;

import java.util.stream.Stream;

public class BaseBallGameMachine {

    public boolean validation(String userInputGameNumber, String machineGameNumber) {
        System.out.println("컴퓨터 숫자 : "+ machineGameNumber);
        if (machineGameNumber.equals(userInputGameNumber)) return true;

        validBallGameNumber(userInputGameNumber, machineGameNumber);
        validStrikeGameNumber(userInputGameNumber, machineGameNumber);
        System.out.println();

        return false;
    }

    private void validStrikeGameNumber(String userNumber, String machineNumber) {
        char[] userNumbers = userNumber.toCharArray();
        char[] machineNumbers = machineNumber.toCharArray();
        int loopCount = userNumber.length();

        long strikeCount = Stream.iterate(0, i -> i + 1).limit(loopCount)
                .filter(i -> userNumbers[i] == machineNumbers[i])
                .count();

        System.out.print(String.format("%d스트라이크", strikeCount));
    }

    private void validBallGameNumber(String userNumber, String machineNumber) {

        long ballCount = userNumber.chars()
                .mapToObj(c -> (char) c)
                .filter(item -> machineNumber.contains(item.toString()))
                .count();

        System.out.print(String.format("%d볼 ", ballCount));
    }
}
