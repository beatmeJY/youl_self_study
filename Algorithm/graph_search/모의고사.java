import java.util.*;
import java.util.stream.IntStream;

public class 모의고사 {

	public static void main(String[] args) {
		int[] solution = solution(new int[]{1, 2, 3, 4, 5});
		for (int i : solution) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] answers) {
		int[][] answerCount = {{1, 0}, {2, 0}, {3, 0}};
		int[] first = {1, 2, 3, 4, 5};
		int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == first[i % 5]) {
				answerCount[0][1]++;
			}
			if (answers[i] == second[i % 8]) {
				answerCount[1][1]++;
			}
			if (answers[i] == third[i % 10]) {
				answerCount[2][1]++;
			}
		}
		Arrays.sort(answerCount, (i, j) -> {
			return -1 * (i[1]-j[1]);
		});
		List<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (answerCount[i][1] != 0) {
				arrayList.add(answerCount[i][0]);
			}
		}
		int[] result = arrayList.stream().mapToInt(Integer::intValue).toArray();
		return result;
	}
}
