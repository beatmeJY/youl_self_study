public class 조이스틱 {
    int[] visit;

    public int solution(String name) {
        int answer = 0;
        String al = "ABCDEFGHIJKLNMOPQRSTUVWXYZ";
        visit = new int[name.length()];

        for (int i = 0; i < name.length(); i++) {
            if ("A" == String.valueOf(name.charAt(i))) {
                visit[i] = 1;
            }
        }

        for (int i = 0; i < name.length(); i++) {
            if (visit[i] == 1) {
                findNext(i);
            }
        }
        return answer;
    }

    private int findNext(int i) {
        int next;
        int right = visit[i + 1];
        int left = visit[i - 1];
        while(true){
            if (right == left) {
            }
        }
        return next;
    }
}
