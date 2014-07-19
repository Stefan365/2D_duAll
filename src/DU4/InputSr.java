package DU4;

import DU1SER.AddressBookRecordSer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * T��da demonstruj�c� na��t�n� z�znam� z textov�ho souboru. ktera data nasledne
 * ulozi do bitoveho souboru pomoci seriazable.
 */
public class InputSr {

    /**
     * Form�tovan� vstup z textov�ho souboru.
     * a form�tov� v�stup do bin�rn�ho souboru
     */
    private Scanner input;
    private ObjectOutputStream output;

    //1.
    /**
     * Otev�e soubor se z�znamy.
     */
    public void openFile() {
        try {
            input = new Scanner(new File("adresar.txt"), "UTF-8");
        } catch (FileNotFoundException e) {
            System.err.println("Chyba otev�r�n� souboru.");
            System.exit(1);
        }
    }

    //2.
    /**
     * Na�te z�znamy ze souboru a vytiskne je do bin�rn�ho souboru pomoc�
     * seriazable.
     */
    public void readRecords() throws UnsupportedEncodingException, IOException {

        this.openFile();
        this.openFileBin();

        //output = new ObjectOutputStream(new FileOutputStream("clients.ser"));

        OutputStreamWriter osw = new OutputStreamWriter(System.out, "UTF-8");
        PrintWriter p = new PrintWriter(osw);

        try {
            while (this.input.hasNext()) {
                AddressBookRecordSer record = AddressBookRecordSer.read2(input);
                //p.println(record.toString());
                output.writeObject(record);
            }
        } catch (NoSuchElementException e) {
            System.err.println("Neplatn� form�t souboru.");
            this.input.close();
            System.exit(1);
        }

        this.closeFile();
        this.closeFileBin();
    }

    //3.
    /**
     * Zav�e soubor.
     */
    public void closeFile() {
        if (this.input != null) {
            this.input.close();
        }
    }

    //4.
    /**
     * Otev�e soubor bin�rn� soubor.
     */
    public void openFileBin() {
        try {
            output = new ObjectOutputStream(new FileOutputStream("adresar.ser"));
        } catch (FileNotFoundException ex) {
            System.err.println("Chyba otev�r�n� souboru.");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Chyba z�pisu do souboru.");
            System.err.println(ex.toString());
            System.exit(1);
        }
    }

    //5.
    /**
     * Zav�e bin�rn� soubor.
     */
    public void closeFileBin() {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException ex) {
            System.err.println("Chyba zav�r�n� souboru.");
            System.err.println(ex.toString());
        }
    }   
}
