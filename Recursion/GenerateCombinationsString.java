
public class GenerateCombinationsString{
    public static void main(String [] args){
        String str = "123";
        combinations(str, "", str.length());
    }

    static void combinations(String str, String slate, int length ){
        if (length==0){
            System.out.println(slate);
            return;
        }
        for(int i=0;i<str.length();i++){
            combinations(str, slate+""+str.charAt(i), length-1);
        }
    }
}