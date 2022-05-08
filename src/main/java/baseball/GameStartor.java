package baseball;

import java.util.Scanner;

public class GameStartor {

    private final Scanner scanner;

    public GameStartor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        // 객체들간의 의존성 연결
        // 리펙토링 책에 나오는 객체들 간의 초기화 부분!
        BaseBallGameMachine baseBallGameMachine = new BaseBallGameMachine();
        UserGameNumberController userGameNumberController = new UserGameNumberController(scanner);
        BaseBallNumberMaker baseBallNumberMaker = new BaseBallNumberMaker();
        BaseBallGameViewer baseBallGameViewer = new BaseBallGameViewer(baseBallGameMachine,
            userGameNumberController, baseBallNumberMaker);

        boolean gameLoop = true;
        while (gameLoop) {
            baseBallGameViewer.show();
            System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
            gameLoop = checkGameStart(scanner.nextLine());
        }
    }

    private boolean checkGameStart(String gameKey) {
        switch (gameKey) {
            case "1":
                return true;
            case "2":
                return false;
        }
        return false;
    }
}
