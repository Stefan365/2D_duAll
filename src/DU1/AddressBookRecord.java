package DU1;

import java.util.Scanner;

/**
 * @author Stefan
 */
/**
 * Z�znam v datab�zi ad�es obydl�.
 */
public class AddressBookRecord {

    
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
    public AddressBookRecord() {
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
    public AddressBookRecord(String first, String last, String str, String descr,
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
    public void setFirstName(String first) {
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
    private void setLastName(String last) {
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
    private void setStreet(String str) {
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
    private void setDescribtionNr(String descr) {
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
    private void setCity(String ct) {
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
    private void setPSC(String psc) {
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
    private void setPhone(int ph) {
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

    //15.
    /**
     * Na�te z�znam z dan�ho Scanneru.
     *
     * @param input odkud se maj� ��st data ��tu.
     * @return na�ten� z�znam.
     */
    public static AddressBookRecord read(Scanner input) {
        AddressBookRecord record = new AddressBookRecord();
        System.out.print("zadaj krstne meno: ");
        record.setFirstName(input.next());
        
        System.out.print("zadaj priezvisko: ");
        record.setLastName(input.next());
        
        System.out.print("zadaj nazov ulice: ");
        record.setStreet(input.next());

        System.out.print("zadaj popisne cislo: ");
        record.setDescribtionNr(input.next());

        System.out.print("zadaj mesto: ");
        record.setCity(input.next());
        input.nextLine();
        
        System.out.print("zadaj PSC mesta: ");
        record.setPSC(input.nextLine());
        
        System.out.print("zadaj cislo telefonu: ");
        record.setPhone(input.nextInt());
        
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
