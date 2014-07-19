package DU16;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Zena {

    /**
     * Priznak volnosti zeny 1.
     */
    private boolean volna = true;
    
    /**
     * Zamek aplikace pro predavani slova druhemu vlaknu Muze.
     */
    private Lock zamek = new ReentrantLock();
    
    /**
     * Podminkova premenna 1.
     */
    private Condition somVolna = zamek.newCondition();
    
    /**
     * Podminkova premenna 2.
     */
    private Condition somObsadena = zamek.newCondition();
    
    /**
     * generator nahodnych cisel.
     */
    private Random generator = new Random();
    
    /**
     * Meno zeny.
     */
    private String name;

    //0.KONSTRUKTOR
    /**
     * Vytvoøí novou instanci tøídy Zena.
     * 
     * @param meno meno zeny;
     */
    public Zena(String meno){
        this.name = meno;
    } 

    //1.
    /**
     * Vola muz, aby ziskal zenu.
     * 
     */
    public void ziskaj() {
        zamek.lock();
        try {
            String s = Thread.currentThread().getName();
            Thread.State state = Thread.currentThread().getState();
            
            while (this.volna == false) {
                System.out.println(s + " stav: " + state + ": caka sa na "
                        + "uvolnenie Zeny " + this.name);
                this.somVolna.await();
            }
            System.out.println(s + " stav: " + state + ": 'Ziskal som ta, " 
                    + this.name + "!'");
            this.volna = false;

            //uziju si:
            //System.out.println(s + ": si teraz uziva s " + this.name);
            Thread.sleep(generator.nextInt(1000) + 500);

            //toto je zbytocne, viz. nize.
            this.somObsadena.signal();
            
        } catch (InterruptedException ex) {
            System.err.println(ex);
        } finally {
            zamek.unlock();
        }
    }

    public void odvrhni() {
        
        zamek.lock();

        try {
            String s = Thread.currentThread().getName();
            Thread.State state = Thread.currentThread().getState();
            //toto je tu zbytocne, pretoze je to osetrene tym, kedy sa to vola.
            while (this.volna == true) {
                System.out.println(s + " stav: " + state 
                        + ": caka sa na obsadenie" + this.name);
                somObsadena.await();
            }

            System.out.println(s + " stav: " + state + ": 'Odvrhol som ta, " 
                    + this.name);
            this.volna = true;

            //uzije si oddychu:
            //System.out.println(s + ": oddychuje osamote..");
            Thread.sleep(generator.nextInt(1000) + 500);

            this.somVolna.signal();
            
        } catch (InterruptedException ex) {
            System.err.println(ex);
        } finally {
            zamek.unlock();
        }
    }
}
 