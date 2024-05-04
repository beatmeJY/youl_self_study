import java.util.Arrays;

public class 조이스틱 {
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

        return answer;
    }
}
