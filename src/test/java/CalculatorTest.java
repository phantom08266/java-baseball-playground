import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final String args = "2 + 3 * 4 / 2";
    private String[] readValues;

    private Calculator calculator;
    @BeforeEach
    void init() {
        System.out.println("나 호출된다");
        calculator = new Calculator();
        Scanner scanner = new Scanner(args);
        String readLine = scanner.nextLine();
        readValues = readLine.split(" ");
    }

    @Test
    void test1(){
        Assertions.assertThat(calculator.totalArgsCalculate(readValues)).isEqualTo(10);
    }
}