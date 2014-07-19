package DU6;

import DU1SER.AddressBookRecordSer;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Obsluha ud�lost� od SAX parseru. Vytv��� seznam ��t� na�ten� z XML souboru.
 */
public class AddressBookRecordHandler extends DefaultHandler {

    /**
     * Seznam ��t� na��tan� ze souboru.
     */
    private List<AddressBookRecordSer> addressRecords;
    
    /**
     * Aktu�ln� na��tan� z�znam.
     */
    private AddressBookRecordSer current;
    
    /**
     * Text polo�ky.
     */
    private StringBuffer text;
    
    /*
     * Tato metoda nacita hodnotu daneho elementu (evidentne sa vola automaticky).
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (text != null) {
            text.append(ch, start, length);
        }
    }
    
    @Override
    public void startDocument() throws SAXException {
        this.addressRecords = new ArrayList<AddressBookRecordSer>();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (qName.equals("addressRecord")) {
            this.current = new AddressBookRecordSer();
            //current.setAccount(Integer.parseInt(attributes.getValue("id")));
        } else {
            //vynuluje this.text (zahadzuje stary obsah)
            this.text = new StringBuffer();
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        switch (qName) {
            case "addressRecord":
                //ulozi doteraz vyplneny address Record 
                this.addressRecords.add(current);
                this.current = null;
                break;
            case "firstName":
                this.current.setFirstName(text.toString());
                break;
            case "lastName":
                this.current.setLastName(text.toString());
                break;
            case "street":
                this.current.setStreet(text.toString());
                break;
            case "descr_nr":
                this.current.setDescribtionNr(text.toString());
                break;
            case "city":
                this.current.setCity(text.toString());
                break;
            case "psc":
                this.current.setPSC(text.toString());
                break;
            case "phone_nr":
                this.current.setPhone(Integer.parseInt(text.toString()));
                break;
        }
        text = null;
    }

    /**
     * Vr�t� seznam na�ten�ch ��t�.
     *
     * @return seznam na�ten�ch ��t�.
     */
    public List<AddressBookRecordSer> getAddressRecords() {
        return this.addressRecords;
    }
}
