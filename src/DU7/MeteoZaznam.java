package DU7;

import java.io.Serializable;

/**
 * @author Stefan
 */
/**
 * Skraceny záznam v databázi meteo-udaju.
 */
public class MeteoZaznam implements Serializable {

    /**
     * Název lokace.
     */
    private String domain_title;
    /**
     * Datum zaznamu.
     */
    private String tsValid_issued_UTC;
    /**
     * Teplota v danem miste a case v °C.
     */
    private int t_degreesC;

    //0.A Konstruktor
    /**
     * Vytvoøí nový záznam s prázdným jménem lokace, prazdnym casem, a absolutne
     * nulovou teplotou.
     */
    public MeteoZaznam() {
        this("", "", -273);
    }

    //0.B Konstruktor s parametry
    /**
     * Vytvoøí nový záznam s jménem lokace, casem, teplotou.
     *
     * @param dom_title jméno lokace.
     * @param datum datum.
     * @param teplota tepltoa v °C.
     */
    public MeteoZaznam(String dom_title, String datum, int teplota) {

        this.setDomainTitle(dom_title);
        this.setDatum(datum);
        this.setTeplotu(teplota);
    }

    //1. 
    /**
     * Nastaví jmeno lokace.
     *
     * @param dom_title nastavované jméno lokace.
     */
    public final void setDomainTitle(String dom_title) {
        this.domain_title = dom_title;
    }

    //2.
    /**
     * Vrátí jmeno lokace.
     *
     * @return jmeno lokace.
     */
    public String getDomainTitle() {
        return this.domain_title;
    }

    //3.
    /**
     * Nastaví UTC datum zaznamu.
     *
     * @param datum utc datum zaznamu.
     */
    public final void setDatum(String datum) {
        this.tsValid_issued_UTC = datum;
    }

    //4.
    /**
     * Vrátí UTC datum.
     *
     * @return UTC datum.
     */
    public String getDatum() {
        return this.tsValid_issued_UTC;
    }

    //5.
    /**
     * Nastaví teplotu.
     *
     * @param teplota nastavovaná teplota.
     */
    public final void setTeplotu(int teplota) {
        this.t_degreesC = teplota;
    }

    //6.
    /**
     * Vrátí teplotu.
     *
     * @return teplota v °C.
     */
    public int getTeplotu() {
        return this.t_degreesC;
    }

    @Override
    public String toString() {
        return String.format("%s : %-2d°C%n", this.getDomainTitle(),
                this.getTeplotu());
    }
}
