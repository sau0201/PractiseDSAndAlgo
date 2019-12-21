import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = { 64, 25, 12, 22, 11 };
        selectionSort(nums);
    }

    public static void selectionSort(int nums[]) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[min_index] > nums[j]) {
                    min_index = j;
                }
            }
            // swap min and i;
            int temp = nums[min_index];
            nums[min_index] = nums[i];
            nums[i] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }
}