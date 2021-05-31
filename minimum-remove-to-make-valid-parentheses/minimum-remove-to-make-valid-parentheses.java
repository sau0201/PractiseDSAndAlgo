class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack();
        for(int i=0;i<sb.length();i++){
            char c = sb.charAt(i);
            if(c=='('){
                stack.add(i);
            }else if(c==')'){
                if(stack.isEmpty()){
                    sb.deleteCharAt(i);
                    i--;
                }else{
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty() && sb.length()>0){
            int index = stack.pop();
            sb.deleteCharAt(index);
        }
        return sb.toString();
    }
}