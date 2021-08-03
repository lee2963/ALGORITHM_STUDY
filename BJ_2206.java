import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206 {
    static boolean[][] map;
    static int[][] graph;
    static boolean[][][] visited;
    static Queue<Pair> q;
    static class Pair{
        int x;
        int y;
        boolean state = false;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair(int x, int y, boolean state) {
            this.x = x;
            this.y = y;
            this.state = state;
        }
    }

    static void bfs() {

        q.add(new Pair(0, 0));
        graph[0][0] = 1;
        visited[0][0][0] = true;
        int[] nextX = {-1, 0, 0, 1};
        int[] nextY = {0, 1, -1, 0};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.x == map.length - 1 && p.y == map[0].length-1) {
                System.out.println(graph[p.x][p.y]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = nextX[i] + p.x;
                int ny = nextY[i] + p.y;

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                        if (p.state && !visited[nx][ny][1]) {
                            if (!map[nx][ny]) {
                                q.add(new Pair(nx, ny, true));
                                graph[nx][ny] = graph[p.x][p.y] + 1;
                                visited[nx][ny][1] = true;
                            }
                        } else if(!p.state && !visited[nx][ny][0]){
                            if (!map[nx][ny]) {
                                q.add(new Pair(nx, ny, false));
                                visited[nx][ny][0] = true;
                            } else {
                                q.add(new Pair(nx, ny, true));
                                visited[nx][ny][1] = true;
                            }
                            graph[nx][ny] = graph[p.x][p.y] + 1;
                        }
                }
            }
        }
        System.out.println("-1");
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new boolean[r][c];
        graph = new int[r][c];
        visited = new boolean[r][c][2];
        q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String s = bf.readLine();
            for (int j = 0; j < c; j++) {
               char n = s.charAt(j);

                if (n == '0') {
                    map[i][j] = false;
                } else{
                    map[i][j] = true;
                }
            }
        }


        bfs();

    }
}
