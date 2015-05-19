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
public class maxWidth {
    
    public static int getWidth(Node root)
    {
        int max = 0;
        Queue<Node> q = new LinkedList<>();
        if(root !=null)
        {
            max = 1;
            q.add(root);
        }
        int tempCounter=1;
        while(true)
        {
            int size = q.size();
            if(tempCounter > max)
            {
                max = tempCounter;
            }
            tempCounter =0;
            if(size == 0)
            {
                return max;
            }
            while(size!=0)
            {
                Node n = q.remove();
                //System.out.println(n.value);
                tempCounter++;
                if(n.left!=null)
                {
                    q.add(n.left);
                }
                if(n.right != null)
                {
                   q.add(n.right); 
                } 
                size--;
            }
        }
        
    }
    
    public static void main(String[] args)
    {
        Node n1 = new Node();
        n1.value=10;
        Node n2 = new Node();
        n2.value = 7;
        Node n3 = new Node();
        n2.value = 8;
        Node n4 = new Node();
        n2.value = 9;
        Node n5 = new Node();
        n2.value = 10;
        n1.left=n2;
        n1.right=n3;
        n2.right=n4;
        n3.left=n5;
        System.out.println(getWidth(n1));
    }
    
}
