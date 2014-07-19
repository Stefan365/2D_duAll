package DU12;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Panel, který kresli farebne pruzky.
 */
public class MyPanelA extends JPanel {


    // 0.A Konstruktor.
    /**
     * Vytvori panel, zadanych rozmerov.
     *
     * @param sizeA kratsia strana obdlznika
     * @param sizeB dlhsia strana obdlznika
     * @param farba farba panelu
     */
    public MyPanelA(int sizeA, int sizeB, MyColor farba) {
        this.setBackground(farba);        //toto je farba panelu:
        this.setPreferredSize(new Dimension(sizeA, sizeB));
    }

    // 0.B Konstruktor.
    /**
     * Vytvori panel, standardnych rozmerov.
     *
     * @param farba farba panelu
     */
     public MyPanelA(MyColor farba) {
        this.setBackground(farba);
        this.setPreferredSize(new Dimension(40, 200));
    }

    @Override
    protected void paintComponent(Graphics g) {
        // vykreslí pozadí
        super.paintComponent(g);
    }
}
