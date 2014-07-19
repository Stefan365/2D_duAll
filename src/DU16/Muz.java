package DU16;

import java.util.Random;

public class Muz implements Runnable {

    /**
     * Zena1.
     */
    private Zena zena1;

    /**
     * Zena2.
     */
    private Zena zena2;
    
    /**
     * Mysleno Zenu.
     */
    private boolean mamPrvu = false;
    
    /**
     * Mysleno Zenu.
     */
    private boolean mamDruhu = false;
    
    /**
     * generator nahodnych cisel.
     */
    private Random generator = new Random();

     //0.KONSTRUKTOR
    /**
     * Vytvoøí novou instanci tøídy MUZ.
     * 
     * @param zena1 prva zena;
     * @param zena2 druha zena;
     */
    public Muz(Zena zena1, Zena zena2) {
        this.zena1 = zena1;
        this.zena2 = zena2;
    }

    @Override
    public void run() {
        //iniciacia:
        int a = generator.nextInt(2) + 1;
        this.ziskajManzelku(a);

        while (true) {
            String s = Thread.currentThread().getName();
            Thread.State state = Thread.currentThread().getState();
            System.out.println(s + " stav: " + state + " (run)");
            this.vymenManzelku();
        }
    }

    public void ziskajManzelku(int PorCislo) {

        if (PorCislo == 1) {
            this.zena1.ziskaj();
            this.mamPrvu = true;
        } else if (PorCislo == 2) {
            this.zena2.ziskaj();
            this.mamDruhu = true;
        } else {
            System.out.println("Zle si zadal, budes sa uchadzat o Zenu c.1");
            this.ziskajManzelku(1);
        }
    }

    public void vymenManzelku() {

        //tento nespravny sposob vymeny zaruci, 
        //ze sa to casom kousne.
        //Bezkonfliktny sposob vymeny by bol keby zenu, ktoru ma najprv uvolnil
        //a az potom chcel ziskat druhu. 
        
        //tento kod neosetruje logicky (resp. osetruje nahodne)
        //stav, ked ma 2 zeny, nicmene zadaniu ulohy sa to neprieci.
        if (this.mamPrvu == true) {
            this.zena2.ziskaj();
            this.mamDruhu = true;
            this.zena1.odvrhni();
            this.mamPrvu = false;
        } else if (this.mamDruhu == true) {
            this.zena1.ziskaj();
            this.mamPrvu = true;
            this.zena2.odvrhni();
            this.mamDruhu = false;
        } else {
            //najdi si niekoho:
            System.out.println("Nemas nikoho, jak chces niekoho vymenit?");
            int a = generator.nextInt(2) + 1;
            this.ziskajManzelku(a);
        }
    }
}