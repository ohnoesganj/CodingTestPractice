import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        Set<String> member = new HashSet();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.equals("ENTER")) {
                member.clear();
            } else {
                if (member.contains(str)) {
                    continue;
                }
                member.add(str);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}