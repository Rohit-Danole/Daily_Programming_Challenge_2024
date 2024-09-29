import java.util.Scanner;
import java.util.Stack;

public class Day_19_Post_Fix_Evaluation
{

    public static int evaluatePostfix(String expression)
    {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens)
        {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
            {
                int b = stack.pop();
                int a = stack.pop();
                switch (token)
                {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b); // Integer division
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a postfix expression:");
        String expression = scanner.nextLine();
        int result = evaluatePostfix(expression);
        System.out.println("Result: " + result);
    }
}