import java.util.*;

public class EvaluateString {

    public static void main(String[] args) 
    { 
        System.out.println(EvaluateString.evaluate("10+2*6")); 
        System.out.println(EvaluateString.evaluate("100 * 2 / 12")); 
        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 )")); 
        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 ) / 14")); 
    } 

    static int evaluate(String s){
        char [] ch = s.toCharArray();
        Stack<Integer> valueStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();
        for(int i=0;i<ch.length;i++){
            char c = ch[i];
            if(c==' '){
                continue;
            }else if(Character.isDigit(c)){
                int value = ch[i]-'0';
                while(i+1<ch.length && Character.isDigit(ch[i+1]))
                    value = 10*value + ch[++i]-'0';
                valueStack.push(value);
            }else if(c=='('){
                opStack.push(c);
            }
            else if(c==')'){
                while(opStack.size()>0 && opStack.peek() != '(' )
                valueStack.push(doOperation(opStack.pop(),valueStack.pop(),valueStack.pop()));
                opStack.pop();
            }else {
                while(opStack.size()>0 && opStack.peek() != '(' && hasPrecedence(opStack.peek(),c))
                    valueStack.push(doOperation(opStack.pop(),valueStack.pop(),valueStack.pop()));
                opStack.push(c);
            }
        }

        while(opStack.size()>0 ){
            valueStack.push(doOperation(opStack.pop(),valueStack.pop(),valueStack.pop()));
        }
        return valueStack.pop();
    }

    static int doOperation(char op, int b, int a){
        if(op=='+'){
            return a+b;
        }else if(op=='-'){
            return a-b;
        }else if(op=='*'){
            return a*b;
        }else if(b!=0){
            return a/b;
        }else{
            return 0;
        }
    }

    static boolean hasPrecedence(char stackOp, char currentOp){
        if(stackOp == '(' || stackOp == ')'){
            return false;
        }else if((currentOp == '*' || currentOp == '/') && (stackOp=='+' || stackOp == '-')){
            return false;
        }else{
            return true;
        }
    }
}