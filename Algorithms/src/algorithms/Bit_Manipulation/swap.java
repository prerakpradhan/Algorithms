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
public class swap {
    
    public static void swap(int x, int y)
    {
        x = x ^ y;
        y = x ^ y;
        x= x ^ y;
        System.out.println(x);
        System.out.println(y);
    }
    
    public static void main(String[] args)
    {
        swap(3,2);
    }
    
}
