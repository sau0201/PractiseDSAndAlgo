class Solution {
    public int shortestWay(String source, String target) {
        int index=0; int prevIndex = 0;
        int count =0 ;
        while(index<target.length()){
            prevIndex = getNewIndex(source, target, index);
            if(prevIndex==-1) return -1;
            index = prevIndex;
            count++;
        }
        return count;
    }
    
    int getNewIndex(String src, String target, int index){
        int i=0; int j= index;
        while(i<src.length() && j<target.length()){
            if(src.charAt(i)==target.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j==index?-1:j;
    }
}