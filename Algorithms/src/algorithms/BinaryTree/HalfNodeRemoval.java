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

//Given A binary Tree, how do you remove all the half nodes (which has only one child)? Note leaves 
//should not be touched as they have both children as NULL.
public class HalfNodeRemoval {
    public Node root;
    
    public void remove(Node node, Node parent, int indicator)
    {
        if(node != null)
        {
            if(node.left == null && node.right == null)
            {
                return;
            }
            if(node.left == null)
            {
                if(parent == null)
                {
                        root = root.right; 
                        remove(root.left,root,1);
                        remove(root.right,root,-1);
                }
                else
                {
                    if(indicator == -1)
                    {
                        parent.right=node.right;
                        remove(parent.right.right,parent.right,-1);
                        remove(parent.right.left,parent.right,1);
                    }
                    else
                    {
                        parent.left=node.right;
                        remove(parent.left.right,parent.right,-1);
                        remove(parent.left.left,parent.right,1);
                    }
                }
            }
            else if(node.right == null)
            {
                if(parent == null)
                {
                        root = root.left; 
                        remove(root.left,root,1);
                        remove(root.right,root,-1);
                }
                else
                {
                    if(indicator == -1)
                    {
                        parent.right=node.left;
                        remove(parent.right.right,parent.right,-1);
                        remove(parent.right.left,parent.right,1);
                    }
                    else
                    {
                        parent.left=node.left;
                        remove(parent.left.right,parent.right,-1);
                        remove(parent.left.left,parent.right,1);
                    }
                }
                
                
            }
            else
            {
                remove(node.left,node,1);
                remove(node.right,node,-1);
            }
            
        }
    }
    
    public void inOrder(Node node)
    {
        if(node!= null)
        {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }
    
    public static void main(String[] args)
    {
        Node n1 = new Node();
        n1.value=7;
        Node n2 = new Node();
        n2.value = 8;
        Node n3 = new Node();
        n3.value = 9;
        Node n4 = new Node();
        n4.value = 5;
        Node n5 = new Node();
        n5.value = 11;
        Node n6 = new Node();
        n6.value = 100;
        Node n7 = new Node();
        n7.value = 80;
        Node n8  = new Node();
        n8.value = 90;
        n1.right = n2;
        n2.right=n3;
        n2.left=n4;
        n1.left=n5;
        n5.right=n6;
        n6.right=n7;
        n6.left=n8;
        HalfNodeRemoval m = new HalfNodeRemoval();
        m.root=n1;
        m.remove(m.root, null, 0);
        m.inOrder(m.root);
                
                
    }
    
}
