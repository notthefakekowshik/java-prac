package org.DSA.Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class KthAncestorInaTree {

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    public Node buildTree(Node root){
        root = new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        return root;
    }
    public void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);
    }

    public int kthAncestor(Node root, int k, int node)
    {
            if(k==0){
                return -1;
            }
            if(node == root.data){
                return -1;
            }
            HashMap<Integer,Node> parents = new HashMap<Integer,Node>();
            Queue<Node> q = new LinkedList<Node>();
            parents.put(root.data,root);
            q.add(root);
            while(q.size() > 0)
            {
                int cnt = q.size();
                while(cnt -- >0)
                {
                    Node curr = q.poll();
                    if(curr.left!=null)
                    {
                        q.add(curr.left);
                        parents.put(curr.left.data,curr);
                    }
                    if(curr.right!=null)
                    {
                        q.add(curr.right);
                        parents.put(curr.right.data,curr);
                    }
                }
            }
            Node curr = parents.get(node);
            k-=1;
            while(k > 0 && curr.data!= root.data)
            {
                curr = parents.get(curr.data);
                k-=1;
            }
            if(curr.data == root.data && k >= 1){
                return -1;
            }
            return curr.data;

    }

    public static void main(String[] args) {
        Node root=null;
        KthAncestorInaTree kthAncestorInaTree = new KthAncestorInaTree();
        root = kthAncestorInaTree.buildTree(root);
        //kthAncestorInaTree.inorder(root);

        System.out.println(kthAncestorInaTree.kthAncestor(root,2,4));
    }
}
