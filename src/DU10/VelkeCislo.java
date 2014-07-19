package DU10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Stefan
 */
/**
 * Trida predstavujici velke prirozene cislo.
 */
public class VelkeCislo {

    /**
     * Zoznam, ktery predstavuje dane cislo.
     */
    private List<Byte> velkyZoznam;

    //0.A KONSTRUKTOR.
    /**
     * Vytvoøí VelkeCislo z cisla typu long.
     *
     * @param cislo hodnota cisla.
     */
    public VelkeCislo(long cislo) {
        this.rozlozCislo(cislo);
    }

    //0.B KONSTRUKTOR.
    /**
     * Vytvoøí prazdne VelkeCislo.
     */
    private VelkeCislo() {
        this.velkyZoznam = new ArrayList<Byte>();
    }

    //1.
    /**
     * Rozlozi cislo typu long do VelkehoCisla.
     *
     * @param cislo vstupne cislo typu long.
     */
    private void rozlozCislo(long cislo) {
        this.velkyZoznam = new ArrayList<Byte>();
        long ostatok = cislo;

        byte mod;
        while (true) {
            if (ostatok == 0) {
                break;
            }
            mod = (byte) (ostatok % 10);
            this.velkyZoznam.add(mod);
            ostatok = (ostatok - mod) / 10;
        }
    }

    //2.
    /**
     * Secte 2 VelkeCisla.
     *
     * @param druhe VelkeCislo.
     * @return sucet.
     */
    public VelkeCislo secti(VelkeCislo velkeCislo2) {

        VelkeCislo sucet = new VelkeCislo(); //konecny sucet
        VelkeCislo[] dvojica = this.usporiadaj(velkeCislo2);
        //dlhsie a kratsie cislo:
        VelkeCislo cisD = dvojica[0];
        VelkeCislo cisK = dvojica[1];

        Iterator itD = cisD.velkyZoznam.iterator();
        Iterator itK = cisK.velkyZoznam.iterator();

        byte cislica1, cislica2, sucetCislic, pripocet, zvysok = 0;

        //1. Samotny algoritmus suctu:
        while (itD.hasNext()) {

            cislica1 = (byte) (itD.next());
            if (itK.hasNext()) {
                cislica2 = (byte) (itK.next());
            } else {
                cislica2 = 0;
            }
            sucetCislic = (byte) (cislica1 + cislica2 + zvysok);

            pripocet = (byte) (sucetCislic % 10);
            zvysok = (byte) ((sucetCislic - pripocet) / 10);

            sucet.velkyZoznam.add(pripocet);
        }
        if (zvysok != 0) {
            sucet.velkyZoznam.add(zvysok);
        }

        return sucet;
    }

    //2.
    /**
     * Vynasobi 2 VelkeCisla.
     *
     * @param druhe VelkeCislo.
     * @return sucin VelkychCislel.
     */
    public VelkeCislo vynasob(VelkeCislo velkeCislo2) {
        VelkeCislo sucin = new VelkeCislo(); //konecny sucin
        VelkeCislo[] dvojica = this.usporiadaj(velkeCislo2);
        //dlhsie a kratsie cislo:
        VelkeCislo cisD = dvojica[0];
        VelkeCislo cisK = dvojica[1];

        byte cislica1, cislica2, meziSucinCislic, pripocet, zvysok = 0;

        //1. Algoritmus sucinu:
        Iterator itK = cisK.velkyZoznam.iterator();
        List<VelkeCislo> meziSuciny = new ArrayList<>();//list medzisucinov
        int i; //citac medzisucinov

        while (itK.hasNext()) {

            //1.0. Pridanie noveho VelkehoCisla do listu medzisucinov:
            meziSuciny.add(new VelkeCislo());
            i = meziSuciny.size() - 1;

            //1.1. Vyplnenie pociatku daneho VelkehoCisla nulami:
            for (int j = 0; j < i; j++) {
                meziSuciny.get(i).velkyZoznam.add((byte) 0);
            }

            //1.2.1 Samotny algoritmus sucinu - vytvorenie mezi sucinov:
            cislica1 = (byte) (itK.next());

            Iterator itD = cisD.velkyZoznam.iterator();
            while (itD.hasNext()) {
                cislica2 = (byte) (itD.next());
                meziSucinCislic = (byte) (cislica1 * cislica2 + zvysok);
                pripocet = (byte) (meziSucinCislic % 10);
                zvysok = (byte) ((meziSucinCislic - pripocet) / 10);
                //zapisanie si vysledku:
                meziSuciny.get(i).velkyZoznam.add(pripocet);
            }
            if (zvysok != 0) {
                meziSuciny.get(i).velkyZoznam.add(zvysok);
                zvysok = 0;
            }
        }
        //1.2.2 Scitanie medzisucinov:
        Iterator itS = meziSuciny.iterator();
        while (itS.hasNext()) {
            VelkeCislo x = (VelkeCislo) (itS.next());
            sucin = sucin.secti(x);
        }

        return sucin;
    }

    //4.
    /**
     * Usporiada dvojicu cisel podla delky.
     *
     * @param druhe VelkeCislo.
     * @return usporiadanu dvojicu, z ktorej prve je dlhsie VelkeCislo.
     */
    public VelkeCislo[] usporiadaj(VelkeCislo velkeCislo2) {
        VelkeCislo[] dvojica = new VelkeCislo[2];
        if (this.velkyZoznam.size() >= velkeCislo2.velkyZoznam.size()) {
            dvojica[0] = this;
            dvojica[1] = velkeCislo2;
        } else {
            dvojica[0] = velkeCislo2;
            dvojica[1] = this;
        }
        return dvojica;
    }

    @Override
    public String toString() {
        StringBuilder cislo = new StringBuilder();
        int citac = 0;

        Iterator it = this.velkyZoznam.iterator();

        //2. Samotny algoritmus suctu:
        while (it.hasNext()) {
            if (citac == 3) {
                cislo.append(" ");
                citac = 0;
            } else {
                cislo.append(it.next());
                citac++;    
            }
        }
        return (cislo.reverse()).toString();
    }
}