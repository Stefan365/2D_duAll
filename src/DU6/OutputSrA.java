package DU6;

import DU1SER.AddressBookRecordSer;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefan
 */
/**
 * T��da demonstruj�c� na��t�n� z�znam� z bin�rn�ho souboru pomoc�
 * deserializace.
 */
public class OutputSrA {

    /**
     * Vstup z bin�rn�ho souboru;
     */
    private ObjectInputStream input;
    
    public List<AddressBookRecordSer> addrRecords;
    
    //1.
    /**
     * Na�te z�znamy ze souboru a vytiskne je na obrazovku.
     */
    public void readRecordsOut(String fileStr) {

        this.openFileBin(fileStr);

        /*
         OutputStreamWriter osw = new OutputStreamWriter(System.out, "UTF-8");
         PrintWriter p = new PrintWriter(osw);
         */
        try {
            this.addrRecords = new ArrayList<>();
            for (;;) {
                AddressBookRecordSer record =
                        (AddressBookRecordSer) input.readObject();
                this.addrRecords.add(record);
            }
        } catch (EOFException e) {
            // konec souboru
        } catch (ClassNotFoundException ex) {
            System.err.println("Nelze naj�t t��du pro na��tan� objekt.");
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println("Chyba �ten� souboruAAA.");
            System.err.println(ex.toString());
        } finally {
            this.closeFileBin();
        }
    }

    //2.
    /**
     * Otev�e bin�rn� soubor se z�znamy.
     */
    private void openFileBin(String fileStr) {
        try {
            input = new ObjectInputStream(new FileInputStream(fileStr));
        } catch (IOException e) {
            System.err.println("Chyba otev�r�n� souboruAAA.");
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
                System.err.println("Chyba zav�r�n� souboruAAA.");
            }
        }
    }
}
