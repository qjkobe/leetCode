package Review;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String[] aa = a.split(" ");
        int[] x = new int[aa.length];
        String b = in.nextLine();
        String[] bb = b.split(" ");
        int[] y = new int[bb.length];
        int index = 0;
        for (String n : aa) {
            x[index++] = Integer.parseInt(n);
        }
        index = 0;
        for (String n : bb) {
            y[index++] = Integer.parseInt(n);
        }

    }
}
