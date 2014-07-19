package DU17;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Consumer view - zobrazenie stavu Konzumenta.
 */
public class ConsumerView implements Observer {

    /**
     * Consumer, ktory sa sleduje.
     */
    public Consumer konzument;
    
    /**
     * Label, na ktory sa zobrazuje priebeh konzumentacie.
     */
    public JLabel labelKonzum;

    //0. KONSTRUKTOR
    /**
     * Vytvorí novou instanci tøídy ConsumerView.
     */
    public ConsumerView(BlockingBuffer buffer) {
        this.konzument = new Consumer(buffer);
        this.labelKonzum = new JLabel();
        this.labelKonzum.setOpaque(true);
        this.labelKonzum.setForeground(Color.BLUE);
        this.labelKonzum.setHorizontalAlignment(SwingConstants.CENTER);
        //this.add(this.labelKonzum);
        this.konzument.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object x) {
        this.nastavLabel();
        this.labelKonzum.repaint();
    }

    private void nastavLabel() {
        final int cislo = this.konzument.cislo;
        if (cislo == -1) {
            //A. zobrazenie stavu 'Nacitavam'.
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    labelKonzum.setText("Nacitavam cislo");
                    labelKonzum.setBackground(Color.YELLOW);
                }
            });
        } else {
           //B. zobrazenie stavu 'Konzumuji'.
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    labelKonzum.setText("Konzumuji: " + cislo + "");
                    labelKonzum.setBackground(Color.GREEN);
                }
            });
        }
    }
}
