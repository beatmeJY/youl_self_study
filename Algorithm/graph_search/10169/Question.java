import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 마을의 수
        int M = Integer.parseInt(st.nextToken()); // 도로의 수

        int[][] list = new int[N][];


        // M개의 도로 정보 입력 받기
        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 첫 번째 마을
            int v = Integer.parseInt(st.nextToken()); // 두 번째 마을
            int cost = Integer.parseInt(st.nextToken()); // 관리 비용
        }

        br.close();
    }
}
