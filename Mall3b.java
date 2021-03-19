import java.util.Arrays;

public class Mall3b {

    public static void main(String[] args) {
        // Näidis
        System.out.println("Kodutöö nr 3b.                          Programmi väljund");
        System.out.println("=========================================================:");
        //Siia lisada testimine
        System.out.println(Arrays.deepToString(juhuslik_2d_massiiv(5, 1, 10))); //näidismassiivi genereerimine
        System.out.println("\n=========================================================.");
        System.out.println("Ülli Õpilane                      " + new java.sql.Timestamp(System.currentTimeMillis()));
    }

    //ABIMEETOD - Sobilik kasutada testimiseks
    public static int[][] juhuslik_2d_massiiv(int n, int a, int b){
        //Antud: n - elementide arv, poollõik [a,b)
        //Tagastab: n x n -elemendilise juhuslike täisarvudega järjendi, elemendid läigult [a,b)
        int[][] x=new int[n][n];
        for(int i=0;i<n;i++)
            for (int j = 0; j < x.length; j++) {
                x[i][j]=juhuslik(a,b);
            }
        return x;
    }

    //ABIMEETOD
    public static int juhuslik(int a, int b){
        //Antud: poollõik [a,b)
        //Tagastab: juhusliku täisarvu sellelt lõigult
        return (int)(Math.round(Math.random()*(b-a)+a));
    }


    /**
     * Antud on n*n täisarvude massiiv, elemendid int-tüüpi.
     * Ülesandeks on leida arvud, mis esinevad igas reas.
     * Tulemusmassiiv peab olema mittekahanevalt sorteeritud ja selles leidub mingit arvu täpselt k
     * korda, kui algse massiivi igas reas on seda arvu vähemalt k korda.
     */
    public static int[] korduvadRead(int[][] a){
        return new int[0]; //tagastamiseks vaikeväärtus
    }

}
