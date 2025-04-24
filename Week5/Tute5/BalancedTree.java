package Tute5;

import java.util.Random;

public class BalancedTree {
    public class TreeNode{
        public int data;
        public TreeNode leftChild = null, rightChild = null, parent = null;
        int height = 1, balance = 0;

        public TreeNode(int d){
            data = d;
        }

        public void update(){
            int leftHeight = (leftChild == null) ? 0 : leftChild.height;
            int rightHeight = (rightChild == null) ? 0 : rightChild.height;
            int oldHeight = height;
            height = 1 + Math.max(leftHeight, rightHeight);
            balance = leftHeight - rightHeight;
            if((height != oldHeight) && (parent != null))
                parent.update();
        }
        
        public void setLeftChild(TreeNode n){
            leftChild = n;
            if(n != null){
                n.parent = this;
            }
            update();
        }

        public void setRightChild(TreeNode n){
            rightChild = n;
            if(n != null){
                n.parent = this;
            }
            update();
        }
    }
    
    private TreeNode root = null;
    
    public TreeNode find(int findMe){
        TreeNode n = root;
        while(n != null){
            if(n.data == findMe)
                return n;
            if(n.data < findMe)
                n = n.rightChild;
            else
                n = n.leftChild;
        }
        return null;
    }
    
    /*
    * print the contents of the tree in ascending order (in-order traversal)
    */
    public void output(){
        if(root == null)
            System.out.println("Empty tree");
        else{
            output(root);
            System.out.println();
        }
    }
    
    public void output(TreeNode n){
        if(n != null){
            output(n.leftChild);
            System.out.print(n.data + " ");
            output(n.rightChild);
        }
    }
    
    // preOrder()
    public void preOrder(){
        if(root == null)
            System.out.println("Empty tree");
        else{
            preOrder(root);
            System.out.println();
        }
    }
    
    public void preOrder(TreeNode n){
        if(n != null){
            System.out.print(n.data + " ");
            preOrder(n.leftChild);
            preOrder(n.rightChild);
        }
    }

    // postOrder()
    public void postOrder(){
        if(root == null)
            System.out.println("Empty tree");
        else{
            postOrder(root);
            System.out.println();
        }
    }
    
    public void postOrder(TreeNode n){
        if(n != null){
            postOrder(n.leftChild);
            postOrder(n.rightChild);
            System.out.print(n.data + " ");
        }
    }
    
    /*
    * insert the new value, respecting the order
    */
    public void insert(int value){
        if(root == null)
            root = new TreeNode(value);
        else
            insertBelow(root, value);
    }
    
    /*
    * Recursive auxiliary function: inserts the given value below the given node
    */
    private void insertBelow(TreeNode node, int value){
        if(node.data < value)
            if(node.rightChild == null)
                node.setRightChild(new TreeNode(value));
            else
                insertBelow(node.rightChild, value);
        else
            if(node.leftChild == null)
                node.setLeftChild(new TreeNode(value));
            else
                insertBelow(node.leftChild, value);
        
        // Once the value is inserted, re-balance      
        if(node.balance > 1)
            if(node.leftChild.balance < 0)
                leftRightRotation(node);
            else
                rightRotation(node);
        else if(node.balance < -1)
            if(node.rightChild.balance > 0)
                rightLeftRotation(node);
            else
                leftRotation(node);
    }
    
    
    /*
    * Auxiliary function: replaces a node
    * If node is the root, replacement becomes the new root
    * Otherwise, node is the left/right child of some parent, and replacement takes that place
    */
    private void replaceNode(TreeNode node, TreeNode replacement){
        TreeNode parent = node.parent;
        if(parent == null){  // node is the root 
            root = replacement;
            if(root != null)
                root.parent = null;
        }
        else if(node == parent.leftChild)
            parent.setLeftChild(replacement);
        else parent.setRightChild(replacement);
    }

    private void leftRotation(TreeNode n){
        System.out.println("Rotating left at key " + n.data);
        TreeNode temp = n.rightChild.leftChild;
        replaceNode(n, n.rightChild);
        n.rightChild.setLeftChild(n);
        n.setRightChild(temp);
    }
    
    private void rightRotation(TreeNode n){
        System.out.println("Rotating right at key " + n.data);
        TreeNode temp = n.leftChild.rightChild;
        replaceNode(n, n.leftChild);
        n.leftChild.setRightChild(n);
        n.setLeftChild(temp);
    }
    
    private void leftRightRotation(TreeNode n){
        leftRotation(n.leftChild);
        rightRotation(n);
    }
    
    private void rightLeftRotation(TreeNode n){
        rightRotation(n.rightChild);
        leftRotation(n);
    }
    
    /*
    * Generates an array of the given size, containing random values
    */
    public static int[] randomValues(int howMany){
        int[] result = new int[howMany];
        Random random = new Random();
        for(int i=0; i<howMany; i++)
           result[i] = random.nextInt() % (10 * howMany);
        return result;
    }
    
    /*
    * Inserts all the values in the given array
    */
    public void insertAll(int[] values, boolean printResults){
        for(int i=0; i<values.length; i++){
            insert(values[i]);
            if(printResults){
                output();
                preOrder();
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	int[] treeA = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55 } ;
	int[] treeB = { 55, 50, 45, 40, 35, 30, 25, 20, 15, 10, 5 } ;
	int[] treeC = { 30, 25, 20, 15, 10, 5, 35, 40, 45, 50, 55 } ;
	int[] treeD = { 30, 15, 45, 10, 40, 20, 50, 5, 35, 25, 55 } ;
        // Whether to print results. Only use with small numbers of values.
        boolean printResults = true; 
        
        BalancedTree t = new BalancedTree();
        long start = System.currentTimeMillis();
        t.insertAll(treeA, printResults);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
    	System.out.println();
        System.out.println("Elapsed time = " + elapsed + " seconds");        
    }
}
