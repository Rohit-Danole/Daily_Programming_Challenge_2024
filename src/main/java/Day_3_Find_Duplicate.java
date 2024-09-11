import java.util.Scanner;

public class Day_3_Find_Duplicate {
    public static int findDuplicates(int arr[] ){
        int n = arr.length - 1;
        int originalSum = n * (n + 1) / 2;
        int actualSum = 0;

        for(int i : arr) {
            actualSum += i;
        }

        return actualSum - originalSum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int duplicate = findDuplicates(arr);
        System.out.println("The duplicate number is: " + duplicate);

        sc.close();
    }
}

