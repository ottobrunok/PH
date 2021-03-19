/***************************************************************************************************
 * Programmeerimisharjutused. LTAT.03.007
 * 2020/2021 kevadsemester
 *
 * Kodut��. �lesanne nr 2a
 * Teema:
 *           J�rjendid I
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
    // Kolm massiivi, mis t�idetakse failist loetud andmetega
    static String[] kuup�ev;
    static String[] kellaaeg;
    static double[] temperatuur;

    // Seadistus, t�idetakse enne peameetodit
    static {
        try {
            // Loeme failist k�ik read, eeldame et faili kodeering on UTF-8
            List<String> read = Files.readAllLines(Path.of(failitee), StandardCharsets.UTF_8);
            // M��rame massiivide pikkuse
            kuup�ev = new String[read.size()];
            kellaaeg = new String[read.size()];
            temperatuur = new double[read.size()];
            for (int i = 0; i < read.size(); i++) {
                // Hakime read t�hikute p�hjal
                String[] jupid = read.get(i).split(" ");
                // M��rame hakitud jupid vastavatesse massiividesse
                kuup�ev[i] = jupid[0];
                kellaaeg[i] = jupid[1];
                temperatuur[i] = Double.parseDouble(jupid[2]);
            }
        } catch (IOException e){
            // Faili ei leitud v�i lugemisel esines viga - v�ljastame veateate ja l�petame t��
            e.printStackTrace();
            System.exit(1);
        }
    }

    static double temperatuurValitudP�evalJaKellal(String p�ev, String kell){
        for (int i = 0; i < temperatuur.length; i++) {
            //kontrollime k�ik kuup�evad ja kellaajad l�bi, kas leidub meie s�nnip�eva-aegne temperatuurin�it
            if (kuup�ev[i].equals(p�ev) && kellaaeg[i].equals(kell))
                return temperatuur[i];
        }
        //kui ei leidu, siis tagastame NaN
        return Double.NaN;
    }

    static public void main(String[] args) {


        System.out.println("Kodut�� nr 2a.                          Programmi v�ljund");
        System.out.println("=========================================================:");


        String s�nnip�ev = "2019-02-22";
        String kell = "22:00:00";
        double temp = temperatuurValitudP�evalJaKellal(s�nnip�ev, kell);

        System.out.print("\nMinu s�nnip�eval eelmisel aastal (" + s�nnip�ev
                + ") oli keskp�evane temperatuur ");
        if (Double.isNaN(temp))
            System.out.println("- \nAntud aega: " + s�nnip�ev + " " + kell + " ei ole andmestikus!");
        else
            System.out.println(Math.round(temp*10)/10.0 + " kraadi.");


        System.out.println("2019. aasta keskmine temperatuur oli " + aastaKesk() + " kraadi.");

        System.out.println("2019. aasta suurim ja v�him temperatuur olid: " + Arrays.toString(aastaMinMax()));

        System.out.println("2019. aasta kuude keskmised temperatuurid olid: " + Arrays.toString(kuudeKeskmised()));

        System.out.println("2019. aasta pikim kasvav v�i kahanev periood oli: " + Arrays.toString(pikimKasvavKahanev()));

        System.out.println("2019. aastal oli " + lokaalsedEkstreemumid() + " lokaalset ekstreemumit.");

        System.out.println("\n=========================================================.");
        System.out.println("Otto Bruno Koobakene                      " + new java.sql.Timestamp(System.currentTimeMillis()));
    }


    // a)
    public static double aastaKesk(){
        double summa = 0;
        //for-ts�kliga k�ime k�ik temperatuurid l�bi, liidame need summale ning hiljem arvutame keskmise
        for (int i = 0; i < kodu2a.temperatuur.length; i++) {
            summa = summa + kodu2a.temperatuur[i];
        }
        return summa/ kodu2a.temperatuur.length;
    }
    // b)
    public static double[] aastaMinMax(){

        //teame, et meil on vaja tagastada double t��pi list, seega loome t�hja 2-kohalise listi.
        double v�him = temperatuur[0];
        double suurim = temperatuur[0];
        double[] tagastus = new double[2];

        //for-ts�kliga k�ime l�bi k�ik temperatuurid, v�rdleme praeguse v�hima ja suurimaga ning kui tegemist on uue
        // suurima v�i v�hima temperatuurin�iduga, siis omistame selle v��rtuse uueks suurimaks v�i v�himaks v��rtuseks
        for (int i = 0; i < temperatuur.length; i++) {
            if(temperatuur[i] < v�him){
                v�him = temperatuur[i];
            }
            else if(temperatuur[i] > suurim) {
                suurim = temperatuur[i];
            }
        }
        tagastus[0]=v�him;
        tagastus[1]=suurim;
        return tagastus;
    }

    public static String[] pikimKasvavKahanev(){
        // Tagastada pikima sellise perioodi algus ja l�pp (kaasa arvatud)
        // kus temperatuur ainult kasvab v�i ainult kahaneb kaheelemendilise massiivi kujul kus
        // 0. kohal on perioodi alguse kuup�ev ja aeg, eraldatud t�hikuga
        // 1. kohal on perioodi l�pu kuup�ev ja aeg, eraldatud t�hikuga
        //Kui selliseid perioode on mitu, siis tagastada esimene neist
        // tagastuse n�ide: ["2019-08-02 00:15:00", "2019-08-02 10:35:00"]
        String[] pikimperiood = new String[2];

        int currentMax = 0;
        String perioodialgus = "";
        String perioodil�pp = "";

        try {
            int loendur = 0;
            perioodialgus = kuup�ev[0] + " " +  kellaaeg[0];
            for (int i = 0; i < temperatuur.length - 1; i++) {
                if(temperatuur[i+1] > temperatuur[i]) {
                    loendur = loendur + 1;
                    perioodil�pp = kuup�ev[i+1] +" "+ kellaaeg[i+1];
                }
                else {
                    throw new Exception();
                }
            }
            pikimperiood[0] = perioodialgus;
            pikimperiood[1] = perioodil�pp;
            return pikimperiood;

        }
        catch (Exception e) {

        }

        perioodialgus = "";
        perioodil�pp = "";

        try {
            int loendur = 0;
            perioodialgus = kuup�ev[0] + " " +  kellaaeg[0];
            for (int i = 0; i < temperatuur.length - 1; i++) {
                if(temperatuur[i+1] < temperatuur[i]) {
                    loendur = loendur + 1;
                    perioodil�pp = kuup�ev[i+1] +" "+ kellaaeg[i+1];
                }
                else {
                    throw new Exception();
                }
            }
            pikimperiood[0] = perioodialgus;
            pikimperiood[1] = perioodil�pp;
            return pikimperiood;

        }
        catch (Exception a) {
        }
        perioodialgus = "";
        perioodil�pp = "";
        // esimese kahe for-ts�kliga leiame suurima perioodi, kus temperatuur ainult kasvab.
        for (int i = 0; i < temperatuur.length; i++) {
            int loendur = 0;
            perioodialgus = kuup�ev[i] + " " +  kellaaeg[i];
            for (int j = i; j < temperatuur.length - 1; j++) {
                if(temperatuur[j+1] > temperatuur[j]) {
                    loendur = loendur + 1;
                }
                else {
                    perioodil�pp = kuup�ev[j] +" "+ kellaaeg[j];
                    if(loendur > currentMax){
                        currentMax = loendur;
                        pikimperiood[0] = perioodialgus;
                        pikimperiood[1] = perioodil�pp;
                    }
                    break;
                }
            }
        }

        perioodialgus = "";
        perioodil�pp = "";

        //j�rgmise kahe for-ts�kliga leiame pikima perioodi, kus temperatuur ainult kahaneb.
        for (int i = 0; i < temperatuur.length; i++) {
            int loendur = 0;
            perioodialgus = kuup�ev[i] + " " +  kellaaeg[i];
            for (int j = i; j < temperatuur.length - 1; j++) {
                if(temperatuur[j+1] < temperatuur[j]) {
                    loendur = loendur + 1;
                }
                else {
                    perioodil�pp = kuup�ev[j] +" "+ kellaaeg[j];
                    if(loendur > currentMax){
                        currentMax = loendur;
                        pikimperiood[0] = perioodialgus;
                        pikimperiood[1] = perioodil�pp;
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
        // Tagastada 12-elemendiline j�rjend kus
        // 0. kohal on jaanuari keskmine temperatuur
        // 1. kohal on veebruari keskmine temperatuur jne
        double[] temperatuurid = new double[12];
        int kusoleme = 0;

        // for-ts�kkel �hekohaliste kuude numbrite jaoks (jaanuar-september)
        for (int i = 0; i <= 8; i++) {
            double summa = 0;
            int loendur = 0;
            for (int j = kusoleme; j < kuup�ev.length ; j++) {
                String miskuu = kuup�ev[kusoleme].substring(6,7);
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
        //for-ts�kkel kahekohaliste numbritega kuude jaoks (oktoober-detsember)
        for (int i = 9; i <= 11 ; i++) {
            double summa = 0;
            double kuukeskmine = 0;
            int loendur = 0;

            for (int j = kusoleme; j < kuup�ev.length; j++) {
                String miskuu = kuup�ev[kusoleme].substring(5, 7);
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


