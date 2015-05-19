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
public class lookAndSay {
    public static void lookandSay(int n)
    {
       String prev = "11";
       if (n == 0)
       {
           System.out.println("1");
       }
       else if (n == 1)
            System.out.println("11");
       else{
            for (int i = 2; i <= n ;i++)
            {
                String temp = "";
                int count = 0;
                boolean flag = false;
                char[] charArray = prev.toCharArray();
                char prevchar = charArray[0];
                int no = 0;
                for(int index=0; index < prev.length();index++)
                {
                    if(charArray[index]==prevchar)
                    {
                        count = count+1;
                        flag = false;
                    }
                    else
                    {
                   
                          temp = temp + Integer.toString(count)+String.valueOf(prevchar);
                          prevchar = charArray[index];
                          count =1;
                          flag = true;
                          no = index;
                    }
               
           }
                //keep track of no to keep track of the case when number
                //chnages but is not taken into account like 21
           if(flag == false|| no == charArray.length-1 )
           {   
                temp = temp + Integer.toString(count)+String.valueOf(prevchar);
           }
           prev = temp;
       }
       
        System.out.println(prev);
       }
        
    }
    
    
    public static void main(String[] args)
    {
        lookandSay(6);
    }
    
    
}
