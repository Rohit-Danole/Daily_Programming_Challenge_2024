import java.util.*;
public class Day_1_Sort_Array_0s_1s_2s
{
    public List<Integer> sortArrays(List<Integer> arr)
    {
        int low = 0, mid = 0, high = arr.size() - 1;
        while (mid <= high)
        {
            switch (arr.get(mid))
            {
                case 0:
                    Collections.swap(arr, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    Collections.swap(arr, mid, high--);
                    break;
                default:
                    break;
            }
        }
        return arr;
    }
}
class SortArray
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> arr= new ArrayList<>();
        System.out.println("Enter the size of array");
        int n = input.nextInt();
        System.out.println("Enter the elements of array");
        for(int i=0;i<n;i++)
        {
            arr.add(input.nextInt());
        }
        Day_1_Sort_Array_0s_1s_2s obj = new Day_1_Sort_Array_0s_1s_2s();
        obj.sortArrays(arr);
        System.out.println("Sorted Array : " + arr);
    }
}


