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
public class inorderSuccesor {
    
    public static modifiedNode leftMost(modifiedNode root)
    {
        if(root == null)
        {
            return null;
        }
        if(root.left == null)
        {
            return root;
        }
        return leftMost(root.left);
    }
    
    public static modifiedNode leftSideParent(modifiedNode parent)
    {
        if(parent == null || parent.parent == null)
        {
            return null;
        }
        if(parent.parent.left == parent)
        {
            return parent.parent;
        }
        return leftSideParent(parent.parent);
    }
    
    public static modifiedNode getInorderSucessor(modifiedNode root)
    {
        if(root == null)
        {
            return null;
        }
        if(root.parent == null && root.left == null && root.right == null)
        {
            return null;
        }
        if(root.right == null)
        {
            if(root.parent.left == root)
            {
                return root.parent;
            }
            else
            {
                return leftSideParent(root.parent);
            }
        }
        else
        {
            return leftMost(root.right);
        }
    }
    
    public static void main(String[] args)
    {
        modifiedNode root = new modifiedNode(8);
        modifiedNode r1 = new modifiedNode(3);
        modifiedNode r2 = new modifiedNode(10);
        modifiedNode r3 = new modifiedNode(2);
        modifiedNode r4 = new modifiedNode(6);
        modifiedNode r5 = new modifiedNode(12);
        modifiedNode r6 = new modifiedNode(1);
        modifiedNode r7 = new modifiedNode(4);
        modifiedNode r8 = new modifiedNode(7);
        root.left=r1;
        root.right=r2;
        r1.left=r3;
        r1.parent=root;
        r1.right=r4;
        r2.parent = root;
        r2.right=r5;
        r5.parent = r2;
        r3.parent=r1;
        r3.left = r6;
        r3.right = r4;
        r4.parent = r1;
        r4.left = r7;
        r4.right = r8;
        r6.parent = r3;
        r7.parent = r4;
        r8.parent = r4;
        modifiedNode node = getInorderSucessor(r8);
        System.out.println(node.value);
                
        
        
    }
    
    
    
}
