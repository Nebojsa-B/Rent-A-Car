
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nesa
 */
public class DatotekaSource {
    public void otvoriDatotekuSource() throws IOException {
        
    try {
       
        File fileklijentiSvi = new File("klijentiSvi.txt");
        
        //da li podrzava desktop platformu
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }
        
        //ako postoji prikazace ga
        Desktop desktop = Desktop.getDesktop();
        if(fileklijentiSvi.exists()) desktop.open(fileklijentiSvi);
        
        
    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
}
