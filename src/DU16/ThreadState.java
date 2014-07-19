package DU16;

public class ThreadState {  
  
    public static void main(String[] args) {  
        Object monitor = new Object();  
        FooRunnable r = new FooRunnable(monitor);  
        Thread t = new Thread(r);  
        Thread.State e = t.getState();  
        //System.out.println("State = " + e);  
        t.start();  
        while (true) {  
            Thread.State e1 = t.getState();  
            if (!e1.equals(e)) {  
                e = e1;  
                System.out.println("State = " + e);  
  
                try {  
                    Thread.sleep(500);  
                } catch (InterruptedException ex) {  
                }  
            }  
            if (e.equals(Thread.State.WAITING)) {  
                synchronized (monitor) {  
                    monitor.notify();  
                }  
            }  
            if (e.equals(Thread.State.TERMINATED)) {  
                break;  
            }  
        }  
    }  
}  