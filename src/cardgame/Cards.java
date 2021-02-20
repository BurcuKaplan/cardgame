package cardgame;

import java.util.Random;


// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author:
// date:
public class Cards {
    final int NOOFCARDSINFULLPACK = 52;
    
    // properties
    Card[] cards;
    int    valid;  // number of cards currently in collection
    
    // constructors
    public Cards( boolean fullPack ) {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        
        if ( fullPack ) {
            createFullPackOfCards();
        }
    }
    
    // methods
    public Card getTopCard() {
        Card tmp;
        if ( valid <= 0 ) {
            return null;
        } else {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    public boolean addTopCard( Card c ) {
        if ( valid < cards.length ) {
            cards[valid] = c;   // should this be cloned?
            valid++;
            return true;
        }
        return false;
    }
    
    private void createFullPackOfCards() {
    	for( int i = 0; i < NOOFCARDSINFULLPACK; i++ ) {
    		addTopCard( new Card(i) );
    	}
    }

	
	public void shuffle() {
		Random random;
		Card temp;
		int newIndex;
		random = new Random();
		for( int i = 0; i < cards.length; i++ ) {
			newIndex = random.nextInt( cards.length );
			temp = cards[newIndex];
			cards[newIndex] = cards[i];
			cards[i] = temp;
		}
		// List interface has the following method:
		// Collections.shuffle(cards);
	}
    
    
    // For testOnly... remove from production version!
    public void testOnlyPrint() {
        for ( int i =0; i < valid; i++ ) {
            System.out.println( cards[i] );
        }
    }
    
} // end class Cards