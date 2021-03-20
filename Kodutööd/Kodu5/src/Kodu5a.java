public class Kodu5a {

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

	public static boolean kasSobib(int[] x, int s){
		return true;
	}

	public static int[] kuidasMaksta(int[] x, int s){
		return null;
	}

	public static String[] sonePoime(String[] a, String[] b){
		return null;
	}

    public static void main(String[] args) {
        // Näidis
        System.out.println("Kodutöö nr 5a.                          Programmi väljund");
        System.out.println("=========================================================:");
        //Siia lisada testimine
        System.out.println("\n=========================================================.");
        System.out.println("Ülli Õpilane                      " + new java.sql.Timestamp(System.currentTimeMillis()));
    }//peameetod


}//Kodu5a
