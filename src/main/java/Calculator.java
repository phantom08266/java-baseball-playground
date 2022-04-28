import java.util.ArrayList;

public class Calculator {

    private ArrayList<String> marks = new ArrayList<>();

    public int totalArgsCalculate(String[] args) {
        boolean check = false;
        int number = 0;
        int total = 0;
        for (String arg : args) {
            if (isMark(arg)) {
                check = true;
                continue;
            }

            number = Integer.parseInt(arg);

            if (check) {
                total = calculate(total, number);
                check = false;
                continue;
            }
            total += number;
        }

        return total;
    }

    private int calculate(int lValue, int rValue) {
        if (marks.isEmpty()) return 0;

        String mark = marks.get(0);
        marks.clear();
        switch (mark) {
            case "+":
                return lValue + rValue;
            case "-":
                return lValue - rValue;
            case "*":
                return lValue * rValue;
            case "/":
                return lValue / rValue;
        }
        return 0;
    }

    private boolean isMark(String arg) {
        switch (arg) {
            case "+":
                marks.add("+");
                return true;
            case "-":
                marks.add("-");
                return true;
            case "*":
                marks.add("*");
                return true;
            case "/":
                marks.add("/");
                return true;
        }
        return false;
    }
}
