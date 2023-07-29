package org.DSA.Trees;


import java.util.Stack;

import org.DSA.Trees.KthAncestorInaTree.Node;
public class IterativePostOrder {

    public static void iterativePostOrderBest(Node root){
        Stack<Node> stk = new Stack<>();
        Node curr = root;
        while(curr!=null || stk.empty() == false){
            if(curr!=null){
                stk.push(curr);
                curr = curr.left;
            }
            else{
                Node temp = stk.peek().right;
                if(temp == null){
                    temp = stk.pop();
                    System.out.print(temp.data+" ");
                    while(stk.empty() == false && temp == stk.peek().right){
                        temp = stk.pop();
                        System.out.print(temp.data + " ");
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
    }

    public static void iterativePostOrderShit(Node root){
        Stack<Node> stk = new Stack<>();
        Stack<Node> ans = new Stack<>();
        stk.push(root);
        while(stk.empty() == false){
            Node temp = stk.pop();
            ans.push(temp);

            if(temp.left!=null){
                stk.push(temp.left);
            }

            if(temp.right!=null){
                stk.push(temp.right);
            }
        }
        while(ans.empty() == false){
            System.out.print(ans.peek().data);
            ans.pop();
        }
    }
    public static void main(String[] args) {
        Node root = null;
        root = new KthAncestorInaTree().buildTree(root);
        iterativePostOrderBest(root);
        root = null;
        root = new KthAncestorInaTree().buildTree(root);
        System.out.println();
        iterativePostOrderShit(root);
    }
}
