import java.util.Arrays;

public class 조이스틱 {

    public static void main(String[] args) {
        int solution = solution("AAAABAAAAAAABABABAB");
        System.out.println("solution = " + solution);
    }

    public static int solution(String name) {
        // 알파벳별 조이스틱 조작 횟수 계산
        int totalMoves = 0;
        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            totalMoves = totalMoves + Math.min(currentChar - 'A', 'Z' - currentChar + 1);
        }

        // 커서 이동 횟수 계산
        int minMovesToChange = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            int nextIndex = i + 1;
            while (nextIndex < name.length() && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            minMovesToChange = Math.min(
                minMovesToChange,
                i + name.length() - nextIndex + Math.min(i, name.length() - nextIndex)
            );
        }

        // 총 이동 횟수 반환
        return totalMoves + minMovesToChange;
    }
}
