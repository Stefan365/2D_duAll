package DU11;

import DU10.VelkeCislo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Stefan
 */
public class Faktorial {

    /**
     * Zoznam faktorialov cisla n.
     */
    private static List<VelkeCislo> faktorialy = new ArrayList<>();
    
    //1.
    /**
     * vypocita faktorial cisla N.
     *
     * @param n cislo n.
     * @return faktorial cisla n.
     */
    public VelkeCislo faktorial(int n) {

        //0. skontroluje, jestli ho jiz nepozna.
        if (n + 1 >= Faktorial.faktorialy.size()) {
            this.nakrmZoznamFakt(n);
        }
        return Faktorial.faktorialy.get(n);
    }

    //2.
    /**
     * Krmi zoznam faktorialov.
     *
     * @param n nakrmi ho az do cisla n.
     */
    private void nakrmZoznamFakt(int n) {
        
        int s = Faktorial.faktorialy.size(); //velkost zoznamu faktorialov
        
        //0. druha kontrola:. sem by sa nemal nikdy dostat.
        if (s >= n + 1) {
            System.out.format("Tuto hodnotu uz v zozname mas!%n");
            return;
        }
        
        //teraz, ked vie, ze 'n' je vacsie ako velkost zoznamu 
        //faktorialov, ktory si pamata, pokracuje tam, kde skoncil,
        //teda od 's' az po 'n'. Je to dane tym, ze poloha v zozname koreluje 
        //s cislom, faktorial ktoreho je hodotou na danom mieste.
        for (int i = s; i <= n; i++) {
            
            //pre zarodocne stavy zoznamu faktorialov:
            if (i == 0 || i == 1) {
                Faktorial.faktorialy.add(new VelkeCislo(1));
            } else if (i == 2) {
                Faktorial.faktorialy.add(new VelkeCislo(2));
            //pre ostatne:
            } else {
                VelkeCislo novyFakt;
                novyFakt = (Faktorial.faktorialy.get(i - 1)).vynasob(new VelkeCislo(i));
                Faktorial.faktorialy.add(novyFakt);
            }
        }
    }

    //3.
    /**
     * Nacitanie vstupneho cisla.
     *
     * @return nacitane cislo.
     */
    public static int ctiCislo() {
        System.out.println("Zadaj cislo, faktorial ktoreho chces vypocitat. "
                + "(ak chces smycku ukoncit, zadaj -1):");
        Scanner sc = new Scanner(System.in);
        int c;
        try {
            c = sc.nextInt();
            return c;
        } catch (Exception e) {
            System.err.println("chyba pri nacitani ZNAKU");
            return 0;
        }
    }
}
