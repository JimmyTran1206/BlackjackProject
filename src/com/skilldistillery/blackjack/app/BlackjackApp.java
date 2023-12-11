package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackDealer;
import com.skilldistillery.blackjack.entities.BlackjackPlayer;

public class BlackjackApp {
	Scanner kb = new Scanner(System.in);
	private String playerContinue = "y";
	private String playerHitStand = "h";
	BlackjackDealer dealer = new BlackjackDealer();
	BlackjackPlayer player = new BlackjackPlayer();

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	private void run() {
		while (playerContinue.equals("y")) {
			System.out.println("Welcome to Blackjack");
			System.out.println("===========================");
			gameStart();
		}
		System.out.println("Exiting...");
		System.out.println("See you again");
		kb.close();

	}

	private void printDealerHand() {
		System.out.println("Dealer hand: ");
		System.out.println(dealer.getHand().getHandCards());
		System.out.println(dealer.getHand());
	}

	private void promptPlayerContinue() {
		playerContinue = player.playAgain(kb);
		if (playerContinue.equals("y")) {
			dealer = new BlackjackDealer();
			player = new BlackjackPlayer();
		}
	}

	private void gameStart() {

		dealer.shuffleDeck();

		// Deal 2 cards to dealer and player
		for (int i = 1; i <= 2; i++) {
			dealer.collectCard(dealer.dealCard());
			System.out.println("The dealer has deal one card to his hand.");
			player.collectCard(dealer.dealCard());
			System.out.println("The dealer has deal one card to your hand:");
			System.out.println(player.getHand().getHandCards());
		}

		// check dealer/player black jack
		if (dealer.isDealerBlackjack() == true) {
			System.out.println("Dealer has BlackJack!!!!");
			printDealerHand();
			System.out.println("Dealer Wins!!!");
			promptPlayerContinue();
			return;
		} else if (player.isPlayerBlackjack() == true) {
			System.out.println("You has BlackJack!!!!");
			System.out.println("Congratualtion! YOU WIN!!!");
			promptPlayerContinue();
			return;
		}
		System.out.println("===========================");
		System.out.println("Ready for the fun? Press anykey to begin...");
		kb.nextLine();

		// Dealer hit/stand
		dealer.dealerHitorStand();
		printDealerHand();

		// Player hit/stand
		while (player.getHand().getHandValue() < 21) {
			System.out.println("Your hand: ");
			System.out.println(player.getHand().getHandCards());
			playerHitStand = player.playerHitOrStand(kb);
			if (playerHitStand.equals("h")) {
				player.collectCard(dealer.dealCard());
			} else if (playerHitStand.equals("s")) {
				System.out.println("You have chosen to stand...");
				break;
			} else {
				System.out.println("Invalid input!!!");
			}
		}

		// compare results
		System.out.println("===========================");
		System.out.print("Your hand: ");
		System.out.println(player.getHand().getHandCards());
		System.out.println(player.getHand().toString());
		System.out.print("Dealer hand: ");
		System.out.println(dealer.getHand().getHandCards());
		System.out.println(dealer.getHand().toString());
		if (dealer.getHand().isBurst()) {
			if (player.getHand().isBurst()) {
				System.out.println("Both of you have bursted");
			} else {
				System.out.println("Congratualtion! YOU WIN!!!");
			}
		} else if (player.getHand().isBurst()) {
			System.out.println("Dealer Wins!!!");
		} else {
			String output = player.getHand().getHandValue() > dealer.getHand().getHandValue()
					? "Congratualtion! YOU WIN!!!"
					: "Dealer Wins!!!";
			System.out.println(output);
		}

		// ask to play again
		promptPlayerContinue();
	}
}
