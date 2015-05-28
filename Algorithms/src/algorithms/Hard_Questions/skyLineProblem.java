/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Hard_Questions;

import java.util.ArrayList;

/**
 *
 * @author coolp_000
 */


public class skyLineProblem {
    
    public SkyLine finalResult;
    
    public class SkyStrip
    {
        public int x;
        public int ht;
        public SkyStrip(int x, int ht)
        {
            this.x = x;
            this.ht = ht;
        }
    }
    public class SkyLine
    {
        ArrayList<SkyStrip> line;
        int n;
        
        public SkyLine()
        {
            this.n=0;
            this.line=new ArrayList<>();
        }
        
        public void addStrip(SkyStrip strip)
        {
            if(n > 0 && line.get(n-1).ht == strip.ht)
            {
                return;
            }
            if(n > 0 && line.get(n-1).x == strip.x)
            {
                line.get(n-1).ht = Math.max(line.get(n-1).ht, strip.ht);
                return;
            }
            line.add(strip);
            n++;
        }
        
    }
    
    public SkyLine findMergedSky(ArrayList<Initials> arr, int l, int r)
    {
        if( l == r)
        {
            SkyLine result = new SkyLine();
            result.addStrip(new SkyStrip(arr.get(l).x, arr.get(l).ht));
            result.addStrip(new SkyStrip(arr.get(l).y, 0));
            return result;
        }
        int mid = l + (r-l)/2;
        SkyLine left = findMergedSky(arr, l, mid);
        SkyLine right = findMergedSky(arr, mid+1, r);
        SkyLine merged = merge(left,right);
        return merged;
    }
    
    public SkyLine merge(SkyLine line1, SkyLine line2)
    {
        int h1= 0;
        int h2=0;
        SkyLine result = new SkyLine();
        int i =0;
        int j =0;
        while(i < line1.line.size() && j < line2.line.size())
        {
            if(line1.line.get(i).x < line2.line.get(j).x)
            {
                int x = line1.line.get(i).x;
                h1 = line1.line.get(i).ht;
                int ht = Math.max(h1, h2);
                result.addStrip(new SkyStrip(x, ht));
                i++;
            }
            else
            {
                int x = line2.line.get(j).x;
                h2 = line2.line.get(j).ht;
                int ht = Math.max(h1, h2);
                result.addStrip(new SkyStrip(x, ht));
                j++;  
            }
        }
        while(i < line1.line.size())
        {
            result.addStrip(line1.line.get(i));
            i++;
        }
        while(j < line2.line.size())
        {
            result.addStrip(line2.line.get(j));
            j++;
        }
        return result;
    }
    
    public void print(SkyLine result)
    {
        System.out.println("---------");
        ArrayList<SkyStrip> strips = result.line;
        for(SkyStrip strip : strips)
        {
            System.out.println(strip.x + " , "+strip.ht);
        }
    }
    
    public static void main(String[] args)
    {
        ArrayList<Initials> initials = new ArrayList<>();
        initials.add(new Initials(1, 11, 5));
        initials.add(new Initials(2, 6, 7));
        initials.add(new Initials(3, 13, 9));
        initials.add(new Initials(12, 7, 16));
        initials.add(new Initials(14, 3, 25));
        initials.add(new Initials(19, 18, 22));
        initials.add(new Initials(23, 13, 29));
        initials.add(new Initials(24, 4, 28));
        skyLineProblem problem = new skyLineProblem();
        problem.print(problem.findMergedSky(initials, 0, initials.size()-1));
        
    }
            
}
