package baseball;

public class BaseBallGameViewer {

    private final BaseBallGameMachine baseBallGameMachine;

    private final UserGameNumberController userGameNumber;

    private final BaseBallNumberMaker baseBallNumberMaker;

    public BaseBallGameViewer(BaseBallGameMachine baseBallGameMachine, UserGameNumberController userGameNumber, BaseBallNumberMaker baseBallNumberMaker) {
        this.baseBallGameMachine = baseBallGameMachine;
        this.userGameNumber = userGameNumber;
        this.baseBallNumberMaker = baseBallNumberMaker;
    }

    public void show() {
        boolean gameLoop = true;
        String randomGameNumber = baseBallNumberMaker.createRandomGameNumber();

        while (gameLoop) {
            String userInputGameNumber = userGameNumber.getGameNumber();

            if (baseBallGameMachine.validation(userInputGameNumber, randomGameNumber)) break;
        }
    }
}
