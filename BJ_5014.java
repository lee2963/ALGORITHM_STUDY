import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5014 {
    static boolean[] visited;
    static Queue<Integer> q;
    static int s;
    static int g;
    static int u;
    static int d;
    static void bfs(int start){

        q.add(start);
        visited[start] = true;
        int[] next = {u, -d};
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int p = q.poll();

                if (p == g) {
                    System.out.println(cnt);
                    return;
                }
                for (int i = 0; i < 2; i++) {
                    int n = next[i] + p;

                    if (n > 0 && n < visited.length) {
                        if (!visited[n]) {
                            q.add(n);
                            visited[n] = true;
                        }

                    }
                }
                size--;
            }
            cnt++;
        }
        System.out.println("use the stairs");
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new boolean[f + 1];
        q = new LinkedList<>();

        bfs(s);
    }
}
