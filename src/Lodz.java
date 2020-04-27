public class Lodz extends Pojazd implements Boat{

    private int polepowierzchnizagla;

    Lodz(String kolor, int rozmiar, int pojemnoscSilnika, int polepowierzchnizagla, Osoba wlasciciel, String rejestracja, String marka) {
        super(kolor, rozmiar, pojemnoscSilnika, wlasciciel, rejestracja,marka);
        this.polepowierzchnizagla = polepowierzchnizagla;
        wlasciciel.dodajDoListyPosiadanychSamochdow(this);
    }

    @Override
    public void plyn() {

    }
}
