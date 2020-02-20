import java.util.*;


public class PhoneNumber{
    static long count =0;
    static HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();

    public static void main(String[] args) {
        numPhoneNumbers(1, 4);
        System.out.println(count);
    }

    static long numPhoneNumbers(int startdigit, int phonenumberlength) {
        map.put(0, new Integer[]{4,6});
        map.put(1, new Integer[]{6,8});
        map.put(2, new Integer[]{7,9});
        map.put(3, new Integer[]{4,8});
        map.put(4, new Integer[]{0,3,9});
        map.put(5, new Integer[]{});
        map.put(6, new Integer[]{0,1,7});
        map.put(7, new Integer[]{2,6});
        map.put(8, new Integer[]{1,3});
        map.put(9, new Integer[]{2,4});
        
       countPhoneNumbers(startdigit,phonenumberlength );
       return count;
        
    }
    
    
    static void countPhoneNumbers(int start,int phoneLength){
        List<Integer> [][] dp = new ArrayList [10][phoneLength+1];
        for(int i=0;i<10;i++){
            for(int j=0;j<=2;j++){
                dp[i][j] = new ArrayList<Integer>();
            }
            dp[i][1].add(i);
            Collections.addAll(dp[i][2], map.get(i));
            
        }
        
        for(int i=3;i<=phoneLength;i++){
            dp[start][i] = new ArrayList<Integer>();
            for(Object childO:dp[start][i-1]){
                int child = (Integer)childO;
               dp[start][i].addAll(dp[child][2]);
           }
        }
        
        count = dp[start][phoneLength].size();
    }
}

