import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int t = 1; t <= T; t++) {
            //Insert your code here.
            //input:N, K, arr:M
            //1: obtain array of difficuties(N-1)
            //2: l = 1, r = max(di) mid = (l + r + 1) / 2
            //3: binary search, sum(ki), ki = Math.ceil(ans/di) sum(ki) < K, l = mid. sum(ki) > K ,r = mid-1
            int N = in.nextInt();
            int K = in.nextInt();
            int l = 1, r = 1;
            int[] m = new int[N];
            int[] d = new int[N-1];
            for(int i = 0; i < N; i++)
                m[i] = in.nextInt();
            for(int i = 0; i < N-1; i++) {
                d[i] = m[i+1] - m[i];
                r = Math.max(r, d[i]);
            }
            
            //binary search
            while(l < r) {
                int mid = (l + r) / 2;
                int sum = sumOfKi(d, mid);
                if(sum <= K)
                    r = mid;
                else
                    l = mid+1;
            }

            System.out.println("Case #" + t + ": " + l);
        }
    }

    private static int sumOfKi(int[] d, int ans) {
        int sum = 0;
        for(int di : d) {
            if(di > ans) {
                sum += Math.ceil((double)di/ans) - 1;
            }
        }
        return sum;
    }
} 