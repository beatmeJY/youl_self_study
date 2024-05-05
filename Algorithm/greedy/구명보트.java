import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                int max = people[maxIndex];
                List<Integer> maxSumList = new ArrayList<>();
                for (int i = maxIndex - 1; i >= 0; i--) {
                    List<Integer> sumList = new ArrayList<>();
                    int sum = people[maxIndex] + people[i];
                    if (limit >= sum) {
                        sumList.add(i);

                        if (limit - 40 < sum && max < sum) {
                            max = sum;
                            maxSumList = sumList;
                            continue;
                        }


                        for (int j = i; j >= 0 ; j++) {
                            if (limit > sum + people[j]) {

                            }
                        }
                    }
                }

            }
        }
        return answer;
    }
}
