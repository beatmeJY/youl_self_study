public class 큰수만들기 {

    StringBuilder builder = new StringBuilder();
    int count = k;

    public String solution(String number, int k) {
        String answer = "";
        builder.append(number);
        int index = 0;
        while (count > 0) {
            if (count > 1) {
                int max = 0;
                for (int i = index; i <= index + count; i++) {
                    max = Integer.max(max, number.charAt(i));
                }
                delete(max);
                builder.deleteCharAt(0);
            } else {

            }
        }




        return answer;
    }

    private void delete(int max) {

    }
}
