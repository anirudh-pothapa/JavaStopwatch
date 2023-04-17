import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class stopwatch implements ActionListener {
    JFrame frame = new JFrame();
    JButton start = new JButton("START");
    JButton reset = new JButton("RESET");
    JLabel timelabel = new JLabel();
    int elapsedtme = 0;
    int seconds = 0;
    int hours = 0;
    int minutes = 0;
    boolean startedboolean = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            elapsedtme = elapsedtme + 1000;
            hours = (elapsedtme / 3600000);
            minutes = (elapsedtme / 60000) % 60;
            seconds = (elapsedtme / 1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timelabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }

    });

    stopwatch() {
        timelabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timelabel.setBounds(100, 100, 200, 100);
        timelabel.setFont(new Font("Verdana", Font.BOLD, 35));
        timelabel.setBackground(Color.CYAN);
        timelabel.setBorder(BorderFactory.createBevelBorder(1));
        timelabel.setOpaque(true);
        timelabel.setHorizontalAlignment(JLabel.CENTER);

        start.setBounds(100, 200, 100, 50);
        start.setFont(new Font("Ink Free", Font.BOLD, 19));
        start.setFocusable(false);
        start.addActionListener(this);

        reset.setBounds(200, 200, 100, 50);
        reset.setFont(new Font("Ink Free", Font.BOLD, 19));
        reset.setFocusable(false);
        reset.addActionListener(this);

        frame = new JFrame();
        frame.add(reset);
        frame.add(start);
        frame.add(timelabel);

        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {

            if (startedboolean == false) {
                startedboolean = true;
                start.setText("STOP");

                started();

            } else {
                startedboolean = false;
                start.setText("START");
                stop();

            }

        }
        if (e.getSource() == reset) {
            startedboolean = false;
            start.setText("START");
            reset();

        }

    }

    public void started() {
        timer.start();

    }

    public void reset() {
        timer.stop();
        elapsedtme = 0;
        seconds = 0;
        hours = 0;
        minutes = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);

        timelabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timelabel.setBackground(Color.GREEN);
        timelabel.setOpaque(true);

    }

    public void stop() {
        timer.stop();
        timelabel.setBackground(Color.red);
        timelabel.setOpaque(true);

    }

    public static void main(String[] args) {
        stopwatch watch = new stopwatch();
    }

}