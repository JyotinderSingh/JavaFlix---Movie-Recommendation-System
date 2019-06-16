import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ResultPage extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    ArrayList<Rating> recommendations;

    public ResultPage(ArrayList<Rating> recommendationsparam) {



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

        recommendations = recommendationsparam;

//        JScrollPane scroll1 = new JScrollPane (textArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        JScrollPane scroll2 = new JScrollPane (textArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        JScrollPane scroll3 = new JScrollPane (textArea3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        JScrollPane scroll4 = new JScrollPane (textArea4, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//
//        add(scroll1);
//        add(scroll2);
//        add(scroll3);
//        add(scroll4);


        textArea1.setText("");
        textArea2.setText("");
        textArea3.setText("");
        textArea4.setText("");
        for(Rating rating : recommendations) {
            textArea1.setText(textArea1.getText() + MovieDatabase.getTitle(rating.getItem()) + "\n\n");
            textArea2.setText(textArea2.getText() + MovieDatabase.getYear(rating.getItem()) + "\n\n");
            textArea3.setText(textArea3.getText() + MovieDatabase.getDirector(rating.getItem()) + "\n\n");
            textArea4.setText(textArea4.getText() + MovieDatabase.getGenres(rating.getItem()) + "\n\n");
        }

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

//    public static void main(String[] args) {
//        ResultPage dialog = new ResultPage();
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
//    }
}
