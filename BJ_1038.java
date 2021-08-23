import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_1038 {
    static int n;
    static ArrayList<Long> list;
    static void func(long num, int d){

        if (d > 10) {
            return;
        }

        list.add(num);

        for (int i = 0; i < 10; i++) {
            if (num % 10 > i) {
                func((num * 10) + i, d + 1);
            }
        }
        return;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if (n <= 10) {
            System.out.println(n);
        } else if(n > 1022){
            System.out.println("-1");
        } else{
            for (int i = 0; i < 10; i++) {
                func(i, 1);
            }
                Collections.sort(list);
                System.out.println(list.get(n));

        }
    }
}