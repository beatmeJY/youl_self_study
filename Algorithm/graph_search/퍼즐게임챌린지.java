package graph_search;

public class 퍼즐게임챌린지 {

    public static void main(String[] args) {
        int[] dd = {1, 1, 1};
        int[] ss = {10, 10, 10};
        int result = solution(dd, ss, 30);
        System.out.println(result);
    }

    public static int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start = 1;
        int end = 100_000;
        if (diffs.length == 1) {
            return times[0];
        }
        while (start <= end) {
            int level = (start + end) / 2;
            long totalTime = getSumTime(diffs, times, limit, level, times[0], times[0]);
            if (totalTime <= limit) {
                answer = level;
                end = level - 1;
            } else {
                start = level + 1;
            }
        }
        return answer;
    }

    private static long getSumTime(int[] diffs, int[] times, long limit, int level, int previousTime, long sumTime) {
        for (int i = 1; i < diffs.length; i++) {
            int currentTime = times[i];
            int differentLevel = diffs[i] - level;
            if (differentLevel > 0) {
                sumTime += (previousTime + currentTime) * differentLevel + currentTime;
            } else {
                sumTime += currentTime;
            }
            previousTime = currentTime;
            if (sumTime > limit) {
                return sumTime;
            }
        }
        return sumTime;
    }
}
