import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1926 {
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(x, y));
        visited[x][y] = true;

        int[] nextX = {0, 1, 0, -1};
        int[] nextY = {1, 0, -1, 0};
        int cnt = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = nextX[i] + p.x;
                int ny = nextY[i] + p.y;

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                    if(!visited[nx][ny]){
                        if (map[nx][ny] == 1) {
                            q.offer(new Pair(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            cnt++;
        }
        max = Math.max(max, cnt);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c];
        int cnt = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }
}
