class Solution {
    public int minimumSwap(String s1, String s2) {
        int x1 =0, y1=0, diff=0, x2=0, y2 = 0;
        int i = 0;
        while(i<s1.length()){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1!=c2){
                 diff++;
                if(c1=='x'){
                    x1++;
                } else {
                    y1++;
                }
                if(c2=='x'){
                    x2++;
                }else {
                    y2++;
                }
            }
            i++;
        }
        if((x1-x2)%2 !=0 || (y2-y1)%2 != 0) return -1;
        if(x1-x2 != y2-y1) return -1;
        int pair1 = Math.min(x1, y2)/2;
        int pair2 = Math.min(x2, y1)/2;
        int pairs = pair1 + pair2;
        int result = pairs + (diff - pair1*2 - pair2*2);
        
        
        return result;
    }
}