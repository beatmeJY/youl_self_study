import java.util.Arrays;
import java.util.List;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> lostList = Arrays.stream(lost).sorted().mapToObj(Integer::valueOf).toList();
        List<Integer> reserveList = Arrays.stream(lost).sorted().mapToObj(Integer::valueOf).toList();
        for (int i = 0; i < lost.length; i++) {
            lostList.remove((Object)lost[i]);
            reserveList.remove((Object)lost[i]);
        }
        Arrays.sort(lost);
        Arrays.sort(reserve);

        
        return answer;
    }
}
