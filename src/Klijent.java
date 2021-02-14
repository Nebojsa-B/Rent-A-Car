/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nesa
 */
class Klijent extends Osoba {
    private String brojTelefona;
    private String lokacijaPreuzimanja;
    private String lokacijaVracanja;
    private int dan;
    private int mesec;
    private String naKolikoDana;
    private String marka;
    private int cena;
    
    public Klijent(){
        
    }
    public Klijent(String ime,String prezime,String jmbg,String brojTelefona, String lokacijaPreuzimanja, String lokacijaVracanja, int dan, int mesec,String naKolikoDana, String marka, int cena){
        super(ime, prezime, jmbg);
        this.brojTelefona = brojTelefona;
        this.lokacijaPreuzimanja = lokacijaPreuzimanja;
        this.lokacijaVracanja = lokacijaVracanja;
        this.dan = dan;
        this.mesec = mesec;
        this.naKolikoDana = naKolikoDana;
        this.marka = marka;
        this.cena = cena;
        
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getLokacijaPreuzimanja() {
        return lokacijaPreuzimanja;
    }

    public void setLokacijaPreuzimanja(String lokacijaPreuzimanja) {
        this.lokacijaPreuzimanja = lokacijaPreuzimanja;
    }

    public String getLokacijaVracanja() {
        return lokacijaVracanja;
    }

    public void setLokacijaVracanje(String lokacijaVracanje) {
        this.lokacijaVracanja = lokacijaVracanje;
    }

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public int getMesec() {
        return mesec;
    }

    public void setMesec(int mesec) {
        this.mesec = mesec;
    }

    

    public String getNaKolikoDana() {
        return naKolikoDana;
    }

    public void setNaKolikoDana(String naKolikoDana) {
        this.naKolikoDana = naKolikoDana;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    

    @Override
    public String toString() {
        return "Ime-> " + super.getIme() + ",\n" + "Prezime-> " + super.getPrezime() + "\n" + "Jmbg-> " + super.getJmbg() +
                "\n" + "Broj Telefona-> " + brojTelefona +"\n" + "Lokacija Preuzimanja-> " + lokacijaPreuzimanja +"\n" + "Lokacija Vracanja-> " + lokacijaVracanja +"\n" + "Datum Preuzimanja-> "+ dan + "." + mesec+ "\n" + "Na Koliko Dana-> " + naKolikoDana +"\n" + "Marka->" + marka + "\n"+ "Cena-> " + cena + " eura\n" +"------------------------------------------------------------------------"; 
    }
    
    
    
}

