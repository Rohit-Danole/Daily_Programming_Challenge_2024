import java.util.*;
public class Day_12_Valid_Paranthesis_With_Multiple_Types
{
    public static boolean parantheses(String s)
    {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c=='(' || c=='{'||c=='[')
            {
                st.push(c);
            }
            else if(c==')' && st.peek()=='(' && !st.isEmpty())
            {
                st.pop();
            }
            else if(c=='}' && st.peek()=='{' && !st.isEmpty())
            {
                st.pop();
            }
            else if(c==']' && st.peek()==']' && !st.isEmpty())
            {
                st.pop();
            }
            else{
                return false;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input = sc.nextLine();

        boolean result=parantheses(input);
        System.out.println(result);
        sc.close();
    }
}