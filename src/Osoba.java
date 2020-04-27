import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Osoba {


    private String imie;



    private String nazwisko;
    private String pesel;
    private String adres;
    private String dataUrodzenia;

    private int stanKonta;
    private ArrayList<Mieszkanie> wynajeteMieszkania = new ArrayList<>();


    private ArrayList<MiejsceParkingowe> wynajeteParkingi = new ArrayList<>();
    private ArrayList<Pojazd> posiadanepojazdy = new ArrayList<>();

    private ArrayList<File> otrzymanepisma = new ArrayList<>();



    public Osoba(String imie, String nazwisko, String pesel, String adres, String dataUrodzenia, int stanKonta, Osiedle osiedle) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
        this.stanKonta = stanKonta;
        osiedle.dodajdolistyOsob(this);

    }
    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public String toString() {
        return "Osoba " +
                "imie= " + imie +
                ", nazwisko = " + nazwisko +
                ", pesel = " + pesel +
                ", adres = " + adres +
                ", data urodzenia = " + dataUrodzenia +
                ", stan Konta = " + stanKonta +
                ", wynajeteMieszkania = " + wynajeteMieszkania.size()+
                ", wynajeteParkingi = " + wynajeteParkingi.size() +
                ", posiadanepojazdy = " + posiadanepojazdy.toString() +
                ", otrzymanepisma= " + otrzymanepisma.size();
    }




    public void wynajmijM(Osoba najemca, Mieszkanie mieszkanie,Osiedle osiedle){

        if((najemca.wynajeteParkingi.size()+najemca.wynajeteMieszkania.size()) > 5){
            System.out.println("Nie mozna wynajac, najemca ma za dużo wynajetych obiektow");
        }else{

            najemca.wynajeteMieszkania.add(mieszkanie);
            osiedle.mieszkanieNajete(mieszkanie);
            osiedle.dodajNajemcedoListy(najemca);
        }


    }
    public void wynajmij(Osoba najemca, MiejsceParkingowe miejsceParkingowe,Osiedle osiedle){

        if((najemca.wynajeteMieszkania.size()+najemca.wynajeteParkingi.size()) < 5){

            najemca.wynajeteParkingi.add( miejsceParkingowe);
            osiedle.parkingNajety(miejsceParkingowe);
        }else{
            System.out.println("Nie mozna wynajac, najemca ma za dużo wynajetych obiektow");


        }

    }
    public void zaparkuj(Osoba osoba, Pojazd pojazd, MiejsceParkingowe miejsceParkingowe){
          if(miejsceParkingowe.ilosoSamochodow()>0) {
              int zajeteMiejsce = 0;
              for (int i = 0; i < miejsceParkingowe.ilosoSamochodow(); i++) {

                  Pojazd p1 = (Pojazd) miejsceParkingowe.zaparkowaneSamochody().get(i);
                  zajeteMiejsce = zajeteMiejsce + p1.getRozmiar();
              }

              if(zajeteMiejsce > miejsceParkingowe.getRozmiar()){
                        try {
                                throw new ProblematicTenantException();
                        } catch (ProblematicTenantException e) {
                          //  System.out.println("Wrocisz teraz do menu");
                         //
                        }
              }
              else{
                  miejsceParkingowe.zaparkowaneSamochody().add(pojazd);

              }
          }else{
              miejsceParkingowe.zaparkowaneSamochody().add(pojazd);


          }
    }


    public void wyswietlposiadanepojazdy(){
        for(int i = 0; i < posiadanepojazdy.size(); i++){
            System.out.println(posiadanepojazdy.get(i).rejestracja + " "+ posiadanepojazdy.get(i).marka);
        }

    }
    public String getPesel(){
        return pesel;
    }




    public void wyswietlparkingi() {
        try {
            for (int i = 0; i < wynajeteParkingi.size(); i++) {
                System.out.println(wynajeteParkingi.get(i).toString());
            }
        }catch (NullPointerException e){
            System.out.println("Nie masz parkingu");
        }
    }


    public Pojazd wybierzpojazd() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Wybierz pojazd(wpisz jego rejestracje)");
        try {
            String rejestracja = reader.readLine();
            for(int i = 0; i < posiadanepojazdy.size();i++){
                if(rejestracja.equals(posiadanepojazdy.get(i).rejestracja));
                return posiadanepojazdy.get(i);
            }
            return null;

        } catch (IOException e) {
            System.out.println("Sproboj jescze raz");
            wybierzpojazd();
            return null;
        }



    }

    public MiejsceParkingowe wybierzparking() { BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Wybierz miejsce parkingowe(Wpisz jego id)");
        try {
            String miejsceparkingowe= reader.readLine();
            for(int i = 0; i < posiadanepojazdy.size();i++){
                if(miejsceparkingowe.equals(wynajeteParkingi.get(i).getParkingID()));
                return  wynajeteParkingi.get(i);
            }
            return null;


        }catch (IOException e){
            System.out.println("sproboj jescze raz");
            wybierzparking();
        }
        return null;
    }


    public void zwolnijmiejsceparkingowe(Osoba osoba,MiejsceParkingowe miejsceParkingowe,Pojazd pojazd){
        miejsceParkingowe.zaparkowaneSamochody().remove(pojazd);

    }

    public ArrayList<Mieszkanie> getWynajeteMieszkania() {
        return wynajeteMieszkania;
    }


    public int getStanKonta() {
        return stanKonta;
    }

    public void oplac(int koszta){
        stanKonta=stanKonta-koszta;

    }

    public void dodajPismo(){
        otrzymanepisma.add(new File());
    }
    public ArrayList<File> getOtrzymanepisma() {
        return otrzymanepisma;
    }
    public ArrayList<Pojazd> getPosiadanepojazdy() {
        return posiadanepojazdy;
    }


    public void dodajDoListyPosiadanychSamochdow(Pojazd pojazd) {
        posiadanepojazdy.add(pojazd);
    }
}

