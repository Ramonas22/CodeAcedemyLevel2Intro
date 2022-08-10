package Task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Task4 extends JFrame implements ActionListener {
    public static void main(String[] args) {
        Task4 run = new Task4();
        run.setVisible(true);
    }

    Task4(){
        super("Press buttons");

        final int[] btnN1 = {0,0,0,0};


        JPanel frame = new JPanel();

        setBounds(100,100,300,300);
        frame.setLayout(new GridLayout(2,2));

        JButton btn1 = new JButton();
        JButton btn2 = new JButton();
        JButton btn3 = new JButton();
        JButton btn4 = new JButton();

        btn1.setText(String.valueOf(btnN1[0]));
        btn2.setText(String.valueOf(btnN1[1]));
        btn3.setText(String.valueOf(btnN1[2]));
        btn4.setText(String.valueOf(btnN1[3]));

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);

        /*btn1.addActionListener(e -> {
            btnN1[0]++;
            btn1.setText(String.valueOf(btnN1[0]));
        });
        btn2.addActionListener(e -> {
            btnN1[1]++;
            btn2.setText(String.valueOf(btnN1[1]));
        });
        btn3.addActionListener(e -> {
            btnN1[2]++;
            btn3.setText(String.valueOf(btnN1[2]));
        });
        btn4.addActionListener(e -> {
            btnN1[3]++;
            btn4.setText(String.valueOf(btnN1[3]));
        });
        */
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);

        setContentPane(frame);
    }
    @Override
    public void actionPerformed(ActionEvent e ) {
        JButton btn = (JButton) e.getSource();
        btn.setText(String.valueOf(Integer.parseInt(btn.getText())+1));
    }

}
