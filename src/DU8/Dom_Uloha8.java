package DU8;

/**
 * @author Stefan
 */
public class Dom_Uloha8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Node<String> stringNode = new Node<String>("Karel");
        Pair<String, Integer> par1 = new Pair<>("Karol", 26);
        Pair<Integer, Integer> par2 = new Pair<>(150, 26);
        Pair<Boolean, Boolean> par3 = new Pair<>(true, false);
        
        System.out.format("Pred:%n%s%s%s %n", par1, par2, par3);
        
        par1.testPair("Jozko", 169);
        par2.testPair(1789, 169);
        par3.testPair(false, true);
        
        System.out.format("Po:%n%s%s%s %n", par1, par2, par3);
        
    }
    /*
    //neuniverzalna testovacia metoda:
    public void testPair(Pair<String, Integer> par, String meno, int vek){
        System.out.format("Pred:%n%s%n", par);
        
        System.out.format("prvy clen:%s, druhy clen:%d%n", par.getFirst(), par.getSecond());
        par.setFirst(meno);
        par.setSecond(vek);
    
        System.out.format("Po:%n%s%n", par);
    }
    */
    
}
