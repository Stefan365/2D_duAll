package DU9;

/**
 * Dynamická struktura fronta umožòující vkládání a vyjímání prvkù.
 */
public class Queue<E> {

    /**
     * První prvek ve frontì.
     */
    private Item<E> head;
    /**
     * Poslední prvek ve frontì.
     */
    private Item<E> tail;

    /**
     * Jeden prvek fronty.
     */
    private static class Item<E> {

        /**
         * Data uložená v tomto prvku fronty.
         */
        private E data;
        /**
         * Reference na následující prvek ve frontì.
         */
        private Item<E> next;

        //I.0. KONSTRUKTOR
        /**
         * Vytvoøí novou instanci prvku fronty.
         *
         * @param data data uložená v novém prvku.
         */
        public Item(E data) {
            this.data = data;
            this.next = null;
        }

        //I.1.
        /**
         * Vrátí data uložená v tomto prvku fronty.
         *
         * @return data z tohoto prvku.
         */
        public E getData() {
            return this.data;
        }

        //I.2.
        /**
         * Vrátí následující prvek ve frontì.
         *
         * @return následující prvek.
         */
        public Item<E> getNext() {
            return this.next;
        }

        //I.3.
        /**
         * Nastaví následující prvek ve frontì.
         *
         * @param next následující prvek ve frontì.
         */
        public void setNext(Item<E> next) {
            this.next = next;
        }
    }

    //1.
    /**
     * Vrací true, pokud je fronta prázdná, false jinak.
     *
     * @return true, pokud je fronta prázdná, false jinak.
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    //2.
    /**
     * Vloží prvek na konec fronty.
     *
     * @param data obsah vkládaného prvku.
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
     * Vyjme první prvek ze zaèátku fronty.
     *
     * @return data vyjímaného prvku.
     * @throws IllegalStateException pokud je fronta prázdná.
     */
    public E dequeue() {
        if (this.head == null) {
            throw new IllegalStateException(
                    "Nelze vybrat prvek z prázdné fronty.");
        }
        E retval = this.head.getData();
        this.head = this.head.getNext();
        if (this.head == null) {
            this.tail = null;
        }
        return retval;
    }
}
