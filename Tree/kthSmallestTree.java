import java.io.*;

public class kthSmallestTree{

    static int count=0; static int number = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeUtil.stringToTreeNode(line);
            line = in.readLine();
            int val = Integer.parseInt(line);
            int ret = kth_smallest_element(root, val);
            System.out.println(ret);
        }
    }
    static int kth_smallest_element(TreeNode root, int k) {
        if(root==null) return 0;
        inorder(root, k);
        return number;
    }
    static void inorder(TreeNode root, int k){
        if(root.left!=null){
            inorder(root.left, k);
        }
        if(count!=k) count ++;
        if(count==k){
            number = root.val;
            return;
        }
        if(root.right!=null){
            inorder(root.right, k);
        }
    }


}