import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day_10_Group_Anagrams
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words separated by spaces (or enter 'exit' to quit):");
        while (true)
        {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit"))
            {
                break;
            }
            String[] words = input.split("\\s+");
            List<List<String>> result = groupAnagrams(words);
            printResult(result);
        }
        scanner.close();
    }
    private static List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String, List<String>> anagram = new HashMap<>();
        for (String word : strs)
        {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            anagram.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(anagram.values());
    }
    private static void printResult(List<List<String>> result)
    {
        for (List<String> group : result)
        {
            System.out.print(group + " ");
        }
        System.out.println();
    }
}
