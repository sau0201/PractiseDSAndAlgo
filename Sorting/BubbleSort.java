import java.util.*;

public class BubbleSort{
    public static void main(String [] args){
        int [] nums ={64, 34, 25, 12, 22, 11, 90};
        bubbleSortLeftToRight(nums);
        int [] arr ={64, 34, 25, 12, 22, 11, 90};
        bubbleSortRightToLeft(arr);
        int [] sort ={64, 34, 25, 12, 22, 11, 90};
        int n = sort.length;
        bubbleSortRecursive(sort, n-1);
        System.out.println("Printing bubble up recurively");
        for(int i=0;i<sort.length;i++){
            System.out.println(sort[i]);
        }
    }

    static void bubbleSortLeftToRight(int nums[]){
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1]= nums[j];
                    nums[j]= temp;
                }
            }
        }
        System.out.println("Printing bubble up");
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    static void bubbleSortRightToLeft(int nums[]){
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=n-1;j>i;j--){
                if(nums[j-1]>nums[j]){
                    int temp = nums[j-1];
                    nums[j-1]= nums[j];
                    nums[j]= temp;
                }
            }
        }
        System.out.println("Printing bubble down");
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    static void bubbleSortRecursive(int []arr, int n){
    if(n==0) return;
    for(int i=0;i<n;i++){
        if(arr[i]>arr[i+1]){
            int temp = arr[i+1];
            arr[i+1] = arr[i];
            arr[i] = temp;
        }
    }
    bubbleSortRecursive(arr,n-1);
}
}