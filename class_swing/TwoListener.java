import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TwoListener implements MouseMotionListener, MouseListener {
    private JFrame frame;
    private JTextField textField;
    public void go(){
        frame = new JFrame("this is an example of two listener");
        Container contentPane = frame.getContentPane();
        contentPane.add(new Label("Click and drag the mouse"), BorderLayout.NORTH);
        textField = new JTextField(30);
        contentPane.add(textField, BorderLayout.SOUTH);
        //注册监听对象
        frame.addMouseMotionListener(this);
        frame.addMouseListener(this);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        String s = "Mouse dragging: x =" +e.getX() + "\ny =" + e.getY();
        textField.setText(s);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        String s = "the mouse entered";
        textField.setText(s);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        String s = "the mouse has left the building";
        textField.setText(s);
    }
}
