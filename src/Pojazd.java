public class Pojazd {
    String marka;
    private String kolor;

    @Override
    public String toString() {
        return "Pojazd " +
                "marka= " + marka +
                ", kolor= " + kolor +
                ", rejestracja= " + rejestracja ;
    }

    private int rozmiar;
    private int pojemnoscSilnika;
    private Osoba wlasciciel;
    String rejestracja;


    Pojazd(String kolor, int rozmiar, int pojemnoscSilnika, Osoba wlasciciel, String rejestracja, String marka){
        this.kolor = kolor;
        this.rozmiar = rozmiar;
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.wlasciciel = wlasciciel;
        this.rejestracja = rejestracja;
        this.marka = marka;

    }

    public int getRozmiar(){

        return rozmiar;
    }
}
