/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coolp_000
 */
public class mergeSort {
    
    public List<Integer> mergeSort(List<Integer> list)
    {
        if(list.size() <= 1)
        {
            return list;
        }
        int length = list.size();
        int middle = length/2;
        List<Integer> left = mergeSort(list.subList(0, middle));
        List<Integer> right = mergeSort(list.subList(middle, length));
        List<Integer> result = merge(left, right); 
        return result;        
    }
    
    public void print(List<Integer> result)
    {
        for(int i: result)
        {
            System.out.println(i);
        }
        System.out.println("--------");
    }
    
    public List<Integer> merge(List<Integer> left, List<Integer> right)
    {
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while(i < left.size() && j < right.size())
        {
            if(left.get(i) < right.get(j))
            {
                result.add(left.get(i));
                i++;
            }
            else
            {
                result.add(right.get(j));
                j++;
            }
        }
        if(i < left.size())
        {
            for(;i<left.size(); i++)
            {
                result.add(left.get(i));
            }
        }
        else if(j < right.size())
        {
            for(;j<right.size();j++)
            {
                result.add(right.get(j));
            }
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        mergeSort m = new mergeSort();
        List<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(2);
        test.add(3);
        test.add(10);
        test.add(4);
        List<Integer> result= m.mergeSort(test);
        m.print(result);
    }
    
}
