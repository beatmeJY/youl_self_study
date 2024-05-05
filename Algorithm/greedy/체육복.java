import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> lostList = Arrays.stream(lost).sorted().mapToObj(Integer::valueOf).toList();
        List<Integer> reserveList = Arrays.stream(lost).sorted().mapToObj(Integer::valueOf).toList();
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            int i1 = reserveList.indexOf(lostList.get(i));
            if (i1 >= 0) {
                reserveList.remove(i1);
                lostList.remove("1");
            }
        }
        return answer;
    }
}
