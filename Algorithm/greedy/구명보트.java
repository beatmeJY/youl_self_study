import java.util.Arrays;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        for (int i = people.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (limit >= people[i] + people[j]) {
                    people[i] = people[j] = 0;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

}
