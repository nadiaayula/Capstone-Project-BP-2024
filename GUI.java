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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.*;
import javax.swing.*;

public class GUI extends JFrame  implements ActionListener {
    public static SnL g1;
    private JButton buttonS;
    private JButton buttonSS;
    private JButton buttonP;
    public static JButton buttonD;
    private CardLayout page;
    private JPanel mainmenu;
    private JComboBox bSize;
    private JLabel label;
    private JLabel boardL;
    private JLabel playerN;
    private JLabel snakef;
    private JLabel ladderf;
    private JComboBox ladder;
    private JComboBox snake;
    private JLabel kel;
    private JComboBox player;
    private JPanel panelNama;
    private JPanel panelSnake;
    private JPanel panelLadder;
    private JButton soundOnIcon;
    private JButton soundOffIcon;
    private List<JTextField> kotakNama;
    private List<JTextField> kotakSnake;
    private List<JTextField> kotakLadder;
    private String[] namaPemain;
    private static JPanel playerPanel;
    private static JLabel logLabel1;
    public static JLabel logLabel2;
    private static JLabel logLabel3;
    public static JLabel logLabel4;
    public static JLabel logLabel5;
    public static JLabel logLabel6;
    public static JLabel logLabel7;
    public static JLabel logLabel8;
    public static JLabel logLabel9;
    public static JLabel logLabel10;
    public static JLabel logLabel11;
    public static JLabel logLabel12;
    public static JLabel logLabel13;
    public static JLabel logLabel14;

    private AudioInputStream audioInputStream;
    private Clip clip;

    GUI (){
        kotakNama = new ArrayList<>();
        page = new CardLayout();
        mainmenu = new JPanel(page);
        JPanel menu1 = buatMenu1();
        JPanel menu2 = buatMenu2();
        JPanel menu3 = buatMenu3();
        JPanel menu4 = buatMenu4();

        try {
            // Load audio file
            File file = new File("SnL_Song.wav");
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, "Error loading audio file: " + e.getMessage(), "Audio Error", JOptionPane.ERROR_MESSAGE);
        }

        mainmenu.add(menu1, "mainmenu");
        mainmenu.add(menu2, "menu 2");
        mainmenu.add(menu3, "menu 3");
        mainmenu.add(menu4, "menu 4");

