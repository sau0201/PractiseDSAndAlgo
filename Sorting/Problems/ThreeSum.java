import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        String newArr[] = findZeroSum(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }
    }

    /*
     * Complete the function below.
     */
        /*
     * Complete the function below.
     */
    static String[] findZeroSum(int[] nums) {
        List<String> parentList = new ArrayList();
        int n = nums.length;
        if(nums.length<2) return new String []{""}; 
        Arrays.sort(nums);
        for(int k=0;k<n-2;k++){
            
            if(nums[k]>0) break;
            if(k>0 && nums[k-1] == nums[k]) continue;
            
            int target = -nums[k];
            int i= k+1; int j=n-1;
            while(i<j){
                int sum = nums[i]+nums[j];
                if(target==sum){
                    String str = ""+nums[k]+","+nums[i]+","+nums[j];
                    parentList.add(str);
                    
                    while(i<j && (i+1)<n && nums[i+1]==nums[i]) i++;
                    while(i<j && (j-1)>k && nums[j-1]==nums[j]) j--;
                    
                    i++;j--;
                    
                }else if(target>sum) i++;
                else j--;
                
            }
        }
        String [] finalArray = new String [parentList.size()];
        return parentList.toArray(finalArray);
    }
}
