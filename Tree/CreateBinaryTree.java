

public class CreateBinaryTree{
    public static void main(String [] args){
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        System.out.println(root.key);
        System.out.println(root.left.key);
        System.out.println(root.right.key);
        System.out.println(root.left.left.key);
    }
}
class Node{
    int key;
    Node left;
    Node right;

    Node(int key){
        this.key=key;
    }
}