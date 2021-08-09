class Solution {
    int max = 1;
    int [][] directions = new int [][]{{1,0}, {-1,0}, {0,1},{0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        Map<String, Integer> visited = new HashMap<>();
        int m = matrix.length;
        int n= matrix[0].length;
        if(m==1 && n==1) return 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                String value = i+","+j;
                if(!visited.containsKey(value)){
                    dfs(matrix, visited, i, j, m, n);
                }
            }
        }
        
        
        
        return max;
        
    }
    
    private void dfs(int [][] matrix, Map<String, Integer> visited, int sr, int sc, int m, int n){
        
        String sourceValue = sr+","+sc;
        
        for(int [] dir:directions){
            int x = dir[0] + sr;
            int y = dir[1] + sc;
            if(x<0 || x>=m || y<0 || y>=n){
                continue;
            }
            
            if(matrix[x][y]<= matrix[sr][sc]){
                continue;
            }
            
            String childValue = x+","+y;
            if(!visited.containsKey(childValue)){
                dfs(matrix, visited, x, y, m, n);
            }
            
            int maxValueOfChild = visited.get(childValue);
            
            if(!visited.containsKey(sourceValue) || maxValueOfChild > visited.get(sourceValue)){
                visited.put(sourceValue, maxValueOfChild);
            }
        }
        
        visited.put(sourceValue, visited.getOrDefault(sourceValue, 0)+ 1);
        max = Math.max(visited.get(sourceValue), max);
    }
    
    
}