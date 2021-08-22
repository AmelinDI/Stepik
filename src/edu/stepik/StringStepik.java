package edu.stepik;


public class StringStepik {
    public static void main(String[] args) {
//        String inputString = "2*(-7+2)";
        String inputString = "2*((-7)+2)";
        System.out.println(inputString + "=" + calculate(inputString));
    }

    static int calculate(String mathString) {
        Integer indexOfChar;

        indexOfChar = mathString.indexOf('('); // ищем правую скобку
        if (indexOfChar >= 0) {
            int leftCount = 1;
            int rightCount = 0;
            for (int i = indexOfChar + 1; i < mathString.length(); i++) {
                switch (mathString.charAt(i)) {
                    case '(':
                        leftCount++;
                        break;
                    case ')':
                        rightCount++;
                        if (leftCount == rightCount) {

                            return calculate(mathString.substring(0, indexOfChar)
                                    + Integer.valueOf(calculate(mathString.substring(indexOfChar + 1, i))).toString()
                                    + mathString.substring(i + 1)
                            );
                        }
                        break;
                }
            }
            return calculate(mathString.substring(0, indexOfChar)) / calculate(mathString.substring(indexOfChar + 1));
        }

        indexOfChar = mathString.indexOf('+');
        if (indexOfChar > 0) {
            return calculate(mathString.substring(0, indexOfChar)) + calculate(mathString.substring(indexOfChar + 1));
        }

        indexOfChar = mathString.indexOf('-');
        if (indexOfChar > 0){
            Character prevChar = mathString.charAt(indexOfChar-1);
            if (prevChar != '+' && prevChar != '*' && prevChar != '/' && prevChar != '(') {
                return calculate(mathString.substring(0, indexOfChar)) - calculate(mathString.substring(indexOfChar + 1));
            }
        }

        indexOfChar = mathString.indexOf('*');
        if (indexOfChar > 0) {
            return calculate(mathString.substring(0, indexOfChar)) * calculate(mathString.substring(indexOfChar + 1));
        }

        indexOfChar = mathString.indexOf('/');
        if (indexOfChar > 0) {
            return calculate(mathString.substring(0, indexOfChar)) / calculate(mathString.substring(indexOfChar + 1));
        }

        return Integer.parseInt(mathString);
    }

}


