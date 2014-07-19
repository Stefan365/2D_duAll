package DU10;

/**
 * @author Stefan
 */
public class Dom_Uloha10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VelkeCislo c1 = new VelkeCislo(12);
        VelkeCislo c2 = new VelkeCislo(941600);
        VelkeCislo c3 = c1.secti(c2);
                
        System.out.format("Sucet: %s + %s = %s%n", c1, c2, c3);
        
        VelkeCislo c4 = new VelkeCislo(1254);
        VelkeCislo c5 = new VelkeCislo(18832);
        VelkeCislo c6 = c4.vynasob(c5);
        
        System.out.format("Sucin: %s x %s = %s%n", c4, c5, c6);
    }   
}
