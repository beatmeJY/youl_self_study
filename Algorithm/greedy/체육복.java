import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 체육복 {

    public static void main(String[] args) {
        int result = solution(5, new int[]{2, 4}, new int[]{3});
        System.out.println("result = " + result);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> lostList = Arrays.stream(lost).sorted().boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).sorted().boxed().collect(Collectors.toList());
        for (int lostStudent : lost) {
            if (reserveList.stream().anyMatch(f -> f == lostStudent)) {
                reserveList.remove((Object)lostStudent);
                lostList.remove((Object)lostStudent);
            }
        }
        answer = n - lostList.size();
        for (Integer lostStudent : lostList) {
            int before = lostStudent - 1;
            int next = lostStudent + 1;
            if (reserveList.stream().anyMatch(f->f == before)){
                reserveList.remove((Object) before);
                answer++;
                continue;
            } else if (reserveList.stream().anyMatch(f->f == next)) {
                reserveList.remove((Object) next);
                answer++;
            }
        }
        return answer;
    }
}
