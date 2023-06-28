import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AutoclickerGUI extends JFrame {
    private JButton startButton;
    private JButton stopButton;
    private JTextField intervalField;
    private Timer timer;
    private Robot robot;

    public AutoclickerGUI() {
        setTitle("Autoclicker");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel intervalLabel = new JLabel("Interval (ms):");
        intervalField = new JTextField(10);
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int interval = Integer.parseInt(intervalField.getText());
                timer = new Timer(interval, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Perform autoclick action
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    }
                });
                timer.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                    timer = null;
                }
            }
        });

        add(intervalLabel);
        add(intervalField);
        add(startButton);
        add(stopButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AutoclickerGUI().setVisible(true);
            }
        });
    }
}