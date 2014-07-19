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
 * Tøída demonstrující naèítání záznamù z textového souboru. ktera data nasledne
 * ulozi do bitoveho souboru pomoci seriazable.
 */
public class InputSr {

    /**
     * Formátovaný vstup z textového souboru.
     * a formátový výstup do binárního souboru
     */
    private Scanner input;
    private ObjectOutputStream output;

    //1.
    /**
     * Otevøe soubor se záznamy.
     */
    public void openFile() {
        try {
            input = new Scanner(new File("adresar.txt"), "UTF-8");
        } catch (FileNotFoundException e) {
            System.err.println("Chyba otevírání souboru.");
            System.exit(1);
        }
    }

    //2.
    /**
     * Naète záznamy ze souboru a vytiskne je do binárního souboru pomocí
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
            System.err.println("Neplatný formát souboru.");
            this.input.close();
            System.exit(1);
        }

        this.closeFile();
        this.closeFileBin();
    }

    //3.
    /**
     * Zavøe soubor.
     */
    public void closeFile() {
        if (this.input != null) {
            this.input.close();
        }
    }

    //4.
    /**
     * Otevøe soubor binární soubor.
     */
    public void openFileBin() {
        try {
            output = new ObjectOutputStream(new FileOutputStream("adresar.ser"));
        } catch (FileNotFoundException ex) {
            System.err.println("Chyba otevírání souboru.");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Chyba zápisu do souboru.");
            System.err.println(ex.toString());
            System.exit(1);
        }
    }

    //5.
    /**
     * Zavøe binární soubor.
     */
    public void closeFileBin() {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException ex) {
            System.err.println("Chyba zavírání souboru.");
            System.err.println(ex.toString());
        }
    }   
}
