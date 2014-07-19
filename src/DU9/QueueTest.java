package DU9;

import java.util.Random;

/**
 * Testovací tøída pro tøídu Queue.
 */
public class QueueTest {

    public static void main(String[] args) {

        Random generator = new Random();

        Queue<Integer> intQueue;

        intQueue = new Queue<Integer>();

        while (true) {
            int prvek = generator.nextInt(20);
            if (prvek == 0) {
                break;
            }
            System.out.println("Vkládám: " + prvek);
            intQueue.enqueue(prvek);
        }

        System.out.println();
        System.out.println("Souèet prvkù ve frontì: ");
        int sum = 0;
        while (!intQueue.isEmpty()) {
            sum += intQueue.dequeue();
        }
        System.out.printf("%d", sum);
        System.out.println();
    }
}
