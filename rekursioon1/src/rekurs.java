import java.util.Arrays;

/*
5.1. Kirjutada meetod, mis väljastab ekraanile etteantud naturaalarvu n > 7
kõikvõimalikud lahutused liidetavate 2 ja 3 summadeks. Liidetavate järjekorra
poolest erinevad summad lugeda erinevateks.

Näiteks argumendile n = 8 vastavalt [3,3,2], [3,2,3], [2,3,3], [2,2,2,2].
 */


public class rekurs {
    public static void main(String[] args) {
        yl1(8);
    }
    public static void yl1(int vajaSummeerida){
        int[] praeguneSumma = new int[vajaSummeerida/2];
        yl1abi(vajaSummeerida,praeguneSumma,0);
    }

    public static void yl1abi(int vajaSummeerida, int[] praeguneSumma,int i){
        //olen puu lehttipus, vaja lõpetada
        if (vajaSummeerida <= 0){
            //mul on õige vastus
            if(vajaSummeerida==0) {
                System.out.println(Arrays.toString(Arrays.copyOfRange(praeguneSumma,0,i)));
                System.out.println("----------");
            }
            return;
        }
        praeguneSumma[i] = 3;
        yl1abi(vajaSummeerida-3,praeguneSumma,i+1);
        praeguneSumma[i] = 2;
        yl1abi(vajaSummeerida-2,praeguneSumma,i+1);
    }
}
