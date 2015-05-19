/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Strings;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author coolp_000
 */
public class Anagram {
    
    public static boolean isAnagram(String x, String y)
    {
        char[] xArray = x.toCharArray();
        char[] yArray = y.toCharArray();
        Arrays.sort(yArray);
        Arrays.sort(xArray);
        x = String.valueOf(xArray);
        y =String.valueOf(yArray);
        HashMap<String,String> map = new HashMap<>();
        map.put(x,x);
        if(map.containsKey(y))
        {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        System.out.println(isAnagram("bad", "dab"));
    }
    
}
