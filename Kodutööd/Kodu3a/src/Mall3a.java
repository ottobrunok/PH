import java.util.Arrays;
import java.util.stream.IntStream;

/***************************************************************************************************
 * Programmeerimisharjutused. LTAT.03.007
 * 2020/2021 kevadsemester
 *
 * Kodutöö. Ülesanne nr 3a
 * Teema:
 *           Järjendid
 *
 * Autor: Otto Bruno Koobakene
 *
 ***************************************************************************************************/

public class Mall3a {
    //ABIMEETOD - Sobilik kasutada testimiseks
    public static int[] juhuslik_massiiv(int n, int a, int b) {
        //Antud: n - elementide arv, poollõik [a,b)
        //Tagastab: n-elemendilise juhuslike täisarvudega järjendi, elemendid läigult [a,b)
        int[] x = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = juhuslik(a, b);
        return x;
    }


    //ABIMEETOD
    public static int juhuslik(int a, int b) {
        //Antud: poollõik [a,b)
        //Tagastab: juhusliku täisarvu sellelt lõigult
        return (int) (Math.round(Math.random() * (b - a) + a));
    }

    public static int[] teeTeisendused(int[] a){
        int[] tulemus = new int[a.length];
        int paarisarve = 0;
        int paarituidarve = 0;

        for (int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0){
                paarisarve = paarisarve + 1;
            }
            else
                paarituidarve = paarituidarve + 1;
        }

        int[] paaris = new int[paarisarve];
        int[] paaritud = new int[paarituidarve];

