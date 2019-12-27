import java.util.*;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 9, 10, 13 ,15,18, 21, 24};
        Random rand  = new Random();
        int number = rand.nextInt(25);
        int index = binarySearch(number, nums);
        System.out.println("Number "+ number);
        System.out.println("index " + index);
    }

    static int binarySearch(int number, int [] nums){
        int left =0; int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>= number) right = mid;
            else left = mid+1;
        }
        return right;
    }
}
