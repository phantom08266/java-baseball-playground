import baseball.BaseBallGameMachine;
import baseball.BaseBallGameViewer;
import baseball.BaseBallNumberMaker;
import baseball.UserGameNumberController;

public class main {
    public static void main(String[] args) {
        // 객체들간의 의존성 연결
        // 리펙토링 책에 나오는 객체들 간의 초기화 부분!
        BaseBallNumberMaker baseBallNumberMaker = new BaseBallNumberMaker();
        BaseBallGameMachine baseBallGameMachine = new BaseBallGameMachine(baseBallNumberMaker);
        UserGameNumberController userGameNumberController = new UserGameNumberController();
        BaseBallGameViewer baseBallGameViewer = new BaseBallGameViewer(baseBallGameMachine, userGameNumberController);

        baseBallGameViewer.show();
    }
}
