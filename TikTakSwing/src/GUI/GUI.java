package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI extends JFrame implements ActionListener {
    private static boolean flag = true;

    private static boolean toggleAI = false;
    private static int toggleAiCount = 0;
    private static boolean gameOver = false;
    JLabel playerXScore = new JLabel();
    JLabel player0Score = new JLabel();
    private final List<JButton> btnList = new ArrayList<>(Arrays.asList(
            new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton()
    ));

    public GUI() {
        super("JAVA Advanced Tic Tac Toe Game");

        GUIService guiService = new GUIService();

        GUIService service = new GUIService();
        setBounds(150, 150, 600, 600);
        Color lightGreen = new Color(144 , 238, 144);

        //Main panel bot
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(600, 600);
        mainPanel.setLayout(new GridLayout(1, 2));

        //Left side
        JPanel panelWest = new JPanel();
        panelWest.setSize(600, 600);
        panelWest.setLayout(new GridLayout(3, 3));

        for (JButton btn : btnList
        ) {
            btn.setText("");
            panelWest.add(btn);
            btn.addActionListener(this);
            btn.setBackground(lightGreen);
            btn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        /*
        for (int i = 0; i < btnList.size(); i++) {
            btnList.get(i).setText(""+i);
            panel.add(btnList.get(i));
            btnList.get(i).addActionListener(this);
        }*/
        mainPanel.add(panelWest);


        //Right Side
        JPanel panelEast = new JPanel();
        panelEast.setSize(600, 600);
        panelEast.setLayout(new GridLayout(2, 1));

        //Right Side Top
        JPanel panelEastTop = new JPanel();
        panelEastTop.setSize(600, 600);
        panelEastTop.setLayout(new GridLayout(2, 2));
        panelEastTop.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panelEast.add(panelEastTop);

        JLabel playerXLabel = new JLabel("Player X");
        playerXLabel.setBackground(Color.pink);
        playerXLabel.setOpaque(true);
        playerXLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelEastTop.add(playerXLabel);

        playerXScore.setBackground(Color.yellow);
        panelEastTop.add(playerXScore);
        playerXScore.setOpaque(true);
        playerXScore.setHorizontalAlignment(SwingConstants.CENTER);
        playerXScore.setText("0");

        JLabel player0Label = new JLabel("Player 0");
        player0Label.setBackground(Color.pink);
        player0Label.setOpaque(true);
        player0Label.setHorizontalAlignment(SwingConstants.CENTER);
        panelEastTop.add(player0Label);


        player0Score.setBackground(Color.yellow);
        panelEastTop.add(player0Score);
        player0Score.setOpaque(true);
        player0Score.setHorizontalAlignment(SwingConstants.CENTER);
        player0Score.setText("0");

        //Right side BottomSplit
        JPanel panelEastBottomTop = new JPanel();
        panelEastBottomTop.setSize(600, 600);
        panelEastBottomTop.setLayout(new GridLayout(3, 1));
        panelEastBottomTop.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panelEast.add(panelEastBottomTop);

        //Right Side Bottom Top :D
        JButton btnBT = new JButton("New Game");
        panelEastBottomTop.add(btnBT);
        btnBT.setBackground(Color.white);
        btnBT.addActionListener(e -> service.clearBoard(this));

        //Right Side Bottom Middle
        JButton btnBBC = new JButton("Toggle AI ON X");
        panelEastBottomTop.add(btnBBC);
        btnBBC.setBackground(Color.white);
        btnBBC.addActionListener(e -> {
            guiService.clearBoard(this);
            if(toggleAiCount == 0){
                toggleAI = true;
                btnBBC.setText("Toggle AI ON 0");
                GUIService.setTurnPlayer(false);
                guiService.AIPlays(this, GUIService.Sides.X);
                toggleAiCount++;
                flag = false;
            }else if(toggleAiCount == 1){
                toggleAI = true;
                btnBBC.setText("Toggle AI OFF");
                toggleAiCount++;
                flag = true;
            } else if (toggleAiCount == 2) {
                toggleAI = false;
                btnBBC.setText("Toggle AI ON X");
                toggleAiCount = 0;
            }
        });

        //Right Side Bottom Bottom
        JPanel panelBotBot = new JPanel();
        panelBotBot.setSize(600, 600);
        panelBotBot.setLayout(new GridLayout(1, 2));
        panelEastBottomTop.add(panelBotBot);

        //Right side Bot Bot left
        JButton btnBBL = new JButton("Reset");
        panelBotBot.add(btnBBL);
        btnBBL.setBackground(Color.white);
        btnBBL.addActionListener(e -> service.clearScores(this));


        //Right side Bot Bot right
        JButton btnBBR = new JButton("Exit");
        panelBotBot.add(btnBBR);
        btnBBR.setBackground(Color.white);
        btnBBR.addActionListener(e ->
            System.exit(1));


        mainPanel.add(panelEast);

        //Show panel
        setContentPane(mainPanel);
    }

    public static boolean isFlag() {
        return flag;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GUIService guiService = new GUIService();
        JButton btn = (JButton) e.getSource();

        if(!gameOver) {
            if (btn.getText().equals("")) {
                if (flag) {
                    btn.setText("X");
                    if(!toggleAI) {
                        flag = false;
                    }else {
                        GUIService.setTurnPlayer(false);
                        guiService.AIPlays(this, GUIService.Sides.O);
                    }
                } else {
                    btn.setText("0");
                    if(!toggleAI) {
                        flag = true;
                    }else {
                        GUIService.setTurnPlayer(false);
                        guiService.AIPlays(this, GUIService.Sides.X);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "This tile is taken :D");
            }
        }
        if (guiService.checkForWinner(GUI.this) && !gameOver) {
            gameOver = true;
            guiService.updateScore(this);
        }
    }

    public List<JButton> getBtnList() {
        return btnList;
    }
    public void setGameOver(boolean gameOver) {
        GUI.gameOver = gameOver;
    }

    public static boolean isToggleAI() {
        return toggleAI;
    }
}
