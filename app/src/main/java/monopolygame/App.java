package monopolygame;

import domain.MonopolyGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner scanner;
    private List<MonopolyGame> monopolyGames; // 게임 기록 저장소
    private MonopolyGame currentGame; // 새로 플레이하는 게임 또는 리플레이를 보는 게임

    public App() {
        scanner = new Scanner(System.in);
        monopolyGames = new ArrayList<MonopolyGame>();
    }

    public void startNewGame() {
        System.out.println("새로운 게임을 시작합니다.");
        currentGame = new MonopolyGame(scanner, "1");
        monopolyGames.add(currentGame);

        currentGame.initialize();
    }

    public void exit() {
        scanner.close();
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("안녕하세요. 모노폴리 게임 시뮬레이터입니다.");
        app.startNewGame();
        app.exit();
    }
}