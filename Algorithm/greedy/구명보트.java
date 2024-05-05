import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = Arrays.stream(people).sorted().boxed().collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size(); j > i; j--) {
                if (list.get(j) + list.get(i) == limit) {
                    
                }
            }
        }
        return answer;
    }
}
