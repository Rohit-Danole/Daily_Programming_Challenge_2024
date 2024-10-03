import java.util.*;
public class Day_23_Sliding_Window
{
    public static List<Integer> maxSlidingWindow(int[] arr, int k)
    {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < arr.length; i++)
        {
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
            {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i])
            {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1)
            {
                result.add(arr[deque.peekFirst()]);
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the window size k: ");
        int k = scanner.nextInt();
        List<Integer> result = maxSlidingWindow(arr, k);
        System.out.println("Maximums for each sliding window of size " + k + ": " + result);
        scanner.close();
    }
}