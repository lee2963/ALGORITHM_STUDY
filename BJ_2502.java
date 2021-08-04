import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2502 {
    static int d;
    static int k;
    static boolean chk;
    static void func(int day, int first, int sec, int prePre ,int pre) {
        if (day == d) {
            if (pre + prePre == k) {
                System.out.println(first);
                System.out.println(sec);
                chk = true;
            }
            return;
        }

        func(day + 1, first, sec, pre, pre + prePre);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i < k; i++) {
            for (int j = i + 1 ; j < k; j++) {
                func(3, i, j, i, j);
                if(chk)
                    return;
            }
        }
    }
}
