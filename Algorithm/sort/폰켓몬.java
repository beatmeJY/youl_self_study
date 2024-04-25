package sort;

import java.util.Arrays;

public class 폰켓몬 {
	public int solution(int[] nums) {
		if (nums.length == 0){
			return 0;
		}
		int halfCount = nums.length / 2;

		Arrays.sort(nums);

		int[] distinctArray = Arrays.stream(nums).distinct().toArray();

		if (distinctArray.length >= halfCount) {
			return halfCount;
		}
		return distinctArray.length;
	}
}
