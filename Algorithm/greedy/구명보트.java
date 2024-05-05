import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = Arrays.stream(people).sorted().boxed().collect(Collectors.toList());

        for (int i = list.size() - 1; i >= 0; i--) {
            Integer big = list.get(i);

        }
        return answer;
    }
}
