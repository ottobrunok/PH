public class vahemikus {
    public static double vahemikus(double[] j�rjend, int mitmes){
        if(j�rjend[mitmes] > 0 && j�rjend[mitmes] < 1)
            return j�rjend[mitmes];
        else
            return vahemikus(j�rjend,mitmes+1);
    }

    public static void main(String[] args) {
        double[] j�rjend = {1.0,0.7,0.0,-0.9,0.3};
        double arv = vahemikus(j�rjend,0);
        System.out.println(arv);

    }
}
