import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TesterinoSwingerino extends JFrame {
    public static void main(String[] args) {
        TesterinoSwingerino frame = new TesterinoSwingerino();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public TesterinoSwingerino() {
        super("Title");

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2,2));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 450, 300);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        Label label1 = new Label("Label1");
        contentPanel.add(label1);

        JTextField textField1 = new JTextField();
        contentPanel.add(textField1);

        JButton btn1 = new JButton("click");
        contentPanel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn1.setText("x");
                btn1.setBackground(Color.GREEN);
            }
        });
        setContentPane(contentPanel);
    }
}
