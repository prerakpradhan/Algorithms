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
public class allAncestors {
    
    public static boolean printAllAncesters(Node root, int key)
    {
        if(root==null)
        {
            return false;
        }
        if(root.value==key)
        {
            return true;
        }
        if (printAllAncesters(root.left, key) || printAllAncesters(root.right, key))
        {
            System.out.println(root.value);
            return true;
        }
        return false;
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
        printAllAncesters(fakeroot, 4);
        
    }
    
}
