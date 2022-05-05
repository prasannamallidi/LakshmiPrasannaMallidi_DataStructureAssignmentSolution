package Trees;

import java.util.*;
import java.lang.*;

class Node
{
    int key;
    Node left, right;
    Node(int data)
    {
        key = data;
        left = null;
        right = null;
    }
}

public class RSkewedTree
{
    public static Node node;
    static Node headNode = null;
    static Node prevNode = null;
    
    static void bstToRST(Node root)
    {
        if(root == null)
        {
            return;   
        }
        bstToRST(root.left);
        Node rightNode = root.right;
        Node leftNode = root.left;
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
        bstToRST(rightNode);
    }
    
    static void printRST(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.key + " ");
        printRST(root.right);
    }
    
    public static void main(String[] args)
    {
        RSkewedTree tree = new RSkewedTree();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);
        bstToRST(node);
        printRST(headNode);
    }
}