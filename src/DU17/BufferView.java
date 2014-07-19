package DU17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Buffer view - zobrazenie stavu Bufferu.
 */
public final class BufferView extends JPanel implements Observer {

    
    /**
     * Spolecny buffer, ktory sa monitoruje.
     */
    public BlockingBuffer buffer;

    /**
     * pole JLabel pro zobrazování položek bufferu.
     */
    private JLabel[] zoznamLab;

    //0. KONSTRUKTOR
    /**
     * VytvoØí novou instanci tøídy BufferView.
     */
    public BufferView(BlockingBuffer buffer) {
        this.buffer = buffer;
        this.zoznamLab = new JLabel[6];
        this.initLab();
        this.obnovLabels();
        
        this.setLayout(new GridLayout(1, 6, 1, 1));
        //vlozi labely do JPanelu:
        for (int i = 0; i < this.zoznamLab.length; i++) {
            this.add(this.zoznamLab[i]);
        }
        this.buffer.addObserver(this);
    }
    
    public void repaint(Graphics g){
        //((Graphics2D) g).rotate(Math.PI / 2);
    }
   

    @Override
    public void update(Observable obs, Object x) {
        this.obnovLabels();
        this.repaint();
    }

    //2.
    /**
     * Nakrm zoznam labels, ktore zobrazuju stav bufferu.
     */
    public final void obnovLabels() {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int c;
                int[] zoznam = buffer.vratAktualnyZoznam();
                int len = zoznam.length;
                
                for (int i = 0; i < len; i++) {
                    c = zoznam[i];
                    zoznamLab[i].setText("" + c + "");
                    zoznamLab[i].setBackground(c == -1 ? Color.BLUE : Color.WHITE);
                }
            }
        });
    }
    
    //3.
    /**
     * Init zoznam Labels.
     */
    public final void initLab() {
        for (int i = 0; i < this.zoznamLab.length; i++){
            this.zoznamLab[i] = new JLabel();
            this.zoznamLab[i].setOpaque(true);
            this.zoznamLab[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
    }
}
