package Task5;

import javax.swing.*;
import java.awt.*;

class Task5 extends JFrame {
    public static void main(String[] args) {
        Task5 run = new Task5();
        run.setVisible(true);
    }

     Task5(){
        super("Calculator");

        JPanel panel= new JPanel();
        setBounds(100,100,600,600);
        panel.setSize(600,600);
        panel.setLayout(new GridLayout(6,2));

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();

        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();

        JButton btn1 = new JButton();
        JButton btn2 = new JButton();
        JButton btn3 = new JButton();
        JButton btn4 = new JButton();
        JButton btn5 = new JButton();
        JButton btn6 = new JButton();

        panel.add(label1);
        label1.setText("First Number");
        panel.add(textField1);

        panel.add(label2);
        label2.setText("Second Number");
        panel.add(textField2);

        panel.add(label3);
        label3.setText("Result");
        panel.add(label4);
        label4.setText("0");

        panel.add(btn1);
        btn1.setText("+");
        panel.add(btn2);
        btn2.setText("-");

        panel.add(btn3);
        btn3.setText("*");
        panel.add(btn4);
        btn4.setText("/");

        panel.add(btn5);
        btn5.setText("%");
        panel.add(btn6);
        btn6.setText("Clear");

      btn1.addActionListener(e -> {
         label4.setText(String.valueOf(
                 Double.parseDouble(textField1.getText())
                 + Double.parseDouble(textField2.getText())
         ));
         textField1.setText(label4.getText());
      });

        btn2.addActionListener(e -> {
           label4.setText(String.valueOf(
                   Double.parseDouble(textField1.getText())
                           - Double.parseDouble(textField2.getText())
           ));
           textField1.setText(label4.getText());
        });

        btn3.addActionListener(e -> {
           label4.setText(String.valueOf(
                   Double.parseDouble(textField1.getText())
                           * Double.parseDouble(textField2.getText())
           ));
           textField1.setText(label4.getText());
        });

        btn4.addActionListener(e -> {
           label4.setText(String.valueOf(
                   Double.parseDouble(textField1.getText())
                           / Double.parseDouble(textField2.getText())
           ));
           textField1.setText(label4.getText());
        });

        btn5.addActionListener(e -> {
           label4.setText(String.valueOf(
                   Double.parseDouble(textField1.getText())
                           % Double.parseDouble(textField2.getText())
           ));
           textField1.setText(label4.getText());
        });

        btn6.addActionListener(e -> {
           textField2.setText("0");
           textField1.setText("0");
           label4.setText("0");
        });

         setContentPane(panel);
     }
}
