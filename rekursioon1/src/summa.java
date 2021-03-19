public class summa {
    static double summa(double[] järjend,double summa,int loendur){
        if(loendur == 0)
            return 0;
        else{
            summa= summa + järjend[loendur];
            return summa + summa(järjend,0,loendur+1);
        }
    }
    static double miinimum(double[] järjend, int loendur){
        if(loendur == 1)
            return järjend[0];
        return Math.min(järjend[loendur-1],miinimum(järjend,loendur-1));
    }
    public static void main(String[] args) {
        double[] järjend = {1.0,0.7,0.0,-0.9,0.3};
        int pikkus = järjend.length;
        System.out.println(miinimum(järjend,pikkus));
    }
}

