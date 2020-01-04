import java.util.*;

public class GenerateCombinationsStringBFS {
    public static void main(String[] args) {
        String str = "123";
        for (String s : permutations(str, str.length())) {
            System.out.println(s);
        }
    }

    static List<String> permutations(String str, int length) {
        if (length == 1) {
            return Arrays.asList(str);
        }
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            List<String> prevResult = permutations(str.substring(0, i) + str.substring(i + 1), length - 1);
            for (String s : prevResult) {
                result.add(str.charAt(i) + "" + s);
            }
        }
        return result;
    }
}