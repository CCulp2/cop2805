package cop2805;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class CCulpFinalClient {

    private static void ConstructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Frame fr = new Frame();
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        ConstructGUI();
    }
}

class Frame extends JFrame {
    int frameWidth = 300;
    int frameHeight = 150;
    Dimension minSize = new Dimension(frameWidth, frameHeight);
    public JTextField input;
    public JButton connectAndSubmit;
    public JLabel comms;

    public Frame() {
        super();
        init();
    }

    private void init() {
        Messages m = new Messages();
        ActionListener sendListener = new SendListener(this);

        this.setTitle("Fib Sequence Client");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        panel.setMinimumSize(minSize);
        panel.add(new JLabel("Enter Place:"));

        panel.add(input = new JTextField());
        input.addActionListener(sendListener);

        panel.add(comms = new JLabel());
        comms.setText(m.onInitMessage);

        panel.add(connectAndSubmit = new JButton());
        connectAndSubmit.setText("Send");
        connectAndSubmit.addActionListener(sendListener);

        this.add(panel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((int) (screenSize.getWidth() / 2) - (frameWidth / 2), (int) (screenSize.getHeight() / 2)
                - (frameHeight / 2), frameWidth, frameHeight);
    }

    static class SendListener implements ActionListener {
        Frame fr;

        public SendListener(Frame fr) {
            this.fr = fr;
        }

        public void actionPerformed(ActionEvent e) {
            Messages m = new Messages();
            FibConnection fib = new FibConnection();
            int place;
            int response;
            JTextField input = fr.input;

                try {
                    place = Integer.parseInt(input.getText());
                    if (place == 999) {
                        fr.comms.setText(m.systemExit);
                        fib.connect(place);
                    } else if (place >= 40 || place <= 0) {
                        fr.comms.setText(m.outOfBounds);
                    } else {
                        response = fib.connect(place);
                        fr.comms.setText(m.displayAnswer(place, response));
                    }
                } catch (NumberFormatException formatException) {
                    fr.comms.setText(m.outOfBounds);
                }
            }
        }
    }

class Messages {
    public final String onInitMessage = "Waiting for connection...";
    public final String outOfBounds = "<html> You must enter a number between 1 - 40 </html>";
    public final String systemExit = "Server has shutdown.";

    public String displayAnswer(int place, int answer) {
        return String.format("<html> The %d place of the Fibonacci sequence is %d </html>", place, answer);
    }


}

class FibConnection {
    public int response = -1;

    public int connect(int place) {
        try {
            Socket connection = new Socket("127.0.0.1", 1337);
            InputStream rawInput= connection.getInputStream();
            OutputStream rawOutput= connection.getOutputStream();
            DataInputStream input = new DataInputStream(rawInput);
            DataOutputStream output = new DataOutputStream(rawOutput);
            output.writeInt(place);
            if (!(place == 999))
                response = input.readInt();
            input.close();
            output.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;

    }
}
