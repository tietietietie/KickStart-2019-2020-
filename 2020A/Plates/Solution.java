import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int curCase = 1;

        while(curCase <= t) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0]-o1[0]);
            int N = in.nextInt();
            int K = in.nextInt();
            int P = in.nextInt();
            int[][] plates = new int[N][K];
            for(int i = 0; i < N; i++)
                for(int j = 0; j < K; j++)
                    plates[i][j] = in.nextInt();
            for(int i = 0; i < N; i++)
                pq.offer(new int[]{plates[i][0], i, 0});
            int ans = 0;
            while(P > 0) {
                int[] maxValuePlate = pq.poll();
                int value = maxValuePlate[0];
                int i     = maxValuePlate[1];
                int j     = maxValuePlate[2];
                if(j+1 < K)
                    pq.offer(new int[]{plates[i][j+1], i, j+1});
                ans += value;
                P--;
            }

            System.out.println("Case #" + curCase + ": " + ans);
            curCase++;
        }
    }
}