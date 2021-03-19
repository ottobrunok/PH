public class vahemikus {
    public static double vahemikus(double[] järjend, int mitmes){
        if(järjend[mitmes] > 0 && järjend[mitmes] < 1)
            return järjend[mitmes];
        else
            return vahemikus(järjend,mitmes+1);
    }

    public static void main(String[] args) {
        double[] järjend = {1.0,0.7,0.0,-0.9,0.3};
        double arv = vahemikus(järjend,0);
        System.out.println(arv);

    }
}
