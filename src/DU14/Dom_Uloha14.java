package DU14;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Stefan
 */
public class Dom_Uloha14 {

    /**
     * Zoznam prvocinitelov:
     */
    private Set<Integer> zoznamUnPrv;
    /**
     * Zoznam prvocinitelov:
     */
    private int vysetrovaneCislo;

    /**
     * Hlavni.
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int n0 = Dom_Uloha14.ctiCislo();

        Dom_Uloha14 case1 = new Dom_Uloha14(n0);
        case1.setZoznamUnPrv();
        System.out.format("%s", case1);

        //testovanie, jestli bylo prvocislom:
        if (case1.zoznamUnPrv.contains(n0)) {
            System.out.println("Zadane cislo bolo PRVOCISLOM!");
        }
    }

    /* METODY: */
    //0.A KONSTRUKTOR
    /**
     * Vytvori instanciu.
     *
     * @param n vysetrovane cislo
     */
    public Dom_Uloha14(int n) {
        this.vysetrovaneCislo = n;
        //this.setZoznamPrv();
    }

    //2.
    /**
     * nastavi vnutorny zoznam unikatnych prvocinitelov.
     */
    public final void setZoznamUnPrv() {
        this.zoznamUnPrv = new TreeSet<Integer>();

        int n = this.vysetrovaneCislo; //inicializacia
        for (int i = 2; i <= (int) (Math.sqrt(this.vysetrovaneCislo)); i++) {

            if (n % i == 0) {
                this.zoznamUnPrv.add(i);
                n = n / i;
            }
            while (n % i == 0) {
                n = n / i;
            }
        }
        if (n != 1) {
            this.zoznamUnPrv.add(n);
        }
    }

    //3.
    /**
     * Naèíta èíslo
     *
     * @return naèítané èíslo
     */
    public static int ctiCislo() {
        Scanner sc = new Scanner(System.in);
        int i;
        try {
            System.out.println("Zadaj kladne cele cislo n: ");
            i = sc.nextInt();
            sc.nextLine(); //vypláchnutie bufferu
            return i;
        } catch (Exception e) {
            System.out.println("chyba pri nacitani cisla");
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder vystup = new StringBuilder();

        Iterator it = this.zoznamUnPrv.iterator();

        vystup.append(String.format("Unikatne prvocinitele cisla %d su: ",
                this.vysetrovaneCislo));
        while (it.hasNext()) {
            vystup.append(it.next());
            vystup.append(", ");
        }
        //odstranenie poslednej oddelovacej ciarky:
        vystup.replace(vystup.length() - 2, vystup.length(), String.format("%n"));
        return vystup.toString();
    }
}
