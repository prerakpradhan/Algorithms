/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Strings;

import java.util.HashMap;

/**
 *
 * @author coolp_000
 */
public class numberToWords {
    
   public static HashMap<Integer, String> getMap()
   {
       HashMap<Integer, String> map = new HashMap<>();
       map.put(1, "one");
       map.put(2, "two");
       map.put(3, "three");
       map.put(4, "four");
       map.put(5, "five");
       map.put(6, "six");
       map.put(7, "seven");
       map.put(8, "eight");
       map.put(9, "nine");
       map.put(10, "ten");
       map.put(11, "eleven");
       map.put(12, "tweleve");
       map.put(13, "thirteen");
       map.put(14, "fourteen");
       map.put(15, "fiften");
       map.put(16, "sixten");
       map.put(17, "seventeen");
       map.put(18, "eighteen");
       map.put(19, "nineteen");
       map.put(20, "twenty");
       map.put(30, "thirty");
       map.put(40, "fourty");
       map.put(50, "fifty");
       map.put(60, "sixty");
       map.put(70, "seventy");
       map.put(80, "eighty");
       map.put(90, "ninety");
       map.put(100,"hundred");
       map.put(1000,"thousand");
       map.put(10000,"lakh");
       return map;
   }
   
   public static String procTen(int n)
   {
       HashMap<Integer, String> map = getMap();
       int ten = n/10;
           String temp_ten = map.get(ten*10);
           String temp_one="";
           if(n%10 !=0)
           {
               temp_one = map.get(n%10);
           }
           return temp_ten+" "+temp_one;
   }
   
   public static int pow(int n, int count)
   {
       return (int)Math.pow((double)n, (double)count);
   }
  
   
   public static String toWord(int n)
   {
       HashMap<Integer, String> map = getMap();
       if(n <=20)
       {
           return map.get(n);
       }
       else if(n < 100)
       {
           return procTen(n);
       }
       else
       {
           int count =1;
           String result ="";
           while(n != 0)
           {
               if(count ==1)
               {
                   int temp = n%100;
                   if(temp != 0)
                   {
                       result = " and " + procTen(temp);
                   }
                   n = n /100;
               }
               else
               {
                   int digit = n%10;
                   if(digit!= 0)
                   {
                       String digit_str = map.get(digit);
                       String multiple = map.get(pow(10,count));
                       result = " "+digit_str +" "+ multiple + result;
                   }
                   n = n/10;
               }
               count++;
           }
           return result.substring(1);
       }
   }
   
   public static void main(String[] args)
   {
       System.out.println(toWord(11199));
   }
    
}
