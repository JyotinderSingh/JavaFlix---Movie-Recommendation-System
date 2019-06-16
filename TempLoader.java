import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempLoader extends JDialog {
    private JPanel contentPane;
    private JButton RUNButton;
    private JButton buttonOK;


    public TempLoader() {

        try {
            String laf = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(laf);
        }
        catch(Exception e) {
            System.out.println("Error in initializing UI");
        }

        // Centring the window///////////////
        Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        Dimension windowSize = new Dimension(getPreferredSize());
        int wdwLeft = screenSize.width / 2 - windowSize.width / 2;
        int wdwTop = screenSize.height / 2 - windowSize.height / 2;
        pack();
        setLocation(wdwLeft, wdwTop);
        ///////////////////////////////////////


        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);



        RUNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                contentPane.setVisible(false);
                dispose();
                RaterPage ref = new RaterPage();
                ref.pack();
                ref.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        TempLoader dialog = new TempLoader();
        dialog.pack();
        dialog.setVisible(true);

//        System.exit(0);
    }
}
