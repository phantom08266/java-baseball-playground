package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserGameNumberControllerTest {

    @Mock
    private Scanner scanner;

    @InjectMocks
    private UserGameNumberController userGameNumberController;


    @BeforeEach
    void setup() {
        userGameNumberController = new UserGameNumberController(scanner);
    }

    @Test
    @DisplayName("사용자 입력값을 게임값으로 변경 가능하다")
    void test1() {
        //given
        String userGameNumber = "123";
        given(scanner.nextLine()).willReturn("123");
        //when
        Set<Integer> makedGameNumber = userGameNumberController.makeGameNumber(userGameNumber);
        Set<Integer> gameNumber = userGameNumberController.getGameNumber();
        //then
        assertThat(makedGameNumber).contains(1);
        assertThat(makedGameNumber).contains(2);
        assertThat(makedGameNumber).contains(3);
        assertThat(gameNumber)
            .contains(1)
            .contains(2)
            .contains(3)
            .hasSize(3);
    }

    @Test
    @DisplayName("사용자 입력값에 중복된 값이 있으면 False")
    void test2() {
        //given
        Set<Integer> gameNumber = new LinkedHashSet<>();
        gameNumber.add(1);
        gameNumber.add(1);
        gameNumber.add(2);
        //when
        boolean numberSizeIsThree = userGameNumberController.validGameNumberSize(gameNumber);
        //then
        assertThat(numberSizeIsThree).isFalse();
    }

    @Test
    @DisplayName("사용자 입력값에 중복된 값이 없다면 게임숫자로 변환하는데 성공한다.")
    void test3() {
        //given
        String userGameNumber = "123";
        //when
        Set<Integer> gameNumbers = userGameNumberController.makeGameNumber(userGameNumber);
        //then
        assertThat(gameNumbers)
            .hasSize(3)
            .contains(1)
            .contains(2)
            .contains(3)
            .doesNotContainNull();
    }

    @Test
    @DisplayName("사용자 입력값에 중복된 값이 있다면 게임숫자로 변환하는데 실패한다.")
    void test4() {
        //given
        String userGameNumber = "122";
        //when
        Set<Integer> gameNumbers = userGameNumberController.makeGameNumber(userGameNumber);
        //then
        assertThat(gameNumbers).hasSizeLessThan(UserGameNumberController.GAME_NUMBER_SIZE);
    }
}