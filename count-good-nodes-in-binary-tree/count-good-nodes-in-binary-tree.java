/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int num = 0;
    public int goodNodes(TreeNode root) {
        if(root==null){
            return num;
        }
        
        dfs(root, root.val);
        return num;
    }
    
    public void dfs(TreeNode root, int maxValSoFar){
        if(root==null){
            return;
        }
        if(root.val>=maxValSoFar){
            num++;
        }
        
        dfs(root.left, Math.max(maxValSoFar, root.val));
        dfs(root.right, Math.max(maxValSoFar, root.val));
        
    }
}