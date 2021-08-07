class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Trie root = new Trie();
        for(String word:words){
            root.insertWord(word);
        }
        
        return root.dfs(s);
        
    }
    
    class Trie{
        TrieNode root;
        int count;
        
        Trie(){
            root = new TrieNode();
        }
        
        void insertWord(String word){
            TrieNode current = root;
            for(char c:word.toCharArray()){
                current = current.children.computeIfAbsent(c, k->new TrieNode());
            }
            ++current.isEndOfWord;
        }
        
        int dfs(String word){
            dfs(word, root, 0);
            return count;
        }
        
        void dfs(String word, TrieNode root, int index){
            for(char c:root.children.keySet()){
                int newIndex = word.indexOf(c, index);
                if(newIndex!=-1){
                    TrieNode current = root.children.get(c);
                    if(current.isEndOfWord>0) count +=current.isEndOfWord;
                    dfs(word, current, newIndex+1);
                }
            }
            
        }
    }
    
    class TrieNode {
        Map<Character, TrieNode> children;
        int isEndOfWord;
        
        TrieNode(){
            children = new HashMap();
        }
    }
}