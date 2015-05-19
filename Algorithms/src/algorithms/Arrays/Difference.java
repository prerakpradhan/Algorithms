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
public class Difference {
    
    public class Interval
    {
        public int buy;
        public int sell;
    }
    
    public Interval[] maxProfit(int[] arr)
    {
        int n = arr.length;
        if (n==1 || n==0)
            return null;
        Interval[] solution = new Interval[n/2+1];
        int i=0;
        int count=0;
        while(i <n)
        {
            while((i < n-1) && (arr[i+1] <= arr[i]))
            {
                i++;
            }
            
            if (i == n-1)
            {
               break; 
            }
            Interval temp = new Interval();
            temp.buy=arr[i++];
            solution[count]=temp;
            
            while((i<n) && (arr[i] >= arr[i-1]))
            {
                i++;
            }
            solution[count].sell=arr[i-1];
            count++;
        }
        return solution;
    }
    
    public int onePairDiff(int[] arr)
    {
        if(arr.length == 1)
        {
            return arr[0];
        }    
        if(arr.length == 0)
        {
            System.out.println("Bad lenght");
            return 0;
        }
        int maxDiff = arr[0]-arr[1];
        int min=arr[0];
        for(int i=1; i <arr.length; i++)
        {
            if(arr[i]-min > maxDiff)
            {
                maxDiff = arr[i]-min;
            }
            if(arr[i]<min)
            {
                min = arr[i];
            }
        }
        return maxDiff;
                
    }
    
    public static void main(String args[])
    {
        Difference m = new Difference();
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(m.onePairDiff(arr));
        int[] newarr = {100, 180, 260, 310, 40, 535, 695};
        Interval[] result=m.maxProfit(newarr);
        for(int i=0; i < result.length; i++)
        {
            //System.out.println(i);
            if(result[i]!=null)
            {
             System.out.println(result[i].buy + "--> "+result[i].sell);  
            }
        }
    }
}
