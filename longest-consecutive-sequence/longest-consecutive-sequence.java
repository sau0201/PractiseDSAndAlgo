class Solution {
    int [] size;
    int [] parents;
    Map<Integer, Integer> map;
    int maxSize;
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return 1;
        size = new int [n];
        parents = nums.clone();
        Arrays.fill(size, 1);
        
        map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        maxSize =1;
        
        for(int i=0;i<nums.length;i++){
            int source = nums[i];
            int dest = source+1;
            if(map.containsKey(dest)){
                int srParent = findParent(source);
                int destParent = findParent(dest);
                if(srParent!=destParent){
                    union(srParent, destParent);
                }
            }
        }
        
        return maxSize;
    }
    
    int findParent(int num){
        int index = map.get(num);
        int parent = parents[index];
        if(num!=parent){
            parents[index] = findParent(parent);
        }
        
        return parents[index];
        
    }
    
    void union(int src, int dest){
        int srcIndex = map.get(src);
        int destIndex = map.get(dest);
        size[srcIndex] += size[destIndex];
        parents[destIndex] = src;
        maxSize = Math.max(maxSize, size[srcIndex]);
    }
}