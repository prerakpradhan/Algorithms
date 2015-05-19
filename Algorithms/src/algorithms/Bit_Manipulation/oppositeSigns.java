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
public class oppositeSigns {
    
    public static boolean oppositeSign(int x, int y)
    {
        return  (x^y) < 0;
    }
    public static void main(String[] args)
    {
        System.out.println(oppositeSign(10, 20));
    }
    
}
