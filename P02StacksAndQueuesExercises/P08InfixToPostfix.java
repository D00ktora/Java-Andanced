/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 3.3.2023 г.
 * Time: 6:52
 */
package P02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(" ");
        ArrayDeque<String> output = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();
        for (int i = 0; i < inputArr.length; i++) {
            if ((inputArr[i].charAt(0) >= '0' && inputArr[i].charAt(0) <= '9') ||
                    (inputArr[i].charAt(0) >= 'a' && inputArr[i].charAt(0) <= 'z') ||
                    (inputArr[i].charAt(0) >= 'A' && inputArr[i].charAt(0) <= 'Z')) { // proverka dali e chislo ili bukva
                output.offer(inputArr[i]);
            } else { // ako ne e chislo
                if (operators.size() > 0) { // proverka dali imame operatori v steka
                    String operator = operators.peek();
                    String operatorFromInput = inputArr[i];
                    if (operator.equals("-") || operator.equals("+")) { // ako operatora v steka e - ili +
                        if (operatorFromInput.equals("-")) { // ako operatora v input e -
                            output.offer(operators.pop());
                            operators.push(operatorFromInput);
                        } else if (operatorFromInput.equals("+")) { // ako operatora v inputa e +
                            output.offer(operators.pop());
                            operators.push(operatorFromInput);
                        } else if (operatorFromInput.equals("/")) { // ako operatora v inputa e /
                            operators.push(operatorFromInput);
                        } else if (operatorFromInput.equals("*")) { // ako operatora v inputa e *
                            operators.push(operatorFromInput);
                        } else if (operatorFromInput.equals("(")) { // ako operatora e (
                            operators.push(operatorFromInput);
                        } else if (operatorFromInput.equals(")")) { // ako operatora e )
                            while (!operator.equals("(")) {
                                output.offer(operators.pop());
                                operator = operators.peek();
                            }
                            operators.pop();
                        }
                    } else if (operator.equals("/") || operator.equals("*")) { // ako operatora v steka e / ili *
                        if (operatorFromInput.equals("-")) { // ako operatora v input e -
                            output.offer(operators.pop());
                            operators.push(operatorFromInput);
                        } else if (operatorFromInput.equals("+")) { // ako operatora v inputa e +
                            output.offer(operators.pop());
                            operators.push(operatorFromInput);
                        } else if (operatorFromInput.equals("/")) { // ako operatora v inputa e /
                            output.offer(operators.pop());
                            operators.push(operatorFromInput);
                        } else if (operatorFromInput.equals("*")) { // ako operatora v inputa e *
                            output.offer(operators.pop());
                            operators.push(operatorFromInput);
                        } else if (operatorFromInput.equals("(")) { // ako operatora e (
                            operators.push(operatorFromInput);
                        } else if (operatorFromInput.equals(")")) { // ako operatora e )
                            while (!operator.equals("(")) {
                                output.offer(operators.pop());
                                operator = operators.peek();
                            }
                            operators.pop();
                        }
                    }  else if (operator.equals("(")) {
                        operators.push(operatorFromInput);
                    }
                } else {
                    operators.push(inputArr[i]);
                }
            }
        }
        for (String operator : operators) {
            output.offer(operator);
        }

        System.out.println(String.join(" ", output));
    }
}
