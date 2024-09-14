import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Day_6_Subarray_With_Sum_Zero
{
    public static List<int[]> findZeroSumSubarraysBF(int[] arr)
    {
        int n = arr.length;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            for (int j = i; j < n; j++)
            {
                sum += arr[j];
                if (sum == 0)
                {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    public static List<int[]> findZeroSumSubarrays(int[] arr)
    {
        int n = arr.length;
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);
        for (int i = 0; i < n; i++)
        {
            sum += arr[i];
            if (sumMap.containsKey(sum))
            {
                List<Integer> indices = sumMap.get(sum);
                for (int start : indices)
                {
                    result.add(new int[]{start + 1, i});
                }
            }
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
        return result;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++)
        {
            arr[i] = scanner.nextInt();
        }
        List<int[]> result = findZeroSumSubarrays(arr);

        if (result.isEmpty())
        {
            System.out.println("No subarray with sum zero found.");
        } else {
            System.out.println("Subarrays with zero sum:");
            for (int[] subarray : result)
            {
                System.out.println("Subarray: (" + subarray[0] + ", " + subarray[1] + ")");
            }
        }
        scanner.close();
    }
}
