/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Strings;

/**
 *
 * @author coolp_000
 */
public class ceasarCypher {
    
    public static String encode(String init, int off)
    {
        String result ="";
        for(char c:init.toCharArray())
        {
            char enc = (char)('a'+((c-'a'+off)%26));
            result = result+String.valueOf(enc);
        }
        return result;
    }
    
    public static String decode(String init, int off)
    {
        String result ="";
        for(char c:init.toCharArray())
        {
            char enc = (char)('a'+((c-'a'-off)%26));
            result = result+String.valueOf(enc);
        }
        return result;
    }
    
    
    public static void main(String[] args)
    {
        System.out.println(encode("ba", 1));
        System.out.println(decode("cb",1));
    }
    
}
