import java.util.*;

public class Day_22_First_Element_Repeating_K_Times
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        for (int num : arr)
        {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (int num : arr)
        {
            if (frequencyMap.get(num) == k)
            {
                System.out.println(num);
                return;
            }
        }
        System.out.println(-1);
    }
}