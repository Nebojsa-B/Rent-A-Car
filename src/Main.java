
import java.awt.Color;
import java.awt.MenuBar;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;




public class Main extends JFrame implements ActionListener {
        JPanel panel = new JPanel();
        
        
        //----------->ADMIN PANEL<----------------//        
        JLabel adminLabel = new JLabel("-Admin Panel-");                                                           
        JButton pregledButton = new JButton("Pregled");                         //Dugmici za pristup administratorskoj strani
        //JButton obrisiButton = new JButton("Obrisi");
        JButton izmeniButton = new JButton("Izmeni");
                       
        //----->CHEK-IN,POCETNA STRANA<----//
        JLabel labelPozadina = new JLabel();                                    //Label koji koristim za sliku
        JLabel labelIme = new JLabel("Ime:");                                   //Blize objasnjavanje polja za upis Imena
        JFormattedTextField  imeField = new JFormattedTextField ();             //Polje za upis Imena
        JLabel labelPrezime = new JLabel("Prezime:");                           //Blize objasnjavanje polja za upis prezimena
        JTextField prezimeField = new JTextField();                             //Polje za upis prezimena
        JLabel labelJmbg = new JLabel("JMBG:");                                 //Blize objasnjavanje polja za JMBG
        JTextField jmbgField = new JTextField();                                //Polje za upis JMBG-a
        JButton checkButton = new JButton("CheckIn");                           //Dugme za pristup sledecoj strani
                
        //------>STRANA O DETALJNIJIM INFORMACIJAMA<-----//
        JLabel labelTelefon = new JLabel("Broj telefona:");                     //Blize objasnjavanje polja za uzimanje broja telefona
        TextField telefonField = new TextField();                               //Polje za upis broja telefona
        JLabel labelLokacijaPreuzimanja = new JLabel("Lokacija Preuzimanja:");  //Blize objasnjavanje liste lokacija za preuzimanje
        JComboBox comboLokacijaPreuzimanja = new JComboBox();                   //Lista lokacija za preuzimanje vozila
        JLabel labelLokacijaZaVracanje = new JLabel("Lokacija za vracanje:");   //Blize objasnjavanje liste lokacija za vracanje vozila
        JComboBox comboLokacijaZaVracanje = new JComboBox();                    //Lista lokacija za vracanje vozila
        JLabel labelDatumPreuzimanja = new JLabel("Datum preuzimanja->");       //Blize objasnjavanje polja za datum preuzimanja u formatu
        JLabel danLabel = new JLabel("Dan:");
        JLabel mesecLabel = new JLabel("Mesec:");                               //Polje za unos datuma preuzimanja
        JTextField danField = new JTextField();
        JTextField mesecField = new JTextField();
        JLabel labelKolikoDana = new JLabel("Na koliko dana?");                 //Blize objasnjavanje liste
        JComboBox comboKolikoDana = new JComboBox();                            //Lista za preuzimanje vozila na koliko dana, samo na odredjeno dana
        JButton izaberiAutoButton = new JButton("Izaberi Vozilo");              //Dugme za prelazak na sledecu stranu
        
        //------->STRANA ZA ODABIR VOZILA<--------//
        JLabel markaLabel = new JLabel("Marka");                                //Blize objasnjavanje liste za odabir marke
        JComboBox comboOdabirMarke = new JComboBox();                           //Lista za odabir marke vozila
        JLabel modelLabel = new JLabel("Model:");                               //Teske pored koje ide model auto, odabrane marke
        JLabel opisModelaLabel = new JLabel("-O Modelu-");                      //Tekst o modelu   
        JLabel labelAudi = new JLabel();                                        //labeli slika vozila, posto slike prikazujem preko labela
        JLabel labelBmw = new JLabel();
        JLabel labelJeep = new JLabel();
        JLabel labelLada = new JLabel();
        JLabel labelMazda = new JLabel();
        JLabel labelMercedes = new JLabel();
        JLabel labelVw = new JLabel();
        JLabel menjacLabel = new JLabel("Menjac:");                             //Specifikacije Vozila,labeli koji se ne menjaju
        JLabel gorivoLabel = new JLabel("Gorivo:");
        JLabel labelVrata = new JLabel("Vrata:");
        JLabel labelKlima = new JLabel("Klima:");
        JLabel labelGps = new JLabel("GPS:");
        JLabel menjac = new JLabel();                                           //Specifikacije vozila, dinamicko, u zavisnosti od marke izbacice odgovarajuce parametre za to vozilo
        JLabel gorivo = new JLabel();
        JLabel vrata = new JLabel();
        JLabel klima = new JLabel();
        JLabel gps = new JLabel();
        JLabel oModeluLabel = new JLabel();                                     //Label koji prikazuje model auta, kubikazu i tip vozila, u zavistnosti od odabira marke
        JLabel cenalabel = new JLabel("Cena:");                                 //Label za cenu
        JLabel cenaLabel = new JLabel();
        JButton rezervisiButton = new JButton("Rezervisi");                     //Dugme za rezervaciju vozila
      
