package baseball;

import java.util.Set;
import java.util.stream.Stream;

public class BaseBallGameMachine {

    public boolean validation(Set<Integer> userInputGameNumbers, Set<Integer> machineGameNumbers) {
        System.out.println("컴퓨터 숫자 : " + machineGameNumbers.toString());
        if (validSameGameNumber(userInputGameNumbers, machineGameNumbers)) {
            return true;
        }

        long ballCount = validBallGameNumber(userInputGameNumbers, machineGameNumbers);
        long strikeCount = validStrikeGameNumber(userInputGameNumbers, machineGameNumbers);

        System.out.print(String.format("%d볼 ", ballCount));
        System.out.print(String.format("%d스트라이크", strikeCount));
        System.out.println();

        return false;
    }

    protected boolean validSameGameNumber(Set<Integer> userNumbers, Set<Integer> machineNumbers) {
        long equalCount = getEqualCount(userNumbers, machineNumbers);

        return equalCount == machineNumbers.size();
    }

    protected long validStrikeGameNumber(Set<Integer> userNumbers, Set<Integer> machineNumbers) {
        return getEqualCount(userNumbers, machineNumbers);
    }

    protected long validBallGameNumber(Set<Integer> userNumbers, Set<Integer> machineNumbers) {
        return  userNumbers.stream()
            .filter(item -> machineNumbers.contains(item))
            .count();
    }

    protected long getEqualCount(Set<Integer> userNumbers, Set<Integer> machineNumbers) {
        int loopCount = userNumbers.size();
        Integer[] userNumberArray = userNumbers.toArray(new Integer[loopCount]);
        Integer[] machineNumberArray = machineNumbers.toArray(new Integer[loopCount]);

        return Stream.iterate(0, i -> i + 1).limit(loopCount)
            .filter(i -> userNumberArray[i].equals(machineNumberArray[i]))
            .count();
    }
}
