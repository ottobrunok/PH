public class summa {
    static double summa(double[] j�rjend,double summa,int loendur){
        if(loendur == 0)
            return 0;
        else{
            summa= summa + j�rjend[loendur];
            return summa + summa(j�rjend,0,loendur+1);
        }
    }
    static double miinimum(double[] j�rjend, int loendur){
        if(loendur == 1)
            return j�rjend[0];
        return Math.min(j�rjend[loendur-1],miinimum(j�rjend,loendur-1));
    }
    public static void main(String[] args) {
        double[] j�rjend = {1.0,0.7,0.0,-0.9,0.3};
        int pikkus = j�rjend.length;
        System.out.println(miinimum(j�rjend,pikkus));
    }
}

