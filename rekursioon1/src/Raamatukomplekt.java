/*

Raamatukomplektid, mille kogusumma j��b [50,55] vahele.
 */

import java.util.Arrays;

public class Raamatukomplekt {
    public static void main(String[] args) {
        int[] raamatuHinnad = {50, 30, 20, 11, 5};
        p�hi(raamatuHinnad);

    }

    public static int[][] p�hi(int[] raamatud) {
        int[] valitudRaamatud = new int[raamatud.length];
        return p�hiabi(raamatud, valitudRaamatud, 0, 0, 0);
    }

    public static int[][] p�hiabi(int[] raamatud, int[] valitudRaamatud, int summa, int i, int j) {
        // puu leht---lehttipud
        //baas
        if (i >= raamatud.length) {
            if (summa >= 50 && summa <= 55) {
                return new int[][]{valitudRaamatud.clone()};
            }
            System.out.println("Komplekt koos");
            return new int[0][];
        }

        //valin praeguse raamatu
        //samm
        valitudRaamatud[j] = raamatud[i];
        int[][] kuivalisin = p�hiabi(raamatud, valitudRaamatud, summa + valitudRaamatud[i], i + 1, j + 1);

        //ei valinud raamatut
        int[][] kuiEiValinud = p�hiabi(raamatud, valitudRaamatud, summa, i + 1, j);

        //paneme vastused kokku
        int[][] vastus = new int[kuivalisin.length][kuiEiValinud.length];
        int rida = 0;
        for (int k = 0; k < kuivalisin.length; k++) {
            vastus[rida++] = kuivalisin[k];
        }
        for (int k = 0; k < kuiEiValinud.length; k++) {
            vastus[rida++] = kuiEiValinud[k];
        }
        return vastus;
    }
}
