
import java.util.Stack;
import java.util.Scanner;
public class Day_20_Sort_Stack_Recurssion
{
    public static void sortStack(Stack<Integer> stack)
    {
        if (stack.isEmpty())
        {
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        insertSorted(stack, top);
    }
    private static void insertSorted(Stack<Integer> stack, int element)
    {
        if (stack.isEmpty() || stack.peek() <= element)
        {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        System.out.println(top);
        insertSorted(stack, element);
        stack.push(top);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int size = sc.nextInt();
        for(int i=0;i<size;i++)
        {
            int num = sc.nextInt();
            stack.push(num);
        }
        System.out.println("Stack before sorting: " + stack);
        sortStack(stack);
        System.out.println("Stack after sorting: " + stack);
    }
}
