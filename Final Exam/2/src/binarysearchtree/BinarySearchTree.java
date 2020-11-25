package binarysearchtree;

public class BinarySearchTree {

    private static int level(Node root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Node root; //ref to root node on tree

    public void addNode(Node node){ 
    //method to add a node on the tree
     if(root == null){ //if the root is empty
         root = node; //set node as the root of the tree
     } 
     else{ //if the root is not empty
         insertNode(root, node); //insert a node on the tree 
     } //using function insertNode
}
    public void insertNode(Node parent, Node node){ 
    //method to insert a node on the tree
        if(parent.getValue() > node.getValue()){ //if the value of parent > node
            if(parent.leftChild == null){ //if the leftChild of parent is null
                parent.leftChild = node; //set node as the leftChild of parent node
            }
            else{ //if the leftChild of parent is not null
                insertNode(parent.leftChild, node); //call function insertNode to
            } //insert a node as a child of the leftChild of parent node
        }
        else{ //if the value of parent <= node
            if(parent.rightChild == null){ //if the rightChild of parent is null
                parent.rightChild = node; //set node as the rightChild of parent node
            }
            else{ //if the rightChild of parent is not null
                insertNode(parent.rightChild, node); //call function insertNode to
            } //insert a node as a child of the rightChild of parent node
        }
    }

    int minValue(Node root){ //method to get the minimum value of tree
        int minv = root.value; //set the value of root of the tree as minv
        while (root.leftChild != null){ //repeat if the leftChild of root is not null
            minv = root.leftChild.value; //update minv as the value of the leftChild of root
            root = root.leftChild; //update root as the leftChild of root
        } 
        return minv; //return the minimum value of the tree
}

    public void deleteNode(int value) { //method to delete node of the tree based on value
            root = deleteFunc(root, value); //using deleteFunc function
}

    public Node deleteFunc(Node root, int value){ 
    //function to delete node of the tree based on value
        if (root == null){ //if the tree is empty
            return root; //return root
        }
        
        // Otherwise, recur down the tree
        if (value < root.value) //if the value < the value of root
            root.leftChild = deleteFunc(root.leftChild, value); 
        else if (value > root.value) //id the value > the value of root
            root.rightChild = deleteFunc(root.rightChild, value); 
  
        // if value is same as root's value, then 
        // this is the node to be deleted 
        else{ 
            // node with only one child or no child 
            if (root.leftChild == null) //if the leftChild of root is null
                return root.rightChild; //return the rightChild of root
            else if (root.rightChild == null) //if the rightChild of root is null
                return root.leftChild; //return the leftChild of root
  
            // node with two children: 
            // Get the inorder successor (smallest in the right subtree)
            root.value = minValue(root.rightChild); //set the min value of right subtree as the value of root
  
            // Delete the inorder successor 
            root.rightChild = deleteFunc(root.rightChild, root.value); 
        } 
        return root;
    } 

    public static void preorderPrint(Node root) { 
    //method to print all elements in a binary tree in preorder process
    //The the root node is printed first, then left subtree, and the last is right subtree 
        if ( root != null ) { //if root is not null
            System.out.print( root.value + " " ); //Print the value root node
            preorderPrint( root.leftChild ); //Print the item in left subtree recursively
            preorderPrint( root.rightChild ); //Print the item in right subtree recursively
        }
    }

    public static void postorderPrint(Node root) {
    //method to print all elements in a binary tree in postorder process
    //The left subtree is printed first, then right subtree and the last is the root node
        if ( root != null ) { //if root is not null
            postorderPrint( root.leftChild ); //Print the item in left subtree recursively
            postorderPrint( root.rightChild ); //Print the item in right subtree recursively
            System.out.print( root.value + " " ); //Print the value root node
        }
    }

    public static void inorderPrint(Node root) {
    //method to print all elements in a binary tree in inorder process
    //The left subtree is printed first, then the root node, and the last is right subtree
        if ( root != null ) { //if root is not null
           inorderPrint( root.leftChild ); //Print the item in left subtree recursively
           System.out.print( root.value + " " ); //Print the item in right subtree recursively
           inorderPrint( root.rightChild ); // Print items di pohon cabang kanan
        }
    } 

    public static boolean searchValue(Node root, int value){
    //method to searchValue in binary tree
        if(root == null){ //if the tree is empty
            return false; //return false
        }
        else{ //if the tree is not empty
            if(root.getValue() == value){ //if the value of root = the value that we search
                return true; //return true
            }
            else if(root.getValue() > value){ //if the value of root > the value that we search
                return searchValue(root.leftChild, value); //search the value in the leftChild of root
            }
            else{ //if the value of root < the value that we search
                return searchValue(root.rightChild, value); //search the value in the rightChild of root
            }
        }
    } 
}