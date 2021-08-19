import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class BJ_1967 {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int n;
    static int maxChild = 0;
    static int max = 0;

    static class Node{
        int n;
        int w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    static void dfs(int num, int w){

        if( max < w){
            maxChild = num;
            max = w;
        }

        for (Node node : list[num]) {
            if (!visited[node.n]) {
                visited[node.n] = true;
                dfs(node.n, w + node.w);
                visited[node.n] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[p].add(new Node(c, w));
            list[c].add(new Node(p, w));
        }

        visited[1] = true;

        for (Node node : list[1] ) {
            visited[node.n] = true;
            dfs(node.n, node.w);
            visited[node.n] = false;
        }


        max = 0;
        visited = new boolean[n + 1];
        visited[maxChild] = true;

        for (Node node : list[maxChild] ) {
            visited[node.n] = true;
            dfs(node.n, node.w);
            visited[node.n] = false;
        }

        System.out.println(max);
    }
}
