public class 큰수만들기 {

    public String solution(String number, int k) {
        int count = k;
        int index = 0;
        while (count > 0) {
            if (count > 1) {
                number


                //확인할 길이
                count + 1;
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
                    }
                }
            }
        }
        return number;
    }
}
