import java.util.ArrayList;
import java.util.Arrays;

/***************************************************************************************************
 * Programmeerimisharjutused. LTAT.03.007
 * 2020/2021 kevadsemester
 *
 * Kodutöö. Ülesanne nr 4a
 * Teema:
 *           Maatriksid
 *
 * Autor: Otto Bruno Koobakene
 *
 ***************************************************************************************************/
public class Kodu4a {
    public static int[] pikendatudDiagonaal(int[][] maatriks){
        ArrayList<Integer> diagonaal = new ArrayList<Integer>();
        int ridu = maatriks.length;
        int veerge = maatriks[0].length;
        int mitmesrida = 0;
        int mitmesveerg = 1;
        int valik = 0;
        String viimane = "";

        //esimene element
        diagonaal.add(maatriks[0][0]);

        // liikumine alla-paremale

        if(ridu<veerge) {
            for (int rida = 1; rida < ridu; rida++) {
                for (int veerg = rida; veerg < ridu; veerg++) {
                    mitmesrida = rida;
                    mitmesveerg = veerg;
                    diagonaal.add(maatriks[mitmesrida][mitmesveerg]);
                    break;
                }
            }
            //while loopis liigume paremale kuni põrkame kõige paremas veerus
            while(mitmesveerg!=veerge-1) {
                try {
                    //kui oleme viimasel real paremal nurgas
                    if (mitmesrida == ridu - 1)
                        valik = 1;
                    else if (mitmesrida == 0)
                        valik = 2;
                    else if (mitmesveerg == veerge - 1)
                        throw null;
                    switch (valik) {
                        //1 - üles-paremale 🡵🡵🡵🡵
                        case (1):
                            for (int rida = mitmesrida - 1; rida >= 0; --rida) {
                                for (int veerg = mitmesveerg + 1; veerg<=veerge-1; veerg++) {
                                    mitmesrida = rida;
                                    mitmesveerg = veerg;
                                    diagonaal.add(maatriks[mitmesrida][mitmesveerg]);
                                    viimane = "üles";
                                    if (mitmesveerg == veerge - 1)
                                        break;
                                    break;
                                }
                            }
                        //2 - alla-paremale 🡶🡶🡶🡶
                        case (2):
                            for (int rida = mitmesrida+1; rida <= ridu-1; rida++) {
                                for (int veerg = mitmesveerg+1; veerg <= veerge-1 ; veerg++) {
                                    mitmesrida = rida;
                                    mitmesveerg = veerg;
                                    diagonaal.add(maatriks[mitmesrida][mitmesveerg]);
                                    viimane = "alla";
                                    if (mitmesveerg == veerge - 1)
                                        break;
                                    break;
                                }
                            }
                    }
                } catch (Exception e) {
                }
            }
            //Praegu oleme paremal ja tuleme vasakule tagasi kuni esimese veeruni
            while(mitmesveerg!=0){
                try {
                    //kui asume üleval paremas nurgas
                    if(mitmesveerg == 0)
                        throw null;
                    //kui asume viimase rea paremas nurgas
                    else if (mitmesrida == ridu - 1)
                        valik = 2;
                    //esimeses reas
                    else if (mitmesrida == 0)
                        valik = 1;
                    //kui eelmine kord läks üles
                    else if (viimane == "üles")
                        valik = 2;

                    else if(viimane == "alla")
                        valik = 1;
                    switch (valik) {
                        //1 - alla-vasakule 🡷🡷🡷🡷
                        case (1):
                            for (int rida = mitmesrida + 1; rida <= ridu-1; rida++) {
                                for (int veerg = mitmesveerg - 1; veerg>=0; --veerg) {
                                    mitmesrida = rida;
                                    mitmesveerg = veerg;
                                    diagonaal.add(maatriks[mitmesrida][mitmesveerg]);
                                    viimane = "alla";
                                    if (mitmesveerg == 0)
                                        break;
                                    break;
                                }
                            }
                        //2- üles-vasakule  🡴🡴🡴🡴
                        case (2):
                            for (int rida = mitmesrida-1; rida >=0; --rida) {
                                for (int veerg = mitmesveerg-1; veerg >= 0; --veerg) {
                                    mitmesrida = rida;
                                    mitmesveerg = veerg;
                                    diagonaal.add(maatriks[mitmesrida][mitmesveerg]);
                                    viimane = "üles";
                                    if (mitmesveerg == 0)
                                        break;
                                    break;
                                }
                            }
                    }
                } catch (Exception e) {
                }
            }
        }

        else if(ridu>veerge) {
            //paremale liikumine
            for (int veerg = 1; veerg < veerge; veerg++) {
                for (int rida = veerg; rida < veerge; rida++) {
                    mitmesrida = rida;
                    mitmesveerg = veerg;
                    diagonaal.add(maatriks[mitmesrida][mitmesveerg]);
                    break;
                }
            }
            //vasakule liikumine
            while(mitmesveerg!=0) {
                if(mitmesveerg == veerge - 1)
                    valik = 1;
                else if(mitmesveerg == 0)
                    throw null;
                else if(mitmesrida == ridu-1)
                    valik =2;
                switch(valik){
                    //1 - alla-vasakule 🡷🡷🡷🡷
                    case (1):
                        for (int rida = mitmesrida + 1; rida <= ridu - 1; rida++) {
                            for (int veerg = mitmesveerg - 1; veerg >= 0; --veerg) {
                                mitmesrida = rida;
                                mitmesveerg = veerg;
                                diagonaal.add(maatriks[mitmesrida][mitmesveerg]);
                                if (mitmesveerg == 0)
                                    break;
                                break;
                            }
                        }
                        //2- üles-vasakule  🡴🡴🡴🡴
                    case (2):
                        for (int rida = mitmesrida - 1; rida >= 0; --rida) {
                            for (int veerg = mitmesveerg - 1; veerg >= 0; --veerg) {
                                mitmesrida = rida;
                                mitmesveerg = veerg;
                                diagonaal.add(maatriks[mitmesrida][mitmesveerg]);
                                if (mitmesveerg == 0)
                                    break;
                                break;
                            }
                        }
                }

            }
        }
        //kui on n*n maatriks
        else if(ridu==veerge) {
            //paremale alla
            for (int rida = 1; rida < ridu; rida++) {
                for (int veerg = rida; veerg < ridu; veerg++) {
                    mitmesrida = rida;
                    mitmesveerg = veerg;
                    diagonaal.add(maatriks[mitmesrida][mitmesveerg]);
                    break;
                }
            }
            //vasakule üles
            for (int rida = ridu-2; rida >= 0 ; --rida) {
                for (int veerg = rida; veerg >= 0 ; --veerg) {
                    mitmesrida = rida;
                    mitmesveerg = veerg;
                    diagonaal.add(maatriks[mitmesrida][mitmesveerg]);
                    if(mitmesveerg == 0)
                        break;
                    break;
                }
            }
        }
        //ArrayList diagonaal int[] tüüpi massiiviks
        int[] diagonaalõige = new int[diagonaal.size()];
        for (int i = 0; i < diagonaalõige.length; i++) {
            diagonaalõige[i] = diagonaal.get(i);
        }
        return diagonaalõige;
    }
    public static void main(String[] args) {
        System.out.println("Kodutöö nr 1b.                                              Programmi väljund");
        System.out.println("=============================================================================:");
        int[][] maatriks6x3 = new int[][]{{ 1, 2, 3 },
                                        { 5, 6, 7 },
                                        { 9, 1, 5 },
                                        { 1, 2, 3 },
                                        { 5, 6, 7 },
                                        { 9, 1, 5 }};
        for(int[] a: maatriks6x3)
            System.out.println(Arrays.toString(a));
        System.out.println("Liikumisel käime läbi järgmised elemendid: " + Arrays.toString(pikendatudDiagonaal(maatriks6x3)));

        int[][] maatriks3x7 = new int[][]{{ 1, 2, 3, 4, 2, 7, 6 },
                                        { 5, 6, 7, 8, 1, 2, 3 },
                                        { 9, 1, 5, 1, 9, 3, 2 }};
        for(int[] a: maatriks3x7)
            System.out.println(Arrays.toString(a));
        System.out.println("Liikumisel käime läbi järgmised elemendid: " + Arrays.toString(pikendatudDiagonaal(maatriks3x7)));

        int[][] maatriks4x4 = new int[][]{{ 1, 2, 3, 5 },
                                            { 5, 6, 7, 1 },
                                            { 9, 1, 5, 4 },
                                            { 1, 2, 3, 3 }};
        for(int[] a: maatriks4x4)
            System.out.println(Arrays.toString(a));
        System.out.println("Liikumisel käime läbi järgmised elemendid: " + Arrays.toString(pikendatudDiagonaal(maatriks4x4)));

        System.out.println("=============================================================================.");
        System.out.println("Otto Bruno Koobakene                                "
                + new java.sql.Timestamp(System.currentTimeMillis()));
    }
}
