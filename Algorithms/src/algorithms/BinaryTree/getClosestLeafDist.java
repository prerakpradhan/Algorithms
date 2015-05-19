/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.BinaryTree;

import java.util.ArrayList;

/**
 *
 * @author coolp_000
 */
public class getClosestLeafDist {
    
    public static int getMinLeaf(Node root)
    {
        if(root == null)
        {
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null)
        {
            return 0;
        }
        return 1 + Math.min(getMinLeaf(root.left), getMinLeaf(root.right));
    }
    
    public static int getMinLeafDist(Node root, ArrayList<Node> arr, int index, int key)
    {
        if(root == null)
        {
            return Integer.MAX_VALUE;
        }
        if(root.value == key)
        {
            int result = getMinLeaf(root);
            for(int i=index; i >0; i--)
            {
                result = Math.min(result, getMinLeaf(arr.get(index)));
            }
            return result;
        }
        arr.add(root);
        return Math.min(getMinLeafDist(root.left, arr, index+1, key), 
                getMinLeafDist(root.right,arr,index+1, key));
    }
    
    public static void main(String[] args)
    {
        Node root = new Node();
        root.value=9;
        Node r1= new Node();
        r1.value = 8;
        Node r2 = new Node();
        r2.value =10;
        Node r3 = new Node();
        r3.value = 11;
        Node r4 = new Node();
        r4.value=90;
        root.left=r1;
        root.right=r2;
        r2.left=r3;
        r2.right=r4;
        System.out.println(getMinLeafDist(root, new ArrayList<Node>(), 0, 9));
    }
    
}
