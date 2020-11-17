package task4;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private int root;
    private BinaryTree leftChild;
    private BinaryTree rightChild;

    public BinaryTree(int root){
        this.root = root;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void insertLeft(int value){
        if (this.leftChild == null){
            this.leftChild = new BinaryTree(value);
            }
        else{
            BinaryTree tree = new BinaryTree(value);
            tree.leftChild = this.leftChild;
            this.leftChild = tree;
        }
    }

    public void insertRight(int value){
        if (this.rightChild == null)
            this.rightChild = new BinaryTree(value);
        else{
            BinaryTree tree = new BinaryTree(value);
            tree.rightChild = this.rightChild;
            this.rightChild = tree;
        }
    }

    public int depthOfTree(BinaryTree tree, int d) {
        if(tree == null) {
            return d;
        }
        int left = d;
        int right = d;
        if(tree.leftChild != null) {
            left = depthOfTree(tree.leftChild, d+1);
        }
        if(tree.rightChild != null) {
            right = depthOfTree(tree.rightChild, d+1);
        }
        return Math.max(left, right);
    }

    static void printLevelOrder(BinaryTree tree, int depth){
        if(tree == null)
            return;
        Queue<BinaryTree> q =new LinkedList<BinaryTree>();
        q.add(tree);
        while(true)
        {
            int nodeCount = q.size();
            if(nodeCount == 0)
                break;
            for(int i=0; i<depth; i++) {
                System.out.print("  ");
            }
            while(nodeCount > 0)
            {
                BinaryTree tree1 = q.peek();
                System.out.print("("+tree1.root + ")");
                q.remove();
                if(tree1.leftChild != null)
                    q.add(tree1.leftChild);
                if(tree1.rightChild != null)
                    q.add(tree1.rightChild);
                if(nodeCount>1){
                    System.out.print(", ");
                }
                nodeCount--;
            }
            depth--;
            System.out.println();
        }
    }

    public boolean search(int value, BinaryTree tree){
        try {
            int current = tree.root;
            if (current == value){
                return true;
            }
            else if (value < current){
                return search(value, tree.leftChild);
            }
            else if (value > current){
                return search(value, tree.rightChild);
            }
            return false;
        } catch (NullPointerException n){
            return false;
        }
    }

    public int getRoot() {
        return root;
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

}
