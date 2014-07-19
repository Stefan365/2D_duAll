package DU15;

import java.util.Random;

/**
 *
 * @author Stefan
 */

/**
 * Trida predstavujici rychlost pohybu objektu v rovine.
 */
public class Velocity {
    
    /**
     * Slozka ve smeru X.
     */
    private double velX;
    
    /**
     * Slozka ve smeru Y.
     */
    private double velY;
    
    private static Random random = new Random();
    
    /*
     * METODY:
     */
    
    //0.A Konstruktor.
    /**
     * Vytvori rychlost, zadanych rozmerov.
     *
     * @param rychX rychlost vo smere osi X.
     * @param rychY rychlost vo smere osi Y.
     */
    public Velocity(double rychX, double rychY){
        this.velX = rychX;
        this.velX = rychY;
    }
    
    //0.B Konstruktor.
    /**
     * Vytvori rychlost, standardnej (pre nas 'jednotkovej') velkosti.
     */
    public Velocity(){
        //nahodny pocatecni smer rychlosti
        this.velX = random.nextDouble() - 0.5;
        this.velY = random.nextDouble() - 0.5;
        
        //standardizacia velikosti vektora rychlosti na 1:
        double vel = this.getVelkost();
        this.nasobVektor(1 / vel);
    }

    //1.
    /**
     * Nastavi zlozku rychlosti X.
     * @param rychX rychlost vo smere osi X.
     */
    public void setVelX(double rychX){
        this.velX = rychX;
    }

    //2.
    /**
     * Nastavi zlozku rychlosti Y.
     * @param rychY rychlost vo smere osi Y.
     */
    public void setVelY(double rychY){
        this.velY = rychY;
    }

    //3.
    /**
     * Vrati zlozku rychlosti X.
     * @return velkost zlozky X
     */
    public double getVelX(){
        return this.velX;
    }
    
    //4.
    /**
     * Vrati zlozku rychlosti Y.
     * @return velkost zlozky Y
     */
    public double getVelY(){
        return this.velY;
    }
    
    //5.
    /**
     * Zvysi rychlost X.
     * @param dX prirastok rychlosti v smere X.
     */
    public void zvysVelX(double dX){
        this.velX = this.velX + dX;
    }
    
    //6.
    /**
     * Zvysi rychlost Y.
     * @param dY prirastok rychlosti v smere Y.
     */
    public void zvysVelY(double dY){
        this.velY = this.velY + dY;
    }

    //7.
    /**
     * Vynasob cely vektor rychlosti.
     * @param x nasobok vektora rychlosti.
     */
    public final void nasobVektor(double x){
        this.velX = this.velX * x;
        this.velY = this.velY * x;
    }

    //8.
    /**
     * Celkova velkost vektora rychlosti.
     * @return velkost vektora rychlosti.
     */
    public final double getVelkost(){
        return Math.sqrt(Math.pow(this.velX, 2) + Math.pow(this.velY, 2));
    }
}
