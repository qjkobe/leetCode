package primary.string;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String res = "1";
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++) {
            sb.delete( 0, sb.length() );
            int k = 0;
            for(int j = 0; j < res.length(); j++) {

                if(res.charAt(j) != res.charAt(k)){
                    sb.append(j - k);
                    sb.append(res.charAt(k));
                    k = j;
                }
                if (j == res.length() - 1) {
                    sb.append(j-k+1);
                    sb.append(res.charAt(j));
                }
            }
            res = sb.toString();

        }
        return sb.toString();
    }
}
