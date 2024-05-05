import java.util.Comparator;
import java.util.PriorityQueue;

public class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visit = new boolean[words.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(c -> c[0]));

        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    count++;
                }
            }
            if (count == 1) {
                queue.add(new int[]{1, i});
                visit[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (target == words[poll[1]]) {
                answer = poll[0];
                break;
            }
            for (int i = 0; i < words.length; i++) {
                if (visit[poll[i]]) {
                    continue;
                }
                int count = 0;
                for (int j = 0; j < begin.length(); j++) {
                    if (words[poll[1]].charAt(j) != words[i].charAt(j)) {
                        count++;
                    }
                }
                if (count == 1) {
                    queue.add(new int[]{1, i});
                    visit[i] = true;
                }
            }
        }
        return answer;
    }
}
