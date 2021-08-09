class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int prevMax = nums[0];
        int prevMin = nums[0];
        int max = nums[0];
        for(int index=1;index<nums.length;index++){
            int currMax = Math.max(nums[index], Math.max(nums[index]*prevMax, nums[index]*prevMin));
            int currMin = Math.min(nums[index], Math.min(nums[index]*prevMax, nums[index]*prevMin));
            prevMax = Math.max(currMax, currMin);
            prevMin = Math.min(currMax, currMin);
            max = Math.max(max, prevMax);
        }
        
        return max;
    }
}