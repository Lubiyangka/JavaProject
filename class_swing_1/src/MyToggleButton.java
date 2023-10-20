import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class MyToggleButton {
    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;
    private List<JToggleButton> toggleButtonList;

    public MyToggleButton(String frameTitle, List<JToggleButton> toggleButtonList) {
        this.frame = new JFrame(frameTitle);
        this.panel = new JPanel();
        this.textArea = new JTextArea();
        this.toggleButtonList = toggleButtonList;
        for(JToggleButton toggleButton: toggleButtonList){
            this.panel.add(toggleButton);
        }
    }

    public void go(){
        frame.getContentPane().add(textArea, BorderLayout.CENTER);
        frame.getContentPane().add(panel,BorderLayout.SOUTH);
        frame.setSize(400, 200);
        frame.setVisible(true);
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JToggleButton toggleButton = (JToggleButton) e.getSource();
                for(JToggleButton j: toggleButtonList){
                    if(toggleButton == j){
                        textArea.append("\n");
                    }
                }
            }
        };

    }
}
