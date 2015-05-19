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
public class singleDetection {
    
    public static int detect(int[] arr)
    {
        int ones =0;
        int twos = 0;
        int common_mask = 0;
        for(int i=0; i < arr.length; i++)
        {
            twos = twos |(ones & arr[i]);
            ones = ones ^ arr[i];
            common_mask=~(ones&twos);
            ones = ones&common_mask;
            twos = twos&common_mask;
                    
        }
        return ones;
    }
    
    public static void main(String[] args)
    {
        int[] array = {3,3,3,2,3,3,3};
        System.out.println(detect(array));
    }
    
}
