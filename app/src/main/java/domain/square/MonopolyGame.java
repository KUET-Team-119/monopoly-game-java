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
        int numOfPlayers = 0;
        while (true) {
            System.out.print("플레이어 수를 입력하세요: ");
            numOfPlayers = scanner.nextInt();

            if (numOfPlayers >= 2 && numOfPlayers <= 8) {
                break;
            } else {
                System.out.println("플레이어 수는 2명 이상, 8명 이하여야 합니다.");
            }
        }
        players = new ArrayList<Player>(numOfPlayers);

        for (int i = 0; i < numOfPlayers; i++) {
            // TODO 임시로 플레이어의 이름을 숫자로 사용
            players.add(new Player(Integer.toString(i)));
        }

        playGame();
    }

    private void playGame() {
        System.out.println("게임 시작!");
        for (int i = 1; i <= ROUNDS_TOTAL; i++) {
            if (i == ROUNDS_TOTAL) {
                System.out.println("마지막 라운드를 진행합니다.");    
            } else {
                System.out.println("제" + i + "라운드를 진행합니다.");
            }
            playRound();
        }
    }

    private void playRound() {
        for (Player player : players) {
            player.takeTurn(dice);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}