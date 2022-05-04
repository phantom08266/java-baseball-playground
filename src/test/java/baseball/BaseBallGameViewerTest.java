package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BaseBallGameViewerTest {

    @Mock
    BaseBallGameMachine baseBallGameMachine;

    @Mock
    UserGameNumberController userGameNumberController;

    @InjectMocks
    private BaseBallGameViewer baseBallGameViewer;


    @Test
    @DisplayName("컴퓨터가 만든 게임번호와 사용자가 입력한 게임번호가 일치하여 루프를 빠져나온다.")
    void test1() {
        //given
        String userGameNumber = "123";
        given(userGameNumberController.getGameNumber()).willReturn(userGameNumber);
        given(baseBallGameMachine.validation(userGameNumber)).willReturn(true);

        //when then
        baseBallGameViewer.show();
    }
}