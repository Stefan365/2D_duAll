/**
 * 2Dom_Uloha1
 *
 * @autor Stefan Veres, 2D, LS
 */
package DU1;

import java.util.Scanner;

public class Dom_Uloha1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AddressBookRecord app = AddressBookRecord.read(input);
        
        System.out.format("%s", app);
       
    }
}
