import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5567 {
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int cnt = 0;
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int i = 2; i <= n; i++) {
            if(map[1][i] == 1) {
                if (!visited[i]) {
                    visited[i] = true;
                    cnt++;
                }
                for (int j = 2; j <= n; j++) {
                    if (map[i][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}