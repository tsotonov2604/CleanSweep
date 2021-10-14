package Power;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class OnOffButton extends JFrame implements ItemListener {
    public static void main(String[] args) {
        new OnOffButton();
    }
    private JToggleButton button;
    OnOffButton() {
        setTitle("Allow a user to turn the device On/Off");
        setLayout(new FlowLayout());
        setJToggleButton();
        setAction();
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void setJToggleButton() {
        button = new JToggleButton("ON");
        add(button);
    }
    private void setAction() {
        button.addItemListener(this);
    }
    public void itemStateChanged(ItemEvent eve) {
        if (button.isSelected())
            button.setText("OFF");
        else
            button.setText("ON");
    }
}  