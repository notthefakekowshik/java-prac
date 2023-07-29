package org.DSA.Trees;

import java.util.Stack;

import org.DSA.Trees.KthAncestorInaTree.Node;
public class IterativePreOrder {

    public static void iterativePreorder(Node root){
        Stack<Node> stk = new Stack<Node>();
        stk.push(root);
        while (stk.empty() == false){
            Node curr = stk.pop();
            System.out.print(curr.data+ " ");
            if(curr.right != null){
                stk.push(curr.right);
            }
            if(curr.left!=null) {
                stk.push(curr.left);
            }
        }
    }
    public static void main(String[] args) {
        Node root = null;
        root = new KthAncestorInaTree().buildTree(root);
        iterativePreorder(root);

    }
}
