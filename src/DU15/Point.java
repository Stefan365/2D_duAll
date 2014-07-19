package DU15;

/**
 * T��da reprezentuj�c� bod ve dvourozm�rn�m kart�zsk�m prostoru.
 */
public class Point {
    /**
     * @param x X-ov� sou�adnice bodu.,
     * @param y Y-ov� sou�adnice bodu.
     */
    private double x;
    private double y;
    
    /*
     * Metody:
     */
    
    //0. Konstruktor.
    /**
     * Vytvo�� bod o sou�adnic�ch x a y.
     * 
     * @param x X-ov� sou�adnice bodu.,
     * @param y Y-ov� sou�adnice bodu.
     */
    public Point(double x, double y) { 
        this.x = x;
        this.y = y;
    }
    
    //1.
    /**
     * Vrac� X-ovu suradnicu bodu.
     *
     * @return x-ov� sou�adnice bodu.
     */
    public double getX() {
        return x;
    }

    //2.
    /**
     * Vrac� Y-ovu suradnici bodu.
     *
     * @return y-ov� sou�adnice bodu.
     */
    public double getY() {
        return y;
    }
    
    //3.
    /**
     * Nastavuje X-ovu suradnicu bodu.
     */
    public void setX(double x) {
        this.x = x;
    }

    //4.
    /**
     * Nastavuje Y-ovu suradnicu bodu.
     */
    public void setY(double y) {
        this.y = y;
    }

   @Override
    public String toString() {
        return String.format("[%.1f, %.1f]", getX(), getY());
    }
}
