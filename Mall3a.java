import java.util.Arrays;

public class Mall3a {
    public static void main(String[] args) {
        // Näidis
        System.out.println("Kodutöö nr 3a.                          Programmi väljund");
        System.out.println("=========================================================:");
        //Siia lisada testimine
        System.out.println(Arrays.toString(juhuslik_massiiv(5, 1, 10))); //näidismassiivi genereerimine
        System.out.println("\n=========================================================.");
        System.out.println("Ülli Õpilane                      " + new java.sql.Timestamp(System.currentTimeMillis()));

    }


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
        
        int[] nihked;
        return nihked;
    }

    /**
     * Meetod, mis järjendisiseselt teostab massiivi b tagasiteisenduse algseks, kasutades etteantud nihkemassiivi
     * nihe elementide väärtustest saadavat informatsiooni.
     * <p>
     * Meetodi testimisel võib eeldada, et massiiv b on saadud mingist algmassiivist a,
     * kusjuures teisendust a->b kirjeldab nihkemassiiv nihe.
     */
    public static int[] teeAlgne(int[] b, int[] nihe) {

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

        return 0;
    }
}
