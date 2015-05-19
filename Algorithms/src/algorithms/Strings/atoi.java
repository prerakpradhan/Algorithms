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
public class atoi {
    
    
    public static boolean isNumeric(char x)
    {
        return (x >= '0' && x <='9');
    }
    
    public static int convert(String str) throws Exception
    {
        char[] chars = str.toCharArray();
        boolean sign = false;
        int counter = 0;
        if(chars[0] == '-')
        {
            sign = true;
            counter = counter + 1;
        }
        int digit = 0;
        for(;counter <= str.length()-1;counter++)
        {
            if(isNumeric(chars[counter]))
            {
                digit = digit *10 + chars[counter]-'0';
            }
            else
            {
                throw new Exception("Not a number");
            }
        }
        if(sign)
        {
            digit = -1 * digit;
        }
        return digit;
    }
    
    public static void main(String[] args)
    {
        try
        {
            String str = "-100";
            System.out.println(convert(str));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}
