import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class RaterPage extends JDialog {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JComboBox comboBox10;
    private JLabel a1;
    private JLabel a2;
    private JLabel b1;
    private JLabel b2;
    private JLabel c1;
    private JLabel c2;
    private JLabel d1;
    private JLabel d2;
    private JLabel e1;
    private JLabel e2;
    private JLabel f1;
    private JLabel f2;
    private JLabel g1;
    private JLabel g2;
    private JLabel h1;
    private JLabel h2;
    private JLabel i1;
    private JLabel i2;
    private JLabel j1;
    private JLabel j2;
    private JTextField genreField;
    private JTextField directorField;
    private JTextField yearField;
    private JTextField minTextField;
    private JTextField maxTextField;
//    private JButton getRecommendationsButton;
    private JButton filterRecommendationsButton;
    private JButton helpButton;
    private JButton buttonOK;
    private JButton buttonCancel;

    public RaterPage() {



        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        // Centring the window///////////////
        Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        Dimension windowSize = new Dimension(getPreferredSize());
        int wdwLeft = screenSize.width / 2 - windowSize.width / 2;
        int wdwTop = screenSize.height / 2 - windowSize.height / 2;
        pack();
        setLocation(wdwLeft, wdwTop);
        ///////////////////////////////////////

        MovieDatabase.initialize("ratedmoviesfull.csv");

//        System.out.println(MovieDatabase.getTitle("111161"));

        ///////LOADING TITLES////////////
        a2.setText(MovieDatabase.getTitle("3390572"));
        b2.setText(MovieDatabase.getTitle("1201607"));
        c2.setText(MovieDatabase.getTitle("1723121"));
        d2.setText(MovieDatabase.getTitle("1343092"));
        e2.setText(MovieDatabase.getTitle("1951261"));
        f2.setText(MovieDatabase.getTitle("3678782"));
        g2.setText(MovieDatabase.getTitle("2184339"));
        h2.setText(MovieDatabase.getTitle("1454468"));
        i2.setText(MovieDatabase.getTitle("2278388"));
        j2.setText(MovieDatabase.getTitle("2752200"));
        ///////LOADING Years////////////
        a1.setText(Integer.toString(MovieDatabase.getYear("3390572")));
        b1.setText(Integer.toString(MovieDatabase.getYear("1201607")));
        c1.setText(Integer.toString(MovieDatabase.getYear("1723121")));
        d1.setText(Integer.toString(MovieDatabase.getYear("1343092")));
        e1.setText(Integer.toString(MovieDatabase.getYear("1951261")));
        f1.setText(Integer.toString(MovieDatabase.getYear("3678782")));
        g1.setText(Integer.toString(MovieDatabase.getYear("2184339")));
        h1.setText(Integer.toString(MovieDatabase.getYear("1454468")));
        i1.setText(Integer.toString(MovieDatabase.getYear("2278388")));
        j1.setText(Integer.toString(MovieDatabase.getYear("2752200")));


        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String msg = "Action, Adventure, Thriller, Mystery, Horror, Drama, Animation, Biography, \nFantasy, Family, Crime, Musical, Romance, History, Documentary, Sport, Sci-Fi";
                infoBox(msg, "Available Genres");
            }
        });

//        System.out.println(MovieDatabase.getTitle("1300854"));

//        a2.setText(MovieDatabase.getTitle("361862"));
//        loadMovieNames();


//        ImageIcon img = new ImageIcon(MovieDatabase.getPoster("1300854"));
//        a1.setIcon(img);


//        buttonCancel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onCancel();
//            }
//        });



        filterRecommendationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double[] rates = new double[10];
//                System.out.println(comboBox1.getSelectedItem().toString());
                rates[0] = Double.parseDouble(comboBox1.getSelectedItem().toString());
                rates[1] = Double.parseDouble(comboBox2.getSelectedItem().toString());
                rates[2] = Double.parseDouble(comboBox3.getSelectedItem().toString());
                rates[3] = Double.parseDouble(comboBox4.getSelectedItem().toString());
                rates[4] = Double.parseDouble(comboBox5.getSelectedItem().toString());
                rates[5] = Double.parseDouble(comboBox6.getSelectedItem().toString());
                rates[6] = Double.parseDouble(comboBox7.getSelectedItem().toString());
                rates[7] = Double.parseDouble(comboBox8.getSelectedItem().toString());
                rates[8] = Double.parseDouble(comboBox9.getSelectedItem().toString());
                rates[9] = Double.parseDouble(comboBox10.getSelectedItem().toString());
                MovieRunnerSimilarRatings ref = new MovieRunnerSimilarRatings();

                ResultPage rp = new ResultPage(ref.printSimiliarRatingsByAllFilters(rates, genreField.getText(), minTextField.getText(), maxTextField.getText(), directorField.getText(), yearField.getText()));
                rp.pack();
                rp.setVisible(true);

            }
        });

//        getRecommendationsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//
//                double[] rates = new double[10];
////                System.out.println(comboBox1.getSelectedItem().toString());
//                rates[0] = Double.parseDouble(comboBox1.getSelectedItem().toString());
//                rates[1] = Double.parseDouble(comboBox2.getSelectedItem().toString());
//                rates[2] = Double.parseDouble(comboBox3.getSelectedItem().toString());
//                rates[3] = Double.parseDouble(comboBox4.getSelectedItem().toString());
//                rates[4] = Double.parseDouble(comboBox5.getSelectedItem().toString());
//                rates[5] = Double.parseDouble(comboBox6.getSelectedItem().toString());
//                rates[6] = Double.parseDouble(comboBox7.getSelectedItem().toString());
//                rates[7] = Double.parseDouble(comboBox8.getSelectedItem().toString());
//                rates[8] = Double.parseDouble(comboBox9.getSelectedItem().toString());
//                rates[9] = Double.parseDouble(comboBox10.getSelectedItem().toString());
//                MovieRunnerSimilarRatings ref = new MovieRunnerSimilarRatings();
//
//
//                ResultPage rp = new ResultPage(ref.printSimiliarRatings(rates));
//                rp.pack();
//                rp.setVisible(true);
//            }
//        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

//    public void loadMovieNames() {
//
//    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        RaterPage dialog = new RaterPage();
        dialog.pack();
        dialog.setVisible(true);
//        System.exit(0);
    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

//    private void createUIComponents() {
//        // TODO: place custom component creation code here
////        a1 = new JLabel(new ImageIcon(MovieDatabase.getPoster("1300854")));
//
//
//
////        ImageIcon img = new ImageIcon(url);
//
//    }
}
