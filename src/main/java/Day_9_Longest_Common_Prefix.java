import java.util.Arrays;
import java.util.Scanner;

public class Day_9_Longest_Common_Prefix
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] userStrings = new String[n];
        System.out.println("Enter the strings one by one:");
        for (int i = 0; i < n; i++)
        {
            System.out.print("String " + (i + 1) + ": ");
            userStrings[i] = scanner.nextLine();
        }
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(userStrings));
        scanner.close();
    }
    private static String longestCommonPrefix(String[] array)
    {
        if (array.length == 0)
        {
            return "";
        }
        Arrays.sort(array);
        int min = Integer.min(array[0].length(), array[array.length - 1].length());
        String result = "";
        for (int i = 0; i < min; i++)
        {
            if (array[0].charAt(i) == array[array.length - 1].charAt(i))
            {
                result += array[0].charAt(i);
            } else {
                break;
            }
        }
        return result;
    }
}
