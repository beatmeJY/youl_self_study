import java.util.Arrays;

public class 모의고사 {

	public static void main(String[] args) {
		solution(new int[]{});
	}

	public static int[] solution(int[] answers) {
		int[] answer = new int[3];
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
			return i[1]-j[1];
		});
		for (int i = 0; i < 3; i++) {
			if (answerCount[i][0] != 0) {
				answer[i] = answerCount[i][0];
			}
		}
		return answer;
	}
}
