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
public class foldableTrees {
    
    public static boolean checkMirrorHelper(Node n1, Node n2)
    {
        if((n1==null) && (n2==null))
        {
            return true;
        }
        if(n1==null)
        {
            return false;
        }
        if(n2==null)
        {
            return false;
        }
        return checkMirrorHelper(n1.left, n2.right) && checkMirrorHelper(n1.right, n2.left);    
    }
    
    public static boolean Foldable(Node root)
    {
        if(root ==null)
        {
            return true;
        }
        else
        {
            return checkMirrorHelper(root.left, root.right);
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
        System.out.println(Foldable(n1));
        
        
    }
            
    
}
