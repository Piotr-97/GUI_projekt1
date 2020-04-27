import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public  class Osiedle implements Comparator<Mieszkanie> {

    private static ArrayList<Mieszkanie> listaMieszkan = new ArrayList<>();
    private  static ArrayList<Mieszkanie> listaWolnychMieszkan = new ArrayList<>();

    private  static ArrayList<MiejsceParkingowe> listaMiejscParkingowych = new ArrayList<>();
    private  static ArrayList<MiejsceParkingowe> listaWolnychMiejscParkingowych = new ArrayList<>();

    private static  HashSet<Osoba> listaNajemcow = new HashSet<>();// w secie
    private static  ArrayList<Osoba> prawdziwaListanajemcow =new ArrayList<>();

    private static HashMap<Osoba, ArrayList> listaposiadanychrzeczyWlasciciela = new HashMap<>();

    private static ArrayList<Osoba> listaWszystkichOsob = new ArrayList<>();



    public void dodajMieszkanie(Mieszkanie mieszkanie){
        listaWolnychMieszkan.add(mieszkanie);
        listaMieszkan.add(mieszkanie);
    }

    public void wyswietlPusteMieszkania(){
        for(Mieszkanie m: listaWolnychMieszkan){
            System.out.println(m.toString());
        }
    }

    public void mieszkanieNajete(Mieszkanie mieszkanie){
        listaWolnychMieszkan.remove(mieszkanie);
    }

   public void dodajMiejsceParkingowe(MiejsceParkingowe miejsceParkingowe){
        listaMiejscParkingowych.add(miejsceParkingowe);
        listaWolnychMiejscParkingowych.add(miejsceParkingowe);


   }
    public void wyswietlPusteMiejscaParkingowe(){

        for (MiejsceParkingowe mp: listaWolnychMiejscParkingowych) {
            System.out.println(mp.toString());

        }
    }

    public void parkingNajety(MiejsceParkingowe miejsceParkingowe){
        listaWolnychMiejscParkingowych.remove(miejsceParkingowe);
    }


    public void dodajNajemcedoListy(Osoba osoba){

        listaNajemcow.add(osoba);
    }

    public void zapisStanuOsiedla(){

        try {
            FileOutputStream fos = new FileOutputStream("c:\\Projekt\\zapis.txt");
            sortujMiejscaParkingowe();
            sortujMieszkania();
            String zapis =("Lista wolnych mieszkań : " + listaWolnychMieszkan.toString()
            +" Lista najemcow: " + listaNajemcow +"Lista wszystkich mieszkan :" + listaMieszkan.toString());

            byte [] zapiswByte = zapis.getBytes();


            fos.write(zapiswByte,0,zapiswByte.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void dodajdolistyOsob(Osoba osoba){
        listaWszystkichOsob.add(osoba);
    }

    public Osoba zaloguj() {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        try {
            String pesel = reader.readLine();
            for (int i = 0; i < listaWszystkichOsob.size(); i++) {
                if (pesel.equals(listaWszystkichOsob.get(i).getPesel())) {
                    return listaWszystkichOsob.get(i);
                }
            }
            System.out.println("Niezidetyfikowany  pesel wpisz go ponownie");
            zaloguj();

        } catch (IOException e) {
            System.out.println("Niezidetyfikowany  pesel wpisz go ponownie");
            zaloguj();
            return null;
        }
        return null;
    }

    public Mieszkanie wybierzMieszkanie(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Wpisz id mieszkania");
        try {
            int numerMieszkania = Integer.parseInt(reader.readLine());
            System.out.println("Wynajęto mieszkanie nr: "+numerMieszkania);

            for(int i =0; i < listaWolnychMieszkan.size(); i++){
                if(numerMieszkania == (listaWolnychMieszkan.get(i).getMieszkanieID())){
                   Mieszkanie wynajmowane = listaWolnychMieszkan.get(i);
                    listaWolnychMieszkan.remove(i);
                    return wynajmowane;


                }
            }
            return null;
        } catch (IOException e) {
            System.out.println("Niepoprawne dane wpisz, jescze raz");
            wyswietlPusteMieszkania();
            wybierzMieszkanie();
            return  null;
        }
    }


    public MiejsceParkingowe wybierzParking() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Wpisz id Parkingu");
        try {
            String numerParkingu = reader.readLine();
            for(int i =0; i< listaWolnychMiejscParkingowych.size();i++){
                if(numerParkingu.equals(listaWolnychMiejscParkingowych.get(i).getParkingID())){
                    MiejsceParkingowe wynajmowanyParking = listaWolnychMiejscParkingowych.get(i);

                    listaWolnychMiejscParkingowych.remove(i);return wynajmowanyParking;

                }
            }
            return null;

        } catch (IOException e) {
            System.out.println("Niepoprawne dane wpisz je jeszcze raz");
            wyswietlPusteMiejscaParkingowe();
            wybierzParking();
            return null;

        }


    }



        @Override
        public int compare(Mieszkanie mieszkanie, Mieszkanie t1) {
            if(mieszkanie.getMetraz() > t1.getMetraz())
                return 1;
            if(mieszkanie.getMetraz() == t1.getMetraz())
                return 0;
            if(mieszkanie.getMetraz() < t1.getMetraz())
                return -1;

            return 0;

    }
    // znalazłem w internecie te dwie metody
     public void sortujMieszkania(){
         listaWolnychMieszkan.sort(Comparator.comparing(Mieszkanie::getMetraz));
         listaMieszkan.sort(Comparator.comparing(Mieszkanie::getMetraz));
     }
     public void sortujMiejscaParkingowe(){
        listaWolnychMiejscParkingowych.sort(Comparator.comparing(MiejsceParkingowe::getRozmiar));
         listaMiejscParkingowych.sort(Comparator.comparing(MiejsceParkingowe::getRozmiar));
     }




     public void zaplac(){
        prawdziwaListanajemcow.addAll(listaNajemcow);
        int suma = 0;
        for(int i =0; i < prawdziwaListanajemcow.size(); i++){
            for(int j = 0; j < prawdziwaListanajemcow.get(i).getWynajeteMieszkania().size();j++){
                int koszt =prawdziwaListanajemcow.get(i).getWynajeteMieszkania().get(j).getCzynsz();
                suma=suma+koszt;

            }
            prawdziwaListanajemcow.get(i).oplac(suma);
            if(prawdziwaListanajemcow.get(i).getStanKonta()<0){
                wystosujpismo(prawdziwaListanajemcow.get(i));
            }

        }




     }

    private void wystosujpismo(Osoba osoba) {
        osoba.dodajPismo();
        if(osoba.getOtrzymanepisma().size() ==3){
            sprzedajPosiadaneSamochody(osoba);
        }



    }

    private void sprzedajPosiadaneSamochody(Osoba dluznik){
        dluznik.getPosiadanepojazdy().clear();

    }


}
