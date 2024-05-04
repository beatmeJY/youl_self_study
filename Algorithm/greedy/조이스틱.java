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
        int next;
        int right = i;
        int left = i;
        while(true){
            if (right == left) {
                int right = right + 1 > length -1;
                int left =
            }
        }
        return next;
    }
}
