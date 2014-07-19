package DU11;

import DU10.VelkeCislo;

/**
 * @author Stefan
 */
public class Dom_Uloha11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 33;
        VelkeCislo fakN;
        Faktorial fak = new Faktorial();
        
        do {
            fakN = fak.faktorial(n);
            System.out.format("Faktorial cisla %d je: %s%n", n, fakN);
            n = Faktorial.ctiCislo();
        } while (n != -1);
    }   
}
