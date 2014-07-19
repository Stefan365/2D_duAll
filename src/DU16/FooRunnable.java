package DU16;

class FooRunnable implements Runnable {

    Object monitor;

    FooRunnable(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            for (long x = 1; x < 6000000000l; x++) {
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
            try {
                synchronized (monitor) {
                    monitor.wait();
                }
            } catch (InterruptedException ex) {
            }
            try {
                synchronized (monitor) {
                    monitor.wait(2000);
                }
            } catch (InterruptedException ex) {
            }
            System.out.println("Exit");
        }
    }
}
