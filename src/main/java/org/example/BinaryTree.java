package org.example;

public class BinaryTree {

    public class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    public Node root;
    public BinaryTree(){
        root=null;
    }
    public boolean accept(int data){
        Node newNode = new Node(data);
        if(root==null){
            root= newNode;
            return true;
        }
        else{
            Node current=root, parent=null;
            while(true){
                parent=current;
                if(data < current.data) {
                    current = current.left;
                    if(current == null) {
                        parent.left = newNode;
                        return true;
                    }
                }
                else {
                    current = current.right;
                    if(current == null) {
                        parent.right = newNode;
                        return true;
                    }
                }
            }

        }
    }
    public void inorderTraversal(Node node) {
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }
        else {
            if(node.left!= null)
                inorderTraversal(node.left);
            System.out.print(node.data + " ");
            if(node.right!= null)
                inorderTraversal(node.right);
        }
    }

    public int getLevel(Node node, int value, int level){
        if (node == null)
            return 0;
        if (node.data == value)
            return level;
        int downlevel = getLevel(node.left, value, level + 1);
        if (downlevel != 0)
            return downlevel;
        downlevel = getLevel(node.right, value, level + 1);
        return downlevel;
    }

    public int depth(Node node, int value){
        return getLevel(node,value,1);
    }

    public int treeDepth(Node root){
        if (root==null)
            return 0;
        else
        {
            int ldepth = treeDepth(root.left);
            int rdepth = treeDepth(root.right);

            if (ldepth > rdepth)
                return(ldepth+1);
            else return(rdepth+1);
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.accept(30);
        bt.accept(20);
        bt.accept(10);
        bt.accept(16);
        bt.accept(40);
        bt.accept(50);
        System.out.println("\nBinary search tree after insertion: ");
        bt.inorderTraversal(bt.root);
        System.out.println("\nDepth of 10 is: "+bt.depth(bt.root, 10));
        System.out.println("\nDepth of Binary Search Tree is: "+bt.treeDepth(bt.root));

    }
}
