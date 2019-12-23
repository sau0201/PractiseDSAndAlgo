import java.util.Random;

class DutchFlagProblem {

    public static void main(String[] args) {
        char flag[] = {'R','G','B','R','G','B','R','G','B'};
        sortColors(flag);
        for (int i = 0; i < flag.length; i++) {
            System.out.println(flag[i]);
        }
    }
    public static void sortColors(char [] nums) {
        quickSort(nums, 0, nums.length-1);
    }
    
    static void quickSort(char [] nums , int lo, int hi){
        if(lo>=hi)return;
        char pivot='G';
        int lt=lo;
        int i=lo;
        int gt=hi;
        
        while(i<=gt){
            if(i<=gt && nums[i]>pivot){
                swap(nums, i,lt);
                i++;lt++;
            }else if(i<=gt&&nums[i]<pivot){
                swap(nums, i,gt);
                gt--;
            }else{
                i++;
            }
            while(i<=gt&&nums[gt]<pivot){
                gt--;
            }
        }
        
    }
    
    static void swap(char [] nums, int first, int second){
        if(first!=second){
            char temp = nums[second];
            nums[second] = nums[first];
            nums[first]= temp;
        }
    }
}