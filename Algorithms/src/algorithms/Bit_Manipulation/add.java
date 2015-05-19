/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Bit_Manipulation;

/**
 *
 * @author coolp_000
 */
public class add {
    
    public static int add(int x, int y)
    {
        while(y!=0)
        {
            int carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }
        return x;
    }
    
    public static void main(String[] args)
    {
        System.out.println(add(14,10));
    }
    
}
