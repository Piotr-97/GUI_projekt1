
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Date data = new Date();
        Osiedle osiedle = new Osiedle();


        Osoba jan = new Osoba("Jan", "Kowalski", "001", "Ulica Sezamkowa", "19-05-66", 5000, osiedle);
        Osoba kazik = new Osoba("Kazik", "Nowak", "002", "Ulica Sezamkowa", "20-12-54", 1000, osiedle);
        Osoba waldek = new Osoba("Waldek", "Wisniewki", "003", "Marszalkowska", "12-06-85", 2000, osiedle);
        Osoba mietek = new Osoba("Mietek", "Wojcik", "004", "piekna", "01-01-91", 3000, osiedle);
        Osoba katarzyna = new Osoba("Katarzyna", "Kowalczyk", "Aleja KEN", "01-10-00", "05-05-99", 4000, osiedle);


        MiejsceParkingowe mp1 = new MiejsceParkingowe(50, 600, osiedle);
        MiejsceParkingowe mp2 = new MiejsceParkingowe(20, 50, osiedle);
        MiejsceParkingowe mp3 = new MiejsceParkingowe(30, 100, osiedle);
        MiejsceParkingowe mp4 = new MiejsceParkingowe(10, 200, osiedle);
        MiejsceParkingowe mp5 = new MiejsceParkingowe(20, 400, osiedle);


        Mieszkanie m1 = new Mieszkanie(100, 3000, osiedle);
        Mieszkanie m2 = new Mieszkanie(150, 2500, osiedle);
        Mieszkanie m3 = new Mieszkanie(90, 1900, osiedle);
        Mieszkanie m4 = new Mieszkanie(50, 1500, osiedle);
        Mieszkanie m5 = new Mieszkanie(20, 500, osiedle);
        Mieszkanie m6 = new Mieszkanie(40, 1200, osiedle);
        Mieszkanie m7 = new Mieszkanie(65, 1700, osiedle);




        SamochodTerenowy jeep = new SamochodTerenowy("czarny", 14, 3000,waldek, "J33P","jeep");
        SamochodMiejski punto = new SamochodMiejski("Zielony", 10,1100,"benzyna",jan,"PJ01","fiat");
        Lodz ldz1 = new Lodz("niebieski", 40, 4000, 10,kazik,"L01", "JakasfirmaProdukujacaLodzie");
        Amfibia am1 = new Amfibia("Zielony", 25, 3500, 2000, katarzyna,"AM1","AMFIBIA");
        Motocykl moto1= new Motocykl("czarny z plomieniami", 3, 2500, mietek, "harley","ogien1","Harley-Davidson");
        //==================================================================================
       /* Thread czas = new Thread(new Runnable() {
            @Override
            public synchronized  void run() {
                int dzien=0;
                try {
                    while (true) {
                        Thread.sleep(5000);
                        dzien++;

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread sprawdzanie = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                try {
                    while (true) {
                        Thread.sleep(10000);
                        osiedle.zaplac();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        });
        czas.start();
        sprawdzanie.start();

*/



        //========================================================================================

        System.out.println("Wpisz swoj pesel aby sie zalogowac");
        Osoba uzytkownik = osiedle.zaloguj();
        System.out.println("Dzien dobry "+ uzytkownik.getImie()+" " + uzytkownik.getNazwisko());
        System.out.println("Co chciałbyś zrobić?");


        while (true) {
            Opcje[] menuOpcje = Opcje.values();
            System.out.println("Opcje do wyboru");
            for (Opcje opcje : menuOpcje) {
                System.out.println(opcje);
            }
            System.out.println();
            try {
                Scanner scanner = new Scanner(System.in);
                String userInput = scanner.nextLine();
                Opcje wybor = Opcje.valueOf(userInput);
                switch (wybor) {
                    case ZAPISZ:
                        osiedle.zapisStanuOsiedla();
                        break;
                    case WYNAJMIJ_MIESZKANIE:
                        System.out.println("Ktore mieszkanie chcesz wynajac?");
                        osiedle.wyswietlPusteMieszkania();
                        Mieszkanie wybranemieszkanie = osiedle.wybierzMieszkanie();
                        uzytkownik.wynajmijM(uzytkownik, wybranemieszkanie, osiedle);
                        System.out.println(uzytkownik.getWynajeteMieszkania());
                        break;
                    case WYNAJMIJ_MIEJSCE:
                        System.out.println("Ktore miejsce parkingowe chcesz wynajac?");
                        osiedle.wyswietlPusteMiejscaParkingowe();
                        MiejsceParkingowe wybranyParking = osiedle.wybierzParking();
                        uzytkownik.wynajmij(uzytkownik, wybranyParking, osiedle);
                        break;
                    case ZAPARKUJ:
                        System.out.println("twoje pojazdy:");
                        uzytkownik.wyswietlposiadanepojazdy();
                        Pojazd wybranyPojazd = uzytkownik.wybierzpojazd();
                        System.out.println("Twoje Parkingi:");
                        uzytkownik.wyswietlparkingi();
                        MiejsceParkingowe wybranyParking2 = uzytkownik.wybierzparking();
                        uzytkownik.zaparkuj(uzytkownik, wybranyPojazd, wybranyParking2);
                        break;
                    case WYPISZ_DANE:
                        System.out.println( uzytkownik.toString());
                        break;
                    case WYSWIETL_WOLNE_POMIESZCZENIA:
                        System.out.println("Wolne Mieszkania:");
                        osiedle.wyswietlPusteMieszkania();
                        System.out.println("Wolne miejsca parkingowe:");
                        osiedle.wyswietlPusteMiejscaParkingowe();
                        break;
                    case ZWOLNIJ_MIEJSCE_PARKINGOWE:
                        System.out.println("Z ktorego parkinu chcesz zwolnic miejsce");
                        uzytkownik.wyswietlparkingi();
                        MiejsceParkingowe wybranyparking3 = uzytkownik.wybierzparking();
                        System.out.println("Samochody na tym parkingu");
                        System.out.println(wybranyparking3.zaparkowaneSamochody());
                        System.out.println("Wybierz Samochod ktory ma zostac usuniety");
                        Pojazd usuwanypojazd = uzytkownik.wybierzpojazd();
                        uzytkownik.zwolnijmiejsceparkingowe(uzytkownik, wybranyparking3, usuwanypojazd);
                        break;
                    case KONIEC:
                        System.exit(0);
                        break;



                }
            } catch (IllegalArgumentException e) {
                System.out.println("Podano zla opcje, wpisz poprawna opcje");
            }


        }
    }
}



