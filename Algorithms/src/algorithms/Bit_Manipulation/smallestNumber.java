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
public class smallestNumber {
    
 public static int min(int x, int y)
 {
    return  y + ((x - y) & ((x - y) >> 
            31)); 
 }
 
 public static void main(String[] args)
 {
     System.out.println(min(7,min(100,200)));
 }
 
    
}
