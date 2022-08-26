package cop2805;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CCulpHomework5 {

    private static void ConstructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Frame frame = new Frame();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ConstructGUI();
            }
        });

    }
}

/* class Frame extends JFrame {
    private ActionListener comboBoxStateChangeListener = new comboBoxStateChangeListener(this);
    private ListSelectionListener countrySelectionListener = new countrySelectionListener(this);

    String[] countries = {"United States", "Dominican Republic", "Haiti", "Bermuda", "Puerto Rico", "Mexico", "Jamaica"};
    String[] comboSelect = {"Single", "Multiple"};
    String labelString = "Selected Countries: ";

    JList<String> jlst = new JList<>(countries);
    JLabel jlbl = new JLabel(labelString);

    JComboBox jcb = new JComboBox(comboSelect);



    public Frame() {
        super();
        init();
    }

    private void init() {
        int frameWidth = 300;
        int frameHeight = 300;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("CCulp Homework 5");

        JComponent panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Choose Selection Mode:"));
        panel.add(jcb);
        jcb.addActionListener(comboBoxStateChangeListener);

        this.add(panel,BorderLayout.NORTH);
        this.add(jlst, BorderLayout.WEST);
        jlst.addListSelectionListener(countrySelectionListener);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.add(jlbl,BorderLayout.SOUTH);

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((int) (screensize.getWidth() / 2) - (frameWidth / 2), (int) (screensize.getHeight() / 2) - (frameHeight / 2), frameWidth, frameHeight);
    }

    class comboBoxStateChangeListener implements ActionListener {
        Frame fr;

        public comboBoxStateChangeListener(Frame fr) {
            this.fr = fr;
        }

        public void actionPerformed(ActionEvent e) {
            JComboBox source = (JComboBox) e.getSource();
            if (source.getSelectedItem().toString().equals("Multiple")) {
                jlst.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            }
            else {
                jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

        }
    }

    class countrySelectionListener implements ListSelectionListener {
        Frame fr;


        public countrySelectionListener(Frame fr) {
            this.fr = fr;
        }

        public void valueChanged(ListSelectionEvent e) {
            JList list = (JList) e.getSource();
            int[] elementsOfCountries = list.getSelectedIndices();
            String countries = "Selected Countries: ";
            for (int element : elementsOfCountries)
                countries += list.getModel().getElementAt(element).toString() + " ";

            fr.jlbl.setText(countries);
            fr.pack();
        }
    }
} */





