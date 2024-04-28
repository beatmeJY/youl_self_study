import java.util.LinkedList;
import java.util.Queue;

public class 타겟넘버 {
    static Queue<NumberPoint> queue = new LinkedList<NumberPoint>();

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 2, 3}, 2);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        queue.add(new NumberPoint(0, numbers[0], 0));
        queue.add(new NumberPoint(0, -1 * numbers[0], 0));

        while (true) {
            NumberPoint numberPoint = queue.poll();
            if (numberPoint == null) {
                return answer;
            }
            numberPoint.count++;
            numberPoint.totalNumber = numberPoint.totalNumber + numberPoint.plusNumber;
            if (numberPoint.count < numbers.length){
                queue.add(new NumberPoint(numberPoint.totalNumber, numbers[numberPoint.count], numberPoint.count));
                queue.add(new NumberPoint(numberPoint.totalNumber, -1 * numbers[numberPoint.count], numberPoint.count));
            }
            if (numberPoint.count == numbers.length && numberPoint.totalNumber == target) {
                answer++;
            }
        }
    }

    static class NumberPoint {
        int totalNumber;
        int plusNumber;
        int count;

        public NumberPoint(int totalNumber, int plusNumber, int count) {
            this.totalNumber = totalNumber;
            this.plusNumber = plusNumber;
            this.count = count;
        }
    }
}
