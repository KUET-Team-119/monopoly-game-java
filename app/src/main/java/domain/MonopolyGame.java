package domain;

import domain.component.card.ChanceCardFactory;
import domain.component.card.ChanceCardType;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

import domain.component.Board;
import domain.component.card.Card;
import domain.component.card.SocialFundCardFactory;
import domain.component.card.SocialFundCardType;
import domain.player.Player;

public class MonopolyGame {
    private final int ROUNDS_TOTAL = 20;

    private Scanner scanner;
    @SuppressWarnings("unused")
    private String id;
    @SuppressWarnings("unused")
    private Board board;
    private static List<Player> players;
    public static Queue<Card> chanceCardDeck;
    public static Queue<Card> socialFundCardDeck;

    public MonopolyGame(Scanner scanner, String id) {
        this.scanner = scanner;
        this.id = id;
        board = new Board();
        players = new ArrayList<Player>();
        chanceCardDeck = new LinkedList<Card>();
        socialFundCardDeck = new LinkedList<Card>();
    }

    public void initialize() {
        int numOfPlayer = enterNumOfPlayer();
        generatePlayer(numOfPlayer);
        buildDeck(ChanceCardType.values());
        buildDeck(SocialFundCardType.values());
        shuffleDeck(chanceCardDeck);
        shuffleDeck(socialFundCardDeck);
        playGame();
    }

    private void playGame() {
        System.out.println("게임 시작!");
        for (int i = 1; i <= ROUNDS_TOTAL; i++) {
            printRoundNumber(i);
            playRound();
        }
    }

    private void printRoundNumber(int number) {
        if (number == ROUNDS_TOTAL) {
            System.out.println("마지막 라운드를 진행합니다.");
            return;
        }
        System.out.println("제" + number + "라운드를 진행합니다.");
    }

    private void playRound() {
        for (Player player : players) {
            player.takeTurn();
        }
    }

    private int enterNumOfPlayer() {
        while (true) {
            System.out.print("플레이어 수를 입력하세요: ");
            int numOfPlayer = scanner.nextInt();
            if (numOfPlayer >= 2 && numOfPlayer <= 8) {
                return numOfPlayer;
            } else {
                System.out.println("플레이어 수는 2명 이상, 8명 이하여야 합니다.");
            }
        }
    }

    private void generatePlayer(int numOfPlayer) {
        for (int i = 0; i < numOfPlayer; i++) {
            players.add(new Player(Integer.toString(i)));
        }
    }

    private void buildDeck(ChanceCardType[] values) {
        for (ChanceCardType type : values) {
            chanceCardDeck.add(ChanceCardFactory.createChanceCards(type));
        }
    }

    private void buildDeck(SocialFundCardType[] values) {
        for (SocialFundCardType type : values) {
            socialFundCardDeck.add(SocialFundCardFactory.createSocialFundCards(type));
        }
    }

    private void shuffleDeck(Queue<Card> card) {
        Collections.shuffle((LinkedList<Card>) card);
    }

    public static List<Player> getPlayers() {
        return players;
    }
}