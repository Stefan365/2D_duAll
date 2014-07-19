package DU15;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Trida predstavujici balonek.
 */
public class Balonek implements Runnable {


    /**
     * stred vytv·¯enÈho balonku.
     */
    private Point stred;
    
    /**
     * kruh zodpovedajici vytv·¯enÈmu balonku.
     */
    private Circle circle;
    
    /**
     * farba - farba balonku.
     */
    private Color farba;
    
    /**
     * vektor rychlosti balonku.
     */
    private Velocity rychlost;
    
    /**
     * sirka panelu v ktorom lieta balonek.
     */
    private int sirka_p;
    
    /**
     * vyska panelu v ktorom lieta balonek.
     */
    private int vyska_p;
    
    /**
     * Ekvivalent odmocniny 'rovinnej' hybnosti, rovnake pro vsechny balonky.
     */
    private static double H = 100; 
    
    /**
     * Spravca vlakien.
     */
    public static ExecutorService SPRAVCE = Executors.newCachedThreadPool();
    
    /**
     * Perioda na uspanie vlakien v milisec.
     */
    private static final int ZASTAV = 10;  
    
    private static Random random = new Random();
    /*
     * METODY:
     */

    //0. Konstruktor 
    /**
     * Vytvo¯Ì nov˝ balonek se zadan˝m stÿedem, n·hodnÏ vygenerovan˝m polomÏrem,
     * barvou a rychlosti.
     *
     * @param c st¯ed vytv·¯enÈho balonku.
     */
    public Balonek(Point c, int s, int v) {
        this.sirka_p = s;
        this.vyska_p = v;
        this.stred = c;
        this.vygenerujVstup();
        
        //kontola, (a pripadna uprava) jestli vygenerovany polomer nepresahuje 
        //za hranice panelu:
        this.skontrolujStred();
    }

    //1.
    /**
     * Vygeneruje nahodne parametre balonku.
     */
    private void vygenerujVstup() {
        //generovanie farby, (iba odstin modrej):
        final int modra = random.nextInt(255);
        
        this.farba = new Color(0, 0, modra);

        //generovanie polomeru balonku v rozsahu 3 - 50 pixelov, v 
        //zavislosti od vygenerovanej farby.
        double polomer = 3.0 + ((double) modra / (double) 255) * 47.0;
        this.circle = new Circle(this.stred, polomer);

        //generovanie rychlosti balonku. opat v zavislosti od farby
        //tak aby celkov· rovinn· hybnosù kaûdÈho balÛnku bola 
        //rovnak·. pozn.: Rovinn·, tj. Hmotnost sa nahr·dza plochou.
        this.rychlost = new Velocity();
        this.rychlost.nasobVektor(Balonek.H / polomer);
    }

    //2.
    /**
     * Funkcia predstavujuca pohyb balonku.
     */
    public void move() {
        //pomocne premenne:
        int x1, y1, x2, y2;
        double r, x, y;

        r = this.circle.getRadius();
        x = this.circle.getCenter().getX();
        y = this.circle.getCenter().getY();

        //posun v smere x:
        this.circle.getCenter().setX(x + this.rychlost.getVelX());
        //posun v smere y:
        this.circle.getCenter().setY(y + this.rychlost.getVelY());

        //poloha okrajov lopticky:
        x1 = (int) (this.circle.getCenter().getX()) + (int) r;
        y1 = (int) (this.circle.getCenter().getY()) + (int) r;
        x2 = (int) (this.circle.getCenter().getX()) - (int) r;
        y2 = (int) (this.circle.getCenter().getY()) - (int) r;

        
        // narazenie do okrajov panelu z Lava a z Prava:
        if (x2 <= 0 || x1 >= this.sirka_p){//BalonekPanel.SIRKA_PANELU) {
            //this.circle.setX(5);
            this.rychlost.setVelX(-this.rychlost.getVelX());
        }

        // narazenie do okrajov panelu z Vrchu a Zospodu:
        if (y2 <= 0 || y1 >= this.vyska_p){//BalonekPanel.VYSKA_PANELU) {
            this.rychlost.setVelY(-this.rychlost.getVelY());
        }
    }

    //3.
    /**
     * Skontroluje a pripadne upravi pociatocnu hodnotu stredu,
     * aby to neuviazlo v polohe pri okraji panelu. 
     */
    private void skontrolujStred() {
        int x1, x2, y1, y2;
        double r = this.circle.getRadius();
        
        x1 = (int) (this.circle.getCenter().getX()) + (int) r;
        y1 = (int) (this.circle.getCenter().getY()) + (int) r;
        x2 = (int) (this.circle.getCenter().getX()) - (int) r;
        y2 = (int) (this.circle.getCenter().getY()) - (int) r; 
        
        //ak prekracuje hranice - tak ho posun naspat.
        if (x2 < 0){
            this.circle.setX(r + 5);
        } else if (x1 > this.sirka_p){
            this.circle.setX(this.sirka_p - (r + 5));
        }
        
        //ak prekracuje hranice - tak ho posun naspat.
        if (y2 < 0){
            this.circle.setY(r + 5);
        } else if (y1 > this.vyska_p){
            this.circle.setY(this.vyska_p - (r + 5));
        }
    }

    //4.
    /**
     * Vykresli balonek. 
     */
    public void paint(Graphics g) {
        int x = (int) (circle.getCenter().getX() - circle.getRadius());
        int y = (int) (circle.getCenter().getY() - circle.getRadius());
        int w = (int) (circle.getRadius() * 2);
        //farba okraja:
        g.setColor(Color.BLACK);
        g.drawOval(x, y, w, w);
        //farba vyplne:
        g.setColor(this.getColor());
        g.fillOval(x, y, w, w);
    }

    public Color getColor() {
        return this.farba;
    }

    @Override
    public void run() {
        int spat;

        while (true) {
            //posunie balonek:
            this.move();    
            
            //cas uspatia vlakna. lokalna premenna urychli vypocet
            spat = Balonek.ZASTAV;
            try {
                Thread.sleep(spat);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}
