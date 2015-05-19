/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author coolp_000
 */
public class SumOfPaths {
    
    
    public void noRootPath(Node root, int value)
    {
        Stack stack = new Stack();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node n = q.remove();
            if(n.left != null)
            {
                q.add(n.left);
            }
            if(n.right != null)
            {
                q.add(n.right);   
            }
            getPath(n, value,stack);
        }
        
    }
    
    public void getPath(Node root, int value, Stack stack)
    {
        if (root == null)
        {
            return;
        }
        if (root.value > value)
        {
            return;
        }
        stack.add(root.value);
        if(root.value == value)
        {
            String s = "";
            for (int i=0; i < stack.size()-1; i++)
            {
                s = s + stack.get(i) + "-->";      
            }
            s = s+stack.get(stack.size()-1);
            System.out.println(s);
        }
        getPath(root.left, value-root.value,stack);
        getPath(root.right, value-root.value,stack);
        stack.pop();
    }
    public static void main(String[] args)
    {
        Tree tree= new Tree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(12);
        tree.insert(4);
        tree.insert(7);
        
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
        System.out.println("--sum of paths---");
        SumOfPaths path = new SumOfPaths();
        path.noRootPath(fakeroot, 3);
    }
    
    
}
