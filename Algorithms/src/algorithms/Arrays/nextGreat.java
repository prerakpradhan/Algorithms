/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;
import javax.naming.ldap.HasControls;

/**
 *
 * @author coolp_000
 */
public class nextGreat {
    public void printNextGreat(int arr[])
    {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i=1; i < arr.length; i++)
        {
           while(!stack.isEmpty())
           {
                if(stack.peek() < arr[i])
                {
                    int element = stack.pop();
                    map.put(element, arr[i]);
                }
                else
                    break;
           }
           stack.push(arr[i]);
        }
        while(!stack.isEmpty())
        {
            map.put(stack.pop(), -1);
        }
        for ( int key : map.keySet() ) {
            System.out.println( key + ":" + map.get(key) );
        }
    }
    
    public static void main(String[] args)
    {
        int[] arr ={4, 15, 2, 9, 20, 11, 13};
        nextGreat m = new nextGreat();
        m.printNextGreat(arr);
    }
}
