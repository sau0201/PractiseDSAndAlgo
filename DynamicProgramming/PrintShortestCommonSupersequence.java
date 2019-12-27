import java.util.*;

public class PrintShortestCommonSupersequence {
    public static void main(String[] args) {
        String X = "bbbaaaba"; 
        String Y = "bbababbb";
        String scs = printShortestSuperSeq(X, Y);
        System.out.println("scs "+scs);
        String scs2 = printShortestSuperSeqSecondMethod(X, Y);
        System.out.println("sc2 " +scs2);
    }

    static String printShortestSuperSeq(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        if(m==0) return s2;
        if(n==0) return s1;
        char [] c1 = s1.toCharArray();
        char [] c2 = s2.toCharArray();
        int [][] dp = new int [m+1][n+1];

        for(int i=0;i<=m;i++) dp[i][0] = i;
        for(int j=0;j<=n;j++) dp[0][j] = j;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(c1[i-1]==c2[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                else  dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[m][n]);
        StringBuilder sb  = new StringBuilder();
        int i=m;int j=n;
        while(i>0 && j>0){
            if(c1[i-1]==c2[j-1]){
                sb.append(c1[i-1]);
                i--;j--;
            }else {
                if(dp[i-1][j]>dp[i][j-1]){
                    sb.append(c2[j-1]);j--;
                }else {
                    sb.append(c1[i-1]);i--;
                }
            }
        }
        while(i>0){
            sb.append(c1[i-1]);
            i--;
        }
        while(j>0){
            sb.append(c2[j-1]);
            j--;
        }
        return sb.reverse().toString();
    }

    static String printShortestSuperSeqSecondMethod(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        if(m==0) return s2;
        if(n==0) return s1;
        char [] c1 = s1.toCharArray();
        char [] c2 = s2.toCharArray();
        String [][] dp = new String [m+1][n+1];
        for (String[] row : dp) 
            Arrays.fill(row, "");

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(c1[i-1]==c2[j-1]) dp[i][j] = dp[i-1][j-1] + c1[i-1];
                else  {
                    if(dp[i-1][j].length()>dp[i][j-1].length()){
                        dp[i][j] =  dp[i-1][j];
                    }else {
                        dp[i][j] =  dp[i][j-1];
                    }
                }
            }
        }

        System.out.println(dp[m][n]);
        char []  lcs = dp[m][n].toCharArray();

        StringBuilder sb = new StringBuilder();
        int i=0;int j=0;int k=0;
        
        while(i<c1.length && j<c2.length && k<lcs.length){
            while(i<c1.length && k<lcs.length && c1[i]!=lcs[k]){
                sb.append(c1[i]);
                i++;
            }
            while(j<c2.length && k<lcs.length && c2[j]!=lcs[k]){
                sb.append(c2[j]);
                j++;
            }
            while(i<c1.length && j<c2.length && k<lcs.length  && c1[i]==lcs[k] && c2[j]==lcs[k]){
                sb.append(lcs[k]);
                k++;i++;j++;
            }
        }

        while(i<c1.length){
            sb.append(c1[i]);
            i++;
        }
        while(j<c2.length){
            sb.append(c2[j]);
            j++;
        }
        return sb.toString();
    }

}