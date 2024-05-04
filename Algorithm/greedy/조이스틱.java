import java.util.Arrays;

public class 조이스틱 {
    int[] visit;
    int[] visit;
    int length;

    public int solution(String name) {
        int answer = 0;
        String al = "ABCDEFGHIJKLNMOPQRSTUVWXYZ";
        length = name.length();
        visit = new int[length];


        for (int i = 0; i < name.length(); i++) {
            if ("A" == String.valueOf(name.charAt(i))) {
                visit[i] = 1;
            }
        }

        for (int i = 0; i < name.length(); i++) {
            if (checkAllVisit()) {
                break;
            }
            if (visit[i] == 1) {
                int next = findNext(i);
            }
        }
        return answer;
    }

    private int findNext(int i) {
        int right = i;
        int rightFirst = 30;
        int left = i;
        int leftFirst = 30;
        while(true){
            if (visit[right] == 0 && rightFirst == 30) {
                rightFirst = visit[right];
            }
            if (visit[left] == 0 && leftFirst == 30) {
                leftFirst = visit[left];
            }

            if (visit[right] == visit[left]) {
                right = right + 1 > length - 1 ? 0 : right + 1;
                left = left - 1 < 0 ? length - 1 : left -1;
                continue;
            }

            if (visit[right] > visit[left]) {
                return leftFirst;
            } else {
                return rightFirst;
            }
        }
    }

    boolean checkAllVisit() {
        return !Arrays.stream(visit).anyMatch(f -> f == 0);
    }
}
