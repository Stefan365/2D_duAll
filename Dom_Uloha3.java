/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DU3;

import java.io. *;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Stefan
 */
public class Dom_Uloha3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        // Demonstrate FileReader. 
        
        

        
                FileReader fr = new FileReader("FileReaderDemo.java");
                BufferedReader br = new BufferedReader(fr);
                String s;
                while ((s = br.readLine()) != null) {
                    System.out.println(s);
                }
                fr.close();
            }
        }
        /*
         Output vystup = new Output();
         //Input vstup = new Input();
        
         vystup.addRecords();
         //vstup.readRecords();
         */
    }
}
