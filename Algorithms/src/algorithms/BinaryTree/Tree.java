/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author coolp_000
 */
public class Tree {
    public Node root;
    public void insert(int value)
    {
        insert(root, value);
    }
    private void insert(Node head, int value)
    {
        if(head == null)
        {
            head = new Node();
            head.value = value;
            if(root == null)
            {
                root = head;
            }
        }
        
        else if(value < head.value)
        {
           
            if(head.left == null)
            {
                Node new_node = new Node();
                new_node.value = value;
                head.left=new_node;
            }
            else
            {
                insert(head.left,value);
            }
        }
        else
        {
            if(head.right == null)
            {
                Node new_node = new Node();
                new_node.value = value;
                head.right=new_node;
            }
            else
            {
                insert(head.right,value);
            }
        }   
        
    }
    
    public Node findparent(Node head, int value)
    {
        if (head == null)
            return null;
        if(value < head.value)
        {
            if (head.left != null)
            {
                if( head.left.value == value)
                    return head;
                else 
                    return findparent(head.left, value);
            }
        }
        else if(value > head.value)
        {
            if (head.right != null)
            {
                if (head.right.value == value)
                    return head;
                else
                    return findparent(head.right,value);
            }
        }
       
        return null;
    }
    
    private Node minValueParent(Node head)
    {
        while(head.left == null)
            head = head.left;
        return head;

    }

    
    public void delete(Node head, int value)
    {
        //System.out.println(head.value);
        if(head == null)
            return;
        else if (value < head.value)
            delete(head.left, value);
        else if(value > head.value)
            delete(head.right,value);
        else
        {

            if (head.left == null & head.right == null)
            {
                //System.out.println(head.value);
                if (head.value == root.value)
                {
                    root = null;
                }
                else
                {
                    Node temp = findparent(root, head.value);                
                    if(head.value > temp.value)
                        temp.right = null;
                    else if (head.value < temp.value)
                        temp.left= null;
                }
                //System.out.println(head);
            }
            else if(head.left == null)
            {
                Node temp = head.right;
                head.value = temp.value;
                head.right = temp.right;
            }
            else if(head.right == null)
            {
                Node temp = head.left;
                head.value = temp.value;
                head.left =temp.left;
                
            }
            else
            {
                Node minparent = minValueParent(head.right);
                head.value = minparent.left.value;
                minparent.left = null;
                        
            }
        }
                  
        
    }
    
    public void inorder(Node root)
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }
    
    public void preorder(Node root)
    {
        if (root == null)
            return;
        System.out.println(root.value);
        preorder(root.left);
        preorder(root.right);
    }
    
    public void postorder(Node root)
    {
        if (root ==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.value);
    }
    
    public int heightOfTree()
    {
        Queue<Node> q = new LinkedList<>();
        int height = 0;
        if(root != null)
        {
         q.add(root);
        }
        int nodeCount;
        while(true)
        {
            nodeCount = q.size();
            if(nodeCount == 0)
            {
                return height;
            }
            height++;
            while(nodeCount > 0)
            {
                Node parent = q.remove();
                if (parent.left != null)
                {
                    q.add(parent.left);
                }
                if (parent.right != null)
                {
                    q.add(parent.right);
                }
                nodeCount--;
            }
        }  
    }
    
    public static void main(String[] args)
    {
        Tree tree= new Tree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(2);
        tree.insert(9);
        tree.insert(6);
        tree.inorder(tree.root);
        System.out.println("---height of tree--");
        System.out.println(tree.heightOfTree());
        System.out.println("--- post order--");
        tree.postorder(tree.root);
        System.out.println("-- pre order");
        tree.preorder(tree.root);
        System.out.println("---delete 5---");
        tree.delete(tree.root, 5);
        tree.inorder(tree.root);
        System.out.println("---delete 9---");
        tree.delete(tree.root, 9);
        tree.inorder(tree.root);
        System.out.println("---delete 6---");
        tree.delete(tree.root, 6);
        tree.inorder(tree.root);
    }
    
}
