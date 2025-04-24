import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    
    public class TreeNode{
        public int data;
        public TreeNode left, right, parent;

        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private TreeNode root;

    public void printInOrder(TreeNode node){
        if(node != null){
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    public TreeNode search(int target){
        TreeNode current = root;
        while(current != null){
            if(current.data == target){
                System.out.println("Node with value " + target + " found.");
                return current;
            }
            else if(current.data > target){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        System.out.println("Node with value " + target + " not found.");
        return null;
    }

    public void insert(int data){
        TreeNode newNode = new TreeNode(data);
        if(root == null){
            root = newNode;
        }
        else{
            TreeNode current = root;
            while (true) { 
                if(current.data > data){
                    if(current.left == null){
                        current.left = newNode;
                        newNode.parent = current;
                        break;
                    }
                    else{
                        current = current.left;
                    }
                }
                else if(current.data < data){
                    if(current.right == null){
                        current.right = newNode;
                        newNode.parent = current;
                        break;
                    }
                    else{
                        current = current.right;
                    }
                }
                else{
                    System.out.println("The value " + data + " already exists in the tree.");
                    break;
                }
            }
        }
    }

    public void delete(int data){
        TreeNode current = root;
        while(current != null){
            if(current.data == data){
                // Case 1: Node has no children
                if(current.left == null && current.right == null){
                    // If the node is the root, set the root to null
                    if(current.parent == null){
                        root = null;
                    }
                    // Otherwise, set the parent's child to null
                    else if(current.parent.left == current){
                        current.parent.left = null;
                    }
                    else{
                        current.parent.right = null;
                    }
                }
                // Case 2: Node has one child
                else if(current.left == null || current.right == null){
                    // If the node is the root, set the root to the child
                    if(current.parent == null){
                        root = current.left != null ? current.left : current.right;
                        root.parent = null;
                    }
                    // Otherwise, set the parent's child to the child
                    else if(current.parent.left == current){
                        current.parent.left = current.left != null ? current.left : current.right;
                        current.parent.left.parent = current.parent;
                    }
                    else{
                        current.parent.right = current.left != null ? current.left : current.right;
                        current.parent.right.parent = current.parent;
                    }
                }
                // Case 3: Node has both children
                else{
                    // Find the inorder successor
                    TreeNode successor = current.right;
                    while(successor.left != null){
                        successor = successor.left;
                    }
                    int temp = successor.data;
                    // Delete the successor
                    delete(successor.data);

                    // Replace the current node's data with the successor's data
                    current.data = temp;
                }
                break;
            }
            else if(current.data > data){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
    }

   public static void printTree(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int maxLevel = getHeight(root);
        int width = (int) Math.pow(2, maxLevel) - 1;
        
        List<List<String>> levels = new ArrayList<>();
        
        for (int i = 0; i < maxLevel; i++) {
            levels.add(new ArrayList<>(Collections.nCopies(width, " ")));
        }
        
        fillLevels(root, 0, 0, width - 1, levels);
        
        for (List<String> level : levels) {
            System.out.println(String.join("", level));
        }
    }
    
    private static void fillLevels(TreeNode node, int level, int left, int right, List<List<String>> levels) {
        if (node == null) return;
        
        int mid = (left + right) / 2;
        levels.get(level).set(mid, String.valueOf(node.data));
        
        fillLevels(node.left, level + 1, left, mid - 1, levels);
        fillLevels(node.right, level + 1, mid + 1, right, levels);
    }
    
    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(9);
        tree.insert(5);

        System.out.println("Binary Search Tree:");
        printTree(tree.root);

        System.out.println("In-order traversal:");
        tree.printInOrder(tree.root);

        // tree.delete(5);
        // System.out.println("Binary Search Tree after deleting 5:");
        // printTree(tree.root);

        // tree.delete(9);
        // System.out.println("Binary Search Tree after deleting 9:");
        // printTree(tree.root);

        // tree.delete(6);
        // System.out.println("Binary Search Tree after deleting 7:");
        // printTree(tree.root);
    }

}