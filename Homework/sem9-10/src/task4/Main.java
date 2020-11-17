package task4;

public class Main {
    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree(5);
        myTree.insertLeft(3);
        myTree.insertRight(7);
        myTree.getLeftChild().insertLeft(2);
        myTree.getLeftChild().insertRight(4);
        myTree.getRightChild().insertRight(10);
        myTree.getRightChild().insertLeft(8);
        myTree.printLevelOrder(myTree, myTree.depthOfTree(myTree, 1));
        System.out.println(myTree.search(4, myTree));
        System.out.println(myTree.search(150, myTree));
    }
}
