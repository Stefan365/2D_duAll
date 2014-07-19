package DU15;

/**
 * Tøída reprezentující bod ve dvourozmìrném kartézském prostoru.
 */
public class Point {
    /**
     * @param x X-ová souøadnice bodu.,
     * @param y Y-ová souøadnice bodu.
     */
    private double x;
    private double y;
    
    /*
     * Metody:
     */
    
    //0. Konstruktor.
    /**
     * Vytvoøí bod o souadnicích x a y.
     * 
     * @param x X-ová souøadnice bodu.,
     * @param y Y-ová souøadnice bodu.
     */
    public Point(double x, double y) { 
        this.x = x;
        this.y = y;
    }
    
    //1.
    /**
     * Vrací X-ovu suradnicu bodu.
     *
     * @return x-ová souøadnice bodu.
     */
    public double getX() {
        return x;
    }

    //2.
    /**
     * Vrací Y-ovu suradnici bodu.
     *
     * @return y-ová souøadnice bodu.
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
