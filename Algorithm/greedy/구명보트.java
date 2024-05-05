import java.util.Arrays;

public class 구명보트 {

    int[] peoples;
    int limitWeight;

    public int solution(int[] people, int limit) {
        int answer = 0;
        limit = limit;
        peoples = Arrays.stream(people).sorted().toArray();

        for (int i = peoples.length-1; i >= 0 ; i--) {
            int[] array = new int[8];
            array[0] = people[i];
            array[1] = i;
            array[8] = 1;
            int[] max = dfs(array);
        }

        return answer;
    }

    private int[] dfs(int[] sumArray) {
        for (int i = sumArray[sumArray[8]] - 1; i >= 0; i--) {
            if (limitWeight >= sumArray[0] + peoples[i]) {
                sumArray[0] = sumArray[0] + peoples[i];
                sumArray[++sumArray[8]] = i;
            }
        }
    }
}
