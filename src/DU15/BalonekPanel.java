package DU15;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;


/**
 * Panel, v ktorom lietaju balonky.
 */
public class BalonekPanel extends JPanel implements MouseListener {

    /**
     * List obsahujuci balonky.
     */
     private List<Balonek> balonky = new ArrayList();
     
     /**
      * sirka panelu.
      */
     private int sirka_panelu;
    
     /**
      * vyska panelu.
      */
     private int vyska_panelu;
    
    
    // 0.A Konstruktor.
    /**
     * Vytvori panel, zadanych rozmerov.
     *
     */
    public BalonekPanel(int sizeW, int sizeH) {
        this.setBackground(Color.WHITE);
        this.sirka_panelu = sizeW;
        this.vyska_panelu = sizeH;
        this.setPreferredSize(new Dimension(sizeW, sizeH));
    }

    @Override
    protected void paintComponent(Graphics g) {
        // prekresli nanovo pozadí:
        super.paintComponent(g);

        //vykreslenie balonkov:
        Iterator it = this.balonky.iterator();
        while (it.hasNext()) {
            ((Balonek) it.next()).paint(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.balonky.add(new Balonek(new Point(x, y), this.sirka_panelu, this.vyska_panelu));
        //Spustenie v sprave SPRAVCE:
        Balonek.SPRAVCE.execute((Balonek) this.balonky.get(this.balonky.size() - 1));
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
    
    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
