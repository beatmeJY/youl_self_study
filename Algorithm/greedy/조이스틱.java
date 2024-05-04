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

        for (int i = 0; i < name.length(); i++) {
            if (visit[i] == 1) {
                findNext(i);
            }
        }
        return answer;
    }

    private int findNext(int i) {
        int right = i;
        int left = i;
        while(true){
            if (visit[right] == visit[left]) {
                right = right + 1 > length - 1 ? 0 : right + 1;
                left = left - 1 < 0 ? length - 1 : left -1;
                continue;
            }
            if (visit[right] > visit[left]) {
                return left;
            } else {
                return right;
            }
        }
    }
}
