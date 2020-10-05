import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int b = in.nextInt();
            int[] prices = new int[n];
            for(int j = 0; j < n; j++)
                prices[j] = in.nextInt();
            Arrays.sort(prices);
            int count = 0, curPrice = 0;
            while(curPrice <= b && count < n) {
                curPrice += prices[count++];
            }
            if(curPrice > b)
                count--;
            System.out.println("Case #" + i + ": " + count);
        }
    }
} 