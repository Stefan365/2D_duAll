package DU6;

import DU1SER.AddressBookRecordSer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Pomocn� t��da pro vytvo�en� XML souboru se z�znamy na z�klad� dat z�skan�ch
 * pomoc� serializace (tj ze souboru).
 */
public class CreateXMLFileA {

    /**
     * Objekt slou��c� pro v�stup textu do souboru.
     */
    private PrintWriter output;

    //1.
    /**
     * Otev�e soubor se z�znamy.
     */
    public void openFileW() {
        try {
            FileOutputStream fos =
                    new FileOutputStream(new File("adresar_saved.xml"));
            this.output = new PrintWriter(new OutputStreamWriter(fos, "UTF-8"));
        } catch (FileNotFoundException ex) {
            System.err.println("Chyba p�i vytv��en� souboruBBB.");
            System.err.println(ex.toString());
            System.exit(1);
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Toto se nestaneBBB", ex);
        }
    }

    //2.
    /**
     * �erp� z�znamy z pole z�znam�.
     */
    public void addRecords(List<AddressBookRecordSer> aRecords) {
        for (AddressBookRecordSer record : aRecords) {
            this.output.println("    <addressRecord>");
            this.output.print("        <firstName>");
            this.output.print(record.getFirstName());
            this.output.println("</firstName>");
            this.output.print("        <lastName>");
            this.output.print(record.getLastName());
            this.output.println("</lastName>");
            this.output.print("        <street>");
            this.output.print(record.getStreet());
            this.output.println("</street>");
            this.output.print("        <descr_nr>");
            this.output.print(record.getDescribtionNr());
            this.output.println("</descr_nr>");
            this.output.print("        <city>");
            this.output.print(record.getCity());
            this.output.println("</city>");
            this.output.print("        <psc>");
            this.output.print(record.getPSC());
            this.output.println("</psc>");
            this.output.print("        <phone_nr>");
            this.output.print(record.getPhone());
            this.output.println("</phone_nr>");
            this.output.println("    </addressRecord>");
        }
    }

    //3.
    /**
     * Vytiskne do souboru za��tek XML souboru.
     */
    public void printXMLStart() {
        this.output.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        this.output.println();
        this.output.println("<!DOCTYPE addressRecords SYSTEM \"adresar.dtd\">");
        this.output.println();
        this.output.println("<addressRecords>");
    }

    //4.
    /**
     * Vytiskne do souboru konec XML souboru.
     */
    public void printXMLEnd() {
        this.output.println("</addressRecords>");
    }

    //5.
    /**
     * Zav�e soubor.
     */
    public void closeFile() {
        if (this.output != null) {
            this. output.close();
        }
    }
}
