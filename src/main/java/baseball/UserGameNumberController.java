package baseball;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UserGameNumberController {

    public static final int GAME_NUMBER_SIZE = 3;

    private final Scanner scanner;

    public UserGameNumberController(Scanner scanner) {
        this.scanner = scanner;
    }

    public Set<Integer> getGameNumber() {
        String userInputGameNumber;
        Set<Integer> userGameNumberSet = new HashSet<>();
        while (userGameNumberSet.size() != GAME_NUMBER_SIZE) {
            System.out.print("숫자를 입력해 주세요 : ");
            userInputGameNumber = scanner.nextLine();

            userGameNumberSet = makeGameNumber(userInputGameNumber);
        }
        return userGameNumberSet;
    }

    protected Set<Integer> makeGameNumber(String userInputGameNumber) {
        char[] gameNumbers = userInputGameNumber.toCharArray();
        Set<Integer> userGameNumbers = new LinkedHashSet<>();

        for (char gameNumber : gameNumbers) {
            userGameNumbers.add(Integer.parseInt(String.valueOf(gameNumber)));
        }

        if (!validGameNumberSize(userGameNumbers)) {
            return new LinkedHashSet<>();
        }

        return userGameNumbers;
    }

    protected boolean validGameNumberSize(Set<Integer> userGameNumbers) {
        if (userGameNumbers.size() != GAME_NUMBER_SIZE) {
            System.out.println("중복되지 않는 3자리의 숫자를 입력하세요");
            return false;
        }
        return true;
    }
}
