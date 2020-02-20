import java.io.*;

public class FindSucessorPred {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeUtil.stringToTreeNode(line);
            line = in.readLine();
            int val = Integer.parseInt(line);
            int pre = findPrdessor(root, val);
            System.out.println("pre "+pre);
            int succ = findSuccessor(root, val);
            System.out.println("succ " + succ);
        }
    }

    static int findPrdessor(TreeNode root, int val) {
        TreeNode curr = searchForVal(root, val);
        TreeNode predessor = null;

        // When curr has right child
        if (curr.left != null) {
            TreeNode right = curr.left;
            // find min in right sub tree
            while (right.right != null) {
                right = right.right;
            }
            predessor = right;
            return predessor.val;
        }else{
            TreeNode newNode =  root;
            while(newNode != null){
                if(newNode.val == val){
                    break;
                }
                else if (val <newNode.val){
                    newNode =  newNode.left;
                }else{
                    predessor = newNode;
                    newNode =  newNode.right;
                }
            }
        }
        return predessor!= null? predessor.val:-5;
    }

    private static TreeNode searchForVal(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == val)
                return curr;
            else if (val < curr.val)
                curr = curr.left;
            else if (val > curr.val)
                curr = curr.right;
        }

        return curr;
    }

    static int findSuccessor(TreeNode root, int val) {
        TreeNode curr = searchForVal(root, val);
        TreeNode successor = null;

        // When curr has right child
        if (curr.right != null) {
            TreeNode left = curr.right;
            // find min in right sub tree
            while (left.left != null) {
                left = left.left;
            }
            successor = left;
            return successor.val;
        }
        else{
            TreeNode newNode = root;
            while(newNode!=null){
                if(newNode.val == val){
                    break;
                }else if(val<newNode.val){
                    successor = newNode;
                    newNode = newNode.left;
                }else{
                    newNode = newNode.right;
                }
            }
        }

        return successor!= null? successor.val:5000;
    }
}