import java.util.*;
public class Day_2_Missing_Number {
    public static int findMissingNum(int arr[], int n)
    {
        Arrays.sort(arr);
        int Sum =0;
        int last =arr[n-1];
        for(int i=1;i<=last;i++)
        {
            Sum += i;
        }
        int actualSum =0;
        for(int i=0;i<n;i++)
        {
            actualSum += arr[i];
        }
        return Sum - actualSum;
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter element in array:");
        for(int i=0;i<n;i++)
        {
            arr[i] =s.nextInt();
        }
        System.out.println("Missing Number is : "+findMissingNum(arr,n));
    }
}