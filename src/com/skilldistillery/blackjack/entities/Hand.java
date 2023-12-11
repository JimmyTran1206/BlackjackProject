package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cardsOnHand= new ArrayList<>();
	
	public abstract int getHandValue();
	
	public void collectCard(Card card) {
		cardsOnHand.add(card);
	}
	
	public void clearHand() {
		cardsOnHand.clear();
	}
	
	public List<Card> getCardsOnHand() {
		return cardsOnHand;
	}

	public String getHandCards() {
		StringBuilder output=new StringBuilder();
		output.append("|");
		for (int i=0;i<cardsOnHand.size(); i++) {
			output.append(cardsOnHand.get(i).getSuit());
			output.append(cardsOnHand.get(i).getRank());
			output.append("|");			
		}
		return output.toString();	
	}
	@Override
	//show all cards on hand
	public String toString() {
		StringBuilder builder= new StringBuilder();
		builder.append("Cards on hand: ");
		for (int i=0; i< cardsOnHand.size();i++) {
			if(i!=cardsOnHand.size()-1) {
				builder.append(cardsOnHand.get(i).toString());
				builder.append(",");
			}else {
				builder.append(cardsOnHand.get(i).toString());
				builder.append(".");
			}
		}
		return builder.toString();
	}
	
	
	

}
