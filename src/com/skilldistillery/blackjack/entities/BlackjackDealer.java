package com.skilldistillery.blackjack.entities;

public class BlackjackDealer {
	// dealer has a deck of cards
	private Deck deck = new Deck();
	// dealer has a blackjackHand
	private BlackjackHand hand = new BlackjackHand();

	public void shuffleDeck() {
		deck.shuffle();
	}

	public Card dealCard() {
		return deck.dealCard();

	}

	public void collectCard(Card card) {
		hand.collectCard(card);
	}
	
	public BlackjackHand getHand() {
		return hand;
	}

	public boolean isDealerBlackjack() {
		if (hand.getCardsOnHand().size() == 2 && hand.holdingAce() && hand.getHandValue() == 21) {
			return true;
		}
		return false;
	}

	public void dealerHitorStand() {
		while(hand.getHandValue()<17) {
			this.collectCard(this.dealCard());
			System.out.println("Dealer hits a card.");
		}
		System.out.println("Dealer stands.");
	}
	
}
