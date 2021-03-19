/***************************************************************************************************
 * Programmeerimisharjutused. LTAT.03.007
 * 2020/2021 kevadsemester
 *
 * Kodutöö. Ülesanne nr 2a
 * Teema:
 *           Järjendid I
 *
 * Autor: Otto Bruno Koobakene
 *
 ***************************************************************************************************/
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Arrays;
import java.util.List;

public class kodu2a {

    static final String failitee = "ilmAegTemp_2019.txt";
    // Kolm massiivi, mis täidetakse failist loetud andmetega
    static String[] kuupäev;
    static String[] kellaaeg;
    static double[] temperatuur;

    // Seadistus, täidetakse enne peameetodit
    static {
        try {
            // Loeme failist kõik read, eeldame et faili kodeering on UTF-8
            List<String> read = Files.readAllLines(Path.of(failitee), StandardCharsets.UTF_8);
            // Määrame massiivide pikkuse
            kuupäev = new String[read.size()];
            kellaaeg = new String[read.size()];
            temperatuur = new double[read.size()];
            for (int i = 0; i < read.size(); i++) {
                // Hakime read tühikute põhjal
                String[] jupid = read.get(i).split(" ");
                // Määrame hakitud jupid vastavatesse massiividesse
                kuupäev[i] = jupid[0];
                kellaaeg[i] = jupid[1];
                temperatuur[i] = Double.parseDouble(jupid[2]);
            }
        } catch (IOException e){
            // Faili ei leitud või lugemisel esines viga - väljastame veateate ja lõpetame töö
            e.printStackTrace();
            System.exit(1);
        }
    }

    static double temperatuurValitudPäevalJaKellal(String päev, String kell){
        for (int i = 0; i < temperatuur.length; i++) {
            //kontrollime kõik kuupäevad ja kellaajad läbi, kas leidub meie sünnipäeva-aegne temperatuurinäit
            if (kuupäev[i].equals(päev) && kellaaeg[i].equals(kell))
                return temperatuur[i];
        }
        //kui ei leidu, siis tagastame NaN
        return Double.NaN;
    }

    static public void main(String[] args) {


        System.out.println("Kodutöö nr 2a.                          Programmi väljund");
        System.out.println("=========================================================:");


        String sünnipäev = "2019-02-22";
        String kell = "22:00:00";
        double temp = temperatuurValitudPäevalJaKellal(sünnipäev, kell);

        System.out.print("\nMinu sünnipäeval eelmisel aastal (" + sünnipäev
                + ") oli keskpäevane temperatuur ");
        if (Double.isNaN(temp))
            System.out.println("- \nAntud aega: " + sünnipäev + " " + kell + " ei ole andmestikus!");
        else
            System.out.println(Math.round(temp*10)/10.0 + " kraadi.");


        System.out.println("2019. aasta keskmine temperatuur oli " + aastaKesk() + " kraadi.");

        System.out.println("2019. aasta suurim ja vähim temperatuur olid: " + Arrays.toString(aastaMinMax()));

        System.out.println("2019. aasta kuude keskmised temperatuurid olid: " + Arrays.toString(kuudeKeskmised()));

        System.out.println("2019. aasta pikim kasvav või kahanev periood oli: " + Arrays.toString(pikimKasvavKahanev()));

        System.out.println("2019. aastal oli " + lokaalsedEkstreemumid() + " lokaalset ekstreemumit.");

        System.out.println("\n=========================================================.");
        System.out.println("Otto Bruno Koobakene                      " + new java.sql.Timestamp(System.currentTimeMillis()));
    }


    // a)
    public static double aastaKesk(){
        double summa = 0;
        //for-tsükliga käime kõik temperatuurid läbi, liidame need summale ning hiljem arvutame keskmise
        for (int i = 0; i < kodu2a.temperatuur.length; i++) {
            summa = summa + kodu2a.temperatuur[i];
        }
        return summa/ kodu2a.temperatuur.length;
    }
    // b)
    public static double[] aastaMinMax(){

        //teame, et meil on vaja tagastada double tüüpi list, seega loome tühja 2-kohalise listi.
        double vähim = temperatuur[0];
        double suurim = temperatuur[0];
        double[] tagastus = new double[2];

        //for-tsükliga käime läbi kõik temperatuurid, võrdleme praeguse vähima ja suurimaga ning kui tegemist on uue
        // suurima või vähima temperatuurinäiduga, siis omistame selle väärtuse uueks suurimaks või vähimaks väärtuseks
        for (int i = 0; i < temperatuur.length; i++) {
            if(temperatuur[i] < vähim){
                vähim = temperatuur[i];
            }
            else if(temperatuur[i] > suurim) {
                suurim = temperatuur[i];
            }
        }
        tagastus[0]=vähim;
        tagastus[1]=suurim;
        return tagastus;
    }

