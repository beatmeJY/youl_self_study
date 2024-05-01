package sort;

import java.util.Arrays;

public class H_Index {

	public static void main(String[] args) {
		int solution = solution(new int[]{3, 0, 6, 1, 5});
		System.out.println("solution = " + solution);
	}

	public static int solution(int[] citations) {
		int answer = 0;

		Arrays.stream(citations).sorted();

		for (int i = citations[citations.length - 1]; i >= 0; i--) {
			int more = 0;
			int less = 0;
			for (int j = 0; j < citations.length; j++) {
				if (citations[j] >= i) {
					more++;
				}
				if (citations[j] <= i) {
					less++;
					if (less > i) {
						break;
					}
				}
			}
			if (less <= i && more >= i) {
				answer = i;
				break;
			}
		}
		return answer;
	}
}
