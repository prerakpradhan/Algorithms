package scoringpokerhand;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coolp_000
 */
public class evaluate {
    
    public int evaluate(Hand handOne, Hand handTwo)
    {
        return 0;
    }
    
    public int isFlush(Hand handOne)
    {
        ArrayList<Card> cards =handOne.cards;
        String prev= cards.get(0).suit;
        for(int i=1; i < 5; i++)
        {
            Card card = cards.get(i);
            if(!card.suit.equals(prev))
            {
                return -1;
            }
        }
        return 6;
    }
    
    public int fullHouse(Hand hand)
    {
        ArrayList<Card> cards = hand.cards;
        String firstCard = "";
        String secondCard = "";
        int firstCardCount = 0;
        int secondCardCount=0;
        for(Card card: cards)
        {
            if(!card.value.equals(firstCard))
            {
                if(firstCard.equals(""))
                {
                   firstCard = card.value;
                   firstCardCount = 1;
                }   
            }
            else
            {
                firstCardCount++;
            }
            if(!card.value.equals(secondCard))
            {
                if(secondCard.equals(""))
                {
                   secondCard = card.value;
                   secondCardCount = 1;
                }   
            }
            else
            {
                secondCardCount++;
            }
            if(firstCardCount > 3 || secondCardCount > 3 )
            {
                return -1;
            }
            if(!card.value.equals(firstCard) || !card.value.equals(secondCard))
            {
                return -1;
            }  
        }
        return 7;
    }
    
    
    public int fourKind(Hand hand)
    {
        ArrayList<Card> cards = hand.cards;
        boolean seenOne = false;
        String firstPrevious = "";
        String secondPrevious = "";
        int firstCount = 0;
        int secondCount = 0;
        for(Card card: cards)
        {
            if(!card.value.equals(firstPrevious))
            {
                if(firstPrevious.equals(""))
                {
                    firstPrevious = card.value;
                    firstCount++;
                }
            }
            else
            {
                firstCount++;
            }
            if(!card.value.equals(secondPrevious))
            {
                if(secondPrevious.equals(""))
                {
                    secondPrevious = card.value;
                    secondCount++;
                }
            }
            else
            {
                secondCount++;
            }
        }
        if(firstCount == 4  || secondCount == 4)
        {
            return 8;
        }
        else
        {
            return -1;
        }
    }
    
    
    public boolean sameSuit(ArrayList<Card> cards)
    {
        String suit = "";
        for(Card card:cards)
        {
            if(!card.suit.equals(suit))
            {
                if(suit.equals(""))
                {
                    suit =card.suit;
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    public HashMap<String, String> royalFlushHand()       
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("J", "A");
        map.put("K", "A");
        map.put("Q", "A");
        map.put("10", "A");
        
       return map; 
    }
    
    public int RoyalFlush(Hand hand)
    {
        ArrayList<Card> cards = hand.cards;
        if(!sameSuit(cards))
        {
            return -1;
        }
        HashMap<String, String> map = royalFlushHand();
        for(Card card:cards)
        {
            if(!map.containsKey(card.value))
            {
                return -1;
            }
        }
        return 10;

    }
    
}
