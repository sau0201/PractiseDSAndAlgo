class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int []>(){
            public int compare(int [] a1, int [] a2){
                if(a1[0]==a2[0]) return a2[1]-a1[1];
                else return a1[0]-a2[0];
            }
        });
        List<int []> result = new ArrayList();
        int endMin = intervals[0][1];
        int startMin = intervals[0][0];
        for(int i=1; i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(endMin>=start){
                endMin = Math.max(endMin, end);
            }else{
                result.add(new int []{startMin, endMin});
                endMin = end;
                startMin = start;
            }
        }
        
        result.add(new int []{startMin, endMin});
        int [][] arr = new int [result.size()][2];
        return result.toArray(arr);
    }
}