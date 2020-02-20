import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        char [] ch = s.toCharArray();
        List<String> list = new ArrayList<String>();
        List<String> solList = new ArrayList<String>();
        helper(list, ch, 0, solList);
        return list;
    }
    
    void helper(List<String> list, char [] ch, int index, 
                List<String> solList){
        
        if(solList.size()==4){
            StringBuilder sb = new StringBuilder();
            for(String s:solList){
                sb.append(s).append(".");
            }
            list.add(sb.toString());
            return;
        }
        
        for(int i=index;i<index+3;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=index;j<=i;j++){
                System.out.println(j);
                System.out.println(new String(ch));
                sb.append(ch[j]);
            }
            int ip = Integer.parseInt(sb.toString());
            if(ip==0 || ip<=255){
                solList.add(sb.toString());
                helper(list, ch, index+sb.length(), solList);
                solList.remove(solList.size()-1);
            }else{
                break;
            }
        }
    }
}

public class MainClass {
    
    public static void main(String[] args) {
        List<String> ret = new Solution().restoreIpAddresses("25525511135");
        for(String s:ret)
        System.out.println("Ans = " + s);
    }
}