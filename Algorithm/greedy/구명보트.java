import java.util.ArrayList;
import java.util.Arrays;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        while (true) {
            for (int maxIndex = people.length - 1; maxIndex >= 0; maxIndex--) {
                if (limit - 40 < people[maxIndex]) {
                    people[maxIndex] = 0;
                    answer++;
                    continue;
                }
                ArrayList<Integer> sumList = new ArrayList<>();
                for (int i = maxIndex - 1; i >= 0; i--) {
                    int sum = 0;
                    if (limit <= people[maxIndex] + people[i]) {
                        if (limit - 40 < people[maxIndex] + people[i]) {
                            continue;
                        }
                        for (int j = i; j >= 0 ; j++) {

                        }
                    }
                }

            }
        }
        return answer;
    }
}
