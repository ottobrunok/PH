/*
 Kirjutada meetod, mis etteantud naturaalarvu n korral v�ljastab selle
 k�ikv�imalikud lahutused liidetavate 3, 4 ja 5 summadeks ja tagastab selliste lahutuste
arvu.
N�ide. Juhul n = 9 v�ljastab [5,4], [4,5] ja [3,3,3] ja tagastab v��rtuse 3. Kui
etteantud n korral selline lahutus pole v�imalik, siis v�ljastamise koht j��b t�hjaks
ja tagastab v��rtuse 0.
 */

import java.util.Arrays;

public class rekurs2 {
    public static void main(String[] args) {
        int arv = 7;
        System.out.println(p�hi(arv));
    }
    public static int p�hi(int vajaLahutada){
        double pikkus = vajaLahutada/3+1;
        int[] praeguneSumma = new int[(int)pikkus];

        return p�hiabi(vajaLahutada,praeguneSumma,0);
    }
    public static int p�hiabi(int vajaLahutada,int[] praeguneSumma, int i){
        if (vajaLahutada<=0){
            if(vajaLahutada==0){
                System.out.println("-----------");
                System.out.println(vajaLahutada);
                System.out.println(Arrays.toString(Arrays.copyOfRange(praeguneSumma,0,i)));
                System.out.println("-----------");
                return 1;
            }
            return 0;
        }
        // System.out.println(Arrays.toString(praeguneSumma));
        //System.out.println(vajaLahutada);
        praeguneSumma[i] = 3;
        int summa1 = p�hiabi(vajaLahutada - 3,praeguneSumma, i+1);
        praeguneSumma[i] = 4;
        int summa2 = p�hiabi(vajaLahutada - 4,praeguneSumma, i+1);
        praeguneSumma[i] = 5;
        int summa3 = p�hiabi(vajaLahutada - 5, praeguneSumma,i+1);
        return summa1+summa2+summa3;
    }
}
