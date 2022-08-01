package Task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Task3 extends JFrame{
    public static void main(String[] args) {
        Task3 runner = new Task3();

        runner.setVisible(true);
    }

    Task3(){
        super("Guess number :)");

        int random = (int)Math.floor(Math.random()*(10+1));

        JPanel panel = new JPanel();

        panel.setSize(600,600);
        setBounds(150, 150, 450, 300);
        panel.setLayout(new GridLayout(1,2));

        JTextField textField = new JTextField();
        JButton btn1 = new JButton();

        panel.add(textField);
        panel.add(btn1);

        btn1.setText("Guess");

        btn1.addActionListener(e->{
            try {
                if(Integer.parseInt(textField.getText())==random){
                    JOptionPane.showMessageDialog(new JFrame(),"You win !");
                    setVisible(false);
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(new JFrame(), "wrong guess try again :D");
                    textField.setText("");
                }
            }catch (Exception a){
                JOptionPane.showMessageDialog(new Frame(),"Entered non integer value :(");
            }
        });

        setContentPane(panel);
    }
}
