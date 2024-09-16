import java.util.Scanner;
public class Day_7_Trapping_Rain_Water
{
    public static int trap(int[] height)
    {
        if (height == null || height.length < 3)
        {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;
        while (left < right)
        {
            if (height[left] <= height[right])
            {
                if (height[left] >= leftMax)
                {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax)
                {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size =sc.nextInt();
        int[] heights = new int[size];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<size;i++)
        {
            heights[i]=sc.nextInt();
        }
        System.out.println("Total water trapped: " + trap(heights) + " units");
    }
}