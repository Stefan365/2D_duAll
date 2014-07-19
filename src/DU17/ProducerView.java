package DU17;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Producer view - zobrazenie stavu producenta.
 */
public class ProducerView implements Observer {

    /**
     * Label, na ktory sa zobrazuje vysledok produkcie.
     */
    public JLabel labelProd;
    
    /**
     * objekt Producer, ktory sa sleduje.
     */
    public Producer producent;

    //0. KONSTRUKTOR
    /**
     * Vytvorí novou instanci tøídy ProducerView.
     */
    public ProducerView(BlockingBuffer buffer) {
        this.producent = new Producer(buffer);
        this.labelProd = new JLabel();
        this.labelProd.setOpaque(true);
        this.labelProd.setForeground(Color.BLUE);
        this.labelProd.setHorizontalAlignment(SwingConstants.CENTER);
        //this.add(this.labelProd);
        this.producent.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object x) {
        this.nastavLabel();
        this.labelProd.repaint();
    }

    //1.
    /**
     * Nastavi Label sledovaneho producera.
     */
    private void nastavLabel() {

        final int cislo = this.producent.cislo;

        if (this.producent.zapisujemCislo == false) {
            //A. zobrazenie stavu 'Produkuji'.
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    labelProd.setBackground(Color.GREEN);
                    labelProd.setText("Produkuji: " + cislo + "");
                }
            });

        } else if (this.producent.zapisujemCislo == true) {
            //B. zobrazenie stavu 'Zapisuji'.
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    labelProd.setText("Zapisuji:  " + cislo + "");
                    labelProd.setBackground(Color.YELLOW);
                }
            });
        }
    }
}