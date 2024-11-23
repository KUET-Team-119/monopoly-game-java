package domain;

import domain.component.card.ChanceCardFactory;
import domain.component.card.ChanceCardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
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
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
    public static Iterator<Player> iterator;

    public MonopolyGame(Scanner scanner, String id) {
        this.scanner = scanner;
        this.id = id;
        board = new Board();
        players = new HashMap<>();
        bankruptPlayers = new HashMap<>();
        chanceCardDeck = new LinkedList<Card>();
        socialFundCardDeck = new LinkedList<Card>();
        iterator = null;
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

        finalizeGame();
    }

    private void finalizeGame() {
        List<Player> survivedPlayersRank = determineSurvivedPlayersRank();
        List<Player> bankruptedPlayersRank = determineBankruptedPlayersRank();

        announceWinner(combinePlayerRank(survivedPlayersRank, bankruptedPlayersRank));
    }

    private List<Player> determineBankruptedPlayersRank() {
        List<Player> bankruptRank = new ArrayList<>(
                bankruptPlayers.values().stream().toList()
        );
        Collections.reverse(bankruptRank);

        return bankruptRank;
    }

    private List<Player> determineSurvivedPlayersRank() {
        return players.values()
                .stream()
                .peek(player -> player.getCashManager().reduceCash(Integer.MAX_VALUE))
                .sorted(Comparator.comparingInt(
                        (Player player) -> player.getCashManager().getCash())
                        .reversed()
                )
                .toList();
    }

    private List<Player> combinePlayerRank(List<Player> survivedPlayersRank, List<Player> bankruptedPlayersRank) {
        return Stream.of(survivedPlayersRank, bankruptedPlayersRank)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private void announceWinner(List<Player> rank) {
        System.out.println("순위를 공개합니다");
        List<String> finalRank = rank.stream().map(Player::getId).toList();
        IntStream.range(0, finalRank.size())
                .forEach(i -> System.out.println((i+1) + "등 : 플레이어 " + finalRank.get(i)));
    }

    private void printRoundNumber(int number) {
        if (number == ROUNDS_TOTAL) {
            System.out.println("마지막 라운드를 진행합니다.");
            return;
        }
        System.out.println("제" + number + " 라운드를 진행합니다.");
    }

    private void playRound() {
        iterator = players.values().iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            player.takeTurn();
            if (players.size() == 1) {
                break;
            }
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
        players.remove(playerId); // id로 플레이어 제거
        bankruptPlayers.put(playerId, player); // 파산한 플레이어를 bankruptPlayers에 추가
        iterator.remove();
    }
}