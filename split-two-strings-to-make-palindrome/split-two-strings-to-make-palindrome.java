class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        if(isPalindrome(a)|| isPalindrome(b)){
            return true;
        }
        
        if(checkPalindrome(a, b) || checkPalindrome(b, a)){
            return true;
        }
        
        return false;
    }
    
    boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    
    boolean checkPalindrome(String a, String b){
        int i=0; int j= b.length()-1;
        
        if(a.charAt(i)!=b.charAt(j)) return false;
        
        while(i<j){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j--;
                continue;
            }else{
                String str = b.substring(i, j+1);
                if(isPalindrome(str)){
                    return true;
                }
                String str2 = a.substring(i, j+1);
                if(isPalindrome(str2)){
                    return true;
                }
                return false;
            }
        }
        return true;
    }
}