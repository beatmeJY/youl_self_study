import java.util.Arrays;

public class 구명보트 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int minIndex = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            if (limit >= people[i] + people[minIndex]) {
                minIndex++;
                answer++;
            } else {
                answer++;
            }
        }
        return answer;
    }
}
