package DU17;

import java.awt.Color;
import java.util.Observable;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Ukázková tøída producenta k problému producent-konzument. Generuje celá
 * èísla, která ukládá do sdílené pamìti. Zároveò poèítá souèet generovanıch
 * èísel.
 */
public class Producer extends Observable implements Runnable {

    /**
     * Generátor náhodnıch èísel.
     */
    private static Random generator = new Random();

    /**
     * Sdílená pamì, do které se ukládají hodnoty.
     */
    private Buffer sharedLocation;
    
    /**
     * Cislo, ktore sa prave konzumuje.
     */
    public int cislo;
    
    /**
     * zapisujem cislo?.
     */
    public boolean zapisujemCislo = false;
    
    //0.KONSTRUKTOR
    /**
     * Vytvoøí novou instanci tøídy Producer, která bude generovaná data ukládat
     * do sdílené pamìti shared.
     *
     * @param shared sdílená pamì, do které se ukládají data.
     */
    public Producer(Buffer shared) {
        this.sharedLocation = shared;
    }

    @Override
    public void run() {
        
        while (true) {
            //generovany produkt:
            this.cislo = generator.nextInt(5000) + 1000;
            this.zapisujemCislo = false;
            
            //signal pre observer:
            this.setChanged(); 
            this.notifyObservers(); 

            try {
                // uspání na náhodnou dobu od 2 do 5 sekund
                Thread.sleep(generator.nextInt(3000) + 2000);
            } catch (InterruptedException e) {
                System.err.println(e + "Nepodarilo sa uspat vlakno");
            }
            this.zapisujemCislo = true;

            //signal pre observer:
            this.setChanged(); 
            this.notifyObservers(); 

            // uloení hodnoty do bufferu. Pokud s tim budou problemy 
            //(teda z dvovodu vlastnosti ArrayBlockingQueue) o to dlhsie 
            // bude trvat zobrazenie B.
            this.sharedLocation.set(this.cislo);
        }
    }
}