        Klijent klijent = new Klijent();
        RentManager rentManager = new RentManager();
        Datoteka datoteka = new Datoteka();
        DatotekaSource datotekaSource = new DatotekaSource();
        
        
    public static void main(String[] args) {
        
        new Main();
    }
       
    public Main(){
        pocetna();                                                              //Kada se pokrene aplikacija, poziva se ova funkcija
        
    }
    
    public void pocetna(){                                         
        setTitle("CheckIn");                                                    //Postavljanje teksta Frame-a
        setSize(400,420);                                                       //Duzina, Sirina Frame-a
        setLocationRelativeTo(null);                                            //kada se pokrene da bude u centru ekrana
        panel.setBackground(Color.white);                                       //Pozadina bela, valjda
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                         //Kada se klikne X da se aplikacija zatvori, odnosno ugasi u potpunosti, a ne samo da se zatvori Frame
        setVisible(true);                                                       //Da bude frame vidljiv
        setResizable(false);                                                    //Da ne mogu korisnici da sire i skupljaju frame, posto mi polja nisu kao kod Google-a
        setLayout(null);                                                        //Nemam nikakve Bordere,Flow-e
        JMenuBar menubar = new JMenuBar();                                      //Kreiranje meni bara
        setJMenuBar(menubar);
        JMenu adminPanel = new JMenu("Opcije");                                 //Dodavanje u meni bar, opciju "opcije"
        menubar.add(adminPanel); 
        JMenuItem menuItemAdmin = new JMenuItem("Napredno");                    //Dodavanje u opcijama napredne opcije
        adminPanel.add(menuItemAdmin);
        
        setInvisible();

        labelIme.setVisible(true);                                              //Svi elemnti koji su mi potrebni za pocetnu stranu bice prikazani
        imeField.setVisible(true);
        labelPrezime.setVisible(true);
        prezimeField.setVisible(true);
        labelJmbg.setVisible(true);
        jmbgField.setVisible(true);
        checkButton.setVisible(true);
        labelPozadina.setVisible(true);

        ImageIcon background = new ImageIcon("slike/checkin.png");                    //Kreiranje slike, njena pozicija, i prikazivanje u vidu labela
        labelPozadina.setBounds(120, 60, 135, 100);       
        labelPozadina.setLayout(null);
        labelPozadina.setIcon(background);
        labelPozadina.setVisible(true);
    
        add();
        
        labelIme.setBounds(100, 200, 70, 20);                                   //Postavljanje pozicija elemata, njihove duzine i sirine
        imeField.setBounds(170, 200,100,20);
        labelPrezime.setBounds(95,240,100,20);
        prezimeField.setBounds(170, 240,100,20);
        labelJmbg.setBounds(110,280,90,20);
        jmbgField.setBounds(170,280,100,20);
        checkButton.setBounds(140,320,100,20);
        

        menuItemAdmin.addActionListener(new ActionListener()                    //ActionListener za opciju admin panel, da prebaci na panelAdmin()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                panelAdmin();
            }
        });
        
        jmbgField.addKeyListener(new KeyAdapter() {                             //KeyListener sam uveo jer mi omogucava da u polju mogu da postavim uslov da mogu da se upisuju samo brojevi
                                    public void keyTyped(KeyEvent e) {
                                    char c = e.getKeyChar();
                            if (c  < '0' || c > '9') {
                                e.consume();                                    //blokira ako nije broj
                                
                             }
         }
       });
        
        imeField.addKeyListener(new KeyAdapter() {                              //ista varijanta samo sto je sada uslov posatavljen da prima slova samo
                                    public void keyTyped(KeyEvent e) {
                                    char c = e.getKeyChar();
                            if (!(Character.isLetter(e.getKeyChar()))) {
                                e.consume();//blokira ako nije slovo
                                
                             }
         }
       });
        
        prezimeField.addKeyListener(new KeyAdapter() {      
                                    public void keyTyped(KeyEvent e) {
                                    char c = e.getKeyChar();
                            if (!(Character.isLetter(e.getKeyChar()))) {
                                e.consume();//blokira ako nije slovo
                                
                             }
         }
       });
        
        checkButton.addActionListener(new ActionListener()                      //ActionListener za prelazak na sledecu stranu
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            try
                    {
                        boolean imaGreske = false;                              //postavljam jednu for petlju i unutar nje if, kako bi mogao da break program ako uslov nije ispunjen
                        for(int i=0;i<1;i++){
                            
                            if (imeField.getText().isEmpty() || prezimeField.getText().isEmpty() || jmbgField.getText().isEmpty())
                            {
                                JOptionPane.showMessageDialog(null, "Popunite sva polja!", "Greska", 2);
                                imaGreske = true;
                                break;
                            }
                            if(jmbgField.getText().length() != 13){
                                JOptionPane.showMessageDialog(null, "JMBG mora da ima 13 cifara!", "Greska", 2);
                                imaGreske = true;
                                break;
                            }
                        }if(imaGreske == false){                                //ako nema greske, pokreni funkciju checkIN(), odnosno drugu stranu
                            checkIn();
                        }
                    } catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(rootPane, ex, "Greska!", 2);
                    }  
            }
        }); 
    }
    
 
    public void panelAdmin(){                                                   //Funkcija za adminov panel
           
            setSize(200,220);                                                   //Postavljanje velicine frame-a,imena i da se ne menja velicina frame-a
            setTitle("Admin Panel");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            
            setInvisible();
            
            adminLabel.setVisible(true);
            pregledButton.setVisible(true);
            izmeniButton.setVisible(true);
            
            add();
            
            adminLabel.setBounds(55,10,90,20);
            pregledButton.setBounds(40,50,120,20);
            izmeniButton.setBounds(40,130,120,20);
            
            
     
        pregledButton.addActionListener(new ActionListener()                    //Dugme poziva funkciju iz klase datoteka, u kojoj se prikazuju sve rezervacije preko JOptionPane
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String prikaz;
                    prikaz = datoteka.otvoriDatotekuVisePuta();
                    JOptionPane.showMessageDialog(null,prikaz);          
                }
            });
      
        izmeniButton.addActionListener(new ActionListener()                     /*Dugme poziva ceo fajl da se prikaze*/
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    
                    try {
                        datotekaSource.otvoriDatotekuSource();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            });     
    }
    
 
    public void checkIn(){                                                      //Funkcija za detaljnije inormacije
            
            setTitle("RENT-A-CAR");
            setSize(700,360);
            setLocationRelativeTo(null);
            panel.setBackground(Color.white);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(false);
            setLayout(null);
        
            setInvisible();
            
            labelTelefon.setVisible(true);
            telefonField.setVisible(true);
            labelLokacijaPreuzimanja.setVisible(true);
            comboLokacijaPreuzimanja.setVisible(true);
            labelLokacijaZaVracanje.setVisible(true);
            comboLokacijaZaVracanje.setVisible(true);
            labelDatumPreuzimanja.setVisible(true);
            danField.setVisible(true);
            mesecField.setVisible(true);
            danLabel.setVisible(true);
            mesecLabel.setVisible(true);
            labelKolikoDana.setVisible(true);
            comboKolikoDana.setVisible(true);
            izaberiAutoButton.setVisible(true);
            
            comboLokacijaPreuzimanja.addItem("Aerodrom Nikola Tesla");          //popunjavanje comboBoxa
            comboLokacijaPreuzimanja.addItem("Trg Republike Srbije");
            comboLokacijaPreuzimanja.addItem("Bulevar Milutina Milankovica 115");
            comboLokacijaPreuzimanja.addItem("Nebojsina 72");
            comboLokacijaPreuzimanja.addItem("Kneza Milosa 33");
            comboLokacijaPreuzimanja.setSelectedItem(null);                     //da se ne prikaze pre nego sto se klike na ComboBox
            
            comboLokacijaZaVracanje.addItem("Aerodrom Nikola Tesla");
            comboLokacijaZaVracanje.addItem("Trg Republike Srbije");
            comboLokacijaZaVracanje.addItem("Bulevar Milutina Milankovica 115");
            comboLokacijaZaVracanje.addItem("Nebojsina 72");
            comboLokacijaZaVracanje.addItem("Kneza Milosa 33");
            comboLokacijaZaVracanje.setSelectedItem(null);
            
            comboKolikoDana.addItem("2");                                       
            comboKolikoDana.addItem("5");
            comboKolikoDana.addItem("7");
            comboKolikoDana.addItem("14");
            comboKolikoDana.addItem("20");
            comboKolikoDana.addItem("30+");
            comboKolikoDana.setSelectedItem(null);
            
            add();
            
            labelTelefon.setBounds(20,20,75,25);
            telefonField.setBounds(110,25,100,20);
            labelLokacijaPreuzimanja.setBounds(20,65,125,25);
            comboLokacijaPreuzimanja.setBounds(170,65,200,25);
            labelLokacijaZaVracanje.setBounds(20,110,120,25);
            comboLokacijaZaVracanje.setBounds(170,110,200,25);
            labelDatumPreuzimanja.setBounds(20,155,170,20);
            danLabel.setBounds(170,155,50,20);
            danField.setBounds(200,155,20,20);
            mesecLabel.setBounds(250,155,90,20);
            mesecField.setBounds(300,155,20,20);
            labelKolikoDana.setBounds(40,200,100,20);
            comboKolikoDana.setBounds(150,200,50,20);
            izaberiAutoButton.setBounds(120,270,150,20);
             
        telefonField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c  < '0' || c > '9') {
                e.consume();
                                
               }
            }
       });
            
        danField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                    if (c  < '0' || c > '9') {
                    e.consume();
                    }
            }
        });
        
        mesecField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c  < '0' || c > '9') {
                e.consume();
                }
            }
       });
        
        comboLokacijaPreuzimanja.addActionListener(new ActionListener()
            {
                @Override
                    public void actionPerformed(ActionEvent e) { 
                    String odabirLokacijePreuzimanjaSrting = (String)comboLokacijaPreuzimanja.getSelectedItem();
                    JTextField odabirLokacijePreuzimanja = new JTextField(odabirLokacijePreuzimanjaSrting);
        
                    klijent.setLokacijaPreuzimanja(odabirLokacijePreuzimanja.getText());
                    }
            }); 
            
        comboLokacijaZaVracanje.addActionListener(new ActionListener()
            {
                @Override
                    public void actionPerformed(ActionEvent e) { 
                        String odabirLokacijeZavracanjeSrting = (String)comboLokacijaZaVracanje.getSelectedItem();
                        JTextField odabirLokacijeZaVracanja = new JTextField(odabirLokacijeZavracanjeSrting);
        
                        klijent.setLokacijaVracanje(odabirLokacijeZaVracanja.getText());
                    }
            }); 
            
        comboKolikoDana.addActionListener(new ActionListener()
            {
                @Override
                    public void actionPerformed(ActionEvent e) { 
                        String odabirLokacijeZavracanjeInteger = (String)comboKolikoDana.getSelectedItem();
                        JTextField naKolikoDanaField = new JTextField(odabirLokacijeZavracanjeInteger);

                        klijent.setNaKolikoDana(naKolikoDanaField.getText());
                    }
            }); 
            
        izaberiAutoButton.addActionListener(new ActionListener()            //Dugme za prelazak na sledecu stranu
            {
                @Override
                    public void actionPerformed(ActionEvent e)
                        {
                   
                            try
                            {
                                boolean imaGreske = false;
                                for(int i=0;i<1;i++){
                            
                                    if (telefonField.getText().isEmpty() || danField.getText().isEmpty() || mesecField.getText().isEmpty())
                                    {
                                        JOptionPane.showMessageDialog(null, "Popunite sva polja", "Greska", 2);
                                        imaGreske = true;
                                        break;
                                    }
                                   if (comboLokacijaPreuzimanja.getSelectedItem() == null)
                                   {
                                        JOptionPane.showMessageDialog(null, "Izaberite lokaciju preuzimanja", "Greska", 2);
                                        imaGreske = true;
                                        break;
                                    }
                                   if (comboLokacijaZaVracanje.getSelectedItem() == null)
                                   {
                                        JOptionPane.showMessageDialog(null, "Izaberite lokaciju vrcanja vozila, ako planirate da vratite", "Greska", 2);
                                        imaGreske = true;
                                        break;
                                    }
                                    if (comboKolikoDana.getSelectedItem() == null)
                                    {
                                        JOptionPane.showMessageDialog(null, "Izaberite na koliko dana zelite da iznajmite vozilo", "Greska", 2);
                                        imaGreske = true;
                                        break;
                                    }
                                    if (Integer.parseInt(danField.getText()) > 30 || Integer.parseInt(danField.getText()) == 0)                         //Ne moram da postavljam uslov i za negativne brojeve, keylistener blokira sve sto nije broj
                                    {
                                        JOptionPane.showMessageDialog(null, "Pogresili ste unos Dana", "Greska", 2);
                                        imaGreske = true;
                                        break;
                                    }
                                    if (Integer.parseInt(mesecField.getText()) > 13 || Integer.parseInt(mesecField.getText()) == 0)
                                    {
                                        JOptionPane.showMessageDialog(null, "Pogresili ste unos Meseca", "Greska", 2);
                                        imaGreske = true;
                                        break;
                                    }    
                                }
                                
                                if(imaGreske == false){
                                    izaberiAuto();
                                }
                               
                            } catch (NumberFormatException ex)
                            {
                                JOptionPane.showMessageDialog(rootPane, ex, "Greska!", 2);
                            }
                        }
            }); 
            
                
    }
   
    public void izaberiAuto(){                                                  //Funkcija za odabir vozila
            
            setTitle("Odabir Vozila");
            setSize(700,430);
            setLocationRelativeTo(null);
            panel.setBackground(Color.white);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(true);
            setLayout(null);
            
            setInvisible();
            
            markaLabel.setVisible(true);
            comboOdabirMarke.setVisible(true);
            oModeluLabel.setVisible(true);
            opisModelaLabel.setVisible(true);
            cenalabel.setVisible(true);
            cenaLabel.setVisible(true);
            rezervisiButton.setVisible(true);
            labelAudi.setVisible(true);
            labelBmw.setVisible(true);
            labelJeep.setVisible(true);
            labelLada.setVisible(true);
            labelMazda.setVisible(true);
            labelMercedes.setVisible(true);
            labelVw.setVisible(true);
            menjacLabel.setVisible(true);
            gorivoLabel.setVisible(true);
            labelVrata.setVisible(true);
            labelKlima.setVisible(true);
            labelGps.setVisible(true);
            menjac.setVisible(true);
            gorivo.setVisible(true);
            vrata.setVisible(true);
            klima.setVisible(true);
            gps.setVisible(true);
            modelLabel.setVisible(true);
            
            add();
            
            markaLabel.setBounds(10,30,70,20);
            comboOdabirMarke.setBounds(70,30,100,20);
            cenalabel.setBounds(450,340,40,20);
            cenaLabel.setBounds(490,340,50,20);
            opisModelaLabel.setBounds(60,130,100,20);
            rezervisiButton.setBounds(60,330,100,20);
            modelLabel.setBounds(20,100,90,20);
            oModeluLabel.setBounds(70,100,200,20);
            opisModelaLabel.setBounds(100,140,100,20);
            menjacLabel.setBounds(30,170,70,20);
            gorivoLabel.setBounds(30,200,70,20);
            labelVrata.setBounds(30,230,70,20);
            labelKlima.setBounds(30,260,70,20);
            labelGps.setBounds(30,290,70,20);
            menjac.setBounds(100,170,200,20);
            gorivo.setBounds(100,200,200,20);
            vrata.setBounds(100,230,200,20);
            klima.setBounds(100,260,200,20);
            gps.setBounds(100,290,200,20);
            
            comboOdabirMarke.addItem("Audi");
            comboOdabirMarke.addItem("BMW");
            comboOdabirMarke.addItem("Jeep");
            comboOdabirMarke.addItem("Lada");
            comboOdabirMarke.addItem("Mazda");
            comboOdabirMarke.addItem("Mercedes");
            comboOdabirMarke.addItem("Volkswagen");
            comboOdabirMarke.setSelectedItem(null);
            
            ImageIcon audiImage = new ImageIcon("slike/audi6.png");                   //Pozivanje i pravljenje slika vozila
            labelAudi.setBounds(250, 100, 450, 232);       
            labelAudi.setLayout(null);
            labelAudi.setIcon(audiImage);
                ImageIcon bmwImage = new ImageIcon("slike/bmw.png");
                labelBmw.setBounds(250, 100, 450, 232);        
                labelBmw.setLayout(null);
                labelBmw.setIcon(bmwImage);
                    ImageIcon jeepImage = new ImageIcon("slike/jeep.png");
                    labelJeep.setBounds(280, 100, 380, 232);        
                    labelJeep.setLayout(null);
                    labelJeep.setIcon(jeepImage);
                        ImageIcon ladaImage = new ImageIcon("slike/lada.png");
                        labelLada.setBounds(280, 50, 450, 337);         
                        labelLada.setLayout(null);
                        labelLada.setIcon(ladaImage);
                            ImageIcon mazdaImage = new ImageIcon("slike/mazda6.png");
                            labelMazda.setBounds(250, 100, 450, 232);         
                            labelMazda.setLayout(null);
                            labelMazda.setIcon(mazdaImage);
                                ImageIcon mercedesImage = new ImageIcon("slike/mercedes.png");
                                labelMercedes.setBounds(250, 100, 450, 232);        
                                labelMercedes.setLayout(null);
                                labelMercedes.setIcon(mercedesImage);
                                    ImageIcon vwImage = new ImageIcon("slike/vw.png");
                                    labelVw.setBounds(250, 100, 450, 232);         
                                    labelVw.setLayout(null);
                                    labelVw.setIcon(vwImage);
            
            comboOdabirMarke.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e) { 
                        
                        
                        int indexodabirMarke = comboOdabirMarke.getSelectedIndex();
                        int indexKolikoDana = comboKolikoDana.getSelectedIndex();
                        int rezultat = 0;
                    if(indexKolikoDana == 0 && indexodabirMarke == 0){
                        rezultat = 2 * 5;
                    }
                    if(indexKolikoDana == 1 && indexodabirMarke == 0){
                        int cena = 5 * 5;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 2 && indexodabirMarke == 0){
                        int cena = 7 * 5;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 3 && indexodabirMarke == 0){
                        int cena = 14 * 5;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 4 && indexodabirMarke == 0){
                        int cena = 20 * 5;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 5 && indexodabirMarke == 0){
                        int cena = 30 * 5;
                        rezultat = cena;
                    }
                    //
                    if(indexKolikoDana == 0 && indexodabirMarke == 1){
                        int cena = 2 * 4;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 1 && indexodabirMarke == 1){
                        int cena = 5 * 4;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 2 && indexodabirMarke == 1){
                        int cena = 7 * 4;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 3 && indexodabirMarke == 1){
                        int cena = 14 * 4;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 4 && indexodabirMarke == 1){
                        int cena = 20 * 4;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 5 && indexodabirMarke == 1){
                        int cena = 30 * 4;
                        rezultat = cena;
                    }
                    //
                    if(indexKolikoDana == 0 && indexodabirMarke == 2){
                        int cena = 2 * 6;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 1 && indexodabirMarke == 2){
                        int cena = 5 * 6;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 2 && indexodabirMarke == 2){
                        int cena = 7 * 6;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 3 && indexodabirMarke == 2){
                        int cena = 14 * 6;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 4 && indexodabirMarke == 2){
                        int cena = 20 * 6;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 5 && indexodabirMarke == 2){
                        int cena = 30 * 6;
                        rezultat = cena;
                    }
                    //
                    if(indexKolikoDana == 0 && indexodabirMarke == 3){
                        int cena = 2 * 0;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 1 && indexodabirMarke == 3){
                        int cena = 5 * 0;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 2 && indexodabirMarke == 3){
                        int cena = 7 * 0;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 3 && indexodabirMarke == 3){
                        int cena = 14 * 0;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 4 && indexodabirMarke == 3){
                        int cena = 20 * 0;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 5 && indexodabirMarke == 3){
                        int cena = 30 * 0;
                        rezultat = cena;
                    }
                    //
                    if(indexKolikoDana == 0 && indexodabirMarke == 4){
                        int cena = 2 * 3;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 1 && indexodabirMarke == 4){
                        int cena = 5 * 3;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 2 && indexodabirMarke == 4){
                        int cena = 7 * 3;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 3 && indexodabirMarke == 4){
                        int cena = 14 * 3;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 4 && indexodabirMarke == 4){
                        int cena = 20 * 3;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 5 && indexodabirMarke == 4){
                        int cena = 30 * 3;
                        rezultat = cena;
                    }
                    //
                    if(indexKolikoDana == 0 && indexodabirMarke == 5){
                        int cena = 2 * 8;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 1 && indexodabirMarke == 5){
                        int cena = 5 * 8;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 2 && indexodabirMarke == 5){
                        int cena = 7 * 8;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 3 && indexodabirMarke == 5){
                        int cena = 14 * 8;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 4 && indexodabirMarke == 5){
                        int cena = 20 * 8;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 5 && indexodabirMarke == 5){
                        int cena = 30 * 8;
                        rezultat = cena;
                    }
                    //
                    if(indexKolikoDana == 0 && indexodabirMarke == 6){
                        int cena = 2 * 2;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 1 && indexodabirMarke == 6){
                        int cena = 5 * 2;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 2 && indexodabirMarke == 6){
                        int cena = 7 * 2;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 3 && indexodabirMarke == 6){
                        int cena = 14 * 2;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 4 && indexodabirMarke == 6){
                        int cena = 20 * 2;
                        rezultat = cena;
                    }
                    if(indexKolikoDana == 5 && indexodabirMarke == 6){
                        int cena = 30 * 2;
                        rezultat = cena;
                    }


                            cenaLabel.setForeground(Color.green);
                            cenaLabel.setText(Integer.toString(rezultat));
            
                            klijent.setCena(Integer.parseInt(cenaLabel.getText()));
                        
                    if(e.getSource() == comboOdabirMarke){              
                            JComboBox box = (JComboBox)e.getSource();
                            String msg = (String)box.getSelectedItem();
                            String odabirMarkeSrting = (String)comboOdabirMarke.getSelectedItem();
                            JTextField odabirMarkeField = new JTextField(odabirMarkeSrting);
        
                        switch(msg){
                            case "Audi":oModeluLabel.setText("A6, 2.0, Limunzina");
                                    menjac.setText("5-stepeni, automatski");
                                    gorivo.setText("Dizel");
                                    vrata.setText("4/5");
                                    klima.setText("Da");
                                    gps.setText("Da");
                                    InvisiblePictures();
                                    labelAudi.setVisible(true);break;
                             
                            case "BMW":oModeluLabel.setText("M2, 3.0, Kupe");
                                    menjac.setText("5-stepeni, poluautomatski");
                                    gorivo.setText("Benzin");
                                    vrata.setText("2/3");
                                    klima.setText("Da");
                                    gps.setText("Da");
                                    InvisiblePictures();
                                    labelBmw.setVisible(true);break;
                            
                            case "Jeep":oModeluLabel.setText("Grand Cherokee, 3.0, Dzip/SUV");
                                    menjac.setText("6-stepeni, automatski, reduktor");
                                    gorivo.setText("Dizel");
                                    vrata.setText("4/5");
                                    klima.setText("Da");
                                    gps.setText("Da");
                                    InvisiblePictures();
                                    labelJeep.setVisible(true);break;
                        
                            case "Lada":oModeluLabel.setText("Niva, 1.7, Dzip/SUV");
                                    menjac.setText("5-stepeni, manuelni, reduktor");
                                    gorivo.setText("Dizel");
                                    vrata.setText("2/3");
                                    klima.setText("Ne");
                                    gps.setText("Ne");
                                    InvisiblePictures();
                                    labelLada.setVisible(true);break;
                        
                            case "Mazda":oModeluLabel.setText("6, 2.0, Karavan");
                                    menjac.setText("6-stepeni, automatski");
                                    gorivo.setText("Dizel");
                                    vrata.setText("4/5");
                                    klima.setText("Da");
                                    gps.setText("Da");
                                    InvisiblePictures();
                                    labelMazda.setVisible(true);break;
                        
                            case "Mercedes":oModeluLabel.setText("S500, 5.0, Limunzina");
                                    menjac.setText("6-stepeni, automatski");
                                    gorivo.setText("Hybrid");
                                    vrata.setText("4/5");
                                    klima.setText("Da");
                                    gps.setText("Da");
                                    InvisiblePictures();
                                    labelMercedes.setVisible(true);break;
                        
                            case "Volkswagen":oModeluLabel.setText("Golf 7, 2.0, Hecbek");
                                    menjac.setText("6-stepeni, automatski");
                                    gorivo.setText("Dizel");
                                    vrata.setText("4/5");
                                    klima.setText("Da");
                                    gps.setText("Da");
                                    InvisiblePictures();
                                    labelVw.setVisible(true);break;
                                
                        }
                        klijent.setMarka(odabirMarkeField.getText());
                        }
                    }
                }); 
            rezervisiButton.addActionListener(new ActionListener()
                {
                
                    @Override
                    public void actionPerformed(ActionEvent e) { 
                            
                            try
                    {
                        boolean imaGreske = false;
                        for(int i=0;i<1;i++){
                            
                            if (comboOdabirMarke.getSelectedItem() == null)
                            {
                                JOptionPane.showMessageDialog(null, "Odaberite Marku vozila", "Greska", 2);
                                imaGreske = true;
                                break;
                            }
                            
                        }if(imaGreske == false){
                        
                            klijent.setIme(imeField.getText());
                            klijent.setPrezime(prezimeField.getText());
                            klijent.setJmbg(jmbgField.getText());
                            klijent.setBrojTelefona(telefonField.getText());
                            klijent.setDan(Integer.parseInt(danField.getText()));
                            klijent.setMesec(Integer.parseInt(mesecField.getText()));
                            
                            rentManager.dodajMusteriju(klijent);
                            
                            datoteka.upisUDatoteke(rentManager);
                            
                            String prikaz;
                            prikaz = datoteka.otvoriDatotekuSamoJednom();
                            JOptionPane.showMessageDialog(null,prikaz);
                            
                            String prikaz2;
                            prikaz2 = datoteka.otvoriDatotekuVisePuta();
                            
                            rezervisiButton.setEnabled(false);
                        }  
                            
                        
                        
                    } catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(rootPane, ex, "Greska!", 2);
                    } 
                    
                    }
                }); 
            
    }
    
 
    
    
    public void add(){
        
        add(labelIme);                                                          //pocetna                                                   
        add(imeField);
        add(labelPrezime);
        add(prezimeField);
        add(labelJmbg);
        add(jmbgField);
        add(checkButton);
        add(labelPozadina);
        add(adminLabel); 
        add(pregledButton);
        add(izmeniButton);
        add(panel);                                                         //checkIn
        add(labelTelefon);
        add(telefonField);
        add(labelLokacijaPreuzimanja);
        add(comboLokacijaPreuzimanja);
        add(labelLokacijaZaVracanje);
        add(comboLokacijaZaVracanje);
        add(labelDatumPreuzimanja);
        add(danField);
        add(mesecField);
        add(danLabel);
        add(mesecLabel);
        add(labelKolikoDana);
        add(comboKolikoDana);
        add(izaberiAutoButton);
        add(comboLokacijaPreuzimanja);
        add(markaLabel);                                                    //izaberi auto
        add(comboOdabirMarke);
        add(oModeluLabel);
        add(opisModelaLabel);
        add(cenalabel);
        add(cenaLabel);
        add(rezervisiButton);
        add(panel);
        add(modelLabel);
        add(opisModelaLabel);
        add(labelAudi);
        add(labelBmw);
        add(labelJeep);
        add(labelLada);
        add(labelMazda);
        add(labelMercedes);
        add(labelVw);
        add(menjacLabel);
        add(gorivoLabel);
        add(labelVrata);
        add(labelKlima);
        add(labelGps);
        add(menjac);
        add(gorivo);
        add(vrata);
        add(klima);
        add(gps);
        add(comboOdabirMarke);
            
    }
        
    public void setInvisible(){                                                 //Postavljanje svih labela, dugmadi i polja da budu nevidljivi, kako bi mogao da manipulisem njima kroz Frame
      adminLabel.setVisible(false);
      pregledButton.setVisible(false);
     // obrisiButton.setVisible(false);
      izmeniButton.setVisible(false);
      labelPozadina.setVisible(false);
      labelIme.setVisible(false);
      imeField.setVisible(false);
      labelPrezime.setVisible(false);
      prezimeField.setVisible(false);
      labelJmbg.setVisible(false);
      jmbgField.setVisible(false);
      checkButton.setVisible(false);
      labelTelefon.setVisible(false);
      telefonField.setVisible(false);
      labelLokacijaPreuzimanja.setVisible(false);
      comboLokacijaPreuzimanja.setVisible(false);
      labelLokacijaZaVracanje.setVisible(false);
      comboLokacijaZaVracanje.setVisible(false);
      labelDatumPreuzimanja.setVisible(false);
      danField.setVisible(false);
      mesecField.setVisible(false);
      danLabel.setVisible(false);
      mesecLabel.setVisible(false);
      labelKolikoDana.setVisible(false);
      comboKolikoDana.setVisible(false);
      izaberiAutoButton.setVisible(false);
      markaLabel.setVisible(false);
      comboOdabirMarke.setVisible(false);
      oModeluLabel.setVisible(false);
      opisModelaLabel.setVisible(false);
      cenalabel.setVisible(false);
      cenaLabel.setVisible(false);
      rezervisiButton.setVisible(false);
      labelAudi.setVisible(false);
      labelBmw.setVisible(false);
      labelJeep.setVisible(false);
      labelLada.setVisible(false);
      labelMazda.setVisible(false);
      labelMercedes.setVisible(false);      
      labelVw.setVisible(false);
      menjacLabel.setVisible(false);
      gorivoLabel.setVisible(false);
      labelVrata.setVisible(false);
      labelKlima.setVisible(false);
      labelGps.setVisible(false);
      menjac.setVisible(false);
      gorivo.setVisible(false);
      vrata.setVisible(false);
      klima.setVisible(false);
      gps.setVisible(false);
      modelLabel.setVisible(false);
      labelAudi.setVisible(false);
      labelBmw.setVisible(false);
      labelJeep.setVisible(false);
      labelLada.setVisible(false);
      labelMazda.setVisible(false);
      labelMercedes.setVisible(false);
      labelVw.setVisible(false);   
    }
   
    public void InvisiblePictures(){                                            //Postavljanje labela slika da budu nevidljivi, da ne bi se ubagovalo, posle ih pozivam, u zavistnosti od odabira marke
        labelAudi.setVisible(false);
        labelBmw.setVisible(false);
        labelJeep.setVisible(false);
        labelLada.setVisible(false);
        labelMazda.setVisible(false);
        labelMercedes.setVisible(false);
        labelVw.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

  
}
