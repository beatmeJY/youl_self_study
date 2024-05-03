import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순위 {

    public static void main(String[] args) {
        int solution = solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
        System.out.println("solution = " + solution);
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        List<List<Integer>> resultList = new ArrayList<>();
        int[] ranks = new int[n + 1];

        for (int i = 1; i <= n + 1; i++) {
            resultList.add(new ArrayList<Integer>());
            ranks[i - 1] = n;
        }
        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            resultList.get(win).add(lose);
            ranks[win-1]--;
        }
        Arrays.stream(ranks).sorted();
        int before = ranks[0];
        int count = 1;
        for (int i = 0; i < ranks.length; i++) {
            if (before != ranks[i] && count == 1 && i == ranks[i]) {
                answer++;
            }
            if (before == ranks[i]) {
                count++;
            } else {
                count = 1;
            }
            before = ranks[i];
        }
        return answer;
    }
}
