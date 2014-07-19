package DU9;

/**
 * Dynamick� struktura fronta umo��uj�c� vkl�d�n� a vyj�m�n� prvk�.
 */
public class Queue<E> {

    /**
     * Prvn� prvek ve front�.
     */
    private Item<E> head;
    /**
     * Posledn� prvek ve front�.
     */
    private Item<E> tail;

    /**
     * Jeden prvek fronty.
     */
    private static class Item<E> {

        /**
         * Data ulo�en� v tomto prvku fronty.
         */
        private E data;
        /**
         * Reference na n�sleduj�c� prvek ve front�.
         */
        private Item<E> next;

        //I.0. KONSTRUKTOR
        /**
         * Vytvo�� novou instanci prvku fronty.
         *
         * @param data data ulo�en� v nov�m prvku.
         */
        public Item(E data) {
            this.data = data;
            this.next = null;
        }

        //I.1.
        /**
         * Vr�t� data ulo�en� v tomto prvku fronty.
         *
         * @return data z tohoto prvku.
         */
        public E getData() {
            return this.data;
        }

        //I.2.
        /**
         * Vr�t� n�sleduj�c� prvek ve front�.
         *
         * @return n�sleduj�c� prvek.
         */
        public Item<E> getNext() {
            return this.next;
        }

        //I.3.
        /**
         * Nastav� n�sleduj�c� prvek ve front�.
         *
         * @param next n�sleduj�c� prvek ve front�.
         */
        public void setNext(Item<E> next) {
            this.next = next;
        }
    }

    //1.
    /**
     * Vrac� true, pokud je fronta pr�zdn�, false jinak.
     *
     * @return true, pokud je fronta pr�zdn�, false jinak.
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    //2.
    /**
     * Vlo�� prvek na konec fronty.
     *
     * @param data obsah vkl�dan�ho prvku.
     */
    public void enqueue(E data) {
        Item<E> insert = new Item<>(data);
        if (this.tail != null) {
            this.tail.setNext(insert);
            this.tail = insert;
        } else {
            this.head = insert;
            this.tail = insert;
        }
    }

    //3.
    /**
     * Vyjme prvn� prvek ze za��tku fronty.
     *
     * @return data vyj�man�ho prvku.
     * @throws IllegalStateException pokud je fronta pr�zdn�.
     */
    public E dequeue() {
        if (this.head == null) {
            throw new IllegalStateException(
                    "Nelze vybrat prvek z pr�zdn� fronty.");
        }
        E retval = this.head.getData();
        this.head = this.head.getNext();
        if (this.head == null) {
            this.tail = null;
        }
        return retval;
    }
}
