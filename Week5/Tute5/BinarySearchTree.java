
package Tute5;

import java.util.Random;


public class BinarySearchTree {
    public class TreeNode{
        public int data, height, bf;
        public TreeNode leftChild, rightChild, parent;

        public TreeNode(int d){
            data = d;
            height = 1;
            bf = 0;
            leftChild = null;
            rightChild = null;
            parent = null;
        }

        public void setLeftChild(TreeNode n){
            leftChild = n;
            if(n != null){
                n.parent = this;
            }
        }

        public void setRightChild(TreeNode n){
            rightChild = n;
            if(n != null){
                n.parent = this;
            }
        }
    }
    
    private TreeNode root;
    
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
    * TO DO: print the contents of the tree in ascending order
    */
    public void output(String traversalMethod){
        if(root == null)
            System.out.println("Empty tree");
        switch (traversalMethod) {
            case "inOrder":
                inOrder(root);
                break;
            case "preOrder":
                preOrder(root);
                break;
            case "postOrder":
                postOrder(root);
                break;
            case "inOrderWithHeights":
                inOrderwithHeight(root);
                break;
            default:
                System.out.println("Invalid traversal method");
                break;
        }
        System.out.println();
    }
    
    public void inOrder(TreeNode n){
        if(n != null){
            inOrder(n.leftChild);
            System.out.print(n.data + " ");
            inOrder(n.rightChild);
        }
    }

    public void inOrderwithHeight(TreeNode n){
        if(n != null){
            inOrderwithHeight(n.leftChild);
            System.out.println(n.data + "( height: " + n.height + " bF: " + n.bf + " ) ");
            inOrderwithHeight(n.rightChild);
        }
    }
    
    public void preOrder(TreeNode n){
        if(n != null){
            System.out.print(n.data + " ");
            preOrder(n.leftChild);
            preOrder(n.rightChild);
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
    * TO DO: insert the new value, respecting the order
    */
    public void insert(int value){
        if(root == null)
            root = new TreeNode(value);
        else
            insertBelow(root, value);

        updateHeightsAndBf(root);
    }

    private void updateHeightsAndBf(TreeNode node){
        if(node != null){
            updateHeightsAndBf(node.leftChild);
            updateHeightsAndBf(node.rightChild);
            // Post-order traversal
            node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
            node.bf = getHeight(node.leftChild) - getHeight(node.rightChild);
        }
    }

    private int getHeight(TreeNode node){
        if(node == null)
            return 0;
        return node.height;
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

        if(node.bf > 1)
            if(node.leftChild.bf < 0)
                leftRightRotation(node);
            else
                rightRotation(node);
        else if(node.bf < -1)
            if(node.rightChild.bf > 0)
                rightLeftRotation(node);
            else
                leftRotation(node);
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
    * TO DO: find and remove the given value in case it is in the tree
    *
    * Function replaceNode below may be useful.
    */
    public void remove(int value){
        TreeNode n = root;
        while(n != null && n.data != value){
            if(n.data < value)
                n = n.rightChild;
            else
                n = n.leftChild;
        }
        if(n != null) // value found, remove it
            if(n.leftChild == null)
                replaceNode(n, n.rightChild);
            else if(n.rightChild == null)
                replaceNode(n, n.leftChild);
            else{
                TreeNode m = n.leftChild;
                while(m.rightChild != null)
                    m = m.rightChild;
                n.data = m.data;
                replaceNode(m, m.leftChild);
            }
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
            // if(printResults)
            //     output("inOrder");
        }
    }
    
    /*
    * Removes all the values in the given array, if present
    */
    public void removeAll(int[] values, boolean printResults){
        for(int i=0; i<values.length; i++){
            remove(values[i]);
            // if(printResults)
            //     output("inOrder");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 10; 
        // Whether to print results. Only use with small numbers of values.
        boolean printResults = true; 
        
        BinarySearchTree t = new BinarySearchTree();
        
        final int[] treeA = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55 } ;
        final int[] treeB = { 55, 50, 45, 40, 35, 30, 25, 20, 15, 10, 5 } ;
        final int[] treeC = { 30, 25, 20, 15, 10, 5, 35, 40, 45, 50, 55 } ;
        final int[] treeD = { 30, 15, 45, 10, 40, 20, 50, 5, 35, 25, 55 } ;

        int[] a = treeD;
        
        if(printResults){
            System.out.print("Input values: ");
            for(int i=0;i<numValues; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }
        long start = System.currentTimeMillis();
        t.insertAll(a, printResults);
        t.output("inOrderWithHeights");
        // t.removeAll(a, printResults);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
    	System.out.println();
        System.out.println("Elapsed time = " + elapsed + " seconds");        
    }
}
