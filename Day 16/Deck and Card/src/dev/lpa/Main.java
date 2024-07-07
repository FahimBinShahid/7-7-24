package dev.lpa;
import java.util.*;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) {



Card [] cardArray = new Card[13];
Card aceOfHeart = Card.getFaceCard(Card.Suit.HEART,'A');

        Arrays.fill(cardArray, aceOfHeart);
        Card.printDeck(Arrays.asList(cardArray),"Ace Of Heart",1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards,aceOfHeart);
        System.out.println(cards);
        System.out.println("card.size() =" + cards.size());

        List<Card>acesOfHeart=Collections.nCopies(13,aceOfHeart);
        Card.printDeck(acesOfHeart,"acesOfHeart",1);

            Card jackOfDiamond = Card.getFaceCard(Card.Suit.DIAMOND,'J');

            List<Card>jacksOfDiamond=Collections.nCopies(13,jackOfDiamond);
            Card.printDeck(jacksOfDiamond,"JackOfDIamond",1);


        Card kingOfClub = Card.getFaceCard(Card.Suit.CLUB,'K');

        List<Card>kingsOfClub=Collections.nCopies(13,kingOfClub);
        Card.printDeck(kingsOfClub,"KingsOfClub",1);




        Collections.addAll(cards,cardArray);
        Card.printDeck(cards,"Card Collection with Aces Added", 1);

        Collections.copy(cards,kingsOfClub);
        Card.printDeck(cards,"Card Collection with King Copied", 1);

        Collections.fill(cards,jackOfDiamond);
        Card.printDeck(cards,"Jack Of Diamond",1);

        Card queenOfSpade =Card.getFaceCard(Card.Suit.SPADE,'Q');

        Collections.fill(cards,queenOfSpade);
        Card.printDeck(cards,"Queen Of Spade", 1);

        cards= List.copyOf(jacksOfDiamond);
        Card.printDeck(cards,"CopyOF JAck", 1);

            List<Card> deck = Card.getStandardDeck();
            Card.printDeck(deck);

            Collections.shuffle(deck);
            Card.printDeck(deck,"Shuffled Deck",4);

            Collections.reverse(deck);
            Card.printDeck(deck,"REversed after shuffled",4);

            var sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
            Collections.sort(deck,sortingAlgorithm);
            Card.printDeck(deck,"Sorted Deck",13);

            Collections.reverse(deck);
            Card.printDeck(deck, "Highest to lowest",13);

            List<Card> kings= new ArrayList<>(deck.subList(4,8));
            Card.printDeck(kings,"Kings in decks",1);

            List<Card> Tens = new ArrayList<>(deck.subList(16,20));
            Card.printDeck(Tens,"Tens in decks", 1);

Collections.shuffle(deck);
            int subListIndex= Collections.lastIndexOfSubList(deck,Tens);
        System.out.println("Sub List Index :"+ subListIndex);
        System.out.println("Contains:" + deck.containsAll(Tens));

        boolean disJoint = Collections.disjoint(deck,Tens);
        System.out.println("Disjoint: " + disJoint);

        boolean disJoint2 = Collections.disjoint(kings,Tens);
        System.out.println("Disjoint: " + disJoint2);


deck.sort(sortingAlgorithm);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART,10);
        int foundIndex = Collections.binarySearch(deck,tenOfHearts,sortingAlgorithm);
        System.out.println("Found index : " + foundIndex);
        System.out.println(deck.get(foundIndex));

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB,10);
        Collections.replaceAll(deck,tenOfClubs,tenOfHearts);
        Card.printDeck(deck.subList(32,36),"Tens:",1);

        Collections.replaceAll(deck,tenOfHearts,tenOfClubs);
        Card.printDeck(deck.subList(32,36),"Tens:",1);

        if(Collections.replaceAll(deck,tenOfHearts,tenOfClubs)){
            System.out.println("Ten of Hearts were replace by the Ten of Clubs");
        }else{
            System.out.println("No Ten of hearts were found");

            System.out.println("Ten of Club Cards =" +
                    Collections.frequency(deck, tenOfClubs));


            List<Card> copied = new ArrayList<>(deck.subList(0,13));
            Collections.rotate(copied,2);
            System.out.println("UnRotated : " + deck.subList(0,13));
            System.out.println("Rotated" + 2 + ":" + copied);

            copied = new ArrayList<>(deck.subList(0,13));
            Collections.rotate(copied,-2);
            System.out.println("UnRotated : " + deck.subList(0,13));
            System.out.println("Rotated" + -2 + ":" + copied);

            copied = new ArrayList<>(deck.subList(0,13));
            for(int i = 0; i<=copied.size() / 2; i++){
                Collections.swap(copied ,i, copied.size()-1-i);
            }
            System.out.println("Manual reverse: " + copied);



        }



    }
}