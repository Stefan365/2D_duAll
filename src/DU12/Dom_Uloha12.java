package DU12;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Vykresli hlavny frame s farebnymi obdlznikmi, Sposob 2.
 */
final public class Dom_Uloha12 {

    /**
     * @param panely pole n panelov.
     * @param farby pole farieb danych panelov.
     * @param n pocet vkladanych panelov.
     */
    private MyPanel[] panely;
    private Color[] farby = new Color[6];
    //private List<Color> farby = new ArrayList<>();
    private int n;
    private static Random random = new Random();

    /*
     * Hlavna
     */
    public static void main(String[] args) {
        int n = 10;

        final Dom_Uloha12 framA = new Dom_Uloha12();
        framA.nakrmPanely(n);

        //nastavenie layoutu:
        JFrame frame = new JFrame("Kreslenie farebnych pruzkov");
        frame.setLayout(new FlowLayout());

        //vkladanie panelov:
        for (int i = 0; i < n; i++) {
            frame.add(framA.panely[i]);
        }

        //1.tlacitko:
        JButton prefarbi = new JButton("Prefarbi");
        frame.add(prefarbi);
        prefarbi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framA.nakrmFarby(framA.n);
                framA.prefarbiPanely();
            }
        });

        //2.tlacitko:
        JButton usporiadaj = new JButton("Usporiadaj");
        frame.add(usporiadaj);
        usporiadaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent b) {
                framA.usporiadajFarby();
                framA.prefarbiPanely();
            }
        });

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //1.
    /**
     * Vytvori pole farieb jednotlivych obdlznikov/panelov.
     *
     * @param n pocet obdlznikov vo Frame.
     */
    public void nakrmFarby(int n) {
        this.farby = new MyColor[n];
        for (int i = 0; i < n; i++) {
            //iba modra:
            this.farby[i] = new MyColor(0, 0, random.nextInt(255));
        }
    }

    //2.
    /**
     * Vytvori pole obdlznikov/panelov a vyfarbi ich.
     *
     * @param n pocet obdlznikov vo Frame.
     */
    public void nakrmPanely(int n) {
        this.n = n;
        this.nakrmFarby(n);

        this.panely = new MyPanel[n];
        for (int i = 0; i < n; i++) {
            this.panely[i] = new MyPanel(this.farby[i]);
        }
    }

    //3.
    /**
     * Prefarbi pole obdlznikov/panelov.
     */
    public void prefarbiPanely() {
        //this.nakrmFarby(this.n);

        for (int i = 0; i < n; i++) {
            this.panely[i].setBackground(this.farby[i]);
        }
    }

    //4.
    /**
     * Usporiada pole farieb podla velkosti vzostupne.
     */
    public void usporiadajFarby() {
        //jak by malo byt this.farby List<Color>, 
        //tak debilne vzrastie 'nakrmFarby()', takze toto je kratsie.
        List<Color> listC = Arrays.asList(this.farby);
        Collections.sort(listC, new ColorComparator());
        this.farby = (Color[])listC.toArray();
    }
}
