package DU17;

import java.util.Iterator;
import java.util.Observable;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Demonstraèní sdílená pamì s vyuitím tøídy ArrayBlockingQueue.
 */
public class BlockingBuffer extends Observable implements Buffer {

    /**
     * Instance tøídy ArrayBlockingQueue pro uloení dat.
     */
    private ArrayBlockingQueue<Integer> buffer;

    //0.KONSTRUKTOR
    /**
     * Vytvoøí novou instanci tøídy BlockingBuffer.
     */
    public BlockingBuffer() {
        this.buffer = new ArrayBlockingQueue<>(6);
    }

    
    @Override
    public void set(int value) {

        try {
            // umístí hodnotu do fronty
            // autoboxing
            // blokuje, pokud je fronta plná
            this.buffer.put(value);

        } catch (InterruptedException e) {
            throw new RuntimeException("Nepodaøilo se zapsat hodnotu.", e);
        }  
        this.setChanged(); 
        this.notifyObservers(); 

    }

    @Override
    public int get() {
        // pomocná promìnná pro ètenou hodnotu:
        int readValue = 0;

        try {
            // ète hodnotu z fronty 
            // autounboxing
            // blokuje, pokud je fronta prázdná
            readValue = this.buffer.take();

        } catch (InterruptedException e) {
            throw new RuntimeException(
                    "Nepodaøilo se naèíst hodnotu.", e);
        }
        
        //signal pre observer:
        this.setChanged(); 
        this.notifyObservers(); 

        return readValue;
    }

    public int[] vratAktualnyZoznam() {
        int[] kopia = new int[6];

        Iterator itr = this.buffer.iterator();
        for (int i = 5; i >= 0; i--) {
            if (itr.hasNext()) {
                kopia[i] = (int) (itr.next());
            } else {
                kopia[i] = -1;
            }
        }
        return kopia;
    }
}
