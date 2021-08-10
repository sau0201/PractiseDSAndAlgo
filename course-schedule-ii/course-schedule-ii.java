class Solution {
    int time =0;
    List<Integer> list = new ArrayList();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] arr = new int [numCourses];
        int [] dep = new int [numCourses];
        
        Arrays.fill(arr, -1);
        Arrays.fill(dep, -1);
        
        Set<Integer>[] graph = new HashSet[numCourses];
        for(int [] req:prerequisites){
            int s = req[0];
            int d = req[1];
            if(graph[s]==null) graph[s] = new HashSet();
            graph[s].add(d);
        }
        
        for(int i=0;i<numCourses;i++){
            if(arr[i]==-1){
                if(!dfs(i, arr,dep, graph)) return new int []{};
            }
        }
        
        int [] resultArray = new int [numCourses];
        for(int i=0;i< numCourses; i++) resultArray[i] = list.get(i);
        return resultArray;
    }
    
    boolean dfs(int s,int [] arr, int [] dep, Set<Integer>[] graph ){
        arr[s]= time++;
        Set<Integer> children = graph[s];
        if(null!=children){
            for(Integer child:children){
                if(arr[child]==-1 ){
                    if(!dfs(child, arr, dep, graph)) return false;
                }
                else{
                    if(dep[child]==-1) return false;
                }
            }
        }
        dep[s]=time++;
        list.add(s);
        return true;
    }
}