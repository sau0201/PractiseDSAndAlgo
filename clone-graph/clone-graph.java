/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Integer, Node> visited = new HashMap<>();
        dfs(node, visited);
        return visited.get(node.val);
    }
    
    private void dfs(Node node, Map<Integer, Node> visited){
        if(node==null){
            return;
        }
        
        int value = node.val;
        Node newNode = new Node(value);
        visited.put(value, newNode);
        
        List<Node> neighs = node.neighbors;
        for(Node childNode:neighs){
            int childVal = childNode.val;
            Node newChildNode = null;
            if(!visited.containsKey(childVal)){
                dfs(childNode, visited);
            }
            newChildNode = visited.get(childVal);
            newNode.neighbors.add(newChildNode);
        }
    }
}