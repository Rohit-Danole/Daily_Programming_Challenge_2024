import java.util.Scanner;

public class Day_18_Number_Of_Divisors
{
    public static int countDivisors(int n)
    {
        int count = 0;
        for (int i = 1; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                count++;
                if (i != n / i)
                {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        int result = countDivisors(N);
        System.out.println("Total number of divisors: " + result);
    }
}