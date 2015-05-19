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
public class Intersection {
    
    public int getLength(Node head)
    {
        int count = 1;
        while(head != null)
        {
            count++;
            head = head.right;
        }
        return count;
    }
    
    public Node getIntersection(Node firstHead, Node secondHead)
    {
        int firstLength = getLength(firstHead);
        int secondLength = getLength(secondHead);
        Node greater = new Node();
        Node lesser = new Node();
        if(firstLength > secondLength)
        {
            greater = firstHead;
            lesser = secondHead;
            
        }
        else
        {
            greater = secondHead;
            lesser = secondHead;
        }
        
        int diff = Math.abs(firstLength-secondLength);
        for(int i = 0; i<diff; i++)
        {
            greater = greater.right;
        }
        while(lesser != null && greater != null)
        {
            if(lesser.data == greater.data)
            {
                return lesser;
            }
            else
            {
                lesser = lesser.right;
                greater = greater.right;
            }
            
        }
        return null;
    }
     public static void main(String[] args)
    {
        Node a1 = new Node();
        a1.data = 1;
        Node a2 = new Node();
        a2.data=2;
        a1.right=a2;
        Node a3 = new Node();
        a3.data=5;
        a2.right=a3;
        Node a5 = new Node();
        a5.data=6;
        a3.right=a5;
        Node a7 = new Node();
        a7.data=7;
        a5.right=a7;
        Node a11 = new Node();
        a11.data = 21;
        a11.right=a3;
        Intersection m = new Intersection();
        Node md = m.getIntersection(a1, a11);
        System.out.println(md.data);
                
                
        
    }
    
}
