class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet(wordList);
        List<List<String>> result = new ArrayList();
        if(!wordSet.contains(endWord)) return result;
        
        Map<String, List<String>> map = new HashMap();
        Set<String> beginSet = new HashSet();
        beginSet.add(beginWord);
        
        buildGraph(beginSet, endWord, map, wordSet, beginWord.length());
        dfs(beginWord, map, result, new ArrayList(), endWord);
        return result;
    }
    
    void dfs(String beginWord, Map<String, List<String>> map, List<List<String>> result, List<String> slate,  String endWord){
        slate.add(beginWord);
        if(beginWord.equals(endWord)){
            result.add(new ArrayList(slate));
        }else{
            List<String> childList = map.get(beginWord);
            if(null !=childList){
                for(String word:childList){
                    dfs(word, map, result, slate, endWord);
                }
            }
        }
        
        slate.remove(slate.size()-1);
            
    }
    
    
    void buildGraph(Set<String> beginSet, String endWord, Map<String, List<String>> map,Set<String> wordSet, int n){
        if(beginSet.size()==0) return;
        boolean hasFound=false;
        wordSet.removeAll(beginSet);
        Set<String> tempSet = new HashSet();
        for(String begin:beginSet){
            if(map.get(begin) == null) map.put(begin, new ArrayList());
            Set<String> childSet  = getChildren(begin, wordSet, n);
            for(String child:childSet){
                if(child.equals(endWord)) hasFound=true;
                tempSet.add(child);
                //if(map.get(begin)==null) map.put(begin, new ArrayList());
                map.get(begin).add(child);
            }  
        }
        
        if(!hasFound) buildGraph(tempSet, endWord, map, wordSet, n);
    }
    
    
    
    Set<String> getChildren(String source, Set<String> set, int n){
        Set<String> childSet = new HashSet();
        char ch[] = source.toCharArray();
        for(int i=0;i<n;i++){
            char k = ch[i];
            for(char c='a';c<='z';c++){
                ch[i] = c;
                if(c==k) continue;
                String word = new String(ch);
                if(set.contains(word)){
                    childSet.add(word);
                } 
            }
            ch[i]=k;
        }
        
        return childSet;
    }
}