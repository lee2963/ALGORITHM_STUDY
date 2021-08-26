import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9466 {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finish;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finish = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }

            System.out.println(n - cnt);

            cnt = 0;

        }

    }

    static void dfs(int n) {

        visited[n] = true;

        int next = arr[n];

        if (!visited[next]) {
            dfs(next);
        } else if (!finish[arr[next]]) {
            cnt++;

            for (int i = next; i != n; i = arr[i]) {
                cnt++;
            }
        }
        finish[n] = true;
    }
}
