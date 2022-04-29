import java.util.*;
import java.util.stream.Collectors;

public class Calculator {

    public static final String DEFAULT_CALCULATOR_MARK = "+";
    private String[] marks = {"+", "-", "*", "/"};

    public int totalArgsCalculate(String[] args) {

        List<String> marks = Arrays.stream(args).filter(this::isMark)
                .collect(Collectors.toList());

        Queue<String> marksQueue = new LinkedList<>();
        marksQueue.add(DEFAULT_CALCULATOR_MARK); // 코드 효율을 위한 +산술연산 추가 (이런 상황 및 주석 없는게 좋은데.. 더좋은 방법이 안떠오름.)
        marksQueue.addAll(marks);

        List<Integer> numbers = Arrays.stream(args).filter(arg -> !isMark(arg))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int total = 0;
        for (int num : numbers) {
            String mark = marksQueue.poll();
            total = calculate(total, num, mark);
        }

        return total;
    }

    private int calculate(int lValue, int rValue, String mark) {
        if (mark == null) return 0;

        switch (mark) {
            case "+":
                return add(lValue, rValue);
            case "-":
                return sub(lValue, rValue);
            case "*":
                return multiple(lValue, rValue);
            case "/":
                return division(lValue, rValue);
        }
        return 0;
    }

    private boolean isMark(String arg) {
        return Arrays.asList(marks).contains(arg);
    }

    private int add(int lValue, int rValue) {
        return lValue + rValue;
    }

    private int sub(int lValue, int rValue) {
        return lValue - rValue;
    }

    private int multiple(int lValue, int rValue) {
        return lValue * rValue;
    }

    private int division(int lValue, int rValue) {
        return lValue / rValue;
    }
}
