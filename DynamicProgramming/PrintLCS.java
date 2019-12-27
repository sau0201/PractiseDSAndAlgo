import java.util.*;

public class PrintLCS {
    public static void main(String[] args) {
        String s1 = "AGGTAB"; 
        String s2 = "GXTXAYB"; 
        String lcs = printLCS(s1, s2);
        System.out.println(lcs);
    }

    static String printLCS(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        char [] c1 = s1.toCharArray();
        char [] c2 = s2.toCharArray();
        int [][] dp = new int [m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(c1[i-1]==c2[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                else  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        StringBuilder sb  = new StringBuilder();
        int i=m;int j=n;
        while(i>0 && j>0){
            if(c1[i-1]==c2[j-1]){
                sb.append(c1[i-1]);
                i--;j--;
            }else {
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else {
                    j--;
                }
            }
        }

        return sb.reverse().toString();
    }
}