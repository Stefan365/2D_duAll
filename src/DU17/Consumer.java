package DU17;

import java.util.Observable;

/**
 * Uk�zkov� t��da konzumenta k probl�mu producent-konzument. Spotrebuvava cel�
 * ��sla, kter� vybera ze sd�len� pam�ti.
 */
public class Consumer extends Observable implements Runnable {

    /**
     * Sd�len� pam�, do kter� se ukl�daj� hodnoty.
     */
    private Buffer sharedLocation;
    
    /**
     * Cislo, ktore sa prave konzumuje.
     */
    public int cislo;
    
    
    //0.KONSTRUKTOR
    /**
     * Vytvo�� novou instanci t��dy Consumer, kter� bude vyberat data ze sd�len�
     * pam�ti shared.
     *
     * @param shared sd�len� pam�, do kter� se ukl�daj� data.
     */
    public Consumer(Buffer shared) {
        this.sharedLocation = shared;
    }

    @Override
    public void run() {

        //final String threadName = Thread.currentThread().getName();

        while (true) {
            
            this.cislo = (int) this.sharedLocation.get();
            
            //signal pre observer:
            this.setChanged(); 
            this.notifyObservers(); 

            try {
                // usp�n� na dobu zodpovedajici nactene hodnote v ms.
                Thread.sleep(cislo);
            } catch (InterruptedException e) {
            }
            //prave ho dojedol, teda nema ziadne co by jedol.
            //ale musime to dat vediet do sveta:
            this.cislo = -1;
            
            //signal pre observer:
            this.setChanged(); 
            this.notifyObservers(); 
        }
    }
}
