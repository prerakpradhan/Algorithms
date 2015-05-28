/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.LinkedList;

/**
 *
 * @author coolp_000
 */
public class reverse {
    
    public static Node reverseLinked(Node node)
    {
        if(node == null)
        {
            return null;
        }
        Node node1 = node;
        Node node2 = node1.right;
        node1.right = null;
        while(node2 != null)
        {
            Node next = node2.right;
            node2.right = node1;
            node1 = node2;
            node2 = next;
        }
        return node1;
                
    }
    
    public static void print(Node node)
    {
        while(node!=null)
        {
            System.out.println(node.data);
            node = node.right;
        }
    }
    
    public static void main(String[] args)
    {
        Node root = new Node();
        root.data =5;
        Node node1 = new Node();
        node1.data = 7;
        Node node3 = new Node();
        node3.data = 8;
        Node node4 = new Node();
        node4.data =1;
        root.right=node1;
        node1.right = node3;
        node3.right =node4;
        Node newNode = reverseLinked(root);
        print(newNode);
    }
    
}
