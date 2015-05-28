/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Arrays;

import java.util.ArrayList;

/**
 *
 * @author coolp_000
 */
public class Heap {
    
    private ArrayList<Integer> storage;
    
    public Heap()
    {
        storage= new ArrayList<>();
    }
    
    private int parentIndex(int i)
    {
        return (i-1)/2;
    }
    
    private int getLeftChild(int i)
    {
        return (2*i+1);
    }
    
    private int getRightChild(int i)
    {
        return (2*i + 2);
    }
    
    
    private void insert_heapify()
    {
        int insert_index = storage.size() -1;
        int parent = parentIndex(insert_index);
        while(parent >= 0)
        {
            if (storage.get(insert_index) < storage.get(parent))
            {
                int temp = storage.get(parent);
                storage.set(parent,storage.get(insert_index));
                storage.set(insert_index, temp);
                insert_index = parent;
                parent = parentIndex(insert_index);
            }
            else
                break;
        }
        
    }
    
    public void insert(int data)
    {
        if(storage.isEmpty())
        {
            storage.add(data);
        }
        else
        {

            storage.add(data);
            insert_heapify();
        }
    }
    
    private void swap(int parent, int child)
    {
        int temp = storage.get(child);
        storage.set(child,storage.get(parent));
        storage.set(parent,temp);
    }
    
    private void rightswap(int parent, int rightchild, int leftchild)
    {
        swap(parent, rightchild);
        parent=rightchild;
        leftchild=getLeftChild(parent);
        rightchild=getRightChild(parent);
    }
    
    private void leftswap(int parent, int rightchild, int leftchild)
    {
        swap(parent, leftchild);
        parent = leftchild;
        leftchild=getLeftChild(parent);
        rightchild =getRightChild(parent);
    }
    
    private void remove_heapify()
    {
        int parent = 0;
        int leftchild = getLeftChild(0);
        int rightchild = getRightChild(0);
        while(true)
        {
            if ((leftchild < storage.size())
                    && (storage.get(leftchild) < storage.get(parent)) 
                    && (rightchild <= storage.size() -1) 
                    && (storage.get(rightchild) < storage.get(parent)))
            {
                if(storage.get(leftchild)< storage.get(rightchild))
                {
                    leftswap(parent, rightchild, leftchild);
                    
                }
                else
                {
                    rightswap(parent, rightchild, leftchild);
                }
            }
            else if ((leftchild < storage.size())
                    && (storage.get(leftchild) < storage.get(parent)))
            {
                leftswap(parent, rightchild, leftchild);
            }
            
            else if ((rightchild <= storage.size() -1) 
                    && (storage.get(rightchild) < storage.get(parent)))
            {
                rightswap(parent, rightchild, leftchild);          
            }
            else
                break;
        }
    }
    
    public void remove()
    {
        if(!storage.isEmpty())
        {
            int temp = storage.get(storage.size()-1);
            storage.set(0, temp);
            storage.remove(storage.size()-1);
            remove_heapify();
        }
    }
    
    public int getTop()
    {
        if(!storage.isEmpty())
            return storage.get(0);
        else
            return Integer.MIN_VALUE;
                    
    }
    
    public static void main(String[] args)
    {
        Heap m = new Heap();
        m.insert(7);
        m.insert(20);
        m.insert(3);
        m.insert(4);
        m.insert(13);
        m.remove();
        m.insert(5);
        m.remove();
        m.insert(16);
        m.remove();
        m.insert(17);
        System.out.println(m.getTop());
        m.remove();
        System.out.println(m.getTop());
        m.remove();
        System.out.println(m.getTop());
        m.remove();
        System.out.println(m.getTop());m.remove();
        System.out.println(m.getTop());
        
        
    }
            
    
}
