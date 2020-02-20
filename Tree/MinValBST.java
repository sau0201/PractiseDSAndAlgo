
import java.io.*;

public class MinValBST{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeUtil.stringToTreeNode(line);
            int ret = findMin(root);
            System.out.println(ret);
            int max = findMax(root);
            System.out.println(max);
        }
    }

    static int findMin(TreeNode root) {
        if(root==null) return 0;
        TreeNode curr = root;
        while(curr.left!=null){
            curr=curr.left;
        }
        return curr.val;
    }

    static int findMax(TreeNode root) {
        if(root==null) return 0;
        TreeNode curr = root;
        while(curr.right!=null){
            curr=curr.right;
        }
        return curr.val;
    }
}