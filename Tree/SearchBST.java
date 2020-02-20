import java.io.*;

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        TreeNode curr = root;
        
        while(curr!=null){
            if(curr.val==val) return curr;
            else if(curr.val>val) curr = curr.left;
            else if(curr.val<val) curr = curr.right;
        }
        return null;
    }
}

public class SearchBST {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeUtil.stringToTreeNode(line);
            line = in.readLine();
            int val = Integer.parseInt(line);
    
            TreeNode ret = new Solution().searchBST(root, val);
            
            String out = TreeUtil.treeNodeToString(ret);
            
            System.out.print(out);
        }
    }
}