class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==0 || k>n) return new int []{};
        if(n==1) return nums;
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> dq = new LinkedList<>();
        int [] result = new int [n-k+1]; 
        int j = 0;
        for(int i=0;i<k;i++){
            queue.add(i);
            processDQ(j, i, dq, nums, result);
        }
        
        for(int i=k;i<n;i++){
            int num = queue.remove();
            if(dq.peekFirst()==num){
                dq.removeFirst();
            }
            queue.add(i);
            processDQ(++j, i, dq, nums, result);
        }   
        return result;
    }
    
    private void processDQ(int j, int i, Deque<Integer> dq, int [] nums, int [] result){
        while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
            dq.removeLast();
        }
        dq.addLast(i);
        result[j] = nums[dq.peekFirst()];
    }
    
}