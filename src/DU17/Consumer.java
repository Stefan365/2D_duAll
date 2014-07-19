package DU17;

import java.util.Observable;

/**
 * Ukázková tøída konzumenta k problému producent-konzument. Spotrebuvava celá
 * èísla, která vybera ze sdílené pamìti.
 */
public class Consumer extends Observable implements Runnable {

    /**
     * Sdílená pamì, do které se ukládají hodnoty.
     */
    private Buffer sharedLocation;
    
    /**
     * Cislo, ktore sa prave konzumuje.
     */
    public int cislo;
    
    
    //0.KONSTRUKTOR
    /**
     * Vytvoøí novou instanci tøídy Consumer, která bude vyberat data ze sdílené
     * pamìti shared.
     *
     * @param shared sdílená pamì, do které se ukládají data.
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
                // uspání na dobu zodpovedajici nactene hodnote v ms.
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
