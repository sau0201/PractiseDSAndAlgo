import java.util.*;

public class graphTransformation{
    public static void main(String args[]){
        String [] words = new String [] {"hat","bad","had","bat"};
        String [] newWords = string_transformation(words, "cat", "had");
        System.out.println("printing ans");
        for(String str:newWords){
            System.out.println(str);
        }
    }

    static String[] string_transformation(String[] words, String start, String stop) {
        if(start.length()!=stop.length()) return new String[]{"-1"};
        List<String> list = new LinkedList<String>();
        List<String> wordsGiven = new ArrayList<String>();
        Collections.addAll(wordsGiven, words);
        wordsGiven.add(stop);
        int length = wordsGiven.size();

        Queue<Integer> q = new LinkedList<Integer>();
        boolean [] visited = new boolean [length];
        int [] parent = new int [length];
        q.add(-1);
        int stop_idx = -1;
        while(!q.isEmpty()){
            String cur_str = "";
            int cur_idx = q.remove();
            if(cur_idx == -1){
                cur_str = start;
            }else{
                cur_str = wordsGiven.get(cur_idx);
            }
            for(int i=0;i<length;i++){
                if(!visited[i] && getDiff(cur_str, wordsGiven.get(i))){
                    parent[i] = cur_idx;
                    if(i==length-1) {
                        stop_idx = i;
                        break;
                    }
                    visited[i]=true;
                    q.add(i);
                }
            }
            if(stop_idx !=-1) break;
        }

        if(stop_idx !=-1){
            while(stop_idx!=-1){
                list.add(wordsGiven.get(stop_idx));
                stop_idx = parent[stop_idx];
            }
            Collections.reverse(list);
            list.add(0,start);
            return list.toArray(new String[list.size()]);
        }else return new String[]{"-1"};
    }
    
    static boolean getDiff(String cur_str, String dest){
        int count=0;
        char [] ch = cur_str.toCharArray();
        char [] c = dest.toCharArray();
        if(c.length!=ch.length) return false;
        for(int i=0;i<c.length;i++){
            if(c[i]!=ch[i]) count++;
            if(count>1) return false;
        }
        return count==1;
    } 
}
