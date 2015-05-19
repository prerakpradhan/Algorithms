/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Strings;

import java.util.HashMap;

/**
 *
 * @author coolp_000
 */
public class palindrome {
    
    public static boolean isPalindromeTwoPointer(String X)
    {
        int i=0;
        int j=X.length()-1;
        while(true)
        {
            if(i >= j)
            {
                break;
            }
            if(X.charAt(i)!=X.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
            
    
    public static boolean isPalindrome(String X)
    {
        int length = X.length();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<length;i++)
        {
            if(map.containsKey(String.valueOf(X.charAt(i))))
            {
                map.put(String.valueOf(X.charAt(i)), map.get(String.valueOf(X.charAt(i)))+1);
                
            }
            else
            {
                map.put(String.valueOf(X.charAt(i)), 1);
            }
        }
        
        boolean odd = false;
        if(length%2!=0)
        {
            odd=true;
        }
        boolean oneMiss= false;
        for(String key:map.keySet())
        {
            int count = map.get(key);
            if(count%2!=0)
            {
                if(odd)
                {
                    if(!oneMiss)
                    {
                        int index = X.indexOf(key);
                        if(index == length/2)
                        {
                            oneMiss= true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        System.out.println(isPalindrome("dad"));
        System.out.println(isPalindromeTwoPointer("dad"));
    }
    
}
