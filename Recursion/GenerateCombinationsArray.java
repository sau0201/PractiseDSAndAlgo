import java.util.*;
import java.util.stream.*;

public class GenerateCombinationsArray{
    public static void main(String [] args){
        int[] ints = {1,2,3};
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        permutations(list,"", ints.length);
    }

    static void permutations(List<Integer> list, String slate, int length ){
        if (length==0){
            System.out.println(slate);
            return;
        }
        for(int i=0;i<list.size();i++){
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.remove(i);
            permutations(newList, slate+""+list.get(i), length-1);
        }
    }
}