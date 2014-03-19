package clueTests;

import java.awt.Color;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.Card;
import clueGame.CardType;
import clueGame.Game;

public class GameSetupTests {
	private static Game ourGame;
	
	@BeforeClass
	public static void setup() {
		ourGame = new Game();
		ourGame.loadConfigFiles("./ourboardfiles/StartCharacters.txt", "./ourboardfiles/Weapons.txt");
	}
	
	@Before
	public void reset() {
		//anything we need to reset before each test? 
		//we shall see
	}
	
	//test the people (part of config file testing)
	@Test
	public void numPlayers() { //correct number of total players
		int expected = 6;
		int actual = ourGame.getPlayers().size();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testHuman() {
		/*check the HumanPlayer
		name
		color
		starting location
		*/
	}	
	@Test
	public void testComputer() {
		/*
		check first ComputerPlayer from file
		name
		color
		starting local
		check last ComputerPlayer from file
		name
		color
		starting local*/
	}
	
	//testing the deck (parts directly influenced by loadConfigFiles)
	@Test
	public void totalCards() { //correct number of cards in deck
		//6 people, 6 weapons, 9 rooms
		int expected = (6+6+9);
		int actual = ourGame.getDeck().size();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void containsCards() {
		//check deck contains specific weapon
		boolean expected = true;
		boolean containsWeapon = false;
		for(Card c: ourGame.getDeck()) {
			if (c.getName().equals("Candlestick") && c.getMyType().equals(CardType.WEAPON))
				containsWeapon = true;
		}
		Assert.assertEquals(expected, containsWeapon);
		
		//check deck contains specific person
		boolean containsPerson = false;
		for(Card c: ourGame.getDeck()) {
			if (c.getName().equals("Mrs. White") && c.getMyType().equals(CardType.PERSON))
				containsPerson = true;
		}
		Assert.assertEquals(expected, containsPerson);
		
		//check deck contains specific room
		boolean containsRoom = false;
		for(Card c: ourGame.getDeck()) {
			if (c.getName().equals("Kitchen") && c.getMyType().equals(CardType.ROOM))
				containsRoom = true;
		}
		Assert.assertEquals(expected, containsRoom);
		
	}
	@Test
	public void cardTypeNums() { //testing number of each type of card in the deck
		//6 people, 6 weapons, 9 rooms 
		int expected = 6;
		int personCards = 0;
		int weaponCards = 0;
		int roomCards = 0;
		for (Card c: ourGame.getDeck()) {
			if (c.getMyType().equals(CardType.PERSON))
				personCards++;
			if (c.getMyType().equals(CardType.WEAPON))
				weaponCards++;
			if (c.getMyType().equals(CardType.ROOM))
				roomCards++;	
		}
		Assert.assertEquals(expected, personCards);
		Assert.assertEquals(expected, weaponCards);
		expected = 9;
		Assert.assertEquals(expected, roomCards);
	}
	@Test
	public void allDelt() { // make sure all the cards got dealt
		
	}
	@Test
	public void evenSplit() { //check that each player has approximately the same number of cards
		
	}
	@Test
	public void uniqueCards() { //check that no card is given out more than once
		
	}
}