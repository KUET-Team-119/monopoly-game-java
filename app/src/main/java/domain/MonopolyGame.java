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
import domain.component.Cup;
import domain.component.card.Card;
import domain.component.card.SocialFundCardFactory;
import domain.component.card.SocialFundCardType;
import domain.player.Player;

public class MonopolyGame {
    private static final int ROUNDS_TOTAL = 20;

    Scanner scanner;
    String id;
    static List<Player> players; // TODO 다른 사람들에게 돈 받는 사회기금 카드 로직 때문에 임시로 public static으로 지정
    Cup cup;
    Board board;
    public static Queue<Card> chanceCardDeck;
    public static Queue<Card> socialFundCardDeck;

    public MonopolyGame(Scanner scanner, String id) {
        this.scanner = scanner;
        this.id = id;
        players = new ArrayList<Player>();
        cup = Cup.getInstance();
        board = new Board();
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
        // TO-DO 찬스카드, 사회기업카드 shuffle
        // 카드 모음은 큐로 구현
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
            players.add(new Player(i));
        }
    }

    private void buildDeck(ChanceCardType[] values) {
        for (ChanceCardType type : values) {
            chanceCardDeck.add(ChanceCardFactory.createSquare(type));
        }
    }

    private void buildDeck(SocialFundCardType[] values) {
        for (SocialFundCardType type : values) {
            chanceCardDeck.add(SocialFundCardFactory.createSquare(type));
        }
    }

    private void shuffleDeck(Queue<Card> card) {
        Collections.shuffle((LinkedList<Card>) card);
    }

    public static List<Player> getPlayers() {
        return players;
    }
}