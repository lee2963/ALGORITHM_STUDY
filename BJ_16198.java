import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class BJ_16198 {
    static Vector<Integer> v;
    static int max = 0;

    static void func(int n, int energy) {

        if (v.size() == 2) {
            max = Math.max(max, energy);
            return;
        }

        for (int i = 1; i < v.size() - 1; i++) {
            int num = v.get(i);
            energy += v.get(i - 1) * v.get(i + 1);
            v.remove(i);
            func(i, energy);
            v.add(i, num);
            energy -= v.get(i - 1) * v.get(i + 1);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        v = new Vector<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int in = Integer.parseInt(st.nextToken());
            v.add(in);
        }

        for (int i = 1; i < n - 1; i++) {
            int num = v.get(i);
            int energy = v.get(i - 1) * v.get(i + 1);
            v.remove(i);
            func(i, energy);
            v.add(i, num);
        }
        System.out.println(max);
    }
}
