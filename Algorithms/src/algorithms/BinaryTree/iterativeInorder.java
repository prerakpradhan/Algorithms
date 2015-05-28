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
public class iterativeInorder {
    
    public static void iterativeInorder(Node root)
    {
        Stack<Node> s1 = new Stack<>();
        Node current = root;
        boolean done = false;
        while(!done)
        {
            if (current != null)
            {
                s1.add(current);
                current = current.left;
            }
            else
            {
                if(!s1.isEmpty())
                {
                    current = s1.pop();
                    System.out.println(current.value);
                    current = current.right;
                }
                else
                {
                    done = true;
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
        iterativeInorder(fakeroot);
    }
    
}
