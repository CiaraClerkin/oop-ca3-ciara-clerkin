import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class ArithmeticExpressionCalculator {
    public static void main(String[] args) {
        //Stack<Integer> results = new Stack<Integer>;
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();
        Scanner in = new Scanner(System.in);

        System.out.printf("Enter an arithmetic expression: ");
        String expression = in.nextLine();
        String[] pieces = expression.split(" ");
        ArrayList<Character> operatorCheck = new ArrayList<Character>();
        operatorCheck.add('+');
        operatorCheck.add('-');
        operatorCheck.add('*');
        operatorCheck.add('/');
        operatorCheck.add('(');
        operatorCheck.add(')');

        int result = 0;
        boolean bracket = false;

        for (int i = 0; i < pieces.length; i++) {

            if (operatorCheck.contains(pieces[i].charAt(0))) {
                //if (pieces[i].charAt(0) == '(') {
                char operator = pieces[i].charAt(0);
                System.out.println(bracket);
                if (operator == '(') {
                    bracket = true;
                }
                else if (operator == ')') {
                    bracket = false;
                }
                operators.push(operator);
            }
            //else if (operatorCheck.contains(pieces[i].charAt(0))) {
            //if (operators.peek() == '(') {

            //}
            //}
            else {
                //System.out.println(operators);
                nums.push(Integer.parseInt(pieces[i]));
                if (!operators.isEmpty()) {
                    if (bracket) {
                        //System.out.println("dog");
                        char operator = operators.pop();

                        if (operator == '*') {
                            nums.push(nums.pop() * nums.pop());
                            //operators.pop();
                        } else if (operator == '/') {
                            int num1 = nums.pop();
                            int num2 = nums.pop();
                            //temporary int?
                            //System.out.println(num2 + "\t" + num1);
                            //System.out.println(num2 / num1);
                            nums.push(num2 / num1);
                            //operators.pop();
                        } else if (operator == '+') {
                            //System.out.println("hi");
                            nums.push(nums.pop() + nums.pop());
                            //operators.pop();
                        } else if (operator == '-') {
                            int num1 = nums.pop();
                            int num2 = nums.pop();
                            nums.push(num2 - num1);
                            //operators.pop();
                        }
                    }
                    else {
                        //operators.pop();
                        //operators.pop();
                        if (operators.peek() == '*') {
                            nums.push(nums.pop() * nums.pop());
                            operators.pop();
                        } else if (operators.peek() == '/') {
                            int num1 = nums.pop();
                            int num2 = nums.pop();
                            //temporary int?
                            //System.out.println(num2 + "\t" + num1);
                            //System.out.println(num2 / num1);
                            nums.push(num2 / num1);
                            operators.pop();
                        }
                    }
                }
            }

        /*if (!operators.isEmpty() && nums.size() >= 2) {
            // There is a problem where it multiplies / divides numbers too early, wrong nums
            if (operators.peek() == '*') {
                nums.push(nums.pop() * nums.pop());
                operators.pop();
            } else if (operators.peek() == '/') {
                int num1 = nums.pop();
                int num2 = nums.pop();
                //temporary int?
                System.out.println(num2 + "\t" + num1);
                System.out.println(num2 / num1);
                nums.push(num2 / num1);
                operators.pop();
            }
        }*/
        }

        while (!operators.isEmpty()) {
            System.out.println(operators);
            System.out.println(nums);
        /*if (operators.contains('*') || operators.contains('/')) {
            if (operators.peek() == '*') {
                nums.push(nums.pop() * nums.pop());
            }
            else if (operators.peek() == '/') {
                nums.push(nums.pop() / nums.pop());
            }
        }*/
            //else {
            if (nums.size() >= 2) {
                if (operators.peek() == ')') {
                    operators.pop();
                }
                if (operators.peek() == '*') {
                    nums.push(nums.pop() * nums.pop());
                    operators.pop();
                }
                else if (operators.peek() == '/') {
                    int num1 = nums.pop();
                    int num2 = nums.pop();
                    //temporary int?
                    //System.out.println(num2 + "\t" + num1);
                    //System.out.println(num2 / num1);
                    nums.push(num2 / num1);
                }
                else if (operators.peek() == '+') {
                    nums.push(nums.pop() + nums.pop());
                    operators.pop();
                } else if (operators.peek() == '-') {
                    int num1 = nums.pop();
                    int num2 = nums.pop();
                    nums.push(num2 - num1);
                    operators.pop();
                }
            }
        }

        /*while (!operators.isEmpty() && !nums.isEmpty()) {
            char operator = operators.pop();

            switch (operator) {
                case '+':
                    result += nums.pop() + nums.peek();
                    break;
                case '-':
                    result += nums.pop() - nums.peek();
                    break;
                case '*':
                    result += nums.pop() * nums.peek();
                    break;
                case '/':
                    result += nums.pop() / nums.peek();
                    break;
                case '(':
                    break;
            }
        }*/
        System.out.println(nums);

        result = nums.pop();

        System.out.println(result);

    }
}
