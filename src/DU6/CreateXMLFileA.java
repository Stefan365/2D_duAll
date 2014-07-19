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
 * Pomocná tøída pro vytvoøení XML souboru se záznamy na základì dat získaných
 * pomocí serializace (tj ze souboru).
 */
public class CreateXMLFileA {

    /**
     * Objekt sloužící pro výstup textu do souboru.
     */
    private PrintWriter output;

    //1.
    /**
     * Otevøe soubor se záznamy.
     */
    public void openFileW() {
        try {
            FileOutputStream fos =
                    new FileOutputStream(new File("adresar_saved.xml"));
            this.output = new PrintWriter(new OutputStreamWriter(fos, "UTF-8"));
        } catch (FileNotFoundException ex) {
            System.err.println("Chyba pøi vytváøení souboruBBB.");
            System.err.println(ex.toString());
            System.exit(1);
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Toto se nestaneBBB", ex);
        }
    }

    //2.
    /**
     * èerpá záznamy z pole záznamú.
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
     * Vytiskne do souboru zaèátek XML souboru.
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
     * Zavøe soubor.
     */
    public void closeFile() {
        if (this.output != null) {
            this. output.close();
        }
    }
}
