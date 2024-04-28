public class 최소직사각형 {
	public int solution(int[][] sizes) {
		int max = 1;
		int min = 1;

		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] > sizes[i][1]) {
				if (max < sizes[i][0]) {
					max = sizes[i][0];
				}
				if (min < sizes[i][1]) {
					min = sizes[i][1];
				}
			} else {
				if (max < sizes[i][1]) {
					max = sizes[i][1];
				}
				if (min < sizes[i][0]) {
					min = sizes[i][0];
				}
			}
		}
		return max * min;
	}
}
