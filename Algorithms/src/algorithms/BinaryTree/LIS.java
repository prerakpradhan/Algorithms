/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.BinaryTree;

import java.util.HashMap;

/**
 *
 * @author coolp_000
 */
public class LIS {
    
    public static String comparator(Node root, HashMap<Integer, String> store, String result)
    {
            String left = getLis(root.left,store) ;
            if(!"".equals(left))
            {
                result = result + ","+left; 
            }
            String right = getLis(root.right,store) ;
            if(!"".equals(right))
            {
                result = result + ","+right; 
            }
            return result;
    }
    
    public static String getLis(Node root, HashMap<Integer, String> store)
    {
        if(root == null)
        {
            return "";
        }
        if(store.containsKey(root.value))
        {
            return store.get(root.value);
        }
        if(root.left == null && root.right == null)
        {
            store.put(root.value,Integer.toString(root.value));
            return store.get(root.value);
        }
        String root_excl = getLis(root.left, store)+ ","+ getLis(root.right,store);
        String root_incl = Integer.toString(root.value);
        if(root.left != null)
        {
            
            root_incl = comparator(root.left, store, root_incl);
        }
        
        if(root.right != null)
        {
            root_incl = comparator(root.right, store, root_incl);
        }
        int root_incl_length = root_incl.split(",").length;
        int root_excl_length = root_excl.split(",").length;
        if(root_incl_length >= root_excl_length)
        {
            store.put(root.value, root_incl);
            return root_incl;
        }
        else
        {
            store.put(root.value, root_excl);
            return root_excl;
        }
    }
    public static void main(String[] args)
    {
        Node root = new Node();
        root.value = 20;
        Node r1 = new Node();
        r1.value = 8;
        root.left = r1;
        Node r2 = new Node();
        r2.value=40;
        root.left.left = r2;
        Node r3 = new Node();
        r3.value = 12;
        root.left.right = r3;
        Node r4 = new Node();
        r4.value = 10;
        root.left.right.left = r4;
        Node r5 = new Node();
        r5.value = 14;
        root.left.right.right  = r5;
        Node r6 = new Node();
        r6.value = 22;
        root.right = r6;
        Node r7 = new Node();
        r7.value = 25;
        root.right.right = r7;
        System.out.println(getLis(root, new HashMap<Integer, String>()));
    }
}
