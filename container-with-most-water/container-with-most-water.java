class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = Math.min(height[left], height[right])*(right-left);
        int area = maxArea;
        while(left<right){
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
            area = Math.min(height[left], height[right])*(right-left);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}