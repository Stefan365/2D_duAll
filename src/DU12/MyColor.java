package DU12;

import java.awt.Color;

/**
 * @author Stefan
 */
/**
 * Trieda predstavujuca barvu.
 */
public class MyColor extends Color implements Comparable {

    /**
     * hodnota farby.
     */
    private double value;

    //0.A KONSTRUKTOR
    /**
     * Vytvori farbu Color.
     *
     * @param r red.
     * @param g green.
     * @param b blue.
     */
    public MyColor(int r, int g, int b) {
        super(r, g, b);

        this.value = 6;
        //super(3, 4, 5);
    }

    //0.B KONSTRUKTOR
    /**
     * Vytvori farbu Color, aj bez parametrov.
     */
    public MyColor() {
        this(0, 0, 0);
    }
    
    //1. vypocita hodnotu danej farby
    /**
     * Vypocita hodnotu farby MyColor.
     */
    private double calculateValue() {
        return 0.3 * this.getRed() + 0.59 * this.getGreen() 
                + 0.11 * this.getBlue();
    }

    @Override
    public int compareTo(Object barva2) {

        //0. vypocet adekvatnych hodnot:
        this.value = this.calculateValue();
        ((MyColor) barva2).value = ((MyColor) barva2).calculateValue();

        if (this.value > ((MyColor) barva2).value) {
            return 1;
        } else if (((MyColor) barva2).value > this.value) {
            return -1;
        } else {
            return 0;
        }
    }
}