    public static String[] pikimKasvavKahanev(){
        // Tagastada pikima sellise perioodi algus ja lõpp (kaasa arvatud)
        // kus temperatuur ainult kasvab või ainult kahaneb kaheelemendilise massiivi kujul kus
        // 0. kohal on perioodi alguse kuupäev ja aeg, eraldatud tühikuga
        // 1. kohal on perioodi lõpu kuupäev ja aeg, eraldatud tühikuga
        //Kui selliseid perioode on mitu, siis tagastada esimene neist
        // tagastuse näide: ["2019-08-02 00:15:00", "2019-08-02 10:35:00"]
        String[] pikimperiood = new String[2];

        int currentMax = 0;
        String perioodialgus = "";
        String perioodilõpp = "";

        try {
            int loendur = 0;
            perioodialgus = kuupäev[0] + " " +  kellaaeg[0];
            for (int i = 0; i < temperatuur.length - 1; i++) {
                if(temperatuur[i+1] > temperatuur[i]) {
                    loendur = loendur + 1;
                    perioodilõpp = kuupäev[i+1] +" "+ kellaaeg[i+1];
                }
                else {
                    throw new Exception();
                }
            }
            pikimperiood[0] = perioodialgus;
            pikimperiood[1] = perioodilõpp;
            return pikimperiood;

        }
        catch (Exception e) {

        }

        perioodialgus = "";
        perioodilõpp = "";

        try {
            int loendur = 0;
            perioodialgus = kuupäev[0] + " " +  kellaaeg[0];
            for (int i = 0; i < temperatuur.length - 1; i++) {
                if(temperatuur[i+1] < temperatuur[i]) {
                    loendur = loendur + 1;
                    perioodilõpp = kuupäev[i+1] +" "+ kellaaeg[i+1];
                }
                else {
                    throw new Exception();
                }
            }
            pikimperiood[0] = perioodialgus;
            pikimperiood[1] = perioodilõpp;
            return pikimperiood;

        }
        catch (Exception a) {
        }
        perioodialgus = "";
        perioodilõpp = "";
        // esimese kahe for-tsükliga leiame suurima perioodi, kus temperatuur ainult kasvab.
        for (int i = 0; i < temperatuur.length; i++) {
            int loendur = 0;
            perioodialgus = kuupäev[i] + " " +  kellaaeg[i];
            for (int j = i; j < temperatuur.length - 1; j++) {
                if(temperatuur[j+1] > temperatuur[j]) {
                    loendur = loendur + 1;
                }
                else {
                    perioodilõpp = kuupäev[j] +" "+ kellaaeg[j];
                    if(loendur > currentMax){
                        currentMax = loendur;
                        pikimperiood[0] = perioodialgus;
                        pikimperiood[1] = perioodilõpp;
                    }
                    break;
                }
            }
        }

        perioodialgus = "";
        perioodilõpp = "";

        //järgmise kahe for-tsükliga leiame pikima perioodi, kus temperatuur ainult kahaneb.
        for (int i = 0; i < temperatuur.length; i++) {
            int loendur = 0;
            perioodialgus = kuupäev[i] + " " +  kellaaeg[i];
            for (int j = i; j < temperatuur.length - 1; j++) {
                if(temperatuur[j+1] < temperatuur[j]) {
                    loendur = loendur + 1;
                }
                else {
                    perioodilõpp = kuupäev[j] +" "+ kellaaeg[j];
                    if(loendur > currentMax){
                        currentMax = loendur;
                        pikimperiood[0] = perioodialgus;
                        pikimperiood[1] = perioodilõpp;
                    }
                    break;
                }
            }

        }

        return pikimperiood;
    }

    public static int lokaalsedEkstreemumid(){
        // Tagastada lokaalsete ekstreemumite koguarv

        int loendur = 0;
        for (int i = 1; i < temperatuur.length - 1; i++) {
            if(temperatuur[i] > temperatuur[i-1] && temperatuur[i] > temperatuur[i+1]) {
                loendur = loendur + 1;
            }
            else if(temperatuur[i] < temperatuur[i-1] && temperatuur[i] < temperatuur[i+1]) {
                loendur = loendur + 1;
            }
        }


        return loendur;
    }

    public static double[] kuudeKeskmised(){
        // Tagastada 12-elemendiline järjend kus
        // 0. kohal on jaanuari keskmine temperatuur
        // 1. kohal on veebruari keskmine temperatuur jne
        double[] temperatuurid = new double[12];
        int kusoleme = 0;

        // for-tsükkel ühekohaliste kuude numbrite jaoks (jaanuar-september)
        for (int i = 0; i <= 8; i++) {
            double summa = 0;
            int loendur = 0;
            for (int j = kusoleme; j < kuupäev.length ; j++) {
                String miskuu = kuupäev[kusoleme].substring(6,7);
                int kuu = Integer.parseInt(miskuu);
                if(i+1 == kuu) {
                    summa = summa + temperatuur[j];
                    loendur = loendur + 1;
                    kusoleme = kusoleme + 1;
                    }
                else
                    break;
                }
            double kuukeskmine = summa/loendur;
            temperatuurid[i] = kuukeskmine;

            }
        //for-tsükkel kahekohaliste numbritega kuude jaoks (oktoober-detsember)
        for (int i = 9; i <= 11 ; i++) {
            double summa = 0;
            double kuukeskmine = 0;
            int loendur = 0;

            for (int j = kusoleme; j < kuupäev.length; j++) {
                String miskuu = kuupäev[kusoleme].substring(5, 7);
                int kuu = Integer.parseInt(miskuu);

                if(i+1 == kuu) {
                    summa = summa + temperatuur[j];
                    loendur = loendur + 1;
                    kusoleme = kusoleme + 1;
                }
                else
                    continue;
            }
            kuukeskmine = summa/loendur;
            temperatuurid[i] =kuukeskmine;
        }
        return temperatuurid;
    }
}


