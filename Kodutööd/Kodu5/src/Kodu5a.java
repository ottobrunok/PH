import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Kodu5a {

    public static void main(String[] args) {
        // Näidis
        System.out.println("Kodutöö nr 5a.                          Programmi väljund");
        System.out.println("=========================================================:");
        //Siia lisada testimine
        int[][] mündid = {{1, 5, 10, 30, 50, 200},
                          {2, 20, 30, 50, 100, 200},
                          {1, 30, 50, 200},
                          {2, 30, 50, 100},
                          {1, 5, 10, 20, 30, 50, 100},
                          {1, 2, 20, 30, 50, 200},
                          {1, 2, 100}};
        int[] summad   = {137, 120, 163, 75, 163, 101, 191};

        for (int i = 1; i < mündid.length; i++) {
            väljastaVastus(mündid[i], summad[i]);
        }

        System.out.println("=========================================================.");
        System.out.println("Ülli Õpilane                      " + new java.sql.Timestamp(System.currentTimeMillis()));
    }//peameetod

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

    public static boolean kasSobib(int[] x, int s) {
        return kasSobibAbi(x, s, 0);
    }
// esimest vaja
    public static boolean kasSobibAbi(int[] x, int s, int i) {
        if (s == 0)
            return true;
        if (i == x.length)
            return false;
        return kasSobibAbi(x, s - x[i], i + 1) || kasSobibAbi(x, s, i + 1);
    }

    public static int[] kuidasMaksta(int[] x, int s) {
        if (kasSobib(x, s)){
            return kuidasMakstaAbi(x, s, new int[]{}, 0);
        }
        return null;
    }
//kõik läbi , leiame vähima
    public static int[] kuidasMakstaAbi(int[] mündid, int summa, int[] valitud, int i) {
        if (summa == 0) {
            return valitud;
        }
        if (summa < 0 || i == mündid.length) {
            return new int[mündid.length + 1];
        }

        int[] valisin = kuidasMakstaAbi(mündid, summa - mündid[i], lisa(valitud, mündid[i]), i+1);
        int[] eiValinud = kuidasMakstaAbi(mündid, summa, valitud, i+1);

        if (valisin.length < eiValinud.length) return valisin;
        return eiValinud;
    }

    public static int[] lisa(int[] a, int x) {
        int[] uus = new int[a.length + 1];
        System.arraycopy(a, 0, uus, 0, a.length);
        uus[a.length] = x;
        return uus;
    }

    public static String[] sonePoime(String[] a, String[] b) {
        return null;
    }

    public static void väljastaVastus(int[] x, int s) {
        boolean saabMaksta = kasSobib(x, s);
        System.out.print("Taskus on mündid ");
        System.out.println(Arrays.toString(x));
        System.out.print("Ostusumma s = " + s + "\t");
        if (saabMaksta) {
            int[] kuidasMaksta = kuidasMaksta(x, s);
            StringBuilder sb = new StringBuilder();
            for (int n : kuidasMaksta)
                sb.append(n).append("+");
            System.out.println(sb.substring(0, sb.length() - 1));
        } else {
            System.out.println("Pole võimalik tasuda!");
        }
        System.out.println();
    }

}//Kodu5a
