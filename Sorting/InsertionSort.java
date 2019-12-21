import java.util.*;

public class InsertionSort{

    public static void main(String[] args) {
        int [] nums = { 12, 11, 13, 5, 6,1 }; 
        insertionSortIterative(nums);
        int arr[] = { 12, 11, 13, 5, 6 ,1}; 
        int n = arr.length;
        insertionSortRecursive(arr,n-1);
        System.out.println("Printing Insert Sort Recursive");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    static void insertionSortIterative(int [] nums){
        int n = nums.length;
        if(n!=1){
            for(int i=1;i<n;i++){
                int key = nums[i];
                int j=i-1;
                while(j>=0 && nums[j]>key){
                        nums[j+1]=nums[j];
                        j--;
                }
                nums[j+1] = key;
            }
        }
        System.out.println("Printing Insert Sort Iterative");
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }

    static void insertionSortRecursive(int [] nums, int lastIndex){
        //Base case
        if(lastIndex==0) return;
        insertionSortRecursive(nums,lastIndex-1);
        int i=lastIndex-1;
        int last = nums[lastIndex];
        while(i>=0 && nums[i]>last){
            nums[i+1] = nums[i];
            i--;
        }
        nums[i+1] = last;
    }
}