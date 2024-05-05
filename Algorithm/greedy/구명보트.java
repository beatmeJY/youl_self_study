import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 구명보트 {

    public static void main(String[] args) {
        int result = solution(new int[]{70, 50, 80, 50}, 100);
        System.out.println("result = " + result);
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = Arrays.stream(people).sorted().boxed().collect(Collectors.toList());
        while (list.size() > 0) {
            int maxIndex = list.size() - 1;
            int max = list.get(maxIndex);
            for (int i = maxIndex; i >= 0; i--) {
                if (limit >= max + list.get(i)) {
                    list.remove(maxIndex);
                    list.remove(i);
                    answer++;
                    break;
                }
                if (i == 0) {
                    list.remove(maxIndex);
                    answer++;
                }
            }
        }
        return answer;
    }

}
