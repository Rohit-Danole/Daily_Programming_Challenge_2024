import java.util.Scanner;
import java.util.Stack;
public class Day_21_Reverse_Stack_Recurrsion
{
    public static void insertAtBottom(Stack<Integer> stack,int ele)
    {
        if(stack.isEmpty())
        {
            stack.push(ele);
        }
        else
        {
            int top=stack.pop();
            insertAtBottom(stack,ele);
            stack.push(top);
        }
    }
    public static void reverseStack(Stack<Integer> stack)
    {
        if(!stack.isEmpty())
        {
            int top = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack,top);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int size = sc.nextInt();
        for(int i=0;i<size;i++)
        {
            stack.push(sc.nextInt());
        }
        reverseStack(stack);
        System.out.println(stack);
    }
}