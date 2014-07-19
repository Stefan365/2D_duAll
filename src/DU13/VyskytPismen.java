package DU13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tøída ktera analyzuje text z jlediska pocetnosti jednotlivych pismen.
 */
public class VyskytPismen implements Comparator<Map.Entry<Character, Integer>> {

    /**
     * Formátovaný vstup z textového souboru.
     */
    public FileReader input;
    
    /**
     * Formátovaný vstup z textového souboru 2.
     */
    public BufferedReader ridr;// = new BufferedReader(this.input);
    
    /**
     * InputstreamReader obsahuje nacitany subor.
     */
    public InputStreamReader source;// = new InputStreamReader(url.openStream());
    
    /**
     * Mapa, ktora bude spocitavat pismena textu.
     */
    public Map<Character, Integer> mapa;// = new HashMap<>();

    /*
     * METODY:
     */
    //1.
    /**
     * Otevøe soubor se záznamy.
     *
     * @param s adresa suboru.
     */
    public void openFile(String s) {
        try {
            //this.input = new FileReader(new File(s));
            this.input = new FileReader(s);
            String coding = this.input.getEncoding();
            System.out.format("CODING CZ: %s %n", coding);

            try {
                this.ridr = new BufferedReader(new InputStreamReader(new FileInputStream(s), coding));
                //this.ridr = new BufferedReader(this.input);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(VyskytPismen.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Chyba otevírání souboru local TXT.");
            System.exit(1);
        }
    }

    //2.
    /**
     * Zavre soubor.
     */
    public void closeFile() {
        if (this.input != null) {
            try {
                this.input.close();
            } catch (IOException ex) {
                System.err.println("Chyba pri zatvarani suboru!");
            }
        }
    }

    //3.
    /**
     * Naèita subor z URL adresy.
     *
     * @param urlS url adresa suboru.
     */
    public void openUrl(String urlS) {
        URL url = null;
        try {
            url = new URL(urlS);

            this.source = new InputStreamReader(url.openStream());
            String coding = this.source.getEncoding();
            System.out.format("CODING EN: %s %n", coding);
            this.source = new InputStreamReader(url.openStream(), coding);
        
        } catch (MalformedURLException e) {
            System.err.println("Chyba programu: neplatné url!");
            System.exit(1);
        } catch (IOException ex) {
            throw new RuntimeException("Chyba pøi ètení dokumentu.", ex);
        } 
    }

    //4.A
    /**
     * Spocita pismena v nacitanom texte a ulozi to do mapy.
     *
     * @param reader InputStreamReader z anglickeho textu.
     */
    public void spocitajPismena(InputStreamReader reader) {
        int nacitaneCislo; //znak v podobe cisla
        char c;
        try {
            while ((nacitaneCislo = reader.read()) != -1) {
                c = (char) nacitaneCislo;
                if (Character.isLetter(c)) {
                    c = Character.toUpperCase(c);
                    this.mapa.put(c, this.mapa.get(c) + 1);
                }
            }
        } catch (IOException ex) {
            System.err.println("Chyba pri nacitani A.");
        }
    }

    //4.B.
    /**
     * Spocita pismena pre FileReader v nacitanom texte a ulozi to do mapy.
     *
     * @param reader FileReader z ceskeho textu.
     */
    public void spocitajPismenaCz(BufferedReader reader) {

        String s;
        try {
            while ((s = reader.readLine()) != null) {
                //System.out.format("PRED:%s ", s);
                s = Normalizer.normalize(s, Normalizer.Form.NFD);
                s = s.replaceAll("[^\\p{ASCII}]", "");
                //System.out.format(",PO:%s %n", s);
                for (char ch : s.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        ch = Character.toUpperCase(ch);
                        this.mapa.put(ch, this.mapa.get(ch) + 1);
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Chyba pri nacitani B.");
        }
    }
    
    //5.
    /**
     * Inicializuje Mapu pismen.
     */
    public void inicializujMapu() {
        this.mapa = new HashMap<>();

        for (int i = 65; i < 91; i++) {
            mapa.put((char) i, 0);
        }
    }

    //6.
    /**
     * Vypise top 5 vyskytov pismen.
     *
     * @param list zoradeny zoznam mapy 'pismeno-vyskyt' podla vyskytu.
     */
    public void vypisTop5(List<Map.Entry<Character, Integer>> list) {
        Iterator it = list.iterator();

        Map.Entry<Character, Integer> ent;
        System.out.format("Vyskyt pismen, Top 5:%n");

        int i = 1; //citac
        while (i < 6) {
            ent = (Map.Entry) (it.next());
            System.out.format("%d. %c : abs.vyskyt:%d, rel.vyskyt:%4.2f%% %n", i,
                    (char) (ent.getKey()),
                    (int) (ent.getValue()),
                    (double) (this.vratPocetnost((int) (ent.getValue()), list)));
            i++;
        }
    }

    //7.
    /**
     * Vrati percentualnu hodnotu vyskytu.
     *
     * @param vyskyt pocet vyskytov skumaneho pismena.
     * @param list zoznam Vstupov(Entry) do mapy: 'pismeno-vyskyt'.
     */
    public double vratPocetnost(int vyskyt,
            List<Map.Entry<Character, Integer>> list) {
        int sum = 0;

        Iterator it = list.iterator();
        Map.Entry<Character, Integer> ent;

        while (it.hasNext()) {
            ent = (Map.Entry) (it.next());
            sum += (int) (ent.getValue());
        }
        return (double) vyskyt * 100.0 / (double) sum;
    }

    @Override
    public int compare(Entry<Character, Integer> ent1,
            Entry<Character, Integer> ent2) {
        if (ent1.getValue() > ent2.getValue()) {
            return 1;
        } else if (ent2.getValue() > ent1.getValue()) {
            return -1;
        } else {
            return 0;
        }
    }
}
