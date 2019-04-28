import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            printSeries(a, b, n);
        }
        in.close();
    }

    public static void printSeries(int a, int b, int n) {
        for (int s = 0; s < n; s++) {
            int result = a;
            for (int exp = 0; exp <= s; exp++) {
                result += Math.pow(2, exp) * b;
            }
            System.out.print(result + " ");
        }
        System.out.println();
    }

}
