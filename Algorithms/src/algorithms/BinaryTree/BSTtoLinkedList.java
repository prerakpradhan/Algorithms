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
public class BSTtoLinkedList {
    
    public Node HeadofList;
    
    public void ConvertBst(Node root)
    {
        convertBSTHelper(root);
        FlipHead();
    }
    
    private void FlipHead()
    {
        if(HeadofList == null)
            return;
        while(HeadofList.left != null)
        {
            HeadofList = HeadofList.left;
        }
    }
    
    private void convertBSTHelper(Node root)
    {
        if(root == null)
            return;
        if(root.left != null)
        {
            convertBSTHelper(root.left);
        }
        root.left = HeadofList;
        if(HeadofList!=null)
        {
            HeadofList.right = root;
        }
        HeadofList = root;
        if(root.right != null)
        {
            convertBSTHelper(root.right);
        }
    }
    
    public void print()
    {
        while(HeadofList!=null)
        {
            System.out.println(HeadofList.value);
            HeadofList = HeadofList.right;
        }
    }
    
    public static void main(String[] args)
    {
        Tree tree= new Tree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(12);
        tree.insert(4);
        tree.insert(7);
        BSTtoLinkedList blist = new BSTtoLinkedList();
        blist.ConvertBst(tree.root);
        blist.print();
    }
    
}
