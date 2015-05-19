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
public class sumTree {
    
    public static int CheckBinaryHelper(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int left= CheckBinaryHelper(root.left);
        if(left == -1)
        {
            return -1;
        }
        int right= CheckBinaryHelper(root.right);
        if(right==-1)
        {
            return -1;
        }
        int sum = left+ right;
        if((sum== root.value)||sum==0)
        {
            return sum+root.value;
        }
        return -1;
    }
    
    public static boolean CheckBinary(Node root)
    {
        int sum = CheckBinaryHelper(root);
        if(sum==-1)
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
        Node root = new Node();
        root.value = 26;
        Node n1 = new Node();
        n1.value=10;
        Node n2 = new Node();
        n2.value = 3;
        Node n4 = new Node();
        n4.value = 6;
        Node n5 = new Node();
        n5.value = 4;
        Node n6 = new Node();
        n6.value = 3;
        root.left = n1;
        root.right = n2;
        n1.left = n4;
        n1.right = n5;
        n2.right = n6;
        System.out.println(CheckBinary(root));
    }
    
}
