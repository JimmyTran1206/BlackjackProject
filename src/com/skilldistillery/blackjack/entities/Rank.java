package com.skilldistillery.blackjack.entities;

public enum Rank {
	TWO(2,"2"), THREE(3,"3"), FOUR(4,"4"), FIVE(5,"5"), SIX(6,"6"), 
    SEVEN(7,"7"), EIGHT(8,"8"), NINE(9,"9"), TEN(10,"10"), 
    JACK(10, "J"), QUEEN(10, "Q"), KING(10, "K"), ACE(1, "A");
    
    private int value;
    private String rank;

    private Rank(int value, String rank) {
      this.value = value;
      this.rank=rank;
    }

    public int getValue() {
      return value;
    }
    
    public String getRank() {
    	return rank;
    }   
}
