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
public class oneEdit {  
    public static boolean onlyOneEdit(String first, String second)
    {
      if(first.equals(second))
      {
        return false;
      }

      int l1 = first.length();
      int l2 = second.length();

      if(l1 - l2 > 1 || l2 - l1 > 1)
      {
        // At least two edits .. no need to continue
        return false;
      }

      String longer = (l1 > l2)? first : second;
      String shorter = (l1 > l2)? second : first;

      for(int i = 0; i < shorter.length(); i++)
      {
        if(longer.charAt(i) != shorter.charAt(i))
        {
            return (longer.substring(i + 1).equals(shorter.substring(i + 1))) || (longer.substring(i+1).equals(shorter.substring(i))) ;
        }
      }  
      return true;
    }

    
}
