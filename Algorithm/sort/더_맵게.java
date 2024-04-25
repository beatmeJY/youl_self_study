package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 더_맵게 {

	public static void main(String[] args) {
		solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		Arrays.sort(scoville);
		PriorityQueue<Integer> queue = new PriorityQueue();
		Arrays.stream(scoville).forEach(queue::add);

		boolean finish = false;
		int mixSpicy = 0;

		while (finish) {
			Integer firstSmallSpicy = queue.poll();
			if (K <= firstSmallSpicy) {
				break;
			}
			if (queue.size() == 0) {
				answer = -1;
				break;
			}
			Integer secondSmallSpicy = queue.poll();
			queue.add(firstSmallSpicy + secondSmallSpicy * 2);
			answer++;
		}
		return answer;
	}
}
