package cteniazapisdosouboru;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CteniAZapisDoSouboru {

    public static void main(String[] args) {
        // nejprve zápisy do souboru
        try {
            // sekce try umožní pomocí catch zachytit problém se zápisem
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("pokus.txt"));
            bw.write("Prvni radek");
            bw.newLine();
            bw.write("Druhy radek\r\n");
            bw.write("Treti radek");
            bw.newLine();
            // flush slouží k donucení systému, aby zapsal obsah bufferu (RAM)
            // do úložného zařízení (do souboru). Zpomaluje práci systému,
            // protože systém nemůže zápisy efektivně sdružovat a kešovat.
            // Proto používá ho používáme jen ve speciálních případech.
            // bw.flush();
            // Nezapomínáme soubor zavírat!
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(CteniAZapisDoSouboru.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // a následně i čtení ze souboru
        try {
            // sekce try umožní reagovat na různé problémy při čtení ze souboru
            BufferedReader br = new BufferedReader(
                    new FileReader("pokus.txt"));
            String radek;
            while ((radek = br.readLine()) != null) {
                System.out.println(radek);
            }
            // nezapomeneme soubor zavřít
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CteniAZapisDoSouboru.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CteniAZapisDoSouboru.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
