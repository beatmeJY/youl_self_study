import java.util.ArrayList;
import java.util.Arrays;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        while (true) {
            for (int maxIndex = people.length - 1; maxIndex >= 0; maxIndex--) {
                int max = people[maxIndex];
                ArrayList<Integer> sumList = new ArrayList<>();
                for (int j = maxIndex - 1; j >= 0; j--) {

                }

            }
        }


        return answer;
    }
}
