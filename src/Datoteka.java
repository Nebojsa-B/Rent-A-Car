
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nesa
 */
public class Datoteka  {
        
    
    public void upisUDatoteke(RentManager rentManager)
    {
        try
        {
            
            FileWriter fileWriterKlijent = new FileWriter("klijent.txt", true);
            FileWriter fileWriterKlijentiSvi = new FileWriter("klijentiSvi.txt", true);
         
            PrintWriter  printWriterKlijent = new PrintWriter(fileWriterKlijent);
           PrintWriter  printWriterKlijentiSvi = new PrintWriter(fileWriterKlijentiSvi);

            for (Klijent klijent : rentManager.getKlijent())
            {
                printWriterKlijent.println(klijent.toString());
            }
            for (Klijent klijent : rentManager.getKlijent())
            {
                printWriterKlijentiSvi.println(klijent.toString());
            }

          
            rentManager.clear();
            printWriterKlijent.close();
            printWriterKlijentiSvi.close();
            
        } catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "Neispravan unos", "Greska!", 2);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Neispravan unos", "Greska!", 2);
        }
    }
    
    
    public String otvoriDatotekuSamoJednom()
    {   
        String result = "";
        try {
            File inputKlijent = new File("klijent.txt");
            
            Scanner scannerKlijent = new Scanner(inputKlijent);
            

            result += "                          :REZERVACIJA:\n";

            while (scannerKlijent.hasNext()) {
                result += scannerKlijent.nextLine();
                result += "\n";
            } 
            
            scannerKlijent.close();
            
            inputKlijent.delete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Datoteka.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;       
        
        
        
    }
    public String otvoriDatotekuVisePuta()
    {   
        
        
        String result = "";
        try {
            File inputKlijent = new File("klijentiSvi.txt");
            
            Scanner scannerKlijent = new Scanner(inputKlijent);
            

            result += "                               :Lista svih rezervacija:\n";

            while (scannerKlijent.hasNext()) {
                result += scannerKlijent.nextLine();
                result += "\n";
            } 
            
            scannerKlijent.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Datoteka.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;       
        
        
        
    }
    

    
    
}
    

   
       
    
    

