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
public class reverseString {
    
    public static char[] reverse(char[] arr, int front, int back)
    {
        while(front < back)
        {
            char temp = arr[front];
            arr[front]=arr[back];
            arr[back]=temp;
            back--;
            front++;
        }
        return arr;
    }
    
    public static void sentenceReverse(String str)
    {
        char[] array = str.toCharArray();
        array = reverse(array, 0, array.length-1);
        int front=0;
        int back= 0;
        for(char a: array)
        {
            if(" ".equals(String.valueOf(a)))
            {
                array=reverse(array, front, back-1);
                front= back+1;
            }
            back++;
        }
        array=reverse(array,front,array.length-1);
        System.out.println(String.valueOf(array));
    }
    
    public static void main(String[] args)
    {
        String s = "rat a is  there google in ";
        sentenceReverse(s);
    }
    
}
