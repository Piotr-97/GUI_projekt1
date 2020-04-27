public class SamochodTerenowy extends Pojazd implements  Car{
    SamochodTerenowy(String kolor, int rozmiar, int pojemnoscSilnika, Osoba wlasciciel, String rejestracja, String marka) {

        super(kolor, rozmiar, pojemnoscSilnika,wlasciciel,rejestracja,marka);
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
