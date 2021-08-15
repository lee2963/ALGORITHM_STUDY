import java.io.*;
import java.util.Stack;

public class BJ_5397 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = bf.readLine();

            Stack<Character> pre = new Stack<>();
            Stack<Character> post = new Stack<>();

            for (int j = 0; j < arr[i].length(); j++) {
                switch (arr[i].charAt(j)) {
                    case '<' :
                        if (!pre.isEmpty()) {
                            post.push(pre.pop());
                        }
                        break;
                    case '>':
                        if (!post.isEmpty()) {
                            pre.push(post.pop());
                        }
                        break;
                    case '-':
                        if (!pre.isEmpty()) {
                            pre.pop();
                        }
                        break;
                    default:
                        pre.push(arr[i].charAt(j));
                        break;
                }
            }
            while (!pre.isEmpty()) {
                post.push(pre.pop());
            }
            while (!post.isEmpty()) {
                bw.write(post.pop());
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
