import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> peopleList = Arrays.stream(people).sorted().boxed().collect(Collectors.toList());

        while (true) {
            int index = peopleList.size() - 1;
            int max = peopleList.get(index);
            List<Integer> sumIndex = new ArrayList<>();
            for (int i = index; i >= 0; i--) {
                int sum = max + peopleList.get(i);
                if (limit <= sum && max < sum) {
                    sumIndex.add()
                }
            }

        }
        return answer;
    }
}
