package DU8;

/**
 * Uzel spojové datové struktury. Obsahuje hodnotu a referenci na další prvek ve
 * struktuøe.
 *
 * @param <F> typ prvniho prvku.
 * @param <S> typ druheho prvku.
 *
 *
 */
public class Pair<F, S> {

    /**
     * Prvy prvek v paru.
     */
    private F first;
    /**
     * Druhy prvek v paru.
     */
    private S second;

    //0. KONSTRUKTOR.
    /**
     * Vytvoøí nový pár s danou hodnotou prvého a druhého prvku.
     *
     * @param prvy hodnota prvého prvku.
     * @param druhy hodnota druhého prvku.
     */
    public Pair(F prvy, S druhy) {
        this.first = prvy;
        this.second = druhy;
    }

    //1.
    /**
     * Vrátí hodnotu prvého prvku páru.
     *
     * @return hodnotu prvního prvku páru.
     */
    public F getFirst() {
        return this.first;
    }

    //2.
    /**
     * Vrátí hodnotu druhého prvku páru.
     *
     * @return hodnotu druhého prvku páru.
     */
    public S getSecond() {
        return this.second;
    }
    
    //3.
    /**
     * Nastaví hodnotu prvého prvku páru.
     */
    public void setFirst(F prvy) {
        this.first = prvy;
    }

    //4.
    /**
     * Nastaví hodnotu druhého prvku páru.
     */
    public void setSecond(S druhy) {
        this.second = druhy;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]%n", this.getFirst(),
                this.getSecond());
    }
    
    //5.
    /**
     * Testovací metoda, ovìruje všechny metody této tøídy.
     */
    public void testPair(F prvy, S druhy){
        //testovani toString + implicitne get metod:
        System.out.format("testovany par pred:%s", this); 
        this.setFirst(prvy);
        this.setSecond(druhy);
        System.out.format("testovany par po:%s%n", this);
    }
}
