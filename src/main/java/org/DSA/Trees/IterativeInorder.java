package org.DSA.Trees;

import java.util.Stack;

import org.DSA.Trees.KthAncestorInaTree.Node;
public class IterativeInorder {
    
    public static void IterativeInorder(Node root){
        Stack<Node> stk = new Stack<>();
        Node curr = root;
        while(curr!=null || stk.empty() == false)
        {
            while(curr!=null)
            {
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            System.out.print(curr.data+ " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        KthAncestorInaTree kthAncestorInaTree = new KthAncestorInaTree();
        Node root = null;
        root = kthAncestorInaTree.buildTree(root);
        IterativeInorder(root);
    

    }

}
