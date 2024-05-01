package sort;

import java.util.Arrays;

public class 가장큰수 {

	public static void main(String[] args) {
//		String result = solution(new int[]{3, 30, 34, 5, 9});
		String result = solution(new int[]{0, 0, 0, 0});
		System.out.println("result = " + result);
	}

	public static String solution(int[] numbers) {
		StringBuilder builder = new StringBuilder();
		String[] collect = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
		Arrays.sort(collect, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
		for (int i = 0; i < collect.length; i++) {
			builder.append(collect[i]);
		}
		String result = builder.toString();
		if ("0".equals(String.valueOf(result.charAt(0)))) {
			return "0";
		}
		return result;
	}
}
