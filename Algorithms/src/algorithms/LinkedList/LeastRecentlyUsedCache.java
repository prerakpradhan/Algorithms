/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.LinkedList;

import java.util.HashMap;

/**
 *
 * @author coolp_000
 */
public class LeastRecentlyUsedCache {
    public HashMap<Integer, Node> map;
    public Node front;
    public Node end;
    public int max;
    public int counter;
    
    public LeastRecentlyUsedCache(int max)
    {
        map=new HashMap<>();
        this.max = max;
        counter= 0;
    }
    
    public void Enqueue(Node node)
    {
        if(counter == 0)
        {
            front=node;
            end = node;
            counter++;
        }
        else
        {
            front.left=node;
            node.right=front;
            front= node;
            counter++;
        }
    }
    
    public void dequeue()
    {
        System.out.println("dequeing");
        map.remove(end.data);
        end.left.right=null;
        end = end.left;
        counter--;
    }
    
    public void testPrint()
    {
        Node temp = front;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp= temp.right;
        }
    }
    
    public void referencePage(int pageNum)
    {
        if(map.containsKey(pageNum))
        {
            Node node = map.get(pageNum);
            node.left.right = node.right;
            if(node == end)
            {
                end = end.left;
            }
            Enqueue(node);
        }
        else
        {
            Node node = new Node();
            node.data=pageNum;
            map.put(pageNum, node);
            if(counter >= max)
            {
                dequeue();
            }
            Enqueue(node);
        }
    }
    
    public static void main(String[] args)
    {
        LeastRecentlyUsedCache l1= new LeastRecentlyUsedCache(3);
        l1.referencePage(4);
        l1.referencePage(5);
        l1.referencePage(7);
        l1.testPrint();
        l1.referencePage(10);
        l1.testPrint();
        l1.referencePage(7);
        l1.testPrint();
    }
            
    
            
    
    
    
}