        this.setTitle("Snake and Ladder Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500,500);
        this.setResizable(false);
        //this.pack();
        this.setLayout(new BorderLayout());
        this.add(mainmenu, BorderLayout.CENTER);
        this.pack();


        ImageIcon logo = new ImageIcon("Logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(255,255,255));
        this.setLocationRelativeTo(null);
        this.setBackground(Color.decode("#f08080"));
    }

    JPanel buatMenu1() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBackground(Color.decode("#FFCC99"));
        JPanel panel1_1 = new JPanel();
        panel1_1.setLayout(new BoxLayout(panel1_1,BoxLayout.Y_AXIS));
        JPanel panel1_1_1 = new JPanel();
        JPanel panel1_1_2 = new JPanel(new GridLayout(1,2)); // sound on off
        JPanel panel1_2 = new JPanel();
        JPanel panel1_3 = new JPanel();
        JPanel panel1_2_1 = new JPanel();

        panel1_1.setBackground(Color.decode("#FFCC99"));
        panel1_1_1.setBackground(Color.decode("#DAD8C9"));
        panel1_2.setBackground(Color.decode("#FFCC99"));
        panel1_3.setBackground(Color.decode("#FFCC99"));
        panel1_2_1.setBackground(Color.decode("#FFCC99"));

        panel1_1.setPreferredSize(new Dimension(500,100));
        panel1_2_1.setLayout(new BoxLayout(panel1_2_1, BoxLayout.Y_AXIS));
        panel1_3.setPreferredSize(new Dimension(500,50));

        ImageIcon icon1 = new ImageIcon(new ImageIcon("board.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon icon2 = new ImageIcon(new ImageIcon("snake.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon icon3 = new ImageIcon(new ImageIcon("ladder.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon icon4 = new ImageIcon(new ImageIcon("players.png").getImage().getScaledInstance(15, 20, Image.SCALE_SMOOTH));
        ImageIcon iconOn = new ImageIcon(new ImageIcon("sound_on.png").getImage().getScaledInstance(15, 20, Image.SCALE_SMOOTH));
        ImageIcon iconOff = new ImageIcon(new ImageIcon("sound_off.png").getImage().getScaledInstance(15, 20, Image.SCALE_SMOOTH));
        soundOnIcon = new JButton(iconOn);
        soundOnIcon.setFocusable(false);
        soundOffIcon = new JButton(iconOff);
        soundOffIcon.setFocusable(false);
        soundOnIcon.addActionListener(this);
        soundOffIcon.addActionListener(this);


        buttonS = new JButton("Set");
        buttonS.setFocusable(false);
        buttonS.setPreferredSize(new Dimension(300,40));
        buttonS.addActionListener(this);

        String[] boardSizes = {"5x5", "8x8", "10x10"};
        bSize = new JComboBox<>(boardSizes);
        bSize.setPreferredSize(new Dimension(200, 40));
        bSize.setFont(new Font("Arial", Font.PLAIN, 15));

        String[] amountP = {"1","2","3"};
        player = new JComboBox(amountP);
        player.setPreferredSize(new Dimension(200,40));
        player.setFont(new Font("Arial",Font.PLAIN,15));

        String[] amountS = {"1","2","3","4","5","6","7","8"};
        snake = new JComboBox(amountS);
        snake.setPreferredSize(new Dimension(200,40));
        snake.setFont(new Font("Arial",Font.PLAIN,15));

        String[] amountL = {"1","2","3","4","5","6","7","8"};
        ladder = new JComboBox(amountL);
        ladder.setPreferredSize(new Dimension(200,40));
        ladder.setFont(new Font("Arial",Font.PLAIN,15));

        label = new JLabel();
        label.setText("Snake and Ladder Game");
        label.setForeground(Color.decode("#006400"));
        label.setFont(new Font("MV Boli", Font.PLAIN,30));

        playerN = new JLabel(icon4);
        playerN.setText("Amount of Players");
        playerN.setForeground(Color.BLACK);
        playerN.setFont(new Font("MV Boli", Font.PLAIN,15));
        playerN.setAlignmentX(Component.CENTER_ALIGNMENT);

        boardL = new JLabel(icon1);
        boardL.setText("Board Size");
        boardL.setForeground(Color.BLACK);
        boardL.setFont(new Font("MV Boli", Font.PLAIN,15));
        boardL.setAlignmentX(Component.CENTER_ALIGNMENT);

        snakef = new JLabel(icon2);
        snakef.setText("Amount of Snakes");
        snakef.setForeground(Color.BLACK);
        snakef.setFont(new Font("MV Boli", Font.PLAIN,15));
        snakef.setAlignmentX(Component.CENTER_ALIGNMENT);

        ladderf = new JLabel(icon3);
        ladderf.setText("Amount of Ladders");
        ladderf.setForeground(Color.BLACK);
        ladderf.setFont(new Font("MV Boli", Font.PLAIN,15));
        ladderf.setAlignmentX(Component.CENTER_ALIGNMENT);


        panel1_1.add(panel1_1_1);
        panel1_1_1.add(label);
        panel1_1.add(panel1_1_2);
        panel1_1_2.add(soundOnIcon);
        panel1_1_2.add(soundOffIcon);
        panel1_3.add(buttonS);
        panel1_2_1.add(boardL);
        panel1_2_1.add(bSize);
        panel1_2_1.add(playerN);
        panel1_2_1.add(player);
        panel1_2_1.add(ladderf);
        panel1_2_1.add(ladder);
        panel1_2_1.add(snakef);
        panel1_2_1.add(snake);

        panel1_2.add(panel1_2_1, BorderLayout.CENTER);
        panel1.add(panel1_1, BorderLayout.NORTH);
        panel1.add(panel1_2, BorderLayout.CENTER);
        panel1.add(panel1_3, BorderLayout.SOUTH);

        this.setBackground(Color.decode("#f08080"));
        return panel1;
    }

    JPanel buatMenu2() {
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.decode("#FFCC99"));
        JPanel panel2_1 = new JPanel();
        JPanel panel2_2 = new JPanel();
        JPanel panel2_3 = new JPanel();

        panel2_1.setBackground(Color.decode("#FFCC99"));
        panel2_2.setBackground(Color.decode("#FFCC99"));
        panel2_3.setBackground(Color.decode("#FFCC99"));
        panel2_1.setPreferredSize(new Dimension(500,100));
        panel2_3.setPreferredSize(new Dimension(500,50));


        buttonSS = new JButton("Set");
        buttonSS.setFocusable(false);
        buttonSS.addActionListener(this);
        buttonSS.setPreferredSize(new Dimension(300,40));

        panelNama = new JPanel();
        panelNama.setLayout(new BoxLayout(panelNama, BoxLayout.Y_AXIS));
        panelNama.setBackground(Color.decode("#f4978e"));

        JLabel insert = new JLabel();
        insert.setText("Insert Players Name");
        insert.setFont(new Font("Arial",Font.PLAIN,30));
        insert.setForeground(Color.BLACK);

        panel2.add(panel2_1, BorderLayout.NORTH);
        panel2.add(panel2_2, BorderLayout.CENTER);
        panel2.add(panel2_3, BorderLayout.SOUTH);

        panel2_1.add(insert);
        panel2_2.add(panelNama);
        panel2_3.add(buttonSS);

        return panel2;
    }

    JPanel buatMenu3() {
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.setBackground(Color.decode("#FFCC99"));
        JPanel panel3_1 = new JPanel();
        JPanel panel3_2 = new JPanel();
        JPanel panel3_3 = new JPanel();
        JPanel panel3_1_1 = new JPanel();
        JPanel panel3_1_2 = new JPanel();

        panel3_1.setBackground(Color.decode("#FFCC99"));
        panel3_2.setBackground(Color.decode("#FFCC99"));
        panel3_3.setBackground(Color.decode("#FFCC99"));
        panel3_1_1.setBackground(Color.decode("#FFCC99"));
        panel3_1_2.setBackground(Color.decode("#FFCC99"));

        panel3_1.setPreferredSize(new Dimension(500,50));
        panel3_2.setLayout(new BorderLayout());


        buttonP = new JButton("Play");
        buttonP.setFocusable(false);
        buttonP.addActionListener(this);
        buttonP.setPreferredSize(new Dimension(300,40));

        panelSnake = new JPanel();
        panelSnake.setLayout(new BoxLayout(panelSnake, BoxLayout.Y_AXIS));
        panelSnake.setBackground(Color.decode("#FFCC99"));

        panelLadder = new JPanel();
        panelLadder.setLayout(new BoxLayout(panelLadder, BoxLayout.Y_AXIS));
        panelLadder.setBackground(Color.decode("#FFCC99"));

        JScrollPane scrollPaneSnake = new JScrollPane(panelSnake);
        scrollPaneSnake.setBackground(Color.decode("#FFCC99"));

        JScrollPane scrollPaneLadder = new JScrollPane(panelLadder);
        scrollPaneLadder.setBackground(Color.decode("#FFCC99"));

        JLabel insert1 = new JLabel();
        insert1.setText("Insert Ladder Position");
        insert1.setFont(new Font("Arial",Font.PLAIN,20));
        insert1.setForeground(Color.BLACK);

        JLabel insert2 = new JLabel();
        insert2.setText("Insert Snake Position");
        insert2.setFont(new Font("Arial",Font.PLAIN,20));
        insert2.setForeground(Color.BLACK);

        panel3.add(panel3_1, BorderLayout.NORTH);
        panel3.add(panel3_2, BorderLayout.CENTER);
        panel3.add(panel3_3, BorderLayout.SOUTH);

        panel3_1.setLayout(new GridLayout(1,2));
        panel3_1.add(panel3_1_1);
        panel3_1.add(panel3_1_2);

        panel3_1_1.add(insert1);
        panel3_1_2.add(insert2);

        panel3_2.setLayout(new GridLayout(1, 2));
        panel3_2.add(scrollPaneLadder);
        panel3_2.add(scrollPaneSnake);

        panel3_3.add(buttonP);

        return panel3;
    }

    JPanel buatMenu4() {
        JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBackground(Color.decode("#FFCC99"));

        JPanel panel4_1 = new JPanel();
        JPanel panel4_2 = new JPanel(new BorderLayout());
        JPanel panel4_3 = new JPanel();

        panel4_1.setBackground(Color.decode("#FFCC99"));
        panel4_2.setBackground(Color.decode("#FFCC99"));
        panel4_3.setBackground(Color.decode("#FFCC99"));
        panel4_3.setLayout(new BoxLayout(panel4_3, BoxLayout.Y_AXIS));

        playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        playerPanel.setBackground(Color.decode("#FFCC99"));

        ImageIcon icon6 = new ImageIcon(new ImageIcon("dice.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        logLabel1 = new JLabel();
        logLabel2 = new JLabel();
        logLabel3 = new JLabel();
        logLabel4 = new JLabel();
        logLabel5 = new JLabel();
        logLabel6 = new JLabel();
        logLabel7 = new JLabel();
        logLabel8 = new JLabel();
        logLabel9 = new JLabel();
        logLabel10 = new JLabel();
        logLabel11 = new JLabel();
        logLabel12 = new JLabel();
        logLabel13 = new JLabel();
        logLabel14 = new JLabel();

        logLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel4.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel5.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel6.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel7.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel8.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel9.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel10.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel11.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel12.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel13.setAlignmentX(Component.CENTER_ALIGNMENT);
        logLabel14.setAlignmentX(Component.CENTER_ALIGNMENT);


        logLabel1.setFont(new Font("Arial",Font.BOLD,18));
        logLabel2.setFont(new Font("Arial",Font.PLAIN,18));
        logLabel3.setFont(new Font("Arial",Font.PLAIN,18));
        logLabel4.setFont(new Font("Arial",Font.PLAIN,18));
        logLabel5.setFont(new Font("Arial",Font.PLAIN,18));
        logLabel6.setFont(new Font("Arial",Font.PLAIN,18));
        logLabel7.setFont(new Font("Arial",Font.PLAIN,18));
        logLabel8.setFont(new Font("Arial",Font.PLAIN,18));
        logLabel9.setFont(new Font("Arial",Font.PLAIN,18));
        logLabel10.setFont(new Font("Arial",Font.PLAIN,18));
        logLabel11.setFont(new Font("Arial",Font.PLAIN,18));


        logLabel1.setText("Let's see where the dice take you!");
        logLabel14.setText("  ");
        logLabel2.setText("Who's first?");
        logLabel3.setText("Click the button to Roll the Dice");
        logLabel4.setText("--------------------------------------------");
        logLabel5.setText("Dice Roll: ");
        logLabel6.setText("New Position: ");
        logLabel7.setText("--------------------------------------------");
        logLabel8.setText("Board Status: ");
        logLabel9.setText("--------------------------------------------");
        logLabel12.setText("  ");
        logLabel10.setText("--------------------------------------------");


        buttonD = new JButton(icon6);
        buttonD.setFocusable(false);
        buttonD.setText("Roll The Dice");
        buttonD.addActionListener(this);

        panel4_1.setLayout(new BoxLayout(panel4_1, BoxLayout.Y_AXIS));
        panel4_1.setPreferredSize(new Dimension(150, 250));
        panel4_1.setBackground(Color.decode("#FFCC99"));

        panel4_3.setBackground(Color.decode("#fbc4ab"));
        panel4_3.add(logLabel1);
        panel4_3.add(logLabel14);
        panel4_3.add(logLabel2);
        panel4_3.add(logLabel3);
        panel4_3.add(logLabel4);
        panel4_3.add(logLabel5);
        panel4_3.add(logLabel6);
        panel4_3.add(logLabel7);
        panel4_3.add(logLabel8);
        panel4_3.add(logLabel9);
        panel4_3.add(logLabel12);
        panel4_3.add(logLabel10);
        panel4_3.add(logLabel11);

        panel4_1.add(playerPanel);


        panel4_2.setBackground(Color.decode("#fbc4ab"));
        panel4_2.setPreferredSize(new Dimension(350, 50));
        panel4_2.add(buttonD, BorderLayout.CENTER);

        panel4.add(panel4_1, BorderLayout.WEST);
        panel4.add(panel4_3, BorderLayout.CENTER);
        panel4.add(panel4_2, BorderLayout.SOUTH);

        return panel4;
    }



    public void actionPerformed(ActionEvent e){
        if(e.getSource()== soundOnIcon) {
            clip.start();

        }
        if(e.getSource()== soundOffIcon) {
            clip.stop();

        }
        if(e.getSource()== buttonS) {
            page.show(mainmenu, "menu 2");
            tambahPlayer();

        }

        if(e.getSource()== buttonSS) {
            g1 = new SnL(parseBoardSize((String) bSize.getSelectedItem()));
            namaPemain = new String[kotakNama.size()];
            for (int i = 0; i < kotakNama.size(); i++) {
                namaPemain[i] = kotakNama.get(i).getText();
            }
            page.show(mainmenu, "menu 3");
            tambahLadder();
            tambahSnake();
            updatePlayerPanel();
        }

        if(e.getSource()== buttonP){
            boolean tes = true;
            int[][] tempatSnake = new int[kotakSnake.size() / 2][2];
            for (int i = 0; i < kotakSnake.size(); i += 2) {
                try {
                    tempatSnake[i / 2][0] = Integer.parseInt(kotakSnake.get(i).getText()); // head
                    tempatSnake[i / 2][1] = Integer.parseInt(kotakSnake.get(i + 1).getText()); // tail
                    if (tempatSnake[i / 2][0] <= tempatSnake[i / 2][1]) { // head harus lebih kecil
                        JOptionPane.showMessageDialog(null, "Head must be more than Tail!", "Warning Snake", JOptionPane.WARNING_MESSAGE);
                        tes = false;
                    }
                    if (tempatSnake[i / 2][0] >= (parseBoardSize((String) bSize.getSelectedItem())) || tempatSnake[i / 2][1] >= (parseBoardSize((String) bSize.getSelectedItem()))) { // head harus lebih kecil
                        JOptionPane.showMessageDialog(null, "Must be less than the Board Size!", "Warning Snake", JOptionPane.WARNING_MESSAGE);
                        tes = false;
                    }
                }catch(NumberFormatException c) {
                        JOptionPane.showMessageDialog(null,"Input must be number!", "Warning Snake", JOptionPane.WARNING_MESSAGE);
                        tes = false;
                    }
                }

            int[][] tempatLadder = new int[kotakLadder.size() / 2][2];
            for (int i = 0; i < kotakLadder.size(); i += 2) {
                try {
                    tempatLadder[i / 2][0] = Integer.parseInt(kotakLadder.get(i).getText()); // start
                    tempatLadder[i / 2][1] = Integer.parseInt(kotakLadder.get(i + 1).getText()); // end
                    if(tempatLadder[i/2][1] <= tempatLadder[i/2][0]){
                        JOptionPane.showMessageDialog(null,"End must be more than Start!", "Warning Ladder", JOptionPane.WARNING_MESSAGE);
                        tes = false;
                    }
                    if (tempatLadder[i / 2][1] >= (parseBoardSize((String) bSize.getSelectedItem())) || tempatLadder[i / 2][0] >= (parseBoardSize((String) bSize.getSelectedItem()))) { // head harus lebih kecil
                        JOptionPane.showMessageDialog(null, "Must be less than the Board Size!", "Warning Ladder", JOptionPane.WARNING_MESSAGE);
                        tes = false;
                    }
                } catch(NumberFormatException a) {
                    JOptionPane.showMessageDialog(null,"Input must be number!", "Warning Ladder", JOptionPane.WARNING_MESSAGE);
                    tes = false;
                }
            }
            if(tes) {
                g1 = new SnL(parseBoardSize((String) bSize.getSelectedItem()));

                page.show(mainmenu, "menu 4");
                new Thread(() -> g1.play(namaPemain, tempatSnake, tempatLadder)).start();
            }

        }
        if(e.getSource()==buttonD){
            try {
                File diceSound = new File("dice_sound.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(diceSound);
                Clip dice = AudioSystem.getClip();
                dice.open(audioInputStream);
                dice.start(); g1.playying();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                JOptionPane.showMessageDialog(null, "Error loading audio file: " + d.getMessage(), "Audio Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    private void updatePlayerPanel() {
        playerPanel.removeAll();
        for (int i = 0; i< namaPemain.length; i++) {
            String playerName = namaPemain[i];
            ImageIcon icon5 = new ImageIcon(new ImageIcon("player.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JLabel label = new JLabel(icon5);
            label.setText("PLAYER " + (i+1));
            JLabel player = new JLabel("" + playerName);
            label.setFont(new Font("Roboto", Font.BOLD, 25));
            player.setFont(new Font("Roboto", Font.PLAIN, 25));
            player.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
            playerPanel.add(label);
            playerPanel.add(player);
        }
        playerPanel.revalidate();
        playerPanel.repaint();
    }

    private int parseBoardSize(String selectedSize) {
        String[] dimensions = selectedSize.split("x");
        return Integer.parseInt(dimensions[0]) * Integer.parseInt(dimensions[1]);
    }

    private void tambahPlayer() {
        for (int i = 1; i <= Integer.parseInt((String) player.getSelectedItem()) ;i++) {
            JPanel panel = new JPanel();
            panel.setBackground(Color.decode("#FFCC99"));
            JLabel bor = new JLabel("Player " + (i) + " name:");
            bor.setFont(new Font("Arial",Font.PLAIN,20));
            panel.add(bor);

            JTextField tempatNama = new JTextField(15);
            tempatNama.setPreferredSize(new Dimension(75,40));
            tempatNama.setFont(new Font("Arial",Font.PLAIN,15));
            kotakNama.add(tempatNama);
            panel.add(tempatNama);
            panelNama.add(panel);
        }
    }

    private void tambahLadder() {
        panelLadder.removeAll();
        kotakLadder = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt((String) ladder.getSelectedItem()); i++) {
            JPanel panel = new JPanel();
            panel.setBackground(Color.decode("#ffdab9"));
            JLabel labelStart = new JLabel("Ladder " + (i) + " start:");
            labelStart.setFont(new Font("Arial", Font.PLAIN, 14));
            panel.add(labelStart);

            JTextField startField = new JTextField(5);
            startField.setFont(new Font("Arial", Font.PLAIN, 10));
            kotakLadder.add(startField);
            panel.add(startField);

            JLabel labelEnd = new JLabel(" end:");
            labelEnd.setFont(new Font("Arial", Font.PLAIN, 15));
            panel.add(labelEnd);

            JTextField endField = new JTextField(5);
            endField.setFont(new Font("Arial", Font.PLAIN, 10));
            kotakLadder.add(endField);
            panel.add(endField);

            panelLadder.add(panel);
        }
        panelLadder.revalidate();
        panelLadder.repaint();
    }

    private void tambahSnake() {
        panelSnake.removeAll();
        kotakSnake = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt((String) snake.getSelectedItem()); i++) {
            JPanel panel = new JPanel();
            panel.setBackground(Color.decode("#ffdab9"));
            JLabel labelHead = new JLabel("Snake " + (i) + " head:");
            labelHead.setFont(new Font("Arial", Font.PLAIN, 14));
            panel.add(labelHead);

            JTextField headField = new JTextField(5);
            headField.setFont(new Font("Arial", Font.PLAIN, 10));
            kotakSnake.add(headField);
            panel.add(headField);

            JLabel labelTail = new JLabel(" tail:");
            labelTail.setFont(new Font("Arial", Font.PLAIN, 15));
            panel.add(labelTail);

            JTextField tailField = new JTextField(5);
            tailField.setFont(new Font("Arial", Font.PLAIN, 10));
            kotakSnake.add(tailField);
            panel.add(tailField);
            panelSnake.add(panel);
        }
        panelSnake.revalidate();
        panelSnake.repaint();

    }
}