package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand{
	StringBuilder sb = new StringBuilder();
	
	
	public boolean isBurst() {
		return (this.getHandValue()>21? true:false);
	}
	
	@Override
	public int getHandValue() {
		boolean hasAce=false;
		int softValue=0;
		int hardValue=0;
		// Note: Ace is counted as 1
		for (Card card:cardsOnHand) {
			softValue+=card.getValue();
			if(card.toString().contains("ACE")) {
				hasAce=true;
			}
		}
		hardValue=softValue+10;
		if(hasAce&&hardValue<=21) {
			return hardValue;
		}else {
			return softValue;
		}
	}
	
	public boolean holdingAce(){
		boolean hasAce=false;
		for (Card card:cardsOnHand) {
			if(card.toString().contains("ACE")) {
				hasAce=true;
			}
		}
		return hasAce;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand Value = ");
		builder.append(this.getHandValue());
		builder.append(". ");
		builder.append(super.toString());
		return builder.toString();
	}
	
	
	
}
