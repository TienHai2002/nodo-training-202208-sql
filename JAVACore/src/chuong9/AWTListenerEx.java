package chuong9;

import javax.swing.*;

public class AWTListenerEx {
    public static void main(String[] args) {
        JFrame srceen = new JFrame();
        srceen.addWindowListener((WindowClosing)(e)->System.exit(0));
        JButton button = new JButton("Press me");
        srceen.add(button);

//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null,"Welcome to java by exemple","Java Sample",JOptionPane.INFORMATION_MESSAGE);
//            }
//        });
        srceen.setSize(250,400);
        srceen.setVisible(true);
    }
}
