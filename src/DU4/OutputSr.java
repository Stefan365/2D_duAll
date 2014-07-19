package DU4;

import DU1SER.AddressBookRecordSer;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Stefan
 */
/**
 * T��da demonstruj�c� na��t�n� z�znam� z bin�rn�ho souboru pomoc�
 * deserializace.
 */
public class OutputSr {

    /**
     * Vstup z bin�rn�ho souboru;
     */
    private ObjectInputStream input;

    //1.
    /**
     * Na�te z�znamy ze souboru a vytiskne je na obrazovku.
     */
    public void readRecordsOut() {

        this.openFileBin();

        /*
         OutputStreamWriter osw = new OutputStreamWriter(System.out, "UTF-8");
         PrintWriter p = new PrintWriter(osw);
         */
        try {
            for (;;) {
                AddressBookRecordSer record =
                        (AddressBookRecordSer) input.readObject();
                System.out.println(record.toString());
            }
        } catch (EOFException e) {
            // konec souboru
        } catch (ClassNotFoundException ex) {
            System.err.println("Nelze naj�t t��du pro na��tan� objekt.");
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println("Chyba �ten� souboru.");
            System.err.println(ex.toString());
        } finally {
            this.closeFileBin();
        }        
    }

    //2.
    /**
     * Otev�e bin�rn� soubor se z�znamy.
     */
    public void openFileBin() {
        try {
            input = new ObjectInputStream(new FileInputStream("adresar.ser"));
        } catch (IOException e) {
            System.err.println("Chyba otev�r�n� souboru.");
            System.exit(1);
        }
    }

    //3.
    /**
     * Zav�e bin�rn� soubor.
     */
    public void closeFileBin() {
        if (this.input != null) {
            try {
                this.input.close();
            } catch (IOException ex) {
                System.err.println("Chyba zav�r�n� souboru.");
            }
        }
    }
}
