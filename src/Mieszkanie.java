import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Mieszkanie {

    private static int iloscMieszkan = 0;
    private int  metraz; // Wyrazony w m^2
    private Osoba najemca;



    private int mieszkanieID;
    private int czynsz;
    ArrayList<Osoba> listaDomownikow = new ArrayList<>();



    Mieszkanie(int metraz, int czynsz, Osiedle osiedle){
        this.metraz = metraz;
        this.czynsz = czynsz;
        this.mieszkanieID = iloscMieszkan+1;
        osiedle.dodajMieszkanie(this);
        iloscMieszkan++;

    }


    public int getMetraz(){
        return metraz;
    }

    public int getCzynsz() {
        return czynsz;
    }


    @Override
    public String toString() {
        return  "mieszkanieID= " + mieszkanieID +
                ", metraz=" + metraz +
                ", czynsz= " + czynsz ;
    }

    public int getMieszkanieID() {
        return mieszkanieID;
    }
}
