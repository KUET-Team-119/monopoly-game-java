package domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MonopolyGame {
    private static final int ROUNDS_TOTAL = 20;
    private List players;
    private Board board = new Board();

    public MonopolyGame() {
        Player player;
        player = new Player("Horse", board);
        players.add(player);
        player = new Player("Car", board);
        players.add(player);
    }

    public void initialize(int numOfPlayers) {
        if (numOfPlayers < 2 || numOfPlayers > 8) {
            throw new IllegalArgumentException("경기자 수는 2명 이상 8명 이하여야 합니다.");
        }
        players = new ArrayList(numOfPlayers);
        playGame();
    }

    public void playGame() {
        for (int i = 0; i < ROUNDS_TOTAL; i++) {
            playRound();
        }
    }

    public List getPlayers() {
        return players;
    }

    private void playRound() {
        for (Object object : players) {
            Player player = (Player) object;
            player.takeTurn();
        }
    }
}
