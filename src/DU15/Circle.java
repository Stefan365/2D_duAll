package DU15;

/**
 * Tøída reprezentující kruh.
 */
public class Circle {

    /**
     * støed kruhu.
     */
    private Point center;
    
    /**    
     * polomìr kruhu.
     */
    private double radius;

    //0.Konstruktor
    /**
     * Vytvoøí nový kruh se zadaným støedem a polomìrem.
     *
     * @param c støed vytváøeného kruhu.
     * @param r polomìr vytváøeného kruhu.
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
     * Vrací bod støedu kruhu.
     *
     * @return støed kruhu.
     */
    public Point getCenter() {
        return this.center;
    }

    //2.
    /**
     * Vrací velikost polomìru kruhu.
     *
     * @return polomìr kruhu.
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