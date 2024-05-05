public class 큰수만들기 {

    public static void main(String[] args) {
//        String solution = solution("87549496413", 6);
        String solution = solution("1231234", 3);
//        String solution = solution("9876543214", 4);
        System.out.println("solution = " + solution);
    }

    public static String solution(String number, int k) {
        StringBuilder builder = new StringBuilder();
        int remain = number.length() - k;
        int start = 0;

        for (int i = 0; i < remain; i++) {
            int maxIndex = start;
            char max = number.charAt(start);

            for (int j = start; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    maxIndex = j;
                }
            }
            builder.append(max);
            start = maxIndex + 1;
        }
        return builder.toString();
    }
}
