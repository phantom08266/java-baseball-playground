import baseball.BaseBallGameMachine;
import baseball.BaseBallGameViewer;
import baseball.BaseBallNumberMaker;
import baseball.UserGameNumberController;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // 객체들간의 의존성 연결
        // 리펙토링 책에 나오는 객체들 간의 초기화 부분!
        BaseBallGameMachine baseBallGameMachine = new BaseBallGameMachine();
        UserGameNumberController userGameNumberController = new UserGameNumberController(new Scanner(System.in));
        BaseBallNumberMaker baseBallNumberMaker = new BaseBallNumberMaker();
        BaseBallGameViewer baseBallGameViewer = new BaseBallGameViewer(baseBallGameMachine, userGameNumberController, baseBallNumberMaker);

        baseBallGameViewer.show();
    }
}
