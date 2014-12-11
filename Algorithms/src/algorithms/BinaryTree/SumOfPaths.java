/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.BinaryTree;

import java.util.Stack;

/**
 *
 * @author coolp_000
 */
public class SumOfPaths {
    Stack stack ;
    public SumOfPaths()
    {
        stack = new Stack();
    }
    
    public void getPath(Node root, int value)
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
        getPath(root.left, value-root.value);
        getPath(root.right, value-root.value);
        stack.pop();
    }
    
    
}
