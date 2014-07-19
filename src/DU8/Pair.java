package DU8;

/**
 * Uzel spojov� datov� struktury. Obsahuje hodnotu a referenci na dal�� prvek ve
 * struktu�e.
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
     * Vytvo�� nov� p�r s danou hodnotou prv�ho a druh�ho prvku.
     *
     * @param prvy hodnota prv�ho prvku.
     * @param druhy hodnota druh�ho prvku.
     */
    public Pair(F prvy, S druhy) {
        this.first = prvy;
        this.second = druhy;
    }

    //1.
    /**
     * Vr�t� hodnotu prv�ho prvku p�ru.
     *
     * @return hodnotu prvn�ho prvku p�ru.
     */
    public F getFirst() {
        return this.first;
    }

    //2.
    /**
     * Vr�t� hodnotu druh�ho prvku p�ru.
     *
     * @return hodnotu druh�ho prvku p�ru.
     */
    public S getSecond() {
        return this.second;
    }
    
    //3.
    /**
     * Nastav� hodnotu prv�ho prvku p�ru.
     */
    public void setFirst(F prvy) {
        this.first = prvy;
    }

    //4.
    /**
     * Nastav� hodnotu druh�ho prvku p�ru.
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
     * Testovac� metoda, ov�ruje v�echny metody t�to t��dy.
     */
    public void testPair(F prvy, S druhy){
        //testovani toString + implicitne get metod:
        System.out.format("testovany par pred:%s", this); 
        this.setFirst(prvy);
        this.setSecond(druhy);
        System.out.format("testovany par po:%s%n", this);
    }
}
