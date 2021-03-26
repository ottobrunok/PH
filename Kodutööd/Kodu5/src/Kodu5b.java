import java.util.ArrayList;
import java.util.Arrays;

public class Kodu5b {

    //ABIMEETOD
    public static int juhuslik(int a, int b) {
        //Antud: poollõik [a,b)
        //Tagastab: juhusliku täisarvu sellelt lõigult
        return (int) (Math.round(Math.random() * (b - a) + a));
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

    public static int[][] summad(int n) {
        return summadAbi(n, new int[]{});
    }

    public static int[][] summadAbi(int n, int[] praegune) {
        if (n < 0 || praegune.length > 1 && praegune[praegune.length - 2] == praegune[praegune.length - 1]) {
            System.out.println("Summa on putsis: " + Arrays.toString(praegune));
            return new int[0][];
        }
        if (n == 0) {
            System.out.println("Summa on 0: " + Arrays.toString(praegune));
            return new int[][]{praegune};
        }

        int[][] kaks = summadAbi(n - 2, lisa(praegune, 2));
        int[][] neli = summadAbi(n - 4, lisa(praegune, 4));
        int[][] kuus = summadAbi(n - 6, lisa(praegune, 6));

        int[][] vastus = new int[kaks.length + neli.length + kuus.length][];
        int rida = 0;
        for (int[] kak : kaks)
            vastus[rida++] = kak;
        for (int[] ints : neli)
            vastus[rida++] = ints;
        for (int[] kuu : kuus)
            vastus[rida++] = kuu;
        return vastus;
    }

    public static int[] lisa(int[] a, int x) {
        int[] uus = new int[a.length + 1];
        System.arraycopy(a, 0, uus, 0, a.length);
        uus[a.length] = x;
        return uus;
    }

    public static String[] rongid(int n) {
        return rongidAbi(n, "");
    }

    public static String[] rongidAbi(int n, String komplekt) {
        if (komplekt.length() > 1) {
            int pikkus = komplekt.length();
            char x = komplekt.charAt(pikkus - 2);
            char y = komplekt.charAt(pikkus - 1);
            if (x == y ||
                    x == 'A' && y == 'D' ||
                    x == 'B' && y == 'C' ||
                    x == 'C' && y == 'B')
                return new String[0];
        }
        if (n == 0)
            return new String[]{komplekt};

        String[] a = rongidAbi(n - 1, komplekt + "A");
        String[] b = rongidAbi(n - 1, komplekt + "B");
        String[] c = rongidAbi(n - 1, komplekt + "C");
        String[] d = rongidAbi(n - 1, komplekt + "D");

        String[] vastus = new String[a.length + b.length + c.length + d.length];
        int rida = 0;

        for (String s : a)
            vastus[rida++] = s;
        for (String s : b)
            vastus[rida++] = s;
        for (String s : c)
            vastus[rida++] = s;
        for (String s : d)
            vastus[rida++] = s;

        return vastus;
    }


    public static void main(String[] args) {
        // Näidis
        System.out.println("Kodutöö nr 5b.                          Programmi väljund");
        System.out.println("=========================================================:");
        //Siia lisada testimine
        //int [][] vastus = summad(8);
        //System.out.println(Arrays.deepToString(vastus));
        String[] vastus2 = rongid(4);
        for (String s : vastus2) {
            System.out.println(s);
        }
        System.out.println(vastus2.length);
        System.out.println("\n=========================================================.");
        System.out.println("Ülli Õpilane                      " + new java.sql.Timestamp(System.currentTimeMillis()));
    }//peameetod


}//Kodu5b
