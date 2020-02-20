class SubsetEqualToSum{

    static boolean helper(int arr[], 
                            int sum, int k, int index) 
    { 
        if(sum==k && index!=0){
            return true;
        }
        
        if(index==arr.length) return false;
        
        for(int i=index;i<arr.length;i++){
            int num = arr[i];
            if(helper(arr,  sum+num, k, index+1)){
                return true;
            }
        }
        return false;
    } 
      
    public static void main (String args[]) 
    { 
        int set[] = {-4,-4,-3,-2,-1,-2,-1,0,0,0,0,1,2,2,3,4,4,4}; 
        int sum = 25; 
        if (helper(set, 0, sum, 0) == true) 
            System.out.println("Found a subset"
                          + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum"); 
    } 
}