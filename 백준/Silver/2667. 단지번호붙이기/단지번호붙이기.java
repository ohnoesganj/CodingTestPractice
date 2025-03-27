import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] arr;
    static int count = 0;
    static int num = 0;
    static int nowX, nowY, N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && (arr[i][j] == 1)) {
                    count = 0;
                    num++;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        sb.append(num).append("\n");
		for (int i : list) {
			sb.append(i).append("\n");
		}

        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        arr[x][y] = num;
        count++;

        for (int i = 0; i < 4; i++) {
            nowX = dx[i] + x;
            nowY = dy[i] + y;

            if (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N && !visited[nowX][nowY] && arr[nowX][nowY] == 1) {
                visited[nowX][nowY] = true;
                arr[nowX][nowY] = num;

                dfs(nowX, nowY);
            }
        }
    }
}