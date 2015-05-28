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
public class iterativeInorderStackLess {
    
    public static void inOrder(Node root)
    {
        Node pre;
        if(root==null)
        {
            return;
        }
        Node current = root;
        while(current!=null)
        {
            if(current.left == null)
            {
                System.out.println(current.value);
                current = current.right;
            }
            else
            {
                pre = current.left;
                while(pre.right != null && pre.right != current)
                {
                    pre=pre.right;
                }
                if(pre.right==null)
                {
                    pre.right=current;
                    current = current.left;
                }
                else
                {
                    pre.right= null;
                    System.out.println(current.value);
                    current = current.right;
                }
            }
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
        inOrder(fakeroot);
    }
    
}
