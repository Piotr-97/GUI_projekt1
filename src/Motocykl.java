public class Motocykl extends Pojazd{

    private String typ;

    Motocykl(String kolor, int rozmiar, int pojemnoscSilnika, Osoba wlasciciel, String typ,String rejestracja, String marka) {
        super(kolor, rozmiar, pojemnoscSilnika, wlasciciel,rejestracja, marka);
        this.typ = typ;
        wlasciciel.dodajDoListyPosiadanychSamochdow(this);
    }
}
