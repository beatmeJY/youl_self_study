import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = Arrays.stream(people).sorted().boxed().collect(Collectors.toList());
        while (list.size() == 0) {
            int max = list.get(list.size());
            for (int j = max - 1; j >= 0; j--) {
                if (limit >= list.get(max) + list.get(j)) {
                    list.remove(max);
                    list.remove(j);
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

}
