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
public class Flatten {
    
    public Node Flattener(Node current, Node rightOfCurrent)
    {
        
        if(current != null)
        {
          //System.out.println(current.data + " -> " + rightOfCurrent.data);
          current.right = rightOfCurrent;  
        } 
        if(rightOfCurrent.down != null)
        {
            Node rightOfCurrentRight = rightOfCurrent.right;
            Node flatTail = Flattener(rightOfCurrent, rightOfCurrent.down);
            rightOfCurrent = Flattener(flatTail, rightOfCurrentRight);
        }
        else if(rightOfCurrent.right!=null)
        {
            rightOfCurrent = Flattener(rightOfCurrent,rightOfCurrent.right);
        }
        return rightOfCurrent;
    }
    
    public void print(Node head)
    {
        while(head!=null)
        {
            System.out.println(head.data);
            head =head.right;
        }
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
        a2.down=a3;
        Node a4 = new Node();
        a4.data = 8;
        a3.down=a4;
        Node a5 = new Node();
        a5.data=6;
        a3.right=a5;
        Node a6= new Node();
        a6.data = 9;
        a5.down=a6;
        Node a7 = new Node();
        a7.data=7;
        a5.right=a7;
        Node a8 = new Node();
        a8.data = 3;
        a2.right=a8;
        Flatten f = new Flatten();
        Node head = f.Flattener(new Node(), a1);
        //System.out.println(a1.right.data);
       f.print(a1);
        System.out.println(a1.data);
                
        
    }
    
}
