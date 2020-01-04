package BackTracking;

public class SubsetWithoutab {

    public static void main(String args[]) {
        String str = "abcd" ;
        createPermutationstWithoutab(str, "ab", 4, "");
    }

    static void createPermutationstWithoutab(String str, String target, int len, String slate) {
       if(len==0){
           System.out.println(slate);
           return;
       }
       else{
           for(int i=0;i<str.length();i++){
               if(!(slate+""+str.charAt(i)).contains(target) ){
                createPermutationstWithoutab(str.substring(0, i) + str.substring(i+1), 
                target, len-1, slate+""+str.charAt(i));
               }
            }
       }
    }
}