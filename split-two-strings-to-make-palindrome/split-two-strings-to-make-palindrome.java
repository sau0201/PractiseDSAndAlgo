class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        
        if(checkPalindrome(a, b) || checkPalindrome(b, a)){
            return true;
        }

        return false;
    }
    
    boolean isPalindrome(String str, int i, int j){
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
        
        while(i<j){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j--;
                continue;
            }else{
                if(isPalindrome(a, i, j)){
                    return true;
                }
                if(isPalindrome(b, i, j)){
                    return true;
                }
                return false;
            }
        }
        return true;
    }
}