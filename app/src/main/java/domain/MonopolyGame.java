package domain;

import domain.component.card.ChanceCardFactory;
import domain.component.card.ChanceCardType;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.HashMap;
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
    private static Map<String, Player> players;
    private static Map<String, Player> bankruptPlayers;
    public static Queue<Card> chanceCardDeck;
    public static Queue<Card> socialFundCardDeck;

    public MonopolyGame(Scanner scanner, String id) {
        this.scanner = scanner;
        this.id = id;
        board = new Board();
        players = new HashMap<>();
        bankruptPlayers = new HashMap<>();
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
            try {
                playRound();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        finishGame();
    }

    private void printRoundNumber(int number) {
        if (number == ROUNDS_TOTAL) {
            System.out.println("마지막 라운드를 진행합니다.");
            return;
        }
        System.out.println("제" + number + "라운드를 진행합니다.");
    }

    private void playRound() {
        for (Player player : players.values()) {
            if (player.getStateManager().isBankruptState()) {
                continue;
            }
            player.takeTurn();
            checkRemainingPlayers();
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
            String playerId = Integer.toString(i);
            players.put(playerId, new Player(playerId));
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

    public static Map<String, Player> getPlayers() {
        return players;
    }

    public static void handleBankruptPlayer(Player player) {
        String playerId = player.getId();
        bankruptPlayers.put(playerId, player); // 파산한 플레이어를 bankruptPlayers에 추가
    }

    private void checkRemainingPlayers() {
        if (bankruptPlayers.size() == players.size() - 1) {
            throw new RuntimeException("플레이어가 한 명 남았습니다.");
        }
    }

    private void finishGame() {
        System.out.println("게임이 종료되었습니다.");
        rankPlayers();
    }

    private void rankPlayers() {
        rankSurvivingPlayersByAssets();
        rankBankruptPlayersBySurvivalTime();
    }

    private void rankSurvivingPlayersByAssets() {
        PriorityQueue<Player> rankedSurvivingPlayers = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.getCashManager().calculateTotalAssets(),
                                        p1.getCashManager().calculateTotalAssets()));
                                        
        players.values().stream()
            .filter(p -> !p.getStateManager().isBankruptState())
            .forEach(rankedSurvivingPlayers::offer);
        
        int rank = 1;
        while (!rankedSurvivingPlayers.isEmpty()) {
            Player player = rankedSurvivingPlayers.poll();
            System.out.println(rank++ + "등: " + player.getId() + " (총자산: " + player.getCashManager().getCash() + ")");
        }
    }

    private void rankBankruptPlayersBySurvivalTime() {
        
    }

}