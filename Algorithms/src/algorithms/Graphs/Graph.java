/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author coolp_000
 */
public class Graph {
    public Node rootnode;
    public ArrayList<Node> nodes=new ArrayList<>();
    public int Adjmat[][];
    
    public void insertnode(Node n)
    {
        nodes.add(n);
    }
    
    public void addedge(Node start, Node end)
    {
        
        int startindex = nodes.indexOf(start);
        int endindex = nodes.indexOf(end);
        int size =  nodes.size();
        if(Adjmat == null)
        {
            Adjmat = new int[size][size];
        }
        Adjmat[startindex][endindex] = 1;
        Adjmat[endindex][startindex] = 1;  
    }
    
    public void reset()
    {
        for(Node node:nodes)
            node.visited=false;
    }
    
    public void printer()
    {
      
        
        for(int i = 0; i < nodes.size(); i++)
        {
            Node n = (Node)nodes.get(i);
            System.out.println(n.value);
        }
    }
    
    public Node unvisited(Node n)
    {
        int index = nodes.indexOf(n);
        int size = nodes.size();
        int j = 0;
       // System.out.println(n.value);
        while ( j< size ){
        
            if (Adjmat[index][j] ==1 && ((Node)nodes.get(j)).visited != true)
            {
                return (Node)nodes.get(j);
            }
           j++;     
        
            
        }
    
            return null;
    }
    
    public void bfs()
    {
        Queue q = new LinkedList();
        Node root = this.rootnode;
        q.add(root);
        
        root.visited = true;
        System.out.println(root.value);
        while(!q.isEmpty())
        {
            Node n = (Node)q.remove();
            Node child=null;
            while(( child=unvisited(n))!= null)
            {
             child.visited = true;
             q.add(child);
             System.out.println(child.value);
                    
            }
        }
        
        
    }
    public void dfs()
    {
        Stack s = new Stack();
        Node root = this.rootnode;
        s.add(root);
        root.visited = true;
        System.out.println(root.value);
        while (!s.isEmpty())
        {
            Node n = (Node)s.peek();
            Node child = unvisited(n);
            if( child!= null)
            {
                child.visited = true;
                System.out.println(child.value);
                s.add(child);
            }
            else
            {
                s.pop();
            }
        }
    }  
    
    public static void main(String[] args)
    {
        Node nA=new Node(1);
	Node nB=new Node(2);
	Node nC=new Node(3);
	Node nD=new Node(4);
	Node nE=new Node(5);
	Node nF=new Node(6);
        Graph g=new Graph();
	g.insertnode(nA);
	g.insertnode(nB);
	g.insertnode(nC);
	g.insertnode(nD);
	g.insertnode(nE);
	g.insertnode(nF);
	g.rootnode = nA;
	g.addedge(nA,nB);
	g.addedge(nA,nC);
	g.addedge(nA,nD);
	g.addedge(nB,nE);
	g.addedge(nB,nF);
        System.out.println("print dfs:");
        g.dfs();
        System.out.println("----------");
        System.out.println("print bfs:");
        g.reset();
        g.bfs();
    }
    
}
