package org.casino.moon.java;

import java.util.Arrays;
import java.util.Collections;

public class Card {
	//속성
	public final static int NEW_DECK_SIZE = 54;
	private int rankNum;
	private int sortNum;
	private String face;
	private String rank;
	private String color;
		
	public Card() {
		int rankNum = (int)(Math.random() * NEW_DECK_SIZE) + 1;
		this.rankNum = rankNum;
		setSortNum(rankNum);
		setFace(rankNum);
		setRank(rankNum);
		setColor(rankNum);	
	}
	
	public int getRankNum() {
		return rankNum;
	}

	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int rankNum) {
		if (rankNum >= 49 && rankNum <= 52) {
			sortNum = 1 + (13 * ((rankNum - 1) % 4));
		} else if (rankNum <= 48) {
			sortNum = 2 + ((rankNum - 1) / 4) + (((rankNum - 1) % 4) * 13);
		} else {
			sortNum = rankNum;
		}
	}

	public String getFace() {
		return face;
	}

	private void setFace(int rankNum) {
		if (rankNum == 53) {
			face = "joker(R)";
			return;
		}
		if (rankNum == 54) {
			face = "joker(B)";
			return;
		}
		if      (rankNum % 4 == 1) {face = "clover";}
		else if (rankNum % 4 == 2) {face = "diamond";}
		else if (rankNum % 4 == 3) {face = "heart";}
		else                       {face = "spade";}
	}

	public String getRank() {
		return rank;
	}

	private void setRank(int rankNum) {
		if (rankNum > 52) {
			this.rank = String.valueOf(rankNum);
			return;
		}
		if ((rankNum-1) / 4 == 9)  {rank = "J"; return;}
		if ((rankNum-1) / 4 == 10) {rank = "Q"; return;}
		if ((rankNum-1) / 4 == 11) {rank = "K"; return;}
		if ((rankNum-1) / 4 == 12) {rank = "A"; return;}
		this.rank = String.valueOf((rankNum-1) / 4 + 2);
	}

	public String getColor() {
		return color;
	}

	private void setColor(int rankNum) {
		if ((rankNum == 53 || rankNum % 4 == 2 || rankNum % 4 == 3) && rankNum != 54) {
			color = "red";
		} else {
			color = "black";
		}
	}
	
	// 카드 노카드로 만들기
	public void delete() {
		rankNum = 0;
		sortNum = 0;
		face = "NoCard";
		rank = "x";
		color = "x";
	}
	
	// 카드 한장뽑기 = 스테틱메소드만들자
	public static Card choiceCard(String face, int rank) {
		Card rtCard = new Card();
		if (face.equalsIgnoreCase("joker")) {
			rtCard.rankNum = 53;
			rtCard.sortNum = 53;
			rtCard.face = "joker(R)";
			rtCard.rank = "53";
			rtCard.color = "red";
		}
		if ((face.equalsIgnoreCase("clover") || face.equalsIgnoreCase("diamond") || face.equalsIgnoreCase("heart") || face.equalsIgnoreCase("spade"))
				&& (rank >= 1 && rank <= 13)) {
			// 카드 맞네~ 만들어주자
			if (face.equalsIgnoreCase("clover")) {
				if (rank == 1) {
					rtCard.rankNum = 49;
				} else {
					rtCard.rankNum = (rank-2) * 4 + 1;
				}
			} else if (face.equalsIgnoreCase("diamond")) {
				if (rank == 1) {
					rtCard.rankNum = 50;
				} else {
					rtCard.rankNum = (rank-2) * 4 + 2;
				}
			} else if (face.equalsIgnoreCase("heart")) {
				if (rank == 1) {
					rtCard.rankNum = 51;
				} else {
					rtCard.rankNum = (rank-2) * 4 + 3;
				}
			} else {
				if (rank == 1) {
					rtCard.rankNum = 52;
				} else {
					rtCard.rankNum = (rank-2) * 4 + 4;
				}
			}
			rtCard.setSortNum(rtCard.rankNum);
			rtCard.setFace(rtCard.rankNum);
			rtCard.setRank(rtCard.rankNum);
			rtCard.setColor(rtCard.rankNum);
		} else {
			rtCard.delete();
		}
		return rtCard;
	}
	// 카드 체인지 card.chainge("spade", 4);
	public void changeCard(String face, int rank) {
		if (face.equalsIgnoreCase("joker")) {
			this.rankNum = 53;
			this.face = "joker(R)";
			this.rank = "53";
			this.color = "red";
			return;
		}
		if ((face.equalsIgnoreCase("clover") || face.equalsIgnoreCase("diamond") || face.equalsIgnoreCase("heart") || face.equalsIgnoreCase("spade"))
				&& (rank >= 1 && rank <= 13)) {
			// 카드 맞네~ 만들어주자
			if (face.equalsIgnoreCase("clover")) {
				if (rank == 1) {
					this.rankNum = 49;
				} else {
					this.rankNum = (rank-2) * 4 + 1;
				}
			} else if (face.equalsIgnoreCase("diamond")) {
				if (rank == 1) {
					this.rankNum = 50;
				} else {
					this.rankNum = (rank-2) * 4 + 2;
				}
			} else if (face.equalsIgnoreCase("heart")) {
				if (rank == 1) {
					this.rankNum = 51;
				} else {
					this.rankNum = (rank-2) * 4 + 3;
				}
			} else {
				if (rank == 1) {
					this.rankNum = 52;
				} else {
					this.rankNum = (rank-2) * 4 + 4;
				}
			}
			this.setSortNum(this.rankNum);
			this.setFace(this.rankNum);
			this.setRank(this.rankNum);
			this.setColor(this.rankNum);
		} else {
			this.delete();
		}
	}
	
	// 덱만들기 = 스테딕 메소드.
	public static Card[] deck() {
		Card[] deck = new Card[NEW_DECK_SIZE];
		for (int i = 0; i < deck.length; i++) {
			Card c = new Card();
			deck[i] = c;
			deck[i].rankNum = i+1;
			deck[i].setSortNum(i+1);
			deck[i].setFace(i+1);
			deck[i].setRank(i+1);
			deck[i].setColor(i+1);
		}
		Card[] sortDeck = new Card[NEW_DECK_SIZE];
		for (int i = 0; i < sortDeck.length; i++) {
			if (i == 0 || i == 13 || i == 26 || i == 39) {
				sortDeck[i] = deck[48 + (i % 4)];
			} else if (i <= 51) {
				sortDeck[i] = deck[(i / 13) + (4 * ((i%13) - 1))];
			} else {
				sortDeck[i] = deck[i];
			}
		}
		return sortDeck;
	}
	
	// 셔플덱 만들기
	public static Card[] shuffleDeck() {
		Card[] deck = new Card[NEW_DECK_SIZE];
		for (int i = 0; i < deck.length; i++) {
			Card c = new Card();
			deck[i] = c;
			deck[i].rankNum = i+1;
			deck[i].setSortNum(i+1);
			deck[i].setFace(i+1);
			deck[i].setRank(i+1);
			deck[i].setColor(i+1);
		}
		Collections.shuffle(Arrays.asList(deck));
		return deck;
	}
	// 덱 정렬해주기
	public static void sort(Card[] deck) {
		for (int i = 0; i < deck.length - 1; i++) {
			//선택정렬.
			int minIdx = i;
			for (int j = i; j < deck.length - 1; j++) {
				if (deck[minIdx].getSortNum() > deck[j+1].getSortNum()) {
					minIdx = j+1;
				}
			}
			if (i != minIdx) {
				Card temp = deck[minIdx];
				deck[minIdx] = deck[i];
				deck[i] = temp;
			}
		}
	}
	// 덱 셔플해주기
	public static void shuffle(Card[] deck) {
		Collections.shuffle(Arrays.asList(deck));
	}
	// 덱을주면 그 덱 내용에서 카드 한장뽑기     return Card
	
	// 덱을주고 그 덱 내용에서 카드 여러장 뽑기 return Card[]
	

	@Override
	public String toString() {
		String f = "";
		if (face.equals("clover")) {
			f += (char)9827;
		} else if (face.equals("diamond")) {
			f += (char)9826;
		} else if (face.equals("heart")) {
			f += (char)9825;
		} else if (face.equals("spade")) {
			f += (char)9824;
		} else if (face.equals("joker(R)")) {
			return "[JOKER(R)]";
		} else if (face.equals("joker(B)")) {
			return "[JOKER(B)]";
		} else {
			return "[NoCard]";
		}
		return "[" + f + " " + rank + "]";
	}
	
	
}
