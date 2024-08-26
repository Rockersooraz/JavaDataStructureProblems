package calculator;

/*
Objective: Implement basic arithmetic operations using a single string expression that includes
        numbers and operators.
        Requirements:
        Implement a method calculate(String expression) that takes a string expression like "3.5 +
        2.1" and returns the result.
        The method should:
        Parse the string to identify the numbers and the operator.
        Perform the corresponding arithmetic operation based on the operator ( + , - , * , / ).
        Return the result as a double or an appropriate error message if the operation is invalid.
        Handle basic operations:
        calculate("3.5 + 2.1") should return 5.6 .
        calculate("10 - 4") should return 6.0 .
        calculate("6 * 7") should return 42.0 .
        calculate("8 / 2") should return 4.0 .
        If the expression is invalid (e.g., "10 / 0" ), return an error message like "Division by zero is
        not allowed." or "Invalid expression." .

 2. Handling Multiple Operations in a Single String
Objective: Allow the calculator to process a more complex string containing multiple arithmetic
operations.
Requirements:
Extend the calculate(String expression) method to handle expressions with multiple
operations, like "3 + 5 * 2 - 4 / 2" .
Parse the expression and break it down into individual numbers and operators.
Handle operator precedence, ensuring that multiplication and division are performed before
addition and subtraction.
Example:
calculate("3 + 5 * 2 - 4 / 2") should return 10.0 .


 */

import Array.Utility;

import java.util.Scanner;

public class Calculate {


    static double calculate(String expression) {
        double[] integerInput = Utility.convertToDoubleArray(expression.trim().split("\\+|\\-|\\*|\\/"));
        if (expression.contains("/")) {
            expression.indexOf('/');

            return performDivision(integerInput);
        } else if ((expression.contains("*"))) {
            return performMultiplication(integerInput);
        } else if (expression.contains("+")) {
            return performAddition(integerInput);
        } else {
            return performSubtraction(integerInput);
        }
    }

    static double performAddition(double[] integerInput) {
        double sum = 0.0;
        for (double intInput : integerInput) {
            sum += intInput;
        }
        return Double.valueOf(sum);
    }

    static double performSubtraction(double[] integerInput) {
        double result = 0.0;
        for (int i = 0; i < integerInput.length; i++) {
            result = i==0 ? integerInput[i] - result : result - integerInput[i];
        }
        return Double.valueOf(result);
    }

    static double performMultiplication(double[] integerInput) {
        double result = 1.0;
        for (int i = 0; i < integerInput.length; i++) {
            result = integerInput[i] * result;
        }
        return Double.valueOf(result);
    }

    static double performDivision(double[] integerInput) {
//        int result = 1;
//        for (int i = 0; i < integerInput.length; i++) {
//            result =  integerInput[i] / ;
//        }
        return Double.valueOf(integerInput[0]/integerInput[1]);
    }

    public static void main(String[] args) {
        while (true) {

            System.out.println("Input the number with operand for calculation or press exit to exit");
            Scanner scanner = new Scanner(System.in);
            String stringInput = scanner.nextLine();
            if (stringInput.equals("exit")) {
                System.out.println("Exiting From Calculator");
                break;
            }
            System.out.println("stringInput = " + calculate(stringInput));
        }
    }
}
