public class SamochodMiejski extends Pojazd implements Car{

    String rodzajsilnika;

    SamochodMiejski(String kolor, int rozmiar, int pojemnoscSilnika, String rodzajsilnika, Osoba wlasciciel, String rejestracja, String marka) {

        super(kolor, rozmiar, pojemnoscSilnika, wlasciciel, rejestracja, marka);
        this.rodzajsilnika = rodzajsilnika;
        wlasciciel.dodajDoListyPosiadanychSamochdow(this);

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
