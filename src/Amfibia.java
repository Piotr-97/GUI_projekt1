public class Amfibia extends Pojazd implements Car, Boat{

    int pojemnoscsilnikamotorowego;
    Amfibia(String kolor, int rozmiar,int pojemnoscsilnika, int pojemnoscsilnikamotorowego, Osoba wlasciciel, String rejestracja,String marka) {
        super(kolor, rozmiar, pojemnoscsilnika, wlasciciel,rejestracja,marka);
        this.pojemnoscsilnikamotorowego = pojemnoscsilnikamotorowego;
        wlasciciel.dodajDoListyPosiadanychSamochdow(this);

    }

    @Override
    public void plyn() {

    }

    @Override
    public void jedz() {

    }

    @Override
    public void hamuj() {

    }

    @Override
    public void gaz() {

    }
}
