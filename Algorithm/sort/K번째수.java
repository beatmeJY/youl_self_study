package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class K번째수 {

	public static void main(String[] args) {
		int[] solution = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		List<Integer> sortList = Arrays.stream(array).boxed().collect(Collectors.toList());

		for (int i = 0; i < commands.length; i++) {
			List<Integer> subStringList = sortList.subList(commands[i][0] - 1, commands[i][1]).stream().collect(Collectors.toList());
			subStringList.sort(Comparator.naturalOrder());
			answer[i] = subStringList.get(commands[i][2] - 1);
		}
		return answer;
	}
}
