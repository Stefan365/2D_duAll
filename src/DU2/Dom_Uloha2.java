/**
 * 2Dom_Uloha2
 *
 * @autor Stefan Veres, 2D, LS
 */
package DU2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dom_Uloha2 {

    //Hlavni
    public static void main(String[] args) {

        //String[] directories = Dom_Uloha2.read();
        if (checkPaths1(args)) {
            if (Dom_Uloha2.checkPaths2(args)) {

                List<File> d = Dom_Uloha2.analyzeContent(args);
                System.out.format("%nRovnake subory:%n");
                //System.out.println("dlzka: " + directories.length);
                for (File f : d) {
                    System.out.println(f.getName());
                }
            }
        }
        System.out.format("%nKONIEC PROGRAMU!%n");
    }

    //1.
    /**
     * Naète z uživatelského rozhraní cesty ke 2 adresáøum.
     *
     * @return naètený záznam 2 cest.
     */
    public static String[] read() {
        Scanner input = new Scanner(System.in);
        String cesty[] = new String[2];

        System.out.print("zadaj cestu 1. adresaru: ");
        cesty[0] = input.nextLine();

        System.out.print("zadaj cestu 2. adresaru: ");
        cesty[1] = input.nextLine();

        return cesty;
    }

    //2.
    /**
     * Zanalyzuje obsah dvoch suborov.
     *
     * @return zoznam suborov, ktoré sú identické.
     */
    public static List<File> analyzeContent(String[] paths) {
        File dir1 = new File(paths[0]);
        File dir2 = new File(paths[1]);
        
        List<File> konecnyZoznam = new ArrayList<>();

        for (File f1 : dir1.listFiles()) {
            for (File f2 : dir2.listFiles()) {
                if ((f1.getName().equals(f2.getName()))
                        && (f1.length() == f2.length())) {
                    konecnyZoznam.add(f1);
                }
            }
        }
        return konecnyZoznam;
    }

    //3.
    /**
     * Zkontroluje jestli vstup od užívatele vyhovuje zadání, tj jsou to cesty k
     * adresáøum.
     *
     * @return vyhovuje(true)/nevyhovuje(false).
     */
    public static boolean checkPaths2(String[] paths) {

        File dir1 = new File(paths[0]);
        File dir2 = new File(paths[1]);

        if (dir1.isDirectory() && dir2.isDirectory()) {
            return true; //jenom kdyz jsou oba typu 'directory'
        } else {
            System.err.println("Zadaj prosim iba take cesty, "
                    + "ktore predstavuju adresar!");
            return false;
        }
    }

    //4.
    /**
     * Zkontroluje jestli vstup úplný, tj aspoò dva údaje.
     *
     * @return vyhovuje(true)/nevyhovuje(false).
     */
    public static boolean checkPaths1(String[] paths) {
        if (paths.length < 2 || (paths[1] == null || paths[0] == null)) {
            System.err.println("Zadaj prosim oba vstupne udaje!");
            return false;
        } else {
            return true; //jenom kdyz jsou oba nenulové øetìzce
        }
    }
}
