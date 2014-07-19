package DU15;

/**
 * T��da reprezentuj�c� kruh.
 */
public class Circle {

    /**
     * st�ed kruhu.
     */
    private Point center;
    
    /**    
     * polom�r kruhu.
     */
    private double radius;

    //0.Konstruktor
    /**
     * Vytvo�� nov� kruh se zadan�m st�edem a polom�rem.
     *
     * @param c st�ed vytv��en�ho kruhu.
     * @param r polom�r vytv��en�ho kruhu.
     */
    public Circle(Point c, double r) throws IllegalArgumentException {
        if (r > 0) {
            this.center = c;
            this.radius = r;
        } else {
            throw new IllegalArgumentException("NIEJE Kruh!");
        }
    }

    /* 
     * METODY 
     */
    
    //1.
    /**
     * Vrac� bod st�edu kruhu.
     *
     * @return st�ed kruhu.
     */
    public Point getCenter() {
        return this.center;
    }

    //2.
    /**
     * Vrac� velikost polom�ru kruhu.
     *
     * @return polom�r kruhu.
     */
    public double getRadius() {
        return this.radius;
    }
    
    //3.
    /**
     * Upravuje X-ovu suradnicu stredu.
     */
    public void setX(double x) {
        this.center.setX(x);
    }
    
    //4.
    /**
     * Upravuje Y-ovu suradnicu stredu.
     */
    public void setY(double y) {
        this.center.setY(y);
    }
}