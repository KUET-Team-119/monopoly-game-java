package domain.square;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MonopolyGame {
    private static final int ROUNDS_TOTAL = 20;

    Scanner scanner;
    String id;
    List<Player> players;
    List<Die> dice;
    Board board;

    public MonopolyGame(Scanner scanner, String id) {
        this.scanner = scanner;
        this.id = id;
        players = new ArrayList<Player>();
        dice = new ArrayList<Die>();
        board = new Board();

        dice.add(new Die("1"));
        dice.add(new Die("2"));
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
            player.takeTurn(dice);
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

    public List<Player> getPlayers() {
        return players;
    }
}