

public class GeneratePermutationsString{
    public static void main(String [] args){
        String str = "123";
        permutations(str, "", str.length());
    }

    static void permutations(String str, String slate, int length ){
        if (length==0){
            System.out.println(slate);
            return;
        }
        for(int i=0;i<str.length();i++){
            permutations(str.substring(0,i)+str.substring(i+1, str.length()), slate+""+str.charAt(i), length-1);
        }
    }
}