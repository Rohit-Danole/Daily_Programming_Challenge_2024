import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day_17_Prime_Factorization
{
    public static List<Integer> primeFactors(int n)
    {
        List<Integer> factors = new ArrayList<>();
        while (n % 2 == 0)
        {
            factors.add(2);
            n /= 2;
        }
        for (int i = 3; i * i <= n; i += 2)
        {
            while (n % i == 0)
            {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2)
        {
            factors.add(n);
        }
        return factors;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        List<Integer> result = primeFactors(N);
        System.out.println("Prime factors: " + result);
    }
}