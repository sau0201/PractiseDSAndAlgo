import java.util.*;

public class GenerateAllExpressions{
    public static void main(String[] args) {
        Set <String> list = generate_all_expressions("222", 24l);
            System.out.println(list.size());
    }
    /*
     * Complete the function below.
     */
    static Set <String> generate_all_expressions(String s, long target) {
        Set<String> list = new HashSet<String>();
        generteAllSubSets(s,list, 1, s.charAt(0)+"", target);
        return list;
    }
    
    static void generteAllSubSets(String s, Set<String> list, int curIndex, String slate , long target){
        
        if(curIndex==s.length()){
            if(isValidList(slate,target)){
                list.add(slate);
            }
            return;
        }
        char c = s.charAt(curIndex);
        
        generteAllSubSets(s, list, curIndex+1, slate+""+c,target);
        generteAllSubSets(s, list, curIndex+1, slate+"*"+c,target);
        generteAllSubSets(s, list, curIndex+1, slate+"+"+c,target);
        
    }
    
    
    static boolean isValidList(String str, long target){
        long value = evaluate(str);
        return target==value;
    }
    
    
    static long evaluate(String s){
        System.out.println("S "+s);
        char [] ch = s.toCharArray();
        Stack<Long> valueStack = new Stack<Long>();
        char sign = '+';
        for(int i=0;i<ch.length;i++){
            char c = ch[i];
            if(Character.isDigit(c)){
                long value = (long)(c-'0');
                System.out.println(value);
                while (i+1 < ch.length && Character.isDigit(ch[i+1])) {
                    value = 10 * value + (ch[++i] - '0');
                }
                System.out.println("final value "+value);
                if(sign == '+'){
                    valueStack.push(value);
                }else if (sign == '*') {
                    valueStack.push(valueStack.pop() * value);
                }
            }else{
                sign = c;
            }
        }
        long res = 0l;
        while(valueStack.size()>0){
            res +=valueStack.pop();
        }
        return res;
    }
}
