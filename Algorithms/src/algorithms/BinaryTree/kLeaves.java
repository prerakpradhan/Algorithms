/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author coolp_000
 */
public class kLeaves {
    public static ArrayList NoOfLeaves(Node root, int k)
    {
        Queue queue = new LinkedList();
        queue.add(root);
        ArrayList<Node> nodes = new ArrayList<>();
        while(!queue.isEmpty())
        {
            Node node = (Node)queue.remove();
            ArrayList<Node> leaves = new ArrayList<>();
            countLeaves(node, leaves);
            if ((leaves.size() == k) && (node.right != null || node.left!=null))
            {
                nodes.add(node);
            }
            if(node.left != null)
            {
                queue.add(node.left);
            }
            if(node.right != null)
            {
                queue.add(node.right);
            }
        }
        return nodes;
        
    }
    
    private static void countLeaves(Node root, ArrayList<Node> array)
    {
        if(root!=null)
        {
           countLeaves(root.left, array);
           if(root.left==null && root.right == null)
           {
               array.add(root);
           }
           countLeaves(root.right, array);
        }
        
    }
    
    public static void main(String[] args)
    {
        Node root = new Node();
        root.value = 5;
        Node left = new Node();
        left.value = 10;
        Node right = new Node();
        right.value =100;
        root.left=left;
        root.right=right;
        ArrayList<Node> nodesWithLeaves = NoOfLeaves(root, 2);
        for(Node n : nodesWithLeaves)
        {
            System.out.println(n.value);
        }
    }
}
