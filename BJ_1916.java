import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bus implements Comparable<Bus>{
    int arrive;
    int cost;

    Bus(int arrive,int cost){
        this.arrive = arrive;
        this.cost = cost;
    }
    @Override
    public int compareTo(Bus o) {
        return cost - o.cost;
    }
}
public class BJ_1916 {
    private static final int INF = Integer.MAX_VALUE;
    static List<Bus> list[];
    static int dist[];
    static int n;
    static int m;
    static void dijsktra(int start){

        PriorityQueue<Bus> pq = new PriorityQueue<>();

        pq.add(new Bus(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Bus b = pq.poll();
            int index = b.arrive;

            if(dist[b.arrive] < b.cost)
                continue;

            for (Bus bus : list[index]) {
                if ( dist[bus.arrive] > dist[index] + bus.cost) {
                    dist[bus.arrive] = dist[index] + bus.cost;
                    pq.offer(new Bus(bus.arrive, dist[bus.arrive]));
                }
            }
        }


    }
    static public void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        list = new List[n + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Bus(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijsktra(s);

        System.out.println(dist[e]);
    }
}
