/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Arrays;

/**
 *
 * @author coolp_000;
 */
public class testmode {
    
    public static int mindJump(int[] arr)
    {
        int n = arr.length;
        int[] jumps = new int[n];
        String[] jumpString = new String[n];
        jumps[n-1]=0;
        int i, j;
        int min;
        for(i = n-2; i >=0; i--)
        {
            if(arr[i]==0)
            {
                jumps[i] = Integer.MAX_VALUE;
                jumpString[i] ="";
            }
            else if (arr[i] >= n - i - 1)
            {
                jumps[i] = 1;
                jumpString[i] = Integer.toString(i);
            }
                
            
 
        // Otherwise, to find out the minimum number of jumps needed
        // to reach arr[n-1], check all the points reachable from here
        // and jumps[] value for those points
        else
        {
            min = Integer.MAX_VALUE;  // initialize min value
            int minIndex = 0;
            // following loop checks with all reachable points and
            // takes the minimum
            for (j = i+1; j < n && j <= arr[i] + i; j++)
            {
                //System.out.println(i);
                //System.out.println(jumps[j]);
                if (min > jumps[j])
                {
                    min = jumps[j];
                    minIndex = j;
                }
                    
            }      
 
            // Handle overflow 
            if (min != Integer.MAX_VALUE)
            {
               jumps[i] = min + 1;
               jumpString[i] = jumpString[minIndex] + ", "+Integer.toString(i);
            }
              
              
            else
            {
                jumps[i] = min;
                jumpString[i]="";
            }
               // or INT_MAX
        }
    }
        System.out.println(jumpString[0]);
    return jumps[0];
        
        
    }
    
    public static int binary(int[] arr, int left, int right, int key)
    {
        if(left == right)
        {
            if(arr[left] == key)
            {
                return left;
            }
            else
            {
                return -1;
            }
        }
        if(left < right && left > -1)
        {
            
            int middle = left+(right-left)/2;
            if(arr[middle]==key)
            {
                if((middle+1 <arr.length) &&(arr[middle+1]==key))
                {
                    return binary(arr,middle+1, right ,key);
                }
                else
                {
                    return middle;
                }
            }
            else if(arr[middle] < key)
            {
                return binary(arr, middle+1, right,key);
            }
            else
            {
                return binary(arr,left, middle-1, key);
            }
        }
        return -1;
    }
    
    public static int valueofI(int i, int[] arr)
    {
         int index = binary(arr,i+1,arr.length-1, arr[i]);
         if(index != -1)
         {
             i = index+1;
         }
         else
          {
             i=i+2;
          }
          return i;
        
    }
    
    public static boolean contains_bomb(int[] arr)
    {
        int count =0; 
        boolean consecutive = false;
        int i =0; 
        while( i < arr.length)
        {
            if((i+1<arr.length) && (arr[i]==arr[i+1]))
                {
                    if(count > 0)
                    {
                        if(arr[i-1]+1 == arr[i])
                        {
                             i = valueofI(i, arr);
                             count++;   
                        }
                        else
                        {
                            i = valueofI(i, arr);
                            count=1;
                        }
                        
                    }
                    else
                    {
                        i = valueofI(i,arr);
                        count++;
                        
                    }                
            }
            else
            {
                count=0;
                i++;
            }
            if(count == 3)
                return true;
            System.out.println(i);
        }
        return false;
    }
    
    public static void test()
    {
        boolean right = false;
        boolean left= false;
        if(!(right&left))
            System.out.println("sss");
    }
    public static void toUpper(String str)
    {
        str = str.toLowerCase();
        String result = "";
        for(int i=0; i <str.length(); i++)
        {
            char x = (char)((str.charAt(i)-'a')+ 'A');
            result = result + String.valueOf(x);
        }
        System.out.println(result);
    }
    
    public static String addition(String str1, String str2)
    {
        int m = str1.length();
        int n = str2.length();
        if(n==0)
        {
            return str1;
        }
        if(m==0)
        {
            return str2;
        }
        int carry =0;
        int i =m-1;
        int j =n-1;
        String result = "";
        while(i >=0 && j >= 0)
        {
            int x = Integer.parseInt(str1.substring(i,i+1));
            int y = Integer.parseInt(str2.substring(j,j+1));
            int temp_result = x+y+carry;
            if(temp_result >= 10)
            {
                carry = temp_result/10;
                temp_result = temp_result%10;
            }
            else
            {
                carry =0;
            }
            result = Integer.toString(temp_result) + result;
            i--;
            j--;
        }
        if(m==n)
        {
            if(carry > 0)
            {
                result = Integer.toString(carry)+result;
            }
            return result;
        }
        while(i >= 0)
        {
            int x = Integer.parseInt(str1.substring(i,i+1));
            int temp_result = x+carry;
            if(temp_result >= 10)
            {
                carry = temp_result/10;
                temp_result = temp_result%10;
            }
            else
            {
                carry =0;
            }
            result = Integer.toString(temp_result) + result;
            i--;
        }
        while(j >= 0)
        {
            int x = Integer.parseInt(str2.substring(j,j+1));
            int temp_result = x+carry;
            if(temp_result >= 10)
            {
                carry = temp_result/10;
                temp_result = temp_result%10;
            }
            else
            {
                carry =0;
            }
            result = Integer.toString(temp_result) + result;
            j--;
        }
        if(carry!=0)
        {
            result = Integer.toString(carry)+result;
        }
        return result;
    }
    public static int[] concat(int[] a, int[] b) {
   int aLen = a.length;
   int bLen = b.length;
   int[] c= new int[aLen+bLen];
   System.arraycopy(a, 0, c, 0, aLen);
   System.arraycopy(b, 0, c, aLen, bLen);
   return c;
}
    
    public static void kadane(int[] arr)
    {
        int counter = 0;
        int maxSofar = 0;
        int max =0;
        int length = arr.length;
        int[] result = concat(arr,arr);
        for(int i = 0; i< result.length; i++)
        {
            maxSofar = maxSofar +result[i];
            if(maxSofar < 0 )
            {
                maxSofar = 0;
                counter =0;
            }
            else
            {
                counter++;
            }
            if(maxSofar > max)
            {
                if(counter <= length)
                {
                    max = maxSofar;
                    System.out.println(i);
                    System.out.println(counter);
                    System.out.println(i-counter+1);
                }
            }
        }
        System.out.println(max);
        
    }
    public static void main(String[] args)
    {
        //System.out.println(addition("1999", "1994"));
        //int a = (int)('a'-'A');
        //toUpper("babB");
        //System.out.println("bab".substring(2, 3));
        //System.out.println(27%10);
        //System.out.println(a);
        int[] arr= {1,4,7,8,8,9,9,9,11,11,11};
        int arr2[] = {1, 3,4,2, 2, 2, 0, 9};
        int[] mis = {10, -3, -4, 7, 6, 5, -4, -1};
        kadane(mis);
                
        //System.out.println(mindJump(arr2));
        //System.out.println(contains_bomb(arr));
        //test();
    }
    
}
