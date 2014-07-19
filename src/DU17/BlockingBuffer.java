package DU17;

import java.util.Iterator;
import java.util.Observable;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Demonstra�n� sd�len� pam� s vyu�it�m t��dy ArrayBlockingQueue.
 */
public class BlockingBuffer extends Observable implements Buffer {

    /**
     * Instance t��dy ArrayBlockingQueue pro ulo�en� dat.
     */
    private ArrayBlockingQueue<Integer> buffer;

    //0.KONSTRUKTOR
    /**
     * Vytvo�� novou instanci t��dy BlockingBuffer.
     */
    public BlockingBuffer() {
        this.buffer = new ArrayBlockingQueue<>(6);
    }

    
    @Override
    public void set(int value) {

        try {
            // um�st� hodnotu do fronty
            // autoboxing
            // blokuje, pokud je fronta pln�
            this.buffer.put(value);

        } catch (InterruptedException e) {
            throw new RuntimeException("Nepoda�ilo se zapsat hodnotu.", e);
        }  
        this.setChanged(); 
        this.notifyObservers(); 

    }

    @Override
    public int get() {
        // pomocn� prom�nn� pro �tenou hodnotu:
        int readValue = 0;

        try {
            // �te hodnotu z fronty 
            // autounboxing
            // blokuje, pokud je fronta pr�zdn�
            readValue = this.buffer.take();

        } catch (InterruptedException e) {
            throw new RuntimeException(
                    "Nepoda�ilo se na��st hodnotu.", e);
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
