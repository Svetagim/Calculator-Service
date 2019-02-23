package Gui;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;

public class ClientGUIDemo {

    private JFrame frame;
    private JPanel panelTop,panelBottom;
    private JButton btPlus, btMinus;
    private JTextField tf1,tf2,tf3;


    public ClientGUIDemo() {
        frame = new JFrame("demo");
        frame.setLayout(new BorderLayout());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        panelTop = new JPanel();
        panelBottom = new JPanel();
        panelTop.setBackground(Color.YELLOW);
        panelBottom.setBackground(Color.GREEN);
        btPlus = new JButton("+");
        btPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(tf1.getText());
                double num2 = Double.parseDouble(tf2.getText());
                double result = num1+num2;
                tf3.setText(String.valueOf(result));
            }
        });
        btMinus = new JButton("-");
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField(10);

    }

    public void start() {
        panelTop.add(btPlus);
        panelBottom.add(tf1);
        panelBottom.add(tf2);
        panelTop.add(btMinus);
        panelBottom.add(tf3);
        frame.add(panelBottom,BorderLayout.NORTH);
        frame.add(panelTop,BorderLayout.SOUTH);
        frame.setSize(800,500);
        frame.setVisible(true);

    }

    public static void main(String args[]) {

        ClientGUIDemo ob = new ClientGUIDemo();
        ob.start();
    }



}