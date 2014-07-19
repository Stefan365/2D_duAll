package DU1SER;

import java.io.Serializable;
import java.util.Scanner;

/**
 * @author Stefan
 */
/**
 * Záznam v databázi adøes obydlí.
 */

public class AddressBookRecordSer implements Serializable {

    /**
     * Køestní jméno osoby bydlící na adøese.
     */
    private String firstName;

    /**
     * Pøíjmení.
     */
    private String lastName;
    
    /**
     * Ulice.
     */
    private String street;

    /**
     * Popisné èíslo.
     */
    private String descriptonNr;
    
    /**
     * Mìsto.
     */
    private String city;
    
    /**
     * PSÈ.
     */
    private String psc;
    
    /**
     * Telefon.
     */
    private int phone;

    //0.A Konstruktor
    /**
     * Vytvoøí nový záznam s prázdným jménem, pøíjmením, ulicí, popisním èíslem,
     * mìstem, PSÈ a nulovým telefonem.
     */
    public AddressBookRecordSer() {
        this("", "", "", "", "", "", 0);
    }

    //0.B Konstruktor s parametry
    /**
     * Vytvoøí nový záznam se zadaným jménem, pøíjmením, ulicí, popisním èíslem,
     * mìstem, PSÈ a daným telefonem.
     *
     * @param first køestní jméno v novì vytvoøeném záznamu.
     * @param last pøíjmení v novì vytvoøeném záznamu.
     * @param str název ulice v novì vytvoøeném záznamu.
     * @param descr popisné èíslo bytu v novì vytvoøeném záznamu.
     * @param ct název mìsta v novì vytvoøeném záznamu.
     * @param psc PSÈ v novì vytvoøeném záznamu.
     * @param ph èíslo telefonu v novì vytvoøeném záznamu.
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
     * Nastaví køestní jméno.
     *
     * @param first nastavované køestní jméno.
     */
    public final void setFirstName(String first) {
        this.firstName = first;
    }

    //2.
    /**
     * Vrátí køestní jméno.
     *
     * @return køestní jméno.
     */
    public String getFirstName() {
        return this.firstName;
    }

    //3.
    /**
     * Nastaví pøíjmení.
     *
     * @param last nastavované pøíjmení.
     */
    public final void setLastName(String last) {
        this.lastName = last;
    }

    //4.
    /**
     * Vrátí pøíjmení.
     *
     * @return pøíjmení.
     */
    public String getLastName() {
        return this.lastName;
    }

    //5.
    /**
     * Nastaví ulici.
     *
     * @param str nastavovaná ulice.
     */
    public final void setStreet(String str) {
        this.street = str;
    }

    //6.
    /**
     * Vrátí ulici.
     *
     * @return ulice.
     */
    public String getStreet() {
        return this.street;
    }

    //7.
    /**
     * Nastaví popisné èíslo adresy.
     *
     * @param descr nastavované popisné èíslo adresy.
     */
    public final void setDescribtionNr(String descr) {
        this.descriptonNr = descr;
    }

    //8.
    /**
     * Vrátí popisné èíslo adresy.
     *
     * @return popisné èíslo adresy.
     */
    public String getDescribtionNr() {
        return this.descriptonNr;
    }

    //9.
    /**
     * Nastaví mìsto.
     *
     * @param ct nastavované mìsto.
     */
    public final void setCity(String ct) {
        this.city = ct;
    }

    //10.
    /**
     * Vrátí mìsto.
     *
     * @return mìsto.
     */
    public String getCity() {
        return this.city;
    }

    //11.
    /**
     * Nastaví PSÈ.
     *
     * @param psc nastavované PSÈ.
     */
    public final void setPSC(String psc) {
        this.psc = psc;
    }

    //12.
    /**
     * Vrátí PSÈ.
     *
     * @return PSÈ.
     */
    public String getPSC() {
        return this.psc;
    }

    //13.
    /**
     * Nastaví telefon.
     *
     * @param ph nastavované telefonní èíslo.
     */
    public final void setPhone(int ph) {
        this.phone = ph;
    }

    //14.
    /**
     * Vrátí telefon.
     *
     * @return telefon.
     */
    public int getPhone() {
        return this.phone;
    }

    //16.
    /**
     * Naète záznam z daného Scanneru.2. verze
     *
     * @param input odkud se mají èíst data úètu.
     * @return naètený záznam.
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
