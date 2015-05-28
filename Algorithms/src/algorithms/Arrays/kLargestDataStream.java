/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Arrays;

/**
 *
 * @author coolp_000
 */
public class kLargestDataStream {
    
    public static void kLargest(int[] mockStream, int k)
    {
        Heap h1 = new Heap();
        int n = 0;
        for(int i=0; i < mockStream.length; i++)
        {
            if(n < k)
            {
                h1.insert(mockStream[i]);
                n++;
            }
            else
            {
                
                if(h1.getTop() < mockStream[i])
                {
                    h1.remove();
                    h1.insert(mockStream[i]);
                }
            }
        }

        for(int i=0; i < k ; i++)
        {
            System.out.println(h1.getTop());
            h1.remove();
        }
    }
    
    public static void main(String[] args)
    {
        int[] mockStream={10,20,3,4,13,5,16,17,1};
        kLargest(mockStream, 5);
    }
    
}
