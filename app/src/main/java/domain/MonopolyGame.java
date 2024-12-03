package domain;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import domain.component.Board;
import domain.player.Player;

public class MonopolyGame {

    private final int ROUNDS_TOTAL = 20;

    private Scanner scanner;
    @SuppressWarnings("unused")
    private String id;
    @SuppressWarnings("unused")
    private Board board;
    private static Map<String, Player> players;
    private static Queue<Player> bankruptPlayers;

    public MonopolyGame(Scanner scanner, String id) {
        this.scanner = scanner;
        this.id = id;
        this.board = new Board();
        players = new HashMap<String, Player>();
        bankruptPlayers = new LinkedList<Player>();
    }

    public void initialize() {
        int numOfPlayer = enterNumOfPlayer();
        generatePlayer(numOfPlayer);
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

    public static Map<String, Player> getPlayers() {
        return players;
    }

    public static void handleBankruptPlayer(Player player) {
        bankruptPlayers.add(player); // 파산한 플레이어를 bankruptPlayers에 추가
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
        List<Player> survivedPlayersRank = rankSurvivingPlayersByAssets();
        List<Player> bankruptedPlayersRank = rankBankruptPlayersBySurvivalTime();

        announceWinner(combinePlayerRank(survivedPlayersRank, bankruptedPlayersRank));
    }

    private List<Player> rankSurvivingPlayersByAssets() {
        List<Player> survivedPlayersRank = new ArrayList<>();
        
        PriorityQueue<Player> rankedSurvivingPlayers = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.getCashManager().calculateTotalAssets(),
                                        p1.getCashManager().calculateTotalAssets()));
                                        
        players.values().stream()
            .filter(p -> !p.getStateManager().isBankruptState())
            .forEach(rankedSurvivingPlayers::offer);
        
        while (!rankedSurvivingPlayers.isEmpty()) {
            Player player = rankedSurvivingPlayers.poll();
            survivedPlayersRank.add(player);
        }

        return survivedPlayersRank;
    }

    private List<Player> rankBankruptPlayersBySurvivalTime() {
        List<Player> bankruptPlayersRank = new ArrayList<>();

        while (!bankruptPlayers.isEmpty()) {
            Player bankruptPlayer = bankruptPlayers.remove();
            bankruptPlayersRank.add(bankruptPlayer);
        }

        return bankruptPlayersRank;
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
}