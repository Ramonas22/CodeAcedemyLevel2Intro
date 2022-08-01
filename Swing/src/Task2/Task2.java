package Task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Task2 extends JFrame {
    public static void main(String[] args) {
    Task2 runner = new Task2();
    runner.setVisible(true);

    }
    Task2(){
        JPanel panel = new JPanel();

        panel.setSize(600,600);
        setBounds(150, 150, 450, 300);
        panel.setLayout(new GridLayout(3,2));

        JButton btn1 = new JButton();
        JButton btn2 = new JButton();

        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();

        panel.add(label1);
        panel.add(textField1);

        panel.add(label2);
        panel.add(textField2);

        panel.add(btn1);
        panel.add(btn2);

        label1.setText("Celsius");
        label2.setText("Fahrenheit");

        btn1.setText("Convert to Fahrenheit");
        btn2.setText("Convert to Celsius");

        btn1.addActionListener(e -> {
            try {
                textField2.setText(String.valueOf((Double.parseDouble(textField1.getText()) * 1.8 + 32)));
            }catch (Exception a){
                JOptionPane.showMessageDialog(new JFrame(),"Entered wrong value");
            }
        });
        btn2.addActionListener(e -> {
                try {
                    textField1.setText(String.valueOf((Double.parseDouble(textField2.getText())-32)/1.8));
                }catch (Exception a){
                    JOptionPane.showMessageDialog(new JFrame(),"Entered wrong value");
                }
        });

        setContentPane(panel);

    }
}
