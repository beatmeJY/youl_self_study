import java.util.Arrays;
import java.util.List;

public class Picture {
    static int answer = 0;
    static String[] character = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static int conditionSize;
    static String[] conditions;
    static List<String> standLines = Arrays.asList(new String[8]);

    public static void main(String[] args) {
        int solution = solution(2, new String[]{"N~F=0", "R~T>2"});
        System.out.println("solution = " + solution);
    }

    public static int solution(int n, String[] data) {
        conditionSize = n;
        conditions = data;
        dfs(0);
        return answer;
    }

    private static void dfs(int position) {
        if (position == 8) {
            if (conditionCheck()) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (standLines.contains(character[i])) {
                continue;
            }
            standLines.set(position, character[i]);
            dfs(position + 1);
            standLines.set(position, "");
        }
    }

    private static boolean conditionCheck() {
        for (String condition : conditions) {
            char me = condition.charAt(0);
            char target = condition.charAt(2);
            char operator = condition.charAt(3);
            int distance = condition.charAt(4) - '0';

            int myPosition = standLines.indexOf(String.valueOf(me));
            int targetPosition = standLines.indexOf(String.valueOf(target));

            if (myPosition == -1 || targetPosition == -1) {
                continue;
            }
            int actualDistance = Math.abs(myPosition - targetPosition) - 1;

            if (operator == '=' && actualDistance != distance) {
                return false;
            }
            if (operator == '>' && actualDistance <= distance) {
                return false;
            }
            if (operator == '<' && actualDistance >= distance) {
                return false;
            }
        }
        return true;
    }
}
