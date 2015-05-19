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
public class maxLeafPath {
    
    public static int sum;
    
    public static int getMaxLeafPathSum(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = getMaxLeafPathSum(root.left);
        int right = getMaxLeafPathSum(root.right);
        int total = left+right +root.value;
        if(total > sum)
        {
            sum = total;
        }
        return Math.max(left, right)+root.value;
    }
    
    public static void main(String[] args)
    {
        Node root = new Node();
        root.value = -15;
        Node r1 = new Node();
        r1.value =5;
        root.left = r1;
        Node r2 = new Node();
        r2.value =6;
        root.right = r2;
        Node r3 = new Node();
        r3.value =-8;
        root.left.left = r3;
        Node r4 = new Node();
        r4.value =1;
        root.left.right = r4;
        Node r6 = new Node();
        r6.value =2;
        root.left.left.left = r6;
        Node r7 = new Node();
        r7.value =6;
        root.left.left.right = r7;
        Node r8 = new Node();
        r8.value =3;
        root.right.left = r8;
        Node r9 = new Node();
        r9.value =9;
        root.right.right = r9;
        Node r10 = new Node();
        r10.value =0;
        root.right.right.right= r10;
        Node r11 = new Node();
        r11.value =4;
        root.right.right.right.left= r11;
        Node r12 = new Node();
        r12.value =-1;
        root.right.right.right.right= r12;
        Node r13 = new Node();
        r13.value =10;
        root.right.right.right.right.left= r13;
        System.out.println(sum);
    }
    
}
