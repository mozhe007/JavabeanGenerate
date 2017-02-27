package javabean.generate.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by linjian on 2017/2/18.
 */
public class JavabeanGenerateFrame extends JFrame {

    public static final int DEFAULT_WIDTH = 680;
    public static final int DEFAULT_HEIGHT = 440;

    private JTextField ipFiled;
    private JTextField dbFiled;
    private JTextField dbNameFiled;
    private JTextField tabField;
    private JTextField packField;
    private JTextField catField;
    private JCheckBox checkBox;
    private JTextField userField;
    private JTextField pwdField;
    private JComboBox dbBox;

    public JavabeanGenerateFrame(){
        //基础信息
        setTitle("JavabeanGenerate");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setLocation(screenSize.width / 2 - DEFAULT_WIDTH / 2, screenSize.height
                / 2 - DEFAULT_HEIGHT / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 544, 374);
        setLayout(null);

        //画板
        JPanel panel = new JPanel();
        this.add(panel, BorderLayout.CENTER);

        //数据库
        JLabel dbLabel = new JLabel("数据库:");
        dbLabel.setBounds(40, 40, 30, 15);
        panel.add(dbLabel);

        dbBox = new JComboBox();
        dbBox.addItem("1");
        dbBox.addItem("2");
        dbBox.setBounds(80, 50, 30, 15);
        dbBox.setMaximumRowCount(3);
        panel.add(dbBox);

        //IP
        JLabel ipLable = new JLabel("IP:");
        ipLable.setBounds(40, 60, 30, 15);
        panel.add(ipLable);

        ipFiled = new JTextField();
        ipFiled.setVisible(true);
        ipFiled.setText("localhost");
        ipFiled.setBounds(146, 10, 147, 21);
        ipFiled.setColumns(10);
        panel.add(ipFiled);
    }

    public static void main(String[] args) {
        JavabeanGenerateFrame jgf = new JavabeanGenerateFrame();
    }
}
