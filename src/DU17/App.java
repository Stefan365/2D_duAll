package DU17;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Spousteci trida pro zobrazeni problemu 3 Producers vs 3 Consumers.
 */
public class App {
    
    /**
     * Pocet vlaken Consumer / Producer.
     */
    private final static int SIZE = 3;

   /*
    * Hlavni
    */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Producenti vs. Konzumenti");
        // vytvoreni kruhoveho zasobniku
        BlockingBuffer sharedLocation = new BlockingBuffer();
        
        //pridanie producentov:
        JPanel producentiPanel = new JPanel();
        producentiPanel.setPreferredSize(new Dimension(120, 200));
        
        ProducerView[] ProdView = new ProducerView[SIZE];
        for (int i =0; i < 3; i++){
            ProdView[i] = new ProducerView(sharedLocation);
            producentiPanel.add(ProdView[i].labelProd);
        }
        producentiPanel.setLayout(new GridLayout(3, 1));
        frame.add(producentiPanel);
        
        //pridanie zobrazenia bufferu:
        BufferView BuffView = new BufferView(sharedLocation);
        BuffView.setPreferredSize(new Dimension(300, 200));
        
        frame.add(BuffView);
        
        //pridanie konzumentov:
        JPanel konzumentiPanel = new JPanel();
        konzumentiPanel.setPreferredSize(new Dimension(120, 200));
        
        ConsumerView[] KonzumView = new ConsumerView[SIZE];
        for (int i =0; i < 3; i++){
            KonzumView[i] = new ConsumerView(sharedLocation);
            konzumentiPanel.add(KonzumView[i].labelKonzum);
        }
        konzumentiPanel.setLayout(new GridLayout(3, 1));
        frame.add(konzumentiPanel);
        
        //frame.setLayout(new GridLayout(1, 3));
        frame.setLayout(new FlowLayout());

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // vytvoreni spravce vlaken
        ExecutorService app = Executors.newFixedThreadPool(6);
        
        // spolupraca vlaken producentov a konzumentov:
        try {
            for (int i = 0; i < 3; i++) {
                app.execute(ProdView[i].producent);
                app.execute(KonzumView[i].konzument);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        app.shutdown();
    }
}
