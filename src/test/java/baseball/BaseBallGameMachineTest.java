package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameMachineTest {

    private BaseBallGameMachine baseBallGameMachine;

    private Set<Integer> machineGameNumbers;
    private Set<Integer> userGameNumbers;

    @BeforeEach
    void setup() {
        baseBallGameMachine = new BaseBallGameMachine();

        machineGameNumbers = new LinkedHashSet<>();
        machineGameNumbers.add(1);
        machineGameNumbers.add(2);
        machineGameNumbers.add(3);

        userGameNumbers = new LinkedHashSet<>();
        userGameNumbers.add(1);
        userGameNumbers.add(2);
        userGameNumbers.add(3);
    }

    @Test
    @DisplayName("게임머신 값과 사용자 입력값이 일치한다.")
    void test1() {
        long equalCount = baseBallGameMachine.getEqualCount(userGameNumbers, machineGameNumbers);
        boolean sameGameNumber = baseBallGameMachine
            .validSameGameNumber(userGameNumbers, machineGameNumbers);
        boolean validation = baseBallGameMachine.validation(userGameNumbers, machineGameNumbers);
        assertThat(equalCount).isEqualTo(machineGameNumbers.size());
        assertThat(sameGameNumber).isTrue();
        assertThat(validation).isTrue();
    }

    @Test
    @DisplayName("2개의 값이 위치, 값 모두 일치하면 2스트라이크!")
    void test2() {
        //given
        machineGameNumbers = new LinkedHashSet<>();
        machineGameNumbers.add(1);
        machineGameNumbers.add(2);
        machineGameNumbers.add(4);

        //when
        long strikeCount = baseBallGameMachine
            .validStrikeGameNumber(userGameNumbers, machineGameNumbers);
        boolean validation = baseBallGameMachine.validation(userGameNumbers, machineGameNumbers);
        //then
        assertThat(strikeCount).isEqualTo(2);
        assertThat(validation).isFalse();
    }

    @Test
    @DisplayName("값이 1개 일치한다면 1볼이다.")
    void test3() {
        //given
        machineGameNumbers = new LinkedHashSet<>();
        machineGameNumbers.add(6);
        machineGameNumbers.add(3);
        machineGameNumbers.add(5);

        //when
        long ballCount = baseBallGameMachine
            .validBallGameNumber(userGameNumbers, machineGameNumbers);
        boolean validation = baseBallGameMachine.validation(userGameNumbers, machineGameNumbers);
        //then
        assertThat(ballCount).isEqualTo(1);
        assertThat(validation).isFalse();
    }
}