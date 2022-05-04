package baseball;

public class BaseBallGameViewer {

    private final BaseBallGameMachine baseBallGameMachine;

    private final UserGameNumberController userGameNumber;

    public BaseBallGameViewer(BaseBallGameMachine baseBallGameMachine, UserGameNumberController userGameNumber) {
        this.baseBallGameMachine = baseBallGameMachine;
        this.userGameNumber = userGameNumber;
    }

    public void show() {
        boolean gameLoop = true;
        while (gameLoop) {
            String userInputGameNumber = userGameNumber.getGameNumber();

            if (baseBallGameMachine.validation(userInputGameNumber)) break;
        }
    }
}
