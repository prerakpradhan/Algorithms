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
public class countSetBits {
    
    public static int countsetBits(int n)
    {
        int count = 0;
        while(n!=0)
        {
            count = count + (n & 1);
            n >>= 1;
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        System.out.println(countsetBits(11));
    }
    
}
