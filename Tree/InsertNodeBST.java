import java.io.*;

class Solution {
    public TreeNode insertNode(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode curr = root;
        TreeNode prev=null;
        while(curr !=null){
            if(val<curr.val){
                prev = curr;
                curr = curr.left;
            }else{
                prev=curr;
                curr = curr.right;
            }
        }

        if(val<prev.val) prev.left=new TreeNode(val);
        else prev.right= new TreeNode(val);

        return root;
    }
}

public class InsertNodeBST {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeUtil.stringToTreeNode(line);
            line = in.readLine();
            int val = Integer.parseInt(line);
            TreeNode ret = new Solution().insertNode(root, val);
            String out = TreeUtil.treeNodeToString(ret);
            System.out.print(out);
        }
    }
}