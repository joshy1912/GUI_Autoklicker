
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AutoclickerGUI extends JFrame{
    private JButton startButton;
    private JButton stopButton;
    private JTextField intervalField;
    private Timer timer;

    public  AutoclickerGUI(){
        setTitle("Autoclicker");
        setSize(300,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel intervalLaabel = new JLabel("Interval (ms)");
        intervalField = new JTextField(10);
        startButton = new JButton("Start");
        stopButton = new JButton ("Stop");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int interval = Integer.parseInt(intervalField.getText());
                timer = new Timer(interval, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("click");
                    }
                });
                timer.start();
            }
        });
    }


}