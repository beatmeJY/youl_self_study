import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        long solution = solution(n, times);
        System.out.println("solution = " + solution);
    }

    public static long solution(int n, int[] times) {
        long totalTime = 0;
        Arrays.sort(times);
        int minNum = times[0];
        int maxNum = times[times.length-1];
        long halfTotalTime = maxNum * n / 2;

        int result = getTotalByTime(n, times, halfTotalTime);

        boolean flag = false;
        if ((!flag) && result == -1) {
            flag = true;
        }
        while (result != 0) {
            if ((!flag) && result == -1) {
                flag = true;
            }
            halfTotalTime += result;
            result = getTotalByTime(n, times, halfTotalTime);
        }

        if (flag) {
            while (result == -1 || result == 0) {
                halfTotalTime--;
                result = getTotalByTime(n, times, halfTotalTime);
            }
            halfTotalTime++;
        }
        return halfTotalTime;
    }

    public static int getTotalByTime(int n, int[] times, long halfTotalTime) {
        int completeCount = 0;
        for (int time : times) {
            completeCount += halfTotalTime / time;
            if (completeCount > n) break;
        }
        return completeCount == n ? 0 : completeCount > n ? -1 : 1;
    }
}

