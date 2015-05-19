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
public class minimalBT {
    
    public Node createMinimal(int[] arr, int start, int end)
    {
        if(end < start)
        {
            return null;
        }
        int middle = start +((end-start)/2);
        Node n = new Node();
        n.value = arr[middle];
        n.left= createMinimal(arr, start, middle-1);
        n.right = createMinimal(arr, middle+1, end);
        return n;
    }
    
    public void inOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.println(root.value);
        inOrder(root.left);
        inOrder(root.right);
    }
    
    public static void main(String[] args)
    {
        minimalBT m = new minimalBT();
        int[] arrayofint= {5, 7, 6, 9, 11, 10, 8};
        Node n = m.createMinimal(arrayofint, 0, arrayofint.length-1);
        m.inOrder(n);
        
    }
    
}
