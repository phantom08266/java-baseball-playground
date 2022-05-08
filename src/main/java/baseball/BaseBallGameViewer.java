package baseball;

import java.util.Set;

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
        Set<Integer> randomGameNumbers = baseBallNumberMaker.createRandomGameNumber();

        while (gameLoop) {
            Set<Integer> userGameNumbers = this.userGameNumber.getGameNumber();

            gameLoop = !baseBallGameMachine.validation(userGameNumbers, randomGameNumbers);
        }
    }
}
