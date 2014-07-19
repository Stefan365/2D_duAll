package DU7;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author Stefan
 */
public class Dom_Uloha7 {

    /**
     * webovska adresa naèítaného souboru.
     */
    public static String meteoAddr =
            "http://meteo.arso.gov.si/uploads/probase/www/observ/surface/text/en/observation_eu_latest.xml";

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //0. Nacitanie min. teploty, spodnej hranice podla zadania.
        int minTep = Dom_Uloha7.vstup();
        
        //1. nacitanie Meteo web adresy:
        URL url = null;
        try {
            url = new URL(meteoAddr);
        } catch (MalformedURLException e) {
            System.out.println("2. som tu");
            System.err.println("Chyba programu: neplatné url!");
            System.exit(1);
        }

        //2. Pouzitie XML souboru 
        MeteoRecordHandler handler = new MeteoRecordHandler();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);

            InputSource source = new InputSource(url.openStream());
            // nastavení cesty, kde se hledají system DTD kvùli odkazu na DTD z XML
            // souboru
            
            source.setSystemId(url.getPath());
            reader.parse(source);
            //System.out.printf("CESTA: %s%n", url.getPath());

        } catch (SAXException ex) {
            throw new RuntimeException("Chyba syntaxe dokumentu.", ex);
        } catch (IOException ex) {
            throw new RuntimeException("Chyba pøi ètení dokumentu.", ex);
        }

        // konecny vypis:
        List<MeteoZaznam> list = handler.getMeteoRecords();
        int i = 1; //citac
        System.out.printf("Na tycho miestach je v case %s, teplota"
                + " rovnaka, alebo vyssia ako: %d°C.%n%n", list.get(0).getDatum(), minTep); 
        for (MeteoZaznam zaznam : list) {
            if (zaznam.getTeplotu() >= minTep){
                //System.out.printf("%s", zaznam);
                System.out.printf("%d. %s", i, zaznam);
                i++;
            }
        }
    }
    
    //1.
    /**
     * Vrátí nacitanu hodnotu teploty z klavesnice.
     *
     * @return teplota v °C.
     */
    public static int vstup() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Zadaj prosim teplotu: %n");
        return sc.nextInt();
    }
}
