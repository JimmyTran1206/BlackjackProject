package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts", "♥️"), SPADES("Spades", "♠️"), CLUBS("Clubs", "♣️️"), DIAMONDS("Diamonds", "♦️");

	private String name;
	private String suit;

	private Suit(String name, String suit) {
		this.name = name;
		this.suit = suit;
	}

	public String getSuit() {
		return suit;
	}

	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name;
	}
}
