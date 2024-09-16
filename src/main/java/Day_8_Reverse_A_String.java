import java.util.Scanner;

public class Day_8_Reverse_A_String
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to reverse word by word:");
        String input = scanner.nextLine();
        System.out.println("Reversed String: [" + reverseStringWordToWord(input) + "]");
        scanner.close();
    }
    private static String reverseStringWordToWord(String s)
    {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--)
        {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
