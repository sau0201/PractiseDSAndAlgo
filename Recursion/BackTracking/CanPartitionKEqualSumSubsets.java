import java.util.*;

public class CanPartitionKEqualSumSubsets {

    public static void main(String args[]) {
        int[] nums = new int[] { 1,5,15,3,11,2,4,10,9,12,8,13,7,14,6 };
        int k=6;
        System.out.println(canPartitionKSubsets(nums, k));
    }

    static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num:nums)sum += num;
        if(k>nums.length) return false;
        if(sum%k !=0) return false;
        int target = sum/k;
        int cur_sum =0;
        boolean [] visited = new boolean [nums.length];
        boolean returnValue =  canPartition(nums, k, target, cur_sum, 0, "", visited);
        return returnValue;
    }

    static boolean canPartition(int[] nums, int k, int target, int cur_sum, int cur_Index, 
                                String slate, boolean[] visited){
        if(k==1) return true;
        if(cur_sum == target){
            System.out.println("when sum==target " + slate);
            return canPartition(nums, k-1, target, 0, 0, "", visited);
        }
        if(cur_sum > target){
            return false;
        }
        else{
            for(int i=cur_Index;i<nums.length;i++){
                if(!visited[i]){
                    visited[i]= true;
                    if(canPartition(nums, k, target, cur_sum+nums[i], i+1, 
                        slate+"-"+nums[i], visited)){
                        return true;
                    }else{
                        visited[i]=false;
                    }
                }
            }
        }
        return false;
    }
}