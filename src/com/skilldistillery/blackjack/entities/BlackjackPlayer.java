package com.skilldistillery.blackjack.entities;

import java.util.Scanner;

public class BlackjackPlayer {
	private BlackjackHand hand = new BlackjackHand();
	
	public void collectCard(Card card) {
		hand.collectCard(card);
	}
	
	public boolean isPlayerBlackjack() {
		if(hand.getCardsOnHand().size()==2 && hand.holdingAce()&&hand.getHandValue()==21) {
			return true;
		}
		return false;
	}
	
	public BlackjackHand getHand() {
		return hand;
	}
	
	public String playerHitOrStand(Scanner userInput) {
		System.out.print("Do you want to hit or stand? Enter h for hit or s for stand: ");
		String choice = userInput.nextLine().toLowerCase();
		return choice;
	}
	
	
	public String playAgain(Scanner userInput) {
		System.out.println("Would you like to play again? Enter y for yes any other key to quit: ");
		String choice = userInput.nextLine().toLowerCase();
		return choice;
	}	
	
}
