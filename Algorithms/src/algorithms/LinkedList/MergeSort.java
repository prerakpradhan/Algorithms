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
public class MergeSort {
    
    public static Node mergeSort(Node head)
    {
        if (head == null || head.right == null)
        {
            return head;
        }
        Node runner = head;
        Node fastRunner = head;
        while(fastRunner != null && fastRunner.right != null && fastRunner.right.right != null)
        {
            runner = runner.right;
            fastRunner = fastRunner.right.right; 
        }
        Node temp = runner.right;
        runner.right = null;
        Node rightHead = temp;
        Node leftHead= mergeSort(head);
        if(rightHead != null)
        {
            rightHead = mergeSort(rightHead);
        }
        Node mergedHead = merge(leftHead,rightHead);
        return mergedHead;
    }
    
    
    public static int size(Node head)
    {
        int count = 0;
        while(head!=null)
        {
            System.out.println(head.data);
            head = head.right;
            count++;
        }
        return count;
    }
    
    
    public static Node merge(Node leftHead, Node rightHead)
    {
         if(leftHead == null)
         {
             return rightHead;
         }
         if(rightHead == null)
         {
             return leftHead;
         }
         Node result;
         if(leftHead.data < rightHead.data)
         {
             result = leftHead;
             result.right = merge(leftHead.right,rightHead);
         }
         else
         {
             result = rightHead;
             result.right = merge(leftHead,rightHead.right);   
         }
        return result;
    }
    
    
    public static void main(String[] args)
    {
         Node a1 = new Node();
        a1.data = 11;
        Node a2 = new Node();
        a2.data=2;
        a1.right=a2;
        Node a3 = new Node();
        a3.data=5;
        a2.right=a3;
        Node a5 = new Node();
        a5.data=3;
        a3.right=a5;
        Node a7 = new Node();
        a7.data=7;
        a5.right=a7;
        Node head = mergeSort(a1);
        System.out.println(head.data);
        size(head);
        
    }
    
            
            
    
}
