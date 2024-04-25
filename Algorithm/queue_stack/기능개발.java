package queue_stack;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {

	static List<Integer> answer = new ArrayList<>();
	static int deployDay = 0;

	public static void main(String[] args) {
		int[] solution = solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
		for (int i : solution) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		answer.add(0);
		process(progresses, speeds, progresses.length - 1);
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	// [95, 90, 99, 99, 80, 99] / [1, 1, 1, 1, 1, 1]
	public static int process(int[] progresses, int[] speeds, int deeps) {
		int totalDay = 0;

		if (0 < deeps) {
			totalDay = process(progresses, speeds, deeps - 1);
		}

		int lackRate = 100 - progresses[deeps];

		int expectDay = lackRate / speeds[deeps];
		if (progresses[deeps] + speeds[deeps] * expectDay < 100) {
			expectDay++;
		}
		if (totalDay == 0) {
			totalDay = expectDay;
		}
		if (totalDay >= expectDay) {
			answer.set(deployDay, answer.get(deployDay) + 1);
		} else {
			totalDay = expectDay;
			deployDay++;
			answer.add(1);
		}
		return totalDay;
	}
}
