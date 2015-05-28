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
public class copyList {
    
    public static randomNode copy(randomNode head)
    {
        randomNode headHolder = head;
        while(head!=null)
        {
            randomNode newNode = new randomNode(head.data);
            randomNode temp = head.next;
            head.next = newNode;
            newNode.next=temp;
            head = temp;
        }
        head = headHolder;
        while(headHolder!= null)
        {
            if(headHolder.next != null && headHolder.random!=null)
            {
                headHolder.next.random=headHolder.random.next;   
            } 
            headHolder = headHolder.next.next;
        }
        randomNode finalHead = head.next;
        while(head!= null)
        {
            if(head.next!=null)
            {
                head.next=head.next.next;
            } 
            head = head.next;
        }
        return finalHead;
        
    }
    public static void print(randomNode node)
    {
        while(node!= null)
        {
            System.out.println(node.data);
            node = node.next;
        }
    }
    
    public static void main(String[] args)
    {
       randomNode head = new randomNode(4);
       
       randomNode h2 = new randomNode(5);
       randomNode h3 = new randomNode(7);
       head.random=h3;
       head.next=h2;
       h2.next=h3;
       randomNode copyHead = copy(head);
       System.out.println(copyHead.random.data);
       print(copyHead);
    }
    
}
