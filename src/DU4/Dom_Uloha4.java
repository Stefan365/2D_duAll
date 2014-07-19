/*
 */
package DU4;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Stefan
 */
public class Dom_Uloha4 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        //OutputSr vystup = new OutputSr();
        InputSr vstup = new InputSr();
        
        //vystup.readRecordsOut();
        vstup.readRecords();
    }
}