        int kinninepaaris = paarisarve;
        int kinninepaaritu = paarituidarve;
        for (int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0){
                paaris[kinninepaaris - paarisarve] = a[i];
                paarisarve = paarisarve - 1;
            }
            else{
                paaritud[kinninepaaritu - paarituidarve] = a[i];
                paarituidarve = paarituidarve - 1;
            }
        }
        for (int i = 0; i < paaris.length; i++) {
            tulemus[i] = paaris[i];
        }
        for (int i = 0; i < paaritud.length; i++) {
            tulemus[paaris.length + i] = paaritud[i];
        }
        return tulemus;
    }


    /**
     * Antud täisarvujärjendis a paigutada ümber järjendi lõppu paaritud arvud. Nii tulemuse algusosas
     * (paarisarvud) kui ka lõpuosas (paaritud arvud) peab olema säilitatud arvude esialgne järjestus
     * järjendis a.
     * <p>
     * Def. Täisarvumassiivi a nihkemassiiviks nimetame massiivi x, milles on elemente sama palju kui
     * massiivis a paarisarve ning väärtus x[i] näitab, mitme positsiooni võrra on massiivi a (i+1). paarisarv
     * nihutatud vasakule võrreldes tulemusmassiiviga.
     *
     * @param a - massiiv, mille peal sooritada töötlus järjendisiseselt.
     * @return nihked - massiiv, mis sisaldab teisenduse nihkeid.
     */
    public static int[] teePaarisPaaritud(int[] a) {
        int[] tulemus = new int[a.length];
        int paarisarve = 0;
        int paarituidarve = 0;

        for (int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0){
                paarisarve = paarisarve + 1;
            }
            else
                paarituidarve = paarituidarve + 1;
        }

        int[] paaris = new int[paarisarve];
        int[] paaritud = new int[paarituidarve];

        int kinninepaaris = paarisarve;
        int kinninepaaritu = paarituidarve;
        for (int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0){
                paaris[kinninepaaris - paarisarve] = a[i];
                paarisarve = paarisarve - 1;
            }
            else{
                paaritud[kinninepaaritu - paarituidarve] = a[i];
                paarituidarve = paarituidarve - 1;
            }
        }
        for (int i = 0; i < paaris.length; i++) {
            tulemus[i] = paaris[i];
        }
        for (int i = 0; i < paaritud.length; i++) {
            tulemus[paaris.length + i] = paaritud[i];
        }
        int[] nihked = new int[a.length];
        paarisarve = 0;
        paarituidarve = 0;

        for (int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0){
                paarisarve = paarisarve + 1;
            }
            else
                paarituidarve = paarituidarve + 1;
        }


        paaris = new int[paarisarve];
        paaritud = new int[paarituidarve];

        kinninepaaris = paarisarve;
        kinninepaaritu = paarituidarve;

        int[] algsedindeksid = new int[paarisarve];
        int[] pärastindeksid = new int[paarisarve];

        for (int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0){
                paaris[kinninepaaris - paarisarve] = a[i];
                algsedindeksid[kinninepaaris - paarisarve] = i;
                paarisarve = paarisarve - 1;
            }
            else{
                paaritud[kinninepaaritu - paarituidarve] = a[i];
                paarituidarve = paarituidarve - 1;
            }
        }
        for (int i = 0; i < paaris.length; i++) {
            nihked[i] = paaris[i];
        }
        for (int i = 0; i < paaritud.length; i++) {
            nihked[paaris.length + i] = paaritud[i];
        }

        //System.out.println("Algsed indeksid: " + Arrays.toString(algsedindeksid));


        int loendur = 0;
        for (int i = 0; i < paaris.length; i++) {
            if(i == 0){
                pärastindeksid[i] = algsedindeksid[i];
                loendur = loendur + 1;
            }
            else{
                pärastindeksid[i] = algsedindeksid[i] - loendur;
                loendur = loendur + 1;
            }
        }
        a = tulemus;
        return pärastindeksid;
    }

    /**
     * Meetod, mis järjendisiseselt teostab massiivi b tagasiteisenduse algseks, kasutades etteantud nihkemassiivi
     * nihe elementide väärtustest saadavat informatsiooni.
     * <p>
     * Meetodi testimisel võib eeldada, et massiiv b on saadud mingist algmassiivist a,
     * kusjuures teisendust a->b kirjeldab nihkemassiiv nihe.
     */
    public static int[] teeAlgne(int[] b, int[] nihe) {
        int paarisarve = 0;
        int paarituidarve = 0;

        for (int i = 0; i < b.length; i++) {
            if(b[i] % 2 == 0){
                paarisarve = paarisarve + 1;
            }
            else
                paarituidarve = paarituidarve + 1;
        }

        for (int i = 0; i < nihe.length; i++) {
            if(i==0){
                int käsitletav = b[i];
                b[i] = b[nihe[i]];
                b[nihe[i]] = käsitletav;
            }
            else{
                int käsitletav = b[i];
                b[i] = b[nihe[i] + 1];
                b[nihe[i] + 1] = käsitletav;
            }
        }
        return b;
    }

    /**
     * Meetod, mis etteantud massiivi a ja tema nihkemassiivi nihe korral tagastab arvu,
     * mitu korda on vaja massiivi a (paarisarvulistele) elementidele rakendada nihkemassiiviga määratud ümberpaigutusi,
     * et saada tagasi algne massiiv või massiiv, mis on juba vaheseisuna olnud.
     * <p>
     * Elemendi a[0] nihutamiseks 1 positsiooni võrra vasakule lugeda elementide a[0] ja
     * a[a.length-1] vahetust.
     */
    public static int mituKordaAlgseni(int[] a, int[] nihe) {
        int[] b = new int[a.length];
        int loendur = 0;

        while(true){
            b = teeAlgne(a,nihe);
            loendur = loendur + 1;
            if(a[0]==b[0]){
                break;
            }
            a = teeAlgne(b,nihe);
            loendur = loendur + 1;
            if(a[0]==b[0]){
                break;
            }
        }
        return loendur;
    }


    public static void main(String[] args) {
        System.out.println("Kodutöö nr 3a.                                              Programmi väljund");
        System.out.println("=============================================================================:");

        for (int i = 0; i < 3; i++) {
            int[] a = juhuslik_massiiv(11, -10, 10);

            System.out.println("Algne massiiv: " + Arrays.toString(a)); //näidismassiivi genereerimine

            int[] b = teeTeisendused(a);
            System.out.println("Teisendatud massiiv: " + Arrays.toString(b));

            int[] nihe = teePaarisPaaritud(a);
            System.out.println("Nihked: "+ Arrays.toString(nihe));

            int[] algne = teeAlgne(b, nihe);
            System.out.println("Algne massiiv: " + Arrays.toString(algne));

            int kordusi = mituKordaAlgseni(a,nihe);
            System.out.println("Korduma hakkab " + kordusi + " korra pärast.\n");

        }


        System.out.println("=============================================================================.");
        System.out.println("Otto Bruno Koobakene                                "
                + new java.sql.Timestamp(System.currentTimeMillis()));
    }
}
