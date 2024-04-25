package queue_stack;

public class 주식가격 {

	public static void main(String[] args) {
		int[] solution = solution(new int[]{1, 2, 3, 2, 3});
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int nowValue = 0; nowValue < prices.length; nowValue++) {
			int count = 0;
			for (int comparativeValue = nowValue + 1; comparativeValue < prices.length; comparativeValue++) {
				answer[nowValue]++;
				if (prices[comparativeValue] < prices[nowValue]) {
					break;
				}
			}
		}
		return answer;
	}
}
