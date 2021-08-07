import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1092 {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] crane = new int[n];
        Vector<Integer>[] v = new Vector[n];

        for (int i = 0; i < n; i++) {
            v[i] = new Vector<>();
        }
        for (int i = 0; i < n; i++) {
            crane[i] = in.nextInt();
        }

        int m = in.nextInt();
        Integer[] box = new Integer[m];
        for (int i = 0; i < m; i++) {
            box[i] = in.nextInt();
        }

        Arrays.sort(crane);
        Arrays.sort(box, Collections.reverseOrder());
        int max = 0;

        for (int i = 0; i < m; i++) {
            boolean chk = false;
            for (int j = 0; j < n; j++) {
                if(crane[j] >= box[i]){
                    chk = true;
                    int min = v[j].size();
                    int index = j;
                    for (int k = j + 1; k < n; k++) {
                        if (min > v[k].size()) {
                            index = k;
                            min = v[k].size();
                        }
                    }
                    v[index].add(box[i]);
                    max = Math.max(max, v[index].size());
                    break;
                }
            }
            if(!chk){
                System.out.println("-1");
                return;
            }
        }
        System.out.println(max);

    }
}
