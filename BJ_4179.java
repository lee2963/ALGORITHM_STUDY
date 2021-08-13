import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179 {
    static char[][] map;
    static boolean[][] visitedJ;
    static boolean[][] visitedF;
    static Queue<Pair> qJ;
    static Queue<Pair> qF;

    static void bfs() {

        int[] nextX = {-1, 0, 1, 0};
        int[] nextY = {0, 1, 0, -1};

        while (!qJ.isEmpty()) {
            int fSize = qF.size();

            if(!qF.isEmpty()) {
                for (int j = 0; j < fSize; j++) {
                    Pair p = qF.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = nextX[i] + p.x;
                        int ny = nextY[i] + p.y;

                        if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                            if (!visitedF[nx][ny]) {
                                if (map[nx][ny] == '.') {
                                    qF.add(new Pair(nx, ny));
                                    visitedF[nx][ny] = true;
                                    map[nx][ny] = 'F';
                                }
                            }
                        }
                    }
                }
            }
            int jSize = qJ.size();
            for (int j = 0; j < jSize; j++) {
                Pair p = qJ.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = nextX[i] + p.x;
                    int ny = nextY[i] + p.y;
                    if (nx == -1 || ny == -1 || nx == map.length || ny == map[0].length) {
                        System.out.println(p.cnt + 1);
                        return;
                    }
                    if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                        if (!visitedJ[nx][ny]) {
                            if (map[nx][ny] != '#' && map[nx][ny] != 'F') {
                                qJ.add(new Pair(nx, ny, p.cnt + 1));
                                visitedJ[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static class Pair {
        int x;
        int y;
        int cnt;

        public Pair() {

        }
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.cnt = 0;
        }

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        visitedJ = new boolean[r][c];
        visitedF = new boolean[r][c];

        qJ = new LinkedList<>();
        qF = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'J') {
                    qJ.add(new Pair(i, j));
                    visitedJ[i][j] = true;
                } else if(map[i][j] == 'F'){
                    qF.add(new Pair(i, j));
                    visitedF[i][j] = true;
                }
            }
        }

        bfs();

    }
}
