public class 큰수만들기 {

    public String solution(String number, int k) {
        int count = k;
        int index = 0;
        while (count > 0) {
            if (count > 1) {
                int max = 0;
                for (int i = index; i <= index + count; i++) {
                    int find = Integer.parseInt(String.valueOf(number.charAt(i)));
                    if (max < find) {
                        max = find;
                    }
                }
                int maxPoint = number.indexOf(max);
                count = count - (maxPoint - index);
                number = number.substring(0, index) + number.substring(maxPoint);
                index++;
            }
            if (count == 1) {
                while (true) {
                    int is = Integer.parseInt(String.valueOf(number.charAt(index)));
                    int next = Integer.parseInt(String.valueOf(number.charAt(index + 1)));
                    if (is > next) {
                        index++;
                    } else {
                        number = number.substring(0, index) + number.substring(index + 1);
                        count--;
                        break;
                    }
                }
            }
        }
        return number;
    }
}
