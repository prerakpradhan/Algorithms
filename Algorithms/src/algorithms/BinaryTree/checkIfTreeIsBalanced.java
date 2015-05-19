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
public class checkIfTreeIsBalanced {
    
    public static int checkWrapper(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int leftHeight = checkWrapper(root.left);
        if(leftHeight == -1)
        {
            return -1;
        }
        int rightHeight = checkWrapper(root.right);
        if(rightHeight == -1)
        {
            return -1;
        }
        int diff = Math.abs(leftHeight-rightHeight);
        if(diff > 1)
        {
            return -1;
        }
        else
            return Math.max(leftHeight,rightHeight)+1;
    }
    
    public static boolean check(Node root)
    {
        int value = checkWrapper(root);
        if(value == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static void main(String[] args)
    {
        Node fakeroot = new Node();
        fakeroot.value = 3;
        Node fakenode =  new Node();
        fakenode.value = 2;
        Node fakenode2 =  new Node();
        fakenode2.value = 5;
        fakeroot.left = fakenode;
        fakeroot.right = fakenode2;
        Node fakenode3 =  new Node();
        fakenode3.value = 1;
        Node fakenode4 =  new Node();
        fakenode4.value = 4;
        fakenode.left=fakenode3;
        fakenode.right = fakenode4;
        System.out.println(check(fakeroot));
    }
    
}
