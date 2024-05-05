public class 큰수만들기 {

    StringBuilder builder = new StringBuilder();
    int count;
    int point = 0;

    public String solution(String number, int k) {
        String answer = "";
        builder.append(number);
        count = k;
        int index = 0;
        while (count > 0) {
            if (count > 1) {
                int max = 0;
                for (int i = point; i <= point + count; i++) {
                    if (max < number.charAt(i)) {
                        max = number.charAt(i);
                        index = i;
                    }
                }
                delete(index);
            } else {
                
            }
        }




        return answer;
    }

    private void delete(int index) {
        builder.delete(point, index);
        count = count - (index - point);
    }
}
