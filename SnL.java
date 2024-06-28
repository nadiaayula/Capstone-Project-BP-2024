/**
 * -----------------------------------------------------
 * ES234211 - Programming Fundamental
 * Genap - 2023/2024
 * Group Capstone Project: Snake and Ladder Game
 * -----------------------------------------------------
 * Class    : D
 * Group    : 12
 * Members  :
 * 1. 5026231197 - Imtiyaz Shafhal Afif
 * 2. 5026231090 - Nadia Ayula Assyaputri
 * 3. 5026221192 - Mirna Irawan
 * ------------------------------------------------------
 */

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SnL {
    private ArrayList<Player> players;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    public int boardSize;
    public int gameStatus;
    private int nowPlaying;
    private boolean rolledSix;

    public SnL(int boardSize) {
        this.boardSize = boardSize;
        this.players = new ArrayList<>();
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        this.gameStatus = 0;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getGameStatus() {
        return this.gameStatus;
    }

    public void play(String[] namaPemain, int[][] posisiSnake, int[][] posisiLadder) {
        for (String namaPemain1 : namaPemain) {
            Player player = new Player(namaPemain1);
            addPlayer(player);
        }

        for (int[] snake : posisiSnake) {
            addSnake(new Snake(snake[0], snake[1]));
        }

        // Add ladders
        for (int[] ladder : posisiLadder) {
            addLadder(new Ladder(ladder[0], ladder[1]));
        }
    }
    public void playying() {
        Player playerInTurn = getWhoseTurn();
        int x = playerInTurn.rollDice();
        rolledSix = (x == 6);
        movePlayerAround(playerInTurn, x);
        if(rolledSix) {
            GUI.logLabel2.setText("Player: "+ playerInTurn.getName());
            GUI.logLabel5.setText("Dice Roll: "+x);
            GUI.logLabel6.setText("New Position: "+playerInTurn.getPosition());
            GUI.logLabel11.setText(playerInTurn.getName() + " gets another roll for rolling a 6!");
            displayBoard();
            Player nextPlayer = this.players.get((this.nowPlaying) % this.players.size());
            GUI.logLabel2.setText(nextPlayer.getName());
        } else {
            GUI.logLabel2.setText("Player: " + playerInTurn.getName());
            GUI.logLabel5.setText("Dice Roll: "+x);
            GUI.logLabel6.setText("New Position: "+playerInTurn.getPosition());
            GUI.logLabel11.setText("");
            displayBoard();
            Player nextPlayer = this.players.get((this.nowPlaying + 1) % this.players.size());
            GUI.logLabel2.setText(nextPlayer.getName());
        }

        if (playerInTurn.getPosition() == boardSize) {
            gameStatus = 2;
            GUI.logLabel11.setText("Winner " + playerInTurn.getName());
            try {
                File winSound = new File("winning_sound.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(winSound);
                Clip win = AudioSystem.getClip();
                win.open(audioInputStream);
                win.start();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                JOptionPane.showMessageDialog(null, "Error loading audio file: " + d.getMessage(), "Audio Error", JOptionPane.ERROR_MESSAGE);
            }
            String [] response = {"Exit","Play Again"};
            ImageIcon icon = new ImageIcon(new ImageIcon("trophy-icon.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
            int n = JOptionPane.showOptionDialog(null,"Winner " + playerInTurn.getName(), "Winner", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon, response, 0);
            GUI.buttonD.setEnabled(false);
            if (n == JOptionPane.NO_OPTION) {
                resetGame();
                GUI.buttonD.setEnabled(true);
            }
        }

    }
    public void addPlayer(Player s) {
        this.players.add(s);
    }
    public void addSnake(Snake s) {
        this.snakes.put(s.getHeadPosition(), s.getTailPosition());
    }
    public void addLadder(Ladder l) {
        this.ladders.put(l.getBottomPosition(), l.getTopPosition());
    }
    public Player getWhoseTurn() {
        if (this.gameStatus == 0) {
            this.gameStatus = 1;
            this.nowPlaying = (int) (Math.random() * this.players.size());
            return this.players.get(this.nowPlaying);
        }
        if(rolledSix){
            this.nowPlaying = (this.nowPlaying) % this.players.size();
            return this.players.get(this.nowPlaying);
        }
        else {
            this.nowPlaying = (this.nowPlaying + 1) % this.players.size();
            return this.players.get(this.nowPlaying);
        }
    }
    public void movePlayerAround(Player p, int x) {
        p.moveAround(x, this.boardSize);
        if (ladders.containsKey(p.getPosition())) {
            GUI.logLabel11.setText(p.getName() + " mendapat tangga dari: " + p.getPosition() + " ke: " + ladders.get(p.getPosition()));
            p.setPosition(ladders.get(p.getPosition()));
        }
        if (snakes.containsKey(p.getPosition())) {
            GUI.logLabel11.setText(p.getName() + " terkena ular dari " + p.getPosition() + " turun ke " + snakes.get(p.getPosition()));
            p.setPosition(snakes.get(p.getPosition()));
        }
        if (p.getPosition() == this.boardSize) {
            this.gameStatus = 2;
        }
    }
    public void displayBoard() {
        String htmlText = "<html>";
        for (Player p : this.players) {
            htmlText += p.getName() + " is at position " + p.getPosition() + "<br>";
        }
        htmlText += "        </html>";
        GUI.logLabel9.setText(htmlText);
    }
    public void resetGame() {
        for (Player p : this.players) {
            p.setPosition(0);
        }
        this.gameStatus = 0;
    }
}