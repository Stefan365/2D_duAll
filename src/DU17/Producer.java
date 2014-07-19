package DU17;

import java.awt.Color;
import java.util.Observable;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Uk�zkov� t��da producenta k probl�mu producent-konzument. Generuje cel�
 * ��sla, kter� ukl�d� do sd�len� pam�ti. Z�rove� po��t� sou�et generovan�ch
 * ��sel.
 */
public class Producer extends Observable implements Runnable {

    /**
     * Gener�tor n�hodn�ch ��sel.
     */
    private static Random generator = new Random();

    /**
     * Sd�len� pam�, do kter� se ukl�daj� hodnoty.
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
     * Vytvo�� novou instanci t��dy Producer, kter� bude generovan� data ukl�dat
     * do sd�len� pam�ti shared.
     *
     * @param shared sd�len� pam�, do kter� se ukl�daj� data.
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
                // usp�n� na n�hodnou dobu od 2 do 5 sekund
                Thread.sleep(generator.nextInt(3000) + 2000);
            } catch (InterruptedException e) {
                System.err.println(e + "Nepodarilo sa uspat vlakno");
            }
            this.zapisujemCislo = true;

            //signal pre observer:
            this.setChanged(); 
            this.notifyObservers(); 

            // ulo�en� hodnoty do bufferu. Pokud s tim budou problemy 
            //(teda z dvovodu vlastnosti ArrayBlockingQueue) o to dlhsie 
            // bude trvat zobrazenie B.
            this.sharedLocation.set(this.cislo);
        }
    }
}
