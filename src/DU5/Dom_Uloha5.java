package DU5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

/**
 *
 * @author Stefan
 */
public class Dom_Uloha5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File fileIn = new File(args[0]);
        File fileOut = new File(args[0] + ".txt");
        
            
        try (FileReader fr = new FileReader(fileIn)) {

            LineNumberReader lnr = new LineNumberReader(fr);
            String s;
            FileWriter f0 = new FileWriter(fileOut);
            PrintWriter pw = new PrintWriter(f0, true);
        
            while ((s = lnr.readLine()) != null) {
                //vystup na obrazovku:
                //System.out.format("%2s. %s%n", lnr.getLineNumber(), s);
                //vystup do .txt suboru:
                pw.println(String.format("%2s. %s", lnr.getLineNumber(), s));
            }
            
            if(f0 != null){
                f0.close();
            }
            
        } catch (IOException e) {
             System.out.println("Subor nebol najdeny");
        } 
        
    }
}
