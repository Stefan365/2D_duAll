package DU1SER;

import java.io.Serializable;
import java.util.Scanner;

/**
 * @author Stefan
 */
/**
 * Z�znam v datab�zi ad�es obydl�.
 */

public class AddressBookRecordSer implements Serializable {

    /**
     * K�estn� jm�no osoby bydl�c� na ad�ese.
     */
    private String firstName;

    /**
     * P��jmen�.
     */
    private String lastName;
    
    /**
     * Ulice.
     */
    private String street;

    /**
     * Popisn� ��slo.
     */
    private String descriptonNr;
    
    /**
     * M�sto.
     */
    private String city;
    
    /**
     * PS�.
     */
    private String psc;
    
    /**
     * Telefon.
     */
    private int phone;

    //0.A Konstruktor
    /**
     * Vytvo�� nov� z�znam s pr�zdn�m jm�nem, p��jmen�m, ulic�, popisn�m ��slem,
     * m�stem, PS� a nulov�m telefonem.
     */
    public AddressBookRecordSer() {
        this("", "", "", "", "", "", 0);
    }

    //0.B Konstruktor s parametry
    /**
     * Vytvo�� nov� z�znam se zadan�m jm�nem, p��jmen�m, ulic�, popisn�m ��slem,
     * m�stem, PS� a dan�m telefonem.
     *
     * @param first k�estn� jm�no v nov� vytvo�en�m z�znamu.
     * @param last p��jmen� v nov� vytvo�en�m z�znamu.
     * @param str n�zev ulice v nov� vytvo�en�m z�znamu.
     * @param descr popisn� ��slo bytu v nov� vytvo�en�m z�znamu.
     * @param ct n�zev m�sta v nov� vytvo�en�m z�znamu.
     * @param psc PS� v nov� vytvo�en�m z�znamu.
     * @param ph ��slo telefonu v nov� vytvo�en�m z�znamu.
     */
    public AddressBookRecordSer(String first, String last, String str, String descr,
            String ct, String psc, int ph) {

        this.setFirstName(first);
        this.setLastName(last);
        this.setStreet(str);
        this.setDescribtionNr(descr);
        this.setCity(ct);
        this.setPSC(psc);
        this.setPhone(ph);
    }

    //1. 
    /**
     * Nastav� k�estn� jm�no.
     *
     * @param first nastavovan� k�estn� jm�no.
     */
    public final void setFirstName(String first) {
        this.firstName = first;
    }

    //2.
    /**
     * Vr�t� k�estn� jm�no.
     *
     * @return k�estn� jm�no.
     */
    public String getFirstName() {
        return this.firstName;
    }

    //3.
    /**
     * Nastav� p��jmen�.
     *
     * @param last nastavovan� p��jmen�.
     */
    public final void setLastName(String last) {
        this.lastName = last;
    }

    //4.
    /**
     * Vr�t� p��jmen�.
     *
     * @return p��jmen�.
     */
    public String getLastName() {
        return this.lastName;
    }

    //5.
    /**
     * Nastav� ulici.
     *
     * @param str nastavovan� ulice.
     */
    public final void setStreet(String str) {
        this.street = str;
    }

    //6.
    /**
     * Vr�t� ulici.
     *
     * @return ulice.
     */
    public String getStreet() {
        return this.street;
    }

    //7.
    /**
     * Nastav� popisn� ��slo adresy.
     *
     * @param descr nastavovan� popisn� ��slo adresy.
     */
    public final void setDescribtionNr(String descr) {
        this.descriptonNr = descr;
    }

    //8.
    /**
     * Vr�t� popisn� ��slo adresy.
     *
     * @return popisn� ��slo adresy.
     */
    public String getDescribtionNr() {
        return this.descriptonNr;
    }

    //9.
    /**
     * Nastav� m�sto.
     *
     * @param ct nastavovan� m�sto.
     */
    public final void setCity(String ct) {
        this.city = ct;
    }

    //10.
    /**
     * Vr�t� m�sto.
     *
     * @return m�sto.
     */
    public String getCity() {
        return this.city;
    }

    //11.
    /**
     * Nastav� PS�.
     *
     * @param psc nastavovan� PS�.
     */
    public final void setPSC(String psc) {
        this.psc = psc;
    }

    //12.
    /**
     * Vr�t� PS�.
     *
     * @return PS�.
     */
    public String getPSC() {
        return this.psc;
    }

    //13.
    /**
     * Nastav� telefon.
     *
     * @param ph nastavovan� telefonn� ��slo.
     */
    public final void setPhone(int ph) {
        this.phone = ph;
    }

    //14.
    /**
     * Vr�t� telefon.
     *
     * @return telefon.
     */
    public int getPhone() {
        return this.phone;
    }

    //16.
    /**
     * Na�te z�znam z dan�ho Scanneru.2. verze
     *
     * @param input odkud se maj� ��st data ��tu.
     * @return na�ten� z�znam.
     */
    public static AddressBookRecordSer read2(Scanner input) {
        AddressBookRecordSer record = new AddressBookRecordSer();

        record.setFirstName(input.next());

        record.setLastName(input.next());
        input.nextLine();

        record.setStreet(input.nextLine());

        record.setDescribtionNr(input.next());
        input.nextLine();

        record.setCity(input.nextLine());

        record.setPSC(input.nextLine());

        record.setPhone(input.nextInt());
        input.nextLine();

        return record;
    }

    @Override
    public String toString() {
        return String.format("%n%s %s%n" + "%s %s%n" + "%s %s%n" + "telefon: %-10d",
                this.getFirstName(), this.getLastName(), this.getStreet(),
                this.getDescribtionNr(), this.getCity(), this.getPSC(),
                this.getPhone());
    }
}
