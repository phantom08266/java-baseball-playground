import baseball.BaseBallGameMachine;
import baseball.BaseBallGameViewer;
import baseball.BaseBallNumberMaker;
import baseball.GameStartor;
import baseball.UserGameNumberController;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GameStartor gameStartor = new GameStartor(new Scanner(System.in));
        gameStartor.start();
    }
}
