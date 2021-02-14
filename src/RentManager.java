
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nesa
 */
public class RentManager {
    
    private ArrayList<Klijent> klijent = new ArrayList<Klijent>();
    
    public RentManager()
    {
    }

    public ArrayList<Klijent> getKlijent()
    {
        return klijent;
    }
    public void clear(){
        klijent.clear();
    }

    public void setKlijent(ArrayList<Klijent> musterija)
    {
        this.klijent = musterija;
    }
    
    public void dodajMusteriju(Klijent m)
    {
        klijent.add(m);
    }

    @Override
    public String toString()
    {
        return "RentManager{" + "Klijent=" + klijent + '}';
    }
    
    
   
}
