package binarysearchtree;

public class Main {
   public static void main(String[] args) {
        // TODO Auto-generated method
        BinarySearchTree bt = new BinarySearchTree();
        bt.addNode(new Node(54));
        bt.addNode(new Node(31));
        bt.addNode(new Node(20));
        bt.addNode(new Node(78));
        bt.addNode(new Node(49));
        bt.addNode(new Node(14));
        bt.addNode(new Node(65));
        bt.addNode(new Node(89));
        bt.addNode(new Node(100));
        bt.addNode(new Node(35));
        bt.addNode(new Node(52));
        bt.addNode(new Node(22));
        bt.addNode(new Node(70));
        bt.addNode(new Node(80));
        bt.addNode(new Node(60));
        
        System.out.println("\nPREODER: Root - Left - Right");
        BinarySearchTree.preorderPrint(bt.root);
        System.out.println("\nPOSTODER: Left - Right - Root");
        BinarySearchTree.postorderPrint(bt.root);
        System.out.println("\nINODER: Left - Root - Right");
        BinarySearchTree.inorderPrint(bt.root);
        
    }
}