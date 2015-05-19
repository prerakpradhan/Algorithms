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
public class Tree {
    public Node root;
    public void insert(int value)
    {
        insert(root, value);
    }
    
    public boolean checkSum(Node start, int sum)
    {
        Stack<Node> previous = new Stack<>();
        Stack<Node> next = new Stack<>();
        
        buildprevious(previous,start);
        buildnext(next,start);
        Node prevNode = getPrevious(previous);
        Node nextNode = getNext(next);
        while(prevNode != null && nextNode != null && prevNode != nextNode)
        {
            int result = prevNode.value + nextNode.value;
            if(result == sum)
            {
                return true;
            }
            if(result < sum)
            {
                prevNode = getPrevious(previous);
            }
            else
            {
                nextNode = getNext(next);
            }
        }
        return false;
    }
    
    private void buildprevious(Stack<Node> previous, Node temp)
    {
        previous.add(temp);
        while(temp != null)
        {
            previous.add(temp);
            temp=temp.left; 
        }
               
    }
    private void buildnext(Stack<Node> next, Node temp)
    {
        next.add(temp);
        while(temp !=null)
        {
            next.add(temp);
            temp = temp.right;  
        }
    }
    
    private Node getNext(Stack<Node> next)
    {
        Node temp = null;
        if(!next.empty())
        {
            temp = next.pop();
            Node templeft = temp.left;
            while(templeft !=null)
            {
                next.add(templeft);
                templeft = templeft.right;    
            }    
        }
        return temp;
    }
    private Node getPrevious(Stack<Node> next)
    {
        Node temp = null;
        if(!next.empty())
        {
            temp = next.pop();
            Node tempright = temp.right;
            while(tempright !=null)
            {
                next.add(tempright);
                tempright = tempright.left;    
            }
            
        }
        return temp;
    }
    
    public boolean verifyBSTPreorder(int [] array, int start, int end)
    {
 
        int rootval = array[end];
        int i = start;
        for(;i<end;i++)
        {
            if (array[i] > rootval)
            {
                break;
            }
        }
        int j =i;
        for(;j<end; j++)
        {
            if(array[j] < rootval)
            {
                return false;
            }
                
        }
        boolean left = true;
        if( i-1 >= 0 && start < i-1 && start >= 0)
            left = verifyBSTPreorder(array, start,i-1);
        boolean right = true;
        if(end-1 > i)
            right = verifyBSTPreorder(array, i, end-1);
        return right&&left;                
    }
    
    private void insert(Node head, int value)
    {
        if(head == null)
        {
            head = new Node();
            head.value = value;
            if(root == null)
            {
                root = head;
            }
        }
        
        else if(value < head.value)
        {
           
            if(head.left == null)
            {
                Node new_node = new Node();
                new_node.value = value;
                head.left=new_node;
            }
            else
            {
                insert(head.left,value);
            }
        }
        else
        {
            if(head.right == null)
            {
                Node new_node = new Node();
                new_node.value = value;
                head.right=new_node;
            }
            else
            {
                insert(head.right,value);
            }
        }   
        
    }
    
    public Node findparent(Node head, int value)
    {
        if (head == null)
            return null;
        if(value < head.value)
        {
            if (head.left != null)
            {
                if( head.left.value == value)
                    return head;
                else 
                    return findparent(head.left, value);
            }
        }
        else if(value > head.value)
        {
            if (head.right != null)
            {
                if (head.right.value == value)
                    return head;
                else
                    return findparent(head.right,value);
            }
        }
       
        return null;
    }
    
    private Node minValueParent(Node head)
    {
        while(head.left.left != null)
            head = head.left;
        return head;

    }
    
    private boolean present(Node head, int value)
    {
       while(head != null)
       {
           if(head.value == value)
           {
               return true;
           }
           else if (value < head.value)
           {
               head = head.left;
           }
           else if(value > head.value)
           {
               head = head.right;
           }
       }
       return false;
    }
    
