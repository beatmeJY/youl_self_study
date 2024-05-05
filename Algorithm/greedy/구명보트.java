import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = Arrays.stream(people).sorted().boxed().collect(Collectors.toList());

        while (true) {
            int max = 0;
            int index = list.size() - 1;


        }
        return answer;
    }
}
