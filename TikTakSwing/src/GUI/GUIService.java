package GUI;


import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

class GUIService {
    enum Sides {
        X,
        O
    }
    static int winX = 0;
    static int win0 = 0;
    static int turnCounter = 0;
    static boolean turnPlayer = true;
    boolean checkForWinner(GUI board) {
        boolean flag = !GUI.isFlag();
        if(!(turnCounter == board.getBtnList().size()-1)){
        if (winCondition(board.getBtnList())) {
            if(GUI.isToggleAI()){
                flag = !flag;
            }
            if (flag) {
                JOptionPane.showMessageDialog(new JFrame(), "X wins ");
                winX++;
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "0 wins ");
                win0++;
            }
            return true;
        }
            turnCounter++;
            return false;
        }else {
            JOptionPane.showMessageDialog(new JFrame(), "Tie ");
        }
        return true;
    }

    private boolean winCondition(List<JButton> tempList) {
        Color lightRed = new Color(255,114,118);
        if (tempList.get(0).getText().equals(tempList.get(1).getText()) && tempList.get(1).getText().equals(tempList.get(2).getText()) && (tempList.get(2).getText().equals("X") || tempList.get(2).getText().equals("0"))) {
            tempList.get(0).setBackground(lightRed);
            tempList.get(1).setBackground(lightRed);
            tempList.get(2).setBackground(lightRed);
            return true;
        } else if (tempList.get(3).getText().equals(tempList.get(4).getText()) && tempList.get(4).getText().equals(tempList.get(5).getText()) && (tempList.get(5).getText().equals("X") || tempList.get(5).getText().equals("0"))) {
            tempList.get(3).setBackground(lightRed);
            tempList.get(4).setBackground(lightRed);
            tempList.get(5).setBackground(lightRed);
            return true;
        } else if (tempList.get(6).getText().equals(tempList.get(7).getText()) && tempList.get(7).getText().equals(tempList.get(8).getText()) && (tempList.get(8).getText().equals("X") || tempList.get(8).getText().equals("0"))) {
            tempList.get(6).setBackground(lightRed);
            tempList.get(7).setBackground(lightRed);
            tempList.get(8).setBackground(lightRed);
            return true;
        } else if (tempList.get(0).getText().equals(tempList.get(3).getText()) && tempList.get(3).getText().equals(tempList.get(6).getText()) && (tempList.get(6).getText().equals("X") || tempList.get(6).getText().equals("0"))) {
            tempList.get(0).setBackground(lightRed);
            tempList.get(3).setBackground(lightRed);
            tempList.get(6).setBackground(lightRed);
            return true;
        } else if (tempList.get(1).getText().equals(tempList.get(4).getText()) && tempList.get(4).getText().equals(tempList.get(7).getText()) && (tempList.get(7).getText().equals("X") || tempList.get(7).getText().equals("0"))) {
            tempList.get(1).setBackground(lightRed);
            tempList.get(4).setBackground(lightRed);
            tempList.get(7).setBackground(lightRed);
            return true;
        } else if (tempList.get(2).getText().equals(tempList.get(5).getText()) && tempList.get(5).getText().equals(tempList.get(8).getText()) && (tempList.get(8).getText().equals("X") || tempList.get(8).getText().equals("0"))) {
            tempList.get(2).setBackground(lightRed);
            tempList.get(5).setBackground(lightRed);
            tempList.get(8).setBackground(lightRed);
            return true;
        } else if (tempList.get(0).getText().equals(tempList.get(4).getText()) && tempList.get(4).getText().equals(tempList.get(8).getText()) && (tempList.get(8).getText().equals("X") || tempList.get(8).getText().equals("0"))) {
            tempList.get(0).setBackground(lightRed);
            tempList.get(4).setBackground(lightRed);
            tempList.get(8).setBackground(lightRed);
            return true;
        } else if(tempList.get(2).getText().equals(tempList.get(4).getText()) && tempList.get(4).getText().equals(tempList.get(6).getText()) && (tempList.get(6).getText().equals("X") || tempList.get(6).getText().equals("0"))){
            tempList.get(2).setBackground(lightRed);
            tempList.get(4).setBackground(lightRed);
            tempList.get(6).setBackground(lightRed);
            return true;
        }
         return false;
    }

    void AIPlays(GUI gui, Sides side){
        if(!turnPlayer && !winCondition(gui.getBtnList())) {
            Random rand = new Random();
            String sideAI = "X";
            if (side.equals(Sides.X)) {
                sideAI = "X";
            } else if (side.equals(Sides.O)) {
                sideAI = "0";
            }
            int temp;
            do {
                temp = rand.nextInt(gui.getBtnList().size());
                if (gui.getBtnList().get(temp).getText().equals("")) {
                    gui.getBtnList().get(temp).setText(sideAI);
                    turnPlayer = true;
                    turnCounter++;
                    return;
                }
            } while (true);
        }
    }

    void updateScore(GUI gui){
        gui.player0Score.setText(String.valueOf(win0));
        gui.playerXScore.setText(String.valueOf(winX));
    }
    void clearBoard(GUI gui){
        for (JButton btn : gui.getBtnList()
        ) {
            btn.setText("");
            btn.setBackground(new Color(144,238,144));
        }
        turnCounter = 0;
        gui.setGameOver(false);
    }

    void clearScores(GUI gui) {
        clearBoard(gui);
        winX = 0;
        win0 = 0;
        gui.player0Score.setText(String.valueOf(win0));
        gui.playerXScore.setText(String.valueOf(winX));
    }

    public static void setTurnPlayer(boolean turnPlayer) {
        GUIService.turnPlayer = turnPlayer;
    }

    void disableBoardButtons(GUI gui){
        for (JButton btn:gui.getBtnList()
             ) {
            btn.setEnabled(false);
        }
    }
    void enableBoardButtons(GUI gui){
        for (JButton btn:gui.getBtnList()
             ) {
            btn.setEnabled(true);
        }
    }
}
