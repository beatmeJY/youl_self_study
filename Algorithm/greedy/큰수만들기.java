public class 큰수만들기 {

    public String solution(String number, int k) {
        String answer = "";
        int count = k;
        int index = 0;
        while (count > 0) {
            if (count > 1) {
                int max = 0;
                for (int i = index; i <= index + count; i++) {
                    max = Integer.max(max, number.charAt(i));
                }
                StringBuilder builder = new StringBuilder();
                builder.append(number);
                builder.deleteCharAt(index);
                number.substring(index, max);
            } else {

            }
        }




        return answer;
    }
}
