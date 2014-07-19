package DU16;

/**
 * Simulacia partnerskych vztahov v patriarchalnej spolecnosti. konkretne 2
 * (pripaden viacerych) muzov o 2 zeny. Pricom, muz po urcitom case ma snahu
 * zenu vymenit. Vedlajsou ulohou je nasimulovat situaciu, ked 
 * nastane 'deadlock'.
 */
public class Dom_Uloha16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zena zena1 = new Zena("Anca");
        Zena zena2 = new Zena("Katka");

        Muz muz1 = new Muz(zena1, zena2);
        Muz muz2 = new Muz(zena1, zena2);

        //kvuli sledovani stavu:
        final Thread t1 = new Thread(muz1);
        final Thread t2 = new Thread(muz2);

        //ExecutorService app = Executors.newFixedThreadPool(2);
        try {
            t1.start();
            t2.start();
            //app.execute(t1);
            //app.execute(t2);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            //app.shutdown();
        }
        
        //vykreslovanie stavov spustenych vlakien.
        //pozn. pokud jsem to spustil cez app.execute(t1), 
        //tak vlakna nebylo mozno timto spusobem sledovat - proc?
        while (true) {
            Thread.State e1 = t1.getState();
            Thread.State e2 = t2.getState();
            String s1 = t1.getName();
            String s2 = t2.getName();

            System.out.format("%s:%s, %s:%s%n", s1, e1, s2, e2);
            //uspani vlakna main:
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
            }
        }
    }
}
