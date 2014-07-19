package DU7;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Obsluha ud�lost� od SAX parseru. Vytv��� seznam ��t� na�ten� z XML souboru.
 */
public class MeteoRecordHandler extends DefaultHandler {
    
    /**
     * Seznam meteo zaznamu na��tan�ch ze XML souboru.
     */
    private List<MeteoZaznam> meteoRecords;
    
    /**
     * Aktu�ln� na��tan� z�znam.
     */
    private MeteoZaznam current;
    
    /**
     * Text polo�ky.
     */
    private StringBuffer text;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (text != null) {
            text.append(ch, start, length);
        }
    }
    
    @Override
    public void startDocument() throws SAXException {
        this.meteoRecords = new ArrayList<MeteoZaznam>();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (qName.equals("metData")) {
            //vytvara novy meteo-zaznam
            this.current = new MeteoZaznam();
        } else {
            //vynuluje this.text (zahadzuje stary obsah)
            this.text = new StringBuffer();
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        
        switch (qName) {
            case "metData":
                //ulozi doteraz vyplneny address Record 
                this.meteoRecords.add(current);
                this.current = null;
                break;
            case "domain_title":
                this.current.setDomainTitle(text.toString());
                break;
            case "tsValid_issued_UTC":
                this.current.setDatum(text.toString());
                break;
            case "t_degreesC":
                this.current.setTeplotu(Integer.parseInt(text.toString()));
                break;
        }
        text = null;
    }

    /**
     * Vr�t� seznam na�ten�ch ��t�.
     *
     * @return seznam na�ten�ch ��t�.
     */
    public List<MeteoZaznam> getMeteoRecords() {
        return this.meteoRecords;
    }   
}
