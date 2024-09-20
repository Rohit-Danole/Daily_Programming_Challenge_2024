import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Day_11_Permutation_Of_String
{
    public static List<String> getPermutations(String str)
    {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        permuteHelper(str, "", set);
        result.addAll(set);
        return result;
    }
    private static void permuteHelper(String str, String perm, Set<String> set)
    {
        if (str.isEmpty())
        {
            set.add(perm);
            return;
        }
        for (int i = 0; i < str.length(); i++)
        {
            permuteHelper(str.substring(0, i) + str.substring(i + 1), perm + str.charAt(i), set);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        List<String> permutations = getPermutations(input);
        System.out.println("Permutations:"+permutations);
        scanner.close();
    }
}