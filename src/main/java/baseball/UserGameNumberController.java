package baseball;

import java.util.Scanner;

public class UserGameNumberController {

    public static final int GAME_NUMBER_SIZE = 3;

    public String getGameNumber() {
        Scanner scanner = new Scanner(System.in);
        String userInputGameNumber;

        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            userInputGameNumber = scanner.nextLine();

            if (validGameNumber(userInputGameNumber)) break;
        }
        return userInputGameNumber;
    }

    private boolean validGameNumber(String userInputGameNumber) {
        if (userInputGameNumber.length() != GAME_NUMBER_SIZE) {
            System.out.println("3자리의 숫자를 입력하세요");
            return false;
        }
        return true;
    }
}
