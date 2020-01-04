import java.util.*;

public class GeneratePermutationsStringBFS {
    public static void main(String[] args) {
        String str = "123";
        for (String s : permutations(str, str.length())) {
            System.out.println(s);
        }
    }

    static List<String> permutations(String str, int length) {
        List<String> result = new ArrayList<String>();
        for(int i=0;i<result.size();i++){
            String c = result.get(i);
            result.add(c+"");
        }
        if(length==1) return result;
        for(int i=2;i<=length;i++){
            //List<String> nextResult = new ArrayList<String>();
            
        }
        return result;
    }
}