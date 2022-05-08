package baseball;

import static org.mockito.BDDMockito.given;

import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BaseBallGameViewerTest {

    @Mock
    BaseBallGameMachine baseBallGameMachine;

    @Mock
    UserGameNumberController userGameNumberController;

    @Mock
    BaseBallNumberMaker baseBallNumberMaker;

    @InjectMocks
    private BaseBallGameViewer baseBallGameViewer;

    private Set<Integer> userNumberSet;
    private Set<Integer> machineNumberSet;


    @BeforeEach
    void setup() {
        userNumberSet = new LinkedHashSet<>();
        userNumberSet.add(1);
        userNumberSet.add(2);
        userNumberSet.add(3);

        machineNumberSet = new LinkedHashSet<>();
        machineNumberSet.add(1);
        machineNumberSet.add(2);
        machineNumberSet.add(3);
    }

    @Test
    @DisplayName("컴퓨터가 만든 게임번호와 사용자가 입력한 게임번호가 일치하여 루프를 빠져나온다.")
    void test1() {
        //given
        given(baseBallNumberMaker.createRandomGameNumber()).willReturn(machineNumberSet);
        given(userGameNumberController.getGameNumber()).willReturn(userNumberSet);
        given(baseBallGameMachine.validation(userNumberSet, userNumberSet)).willReturn(true);

        //when then
        baseBallGameViewer.show();
    }
}