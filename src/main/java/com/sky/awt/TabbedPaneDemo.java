package com.sky.awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;
//http://c.biancheng.net/view/1263.html
public class TabbedPaneDemo extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("尚医智信本地程序");
        ImageIcon imageIcon = createImageIcon("syzx.jpg");
        frame.setIconImage(imageIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TabbedPaneDemo(), BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }


    public TabbedPaneDemo() {
        super(new GridLayout(1, 1));
        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = makeTextPanel("计算机名");
        tabbedPane.addTab("计算机名",  panel1);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        JComponent panel2 = makeTextPanel("硬件");
        tabbedPane.addTab("硬件", panel2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        JComponent panel3 = makeTextPanel("高级");
        tabbedPane.addTab("高级", panel3);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        JComponent panel4 = makeTextPanel("系统保护");
        panel4.setPreferredSize(new Dimension(410, 300));
        tabbedPane.addTab("系统保护", panel4);
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        add(tabbedPane);
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    protected static ImageIcon createImageIcon(String path) {
        URL icon = TabbedPaneDemo.class.getClassLoader().getResource("syzx.jpg");
        if (icon != null) {
            ImageIcon imageIcon = new ImageIcon(icon);
            return imageIcon;
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}