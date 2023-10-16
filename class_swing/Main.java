import javax.swing.*;
import java.awt.*;

/*
   java主要布局管理：
   FlowLayout 、 BorderLayout 、 GridLayout 、
   CardLayout 、 BoxLayout 、 GridBagLayout 、
   SpringLayout
 */
public class Main {
    JFrame frame;  //定义一个JFrame对象frame
    JButton button; //定义一个JButton对象button
    JPanel panel; //定义一个JPanel对象contentPane

    public void init() {
        frame = new JFrame("My JFrame"); //frame对象实例化
        button = new JButton("Press me"); //button对象实例化
        Container contentPane = frame.getContentPane(); //contentPane对象实例化
        //为contentPane对象设置BorderLayout布局管理器
        contentPane.setLayout(new BorderLayout());
        //将button对象放到contentPane的中央
        contentPane.add(button, BorderLayout.CENTER);
        //为frame对象的内容窗格设置为contentPane
        frame.setContentPane(contentPane);
        frame.setSize(300, 200); //设置frame窗口的大小
        frame.setVisible(true); //显示frame窗口
    }

    public void JPaneInit() {

        //初始化
        frame = new JFrame("this is a title");
        panel = new JPanel();
        button = new JButton("this is a button");
        Container contentPane = frame.getContentPane();

        //设置背景
        contentPane.setBackground(Color.CYAN);
        //添加按钮
        panel.add(button);
        //设置按钮位置
        contentPane.add(button, BorderLayout.SOUTH);
        //设置窗口大小，可见度
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    /*
    对容器中组件进行布局的方式是将组件逐个地安放在
    容器中的一行上，一行放满后就另起一个新行。
     */
    public void FlowLayout() {

    }

    //类似GridLayout,但是了可以设置单元格高度宽度
    public void GridBagLayout() {
        frame = new JFrame("GridBagLayout");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();

        //创建布局管理器
        GridBagLayout gridBagLayout = new GridBagLayout();
        contentPane.setLayout(gridBagLayout);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        //设置按钮位置
        int[] gx = {0, 0, 1, 2, 3, 0, 1, 2, 0, 1, 2, 3, 0, 2};
        int[] gy = {0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4};
        int[] gw = {4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2};
        int[] gh = {1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        String[] name = {"显示器", "0", "1", "2", "=", "3", "4", "5", "6", "7", "8", "9", "+", "-"};
        //
        for (int i = 0; i < gx.length; i++) {
            button = new MyButton(name[i]);
            gridBagConstraints.gridx = gx[i];
            gridBagConstraints.gridy = gy[i];
            gridBagConstraints.gridwidth = gw[i];
            gridBagConstraints.gridheight = gh[i];
            //设置组件横向/纵向增量值
            gridBagConstraints.weightx = 100;
            gridBagConstraints.weighty = 100;
            //设置组件填充方式
            gridBagConstraints.fill = GridBagConstraints.BOTH;
            gridBagLayout.setConstraints(button, gridBagConstraints);
            contentPane.add(button);
        }
        frame.setVisible(true);
    }



    public static void main(String[] args) {
//        Main m = new Main();
//        m.GridBagLayout();
        TwoListener twoListener = new TwoListener();
        twoListener.go();
    }
}
