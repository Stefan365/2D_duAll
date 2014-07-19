/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DU13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Stefan
 */
public class Dom_Uloha13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ceskyText = "ceskyText.txt"; 
        //"http://download.csip.eu/_mxfb/gnu-gpl-cz.txt" //- nefunguje;
        
        String engText = "http://www.gnu.org/licenses/old-licenses/gpl-2.0.txt";

        VyskytPismen vyskyt = new VyskytPismen();

        //1. Nacitanie a spracovanie 1. suboru: 
        vyskyt.openUrl(engText);
        vyskyt.inicializujMapu();
        vyskyt.spocitajPismena(vyskyt.source);
        Map<Character, Integer> mapa1 = vyskyt.mapa;

        //2. Nacitanie a spracovanie 2. suboru, s ceskym jazykom,
        //pretoze url odkaz nefunguje: 
        vyskyt.openFile(ceskyText);
        vyskyt.inicializujMapu();
        vyskyt.spocitajPismenaCz(vyskyt.ridr);
        Map<Character, Integer> mapa2 = vyskyt.mapa;
        vyskyt.closeFile();

        List<Map.Entry<Character, Integer>> list1 = new ArrayList<>();
        List<Map.Entry<Character, Integer>> list2 = new ArrayList<>();

        list1.addAll(mapa1.entrySet());
        list2.addAll(mapa2.entrySet());

        Collections.sort(list1, vyskyt);
        Collections.reverse(list1);
        Collections.sort(list2, vyskyt);
        Collections.reverse(list2);
        
        System.out.format("Anglicky text:%n");
        vyskyt.vypisTop5(list1);
        System.out.format("%nCesky text:%n");
        vyskyt.vypisTop5(list2);
    }
}
