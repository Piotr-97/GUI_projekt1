import java.util.ArrayList;

public class MiejsceParkingowe {

    private static int iloscMiejscParkingowych = 0;
    private int  rozmiar; // Wyrazony w m^2
    private String parkingID;
    private int czynsz;
     private Osiedle osiedle;
    private ArrayList<Pojazd> listaSamochodowNaParkingu = new ArrayList<>();

    MiejsceParkingowe(int rozmiar, int czynsz, Osiedle osiedle){
        this.rozmiar = rozmiar;
        this.czynsz = czynsz;
        this.osiedle = osiedle;
        this.parkingID = "MP" + iloscMiejscParkingowych+1;
        osiedle.dodajMiejsceParkingowe(this);

        iloscMiejscParkingowych++;


    }
    public int getRozmiar() {

        return rozmiar;
    }

    public int ilosoSamochodow(){

        return listaSamochodowNaParkingu.size();
    }
    public ArrayList zaparkowaneSamochody(){

        return  listaSamochodowNaParkingu;
    }

    public String getParkingID() {
        return parkingID;
    }

    @Override
    public String toString() {
        return "MiejsceParkingowe :" +
                "rozmiar=" + rozmiar +
                ", ID='" + parkingID +
                ", czynsz=" + czynsz;
    }







}
