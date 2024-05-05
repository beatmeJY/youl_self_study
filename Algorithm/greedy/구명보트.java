import java.util.Arrays;

public class 구명보트 {

    int[] peoples;
    int limitWeight;

    public int solution(int[] people, int limit) {
        int answer = 0;
        limit = limit;
        peoples = Arrays.stream(people).sorted().toArray();

        for (int i = peoples.length-1; i >= 0 ; i--) {
           int[] dd = new int[7]{1,2};
            int[] max = dfs();
        }

        return answer;
    }

    private int[] dfs(int[] sumArray) {
        for (int i = index; i >= 0; i--) {
            if (limitWeight >= people + peoples[i]) {

            }
        }
    }
}
