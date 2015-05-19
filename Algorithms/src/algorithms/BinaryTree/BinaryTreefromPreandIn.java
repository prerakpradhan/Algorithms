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
public class BinaryTreefromPreandIn {
    
    public Node build(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd )
    {
        if(preStart-preEnd ==0)
        {
            Node root = new Node();
            root.value = pre[preStart];
            return root;
        }
        Node root = new Node();
        root.value = pre[preStart];
        int rootinIn=findIndex(in, root.value);
        int divide = rootinIn-inStart;
        int childPreStart = preStart + 1;
        int childPreEnd=preStart+divide;
        int childInStart = inStart;
        int childInEnd = rootinIn - 1;
        
        if(childInEnd >= inStart && childPreEnd <= preEnd)
        {
            root.left = build(pre, in, childPreStart, childPreEnd, childInStart, childInEnd);
        }
        if((childPreEnd + 1 <= preEnd ) && (divide+1 <= inEnd))
        {
            root.right=build(pre,in,childPreEnd+1, preEnd, divide+1, inEnd);
        }
        return root;
    }
    
    public int findIndex(int[] array, int elem)
    {
        int i=0;
        for(; i <array.length; i++)
            if(array[i]==elem)
                break;
        return i;
    }
    
    public void inOrder(Node root)
    {
        if(root!=null)
        {
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
        }
    }
    
    
    
    public static void main(String[] args)
    {
        int[] pre = {5,8,3,4,7,1};
        int[] in={3,8,4,5,1,7};
        BinaryTreefromPreandIn m = new BinaryTreefromPreandIn();
        Node root = m.build(pre, in, 0, pre.length-1, 0, in.length-1);
        m.inOrder(root);
        
        
            
                
        
    }
    
}
