package DU12;

import java.awt.Color;
import java.util.Comparator;

/**
 * Trieda, ktora porovna 2 farby podla svetlosti.
 */
public class ColorComparator implements Comparator {

    //1.
    /**
     * Porovna 2 farby.
     *
     * @param col1 prva farba
     * @param col2 druha farba
     *
     * @return 1: prva je vacsia ako druha. -1: prva je mensia ako druha. 0:
     * prva je rovna druhej
     */
    public static int porovnajFarby(Color col1, Color col2) {

        //0. vypocet adekvatnych hodnot:
        double val1 = ColorComparator.calculateValue(col1);
        double val2 = ColorComparator.calculateValue(col2);

        if (val1 > val2) {
            return 1;
        } else if (val2 > val1) {
            return -1;
        } else {
            return 0;
        }
    }

    //2.
    /**
     * Vypocita hodnotu farby Color.
     *
     * @return hodnota farby.
     */
    private static double calculateValue(Color farba) {
        return 0.3 * farba.getRed() + 0.59 * farba.getGreen()
                + 0.11 * farba.getBlue();
    }

    @Override
    public int compare(Object barva1, Object barva2) {
        
        double d1, d2;
        //vypocet adekvatnych hodnot:
        d1 = ColorComparator.calculateValue((Color) barva1);
        d2 = ColorComparator.calculateValue((Color) barva2);
        
        if (d1 > d2) {
            return 1;
        } else if (d2 > d1) {
            return -1;
        } else {
            return 0;
        }
    }
}
