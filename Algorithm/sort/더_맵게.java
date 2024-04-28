import java.util.PriorityQueue;

public class 더_맵게 {

	public static void main(String[] args) {
		int result = solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
		System.out.println("args = " + result);
	}

	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int result = 0;
		for (int spicy : scoville) {
			queue.add(spicy);
		}
		while (true) {
			Integer first = queue.poll();
			if (first >= K) {
				return result;
			}
			Integer second = queue.poll();
			if (second == null) {
				return -1;
			}
			queue.add(first + second * 2);
			result++;
		}
	}
}
