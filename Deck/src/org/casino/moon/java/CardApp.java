package org.casino.moon.java;

import java.util.Arrays;

public class CardApp {

	public static void main(String[] args) {
		Card[] deck = Card.deck();
		
		System.out.println(deck[52].getColor());
		System.out.println(deck[52].getFace());
		System.out.println(deck[52].getRank());
		System.out.println(deck[52].getRankNum());
		System.out.println(deck[52].getSortNum());
		
		//System.out.println(Arrays.toString(deck));
		

	}

}
