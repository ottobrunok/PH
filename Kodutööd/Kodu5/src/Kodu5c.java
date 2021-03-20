import java.util.Arrays;

public class Kodu5c {
	public static int[][] summad(int n){
		return summadAbi(n, new int[]{});
	}

	public static int[][] summadAbi(int n, int[] praegune) {
		if (n < 0 || praegune.length > 1 && praegune[praegune.length-2] == praegune[praegune.length-1]) {
			System.out.println("Summa on putsis: " + Arrays.toString(praegune));
			return new int[0][];
		}
		if (n == 0) {
			System.out.println("Summa on 0: "+ Arrays.toString(praegune));
			return new int[][]{praegune.clone()};
		}

		int[][] kaks = summadAbi(n - 2, lisa(praegune, 2));
		int[][] neli = summadAbi(n - 4, lisa(praegune, 4));
		int[][] kuus = summadAbi(n - 6, lisa(praegune, 6));

		int[][] vastus = new int[kaks.length + neli.length + kuus.length][];
		int rida = 0;
		for (int[] kak : kaks)
			vastus[rida++] = kak;
		for (int[] ints : neli)
			vastus[rida++] = ints;
		for (int[] kuu : kuus)
			vastus[rida++] = kuu;
		return vastus;
	}

	public static int[] lisa(int[] a, int x) {
		int[] uus = new int[a.length + 1];
		System.arraycopy(a, 0, uus, 0, a.length);
		uus[a.length] = x;
		return uus;
	}

	public static String[] rongid(int n){
		return null;
	}

}//Kodu5c
