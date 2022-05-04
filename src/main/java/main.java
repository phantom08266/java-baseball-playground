import baseball.BaseBallGameMachine;
import baseball.BaseBallGameViewer;
import baseball.UserGameNumberController;

public class main {
    public static void main(String[] args) {
        BaseBallGameMachine baseBallGameMachine = new BaseBallGameMachine();
        UserGameNumberController userGameNumberController = new UserGameNumberController();
        BaseBallGameViewer baseBallGameViewer = new BaseBallGameViewer(baseBallGameMachine, userGameNumberController);

        baseBallGameViewer.show();
    }
}
