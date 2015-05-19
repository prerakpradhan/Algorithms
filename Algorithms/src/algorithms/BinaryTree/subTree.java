/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.BinaryTree;

/**
 *
 * @author coolp_000
 */
public class subTree {
    
    public static boolean checkSubtreeHelper(Node treeRoot, Node subTreeRoot)
    {
        if(treeRoot == null && subTreeRoot == null)
        {
            return true;
        }
        if(treeRoot ==null || subTreeRoot == null)
        {
            return false;
        }
        if(treeRoot.value == subTreeRoot.value)
        {
            return (checkSubtreeHelper(treeRoot.left, subTreeRoot.left) 
                    && checkSubtreeHelper(treeRoot.right, subTreeRoot.right));
        }
        
        return checkSubtreeHelper(treeRoot.right, subTreeRoot) 
                || checkSubtreeHelper(treeRoot.left, subTreeRoot);
    }
    
            
            
    public static boolean checkSubtree(Node treeRoot, Node subTreeRoot)
    {
        if(treeRoot == null)
        {
            return false;
        }
        if(subTreeRoot == null)
        {
            return true;
        }
        return checkSubtreeHelper(treeRoot, subTreeRoot);
    }
    
    public static void main(String[] args)
    {
        Node T = new Node();
        T.value = 26;
        Node t2 = new Node();
        t2.value = 4;
        T.right = t2;
        Node t3 = new Node();
        t3.value =3;
        T.right.right = t3;
        Node t4 = new Node();
        t4.value=10;
        T.left  = t4;
        Node t5 = new Node();
        t5.value=4;
        T.left.left = t5;
        Node t6 = new Node();
        t6.value=30;
        T.left.left.right = t6;
        Node t7 = new Node();
        t7.value=6;
        T.left.right = t7;
 
    /* Construct the following tree
          10
        /    \
      4      6
       \
        30
    */
        Node S = new Node();
        S.value=10;
        Node s1= new Node();
        s1.value = 6;
        S.right = s1;
        Node s2 = new Node();
        s2.value=4;
        S.left = s2;
        Node s3 = new Node();
        s3.value=30;
        S.left.right = s3;
        System.out.println(checkSubtree(T, S));
    }
            
    
}
