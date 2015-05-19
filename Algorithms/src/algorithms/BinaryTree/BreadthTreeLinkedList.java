/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author coolp_000
 */
public class BreadthTreeLinkedList {
    
    public static List<Node> getListOfRoots(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<Node> listOfRoots = new ArrayList<>();
        while(true)
        {
            int height = q.size();
            if(height <= 0)
                break;
            Node listRoot = q.remove();
            if (listRoot.left != null)
                q.add(listRoot.left);
            if (listRoot.right != null)
                q.add(listRoot.right);
            listRoot.left = null;
            listRoot.right =null;
            listOfRoots.add(listRoot);
            height--;
            while(height >= 1)
            {
                listRoot.right = q.remove();
                listRoot =listRoot.right;
                height--;
            }
            
        }
        return listOfRoots;
        
    }
    
    public static void printAll(List<Node> roots)
    {
        for(Node root:roots)
        {
            while(root!=null)
            {
                System.out.println(root.value);
                root = root.right;
                
            }
            System.out.println("--------");
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
        List<Node> listOfRoots =  getListOfRoots(fakeroot);
        printAll(listOfRoots);
    }
    
}