    public Node LCA(Node head, int first, int second)
    {
        if(head == null)
        {
            return null;
        }
        int left;
        int right;
        
        if (first < second)
        {
            left = first;
            right = second;
        }
        else
        { 
            left = second;
            right = first;
        }
        while(root != null)
        {
            if (left < head.value && right < head.value)
            {
                head = head.left;
            }

            else if ( left > head.value && right > head.value)
            {
  		head = head.right;
            }
            else if ( present(head.left, left) && present(head.right, right))
            {
    		return head;
            }
            else
                break;
        }
        return null;
    }

    
    public void delete(Node head, int value)
    {
        //System.out.println(head.value);
        if(head == null)
            return;
        else if (value < head.value)
            delete(head.left, value);
        else if(value > head.value)
            delete(head.right,value);
        else
        {

            if (head.left == null && head.right == null)
            {
                //System.out.println(head.value);
                if (head.value == root.value)
                {
                    root = null;
                }
                else
                {
                    Node temp = findparent(root, head.value);                
                    if(head.value > temp.value)
                        temp.right = null;
                    else if (head.value < temp.value)
                        temp.left= null;
                }
                //System.out.println(head);
            }
            else if(head.left == null)
            {
                Node temp = head.right;
                head.value = temp.value;
                head.right = temp.right;
            }
            else if(head.right == null)
            {
                Node temp = head.left;
                head.value = temp.value;
                head.left =temp.left;
                
            }
            else
            {
                if(head.right.left != null)
                {
                Node minparent = minValueParent(head.right);
                head.value = minparent.left.value;
                minparent.left = null;
                }
                else
                {
                    head.value = head.right.value;
                    head.right = head.right.right;
                }
                        
            }
        }
                  
        
    }
    
    public void inorder(Node root)
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }
    
    public static boolean isBST(Node root, int min, int max)
    {
        if (root == null)
        {
            return true;
        }
        if(root.value < min || root.value > max)
        {
            return false;
        }
        return isBST(root.left, min, root.value) 
               && isBST(root.right, root.value, max);
        
    }
    
    public void preorder(Node root)
    {
        if (root == null)
            return;
        System.out.println(root.value);
        preorder(root.left);
        preorder(root.right);
    }
    
    public void postorder(Node root)
    {
        if (root ==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.value);
    }
    
    
    
    
    public int heightOfTree()
    {
        Queue<Node> q = new LinkedList<>();
        int height = 0;
        if(root != null)
        {
         q.add(root);
        }
        int nodeCount;
        while(true)
        {
            nodeCount = q.size();
            if(nodeCount == 0)
            {
                return height;
            }
            height++;
            while(nodeCount > 0)
            {
                Node parent = q.remove();
                if (parent.left != null)
                {
                    q.add(parent.left);
                }
                if (parent.right != null)
                {
                    q.add(parent.right);
                }
                nodeCount--;
            }
        }  
    }
    
    public static int[] getDiameter(Node root) {
    int[] result = new int[]{0,0};    //1st element: diameter, 2nd: height    
    if (root == null)  return result;
    int[] leftResult = getDiameter(root.left);
    int[] rightResult = getDiameter(root.right);
    int height = Math.max(leftResult[1], rightResult[1]) + 1;
    int rootDiameter = leftResult[1] + rightResult[1] + 1;
    int leftDiameter = leftResult[0];
    int rightDiameter = rightResult[0];
    result[0] = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    result[1] = height;
    return result;
}
    
    public void printSprial()
    {
        int height = heightOfTree();
        boolean alt= false;
        for(int i=1;i<=height; i++)
        {
            printSpiralLevel(root,i,alt);
            alt = !alt;
        }
        
    }
    private void printSpiralLevel(Node head,int level,boolean alt)
    {
        if(head == null)
        {
            return;
        }
        else if(level == 1)
        {
            System.out.println(head.value);
        }
        else if(level > 1)
        {
            if(alt)
            {
                printSpiralLevel(head.left, level-1, alt);
                printSpiralLevel(head.right, level-1, alt);
            }
            else
            {
                printSpiralLevel(head.right, level-1, alt);
                printSpiralLevel(head.left, level-1, alt);
            }
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
        System.out.println("--checking the verify BSTPreorder--");
        int[] arrayofint= {5, 7, 6, 9, 11, 10, 8};
        System.out.println(tree.verifyBSTPreorder(arrayofint, 0, arrayofint.length-1));
        System.out.println("--checking test sum--");
        System.out.println(tree.checkSum(tree.root, 45));
        //converting bst into doubly linked link list
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
        System.out.println("diameter");
        System.out.println(getDiameter(tree.root)[0]);
        System.out.println("testing binary tree for BST");
        System.out.println(isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("--testing binary tree for BST");
        System.out.println(isBST(fakeroot, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("--lca--");
        System.out.println(tree.LCA(tree.root, 5, 12).value);
        System.out.println("---inorder---");
        tree.inorder(tree.root);
        System.out.println("---height of tree--");
        System.out.println(tree.heightOfTree());
        System.out.println("--- post order--");
        tree.postorder(tree.root);
        System.out.println("----sprial order--");
        tree.printSprial();
        System.out.println("-- pre order");
        tree.preorder(tree.root);
        System.out.println("---delete 5---");
        tree.delete(tree.root, 5);
        tree.inorder(tree.root);
        System.out.println("---delete 9---");
        tree.delete(tree.root, 9);
        tree.inorder(tree.root);
        System.out.println("---delete 6---");
        tree.delete(tree.root, 6);
        tree.inorder(tree.root);
    }
    
}
