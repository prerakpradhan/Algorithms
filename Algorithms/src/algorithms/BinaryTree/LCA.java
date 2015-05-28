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
public class LCA {
    
    public static int findNodes(Node root, int one, int two)
    {
        if(root==null)
        {
            return 0;
        }
        if(root.value == one || root.value == two)
        {
            return 1 + findNodes(root.left, one, two)+findNodes(root.right, one, two);
        }
        return findNodes(root.left,one,two) + findNodes(root.right,one,two);
    }
    public static  Node getLCA(Node root, int one, int two)
    {
        if(root == null)
        {
            return null;
        }
        if(root.value == one || root.value== two)
        {
            return root;
        }
        int left = findNodes(root.left, one, two);
        int right = findNodes(root.right, one, two);
        if(left == 1 && right == 1)
        {
            return root;
        }
        if(left == 2)
        {
            return getLCA(root.left, one, two);
        }
        if(right == 2)
        {
            return getLCA(root.right,one, two);
        }
        return null;
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
        System.out.println(getLCA(fakeroot, 5, 4).value);
    }
}
