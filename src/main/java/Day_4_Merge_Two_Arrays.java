import java.util.Arrays;
import java.util.Scanner;

public class Day_4_Merge_Two_Arrays
{
    public static void merge(int[] arr1, int m, int[] arr2, int n)
    {
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n)
        {
            if (arr1[i] > arr2[j])
            {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the first array: ");
        int m = sc.nextInt();
        int[] arr1 = new int[m];
        System.out.println("Enter " + m + " elements for the first array:");
        for (int i = 0; i < m; i++)
        {
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter the size of the second array: ");
        int n = sc.nextInt();
        int[] arr2 = new int[n];
        System.out.println("Enter " + n + " elements for the second array:");
        for (int i = 0; i < n; i++)
        {
            arr2[i] = sc.nextInt();
        }
        merge(arr1, m, arr2, n);
        System.out.println("Merged first array: " + Arrays.toString(arr1));
        System.out.println("Merged second array: " + Arrays.toString(arr2));
    }
}