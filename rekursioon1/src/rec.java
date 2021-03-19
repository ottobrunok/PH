public class rec {
    public static void main(String[] args) {
        String str = "auto";
        System.out.println(vaheta(str,0,1));
    }
    private static String vaheta(String str, int i, int j){
        char temp;
        char[] karakteriRida = str.toCharArray();
        temp = karakteriRida[i];
        karakteriRida[i] = karakteriRida[j];
        karakteriRida[j] = temp;
        return String.valueOf(karakteriRida);
    }
}
