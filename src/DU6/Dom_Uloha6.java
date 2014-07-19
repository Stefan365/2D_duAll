package DU6;

import DU1SER.AddressBookRecordSer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Stefan
 */
public class Dom_Uloha6 {

    public static void main(String[] args) {

        //1. Vytvoreni xml souboru ze souboru vznikleho serializaci. 

        OutputSrA out = new OutputSrA();
        CreateXMLFileA app = new CreateXMLFileA();

        out.readRecordsOut("adresar.ser");
        app.openFileW();
        app.printXMLStart();
        app.addRecords(out.addrRecords);
        app.printXMLEnd();
        app.closeFile();

        //2. Pouziti XML souboru na nacitani udaju a ich vypisu na obrazovku.
        AddressBookRecordHandler handler = new AddressBookRecordHandler();
        InputStream iStr;
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);

            File file = new File("adresar_saved.xml");
            iStr = new FileInputStream(file);
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(iStr, "UTF-8"));

            InputSource source = new InputSource(reader2);
            source.setEncoding("UTF-8");

            reader.parse(source);
            iStr.close();

        } catch (SAXException ex) {
            throw new RuntimeException("Chyba syntaxe dokumentu.", ex);
        } catch (IOException ex) {
            throw new RuntimeException("Chyba pri ctení dokumentu XML.", ex);
        }

        List<AddressBookRecordSer> list = handler.getAddressRecords();

        for (AddressBookRecordSer record : list) {
            System.out.printf(" %s\n", record);
        }
    }
}
