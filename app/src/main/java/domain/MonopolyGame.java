package domain;

import java.util.List;
import java.util.Scanner;

import domain.component.Board;
import domain.component.Cup;
import domain.player.Player;

import java.util.ArrayList;

public class MonopolyGame {
    private static final int ROUNDS_TOTAL = 20;

    Scanner scanner;
    String id;
    static List<Player> players;
    Cup cup;
    Board board;

    public MonopolyGame(Scanner scanner, String id) {
        this.scanner = scanner;
        this.id = id;
        players = new ArrayList<Player>();
        cup = Cup.getInstance();
        board = new Board();
    }

    public void initialize() {
        int numOfPlayer = enterNumOfPlayer();
        generatePlayer(numOfPlayer);
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
            players.add(new Player(Integer.toString(i)));
        }
    }

    public static List<Player> getPlayers() {
        return players;
    }
}