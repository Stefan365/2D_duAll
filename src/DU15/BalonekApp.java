package DU15;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Vykresli hlavny frame s farebnymi obdlznikmi, Sposob 2.
 */
final public class BalonekApp {

    /*
     * Hlavna
     */
    public static void main(String[] args) {

        final BalonekPanel panel1 = new BalonekPanel(350, 400);
        final BalonekPanel panel2 = new BalonekPanel(600, 400);
        panel1.addMouseListener(panel1);
        panel2.addMouseListener(panel2);
        
        //nastavenie layoutu:
        JFrame frame = new JFrame("Lietajuce Balonky");
        frame.setLayout(new FlowLayout());
        frame.add(panel1);
        frame.add(panel2);
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //Spustanie timeru:
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                panel1.repaint();
                panel2.repaint();
            }
        };
        Timer displayTimer = new Timer(10, listener);
        displayTimer.start();
    }
}
