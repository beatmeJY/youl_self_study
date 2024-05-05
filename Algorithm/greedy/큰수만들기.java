public class 큰수만들기 {

    public static void main(String[] args) {
        String solution = solution("87549496413", 6);
        System.out.println("solution = " + solution);
    }

    public static String solution(String number, int k) {
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
                int maxPoint = number.indexOf(""+max);
                count = count - (maxPoint - index);
                number = number.substring(0, index) + number.substring(maxPoint);
                index++;
            }
            if (count == 1) {
                while (true) {
                    int is = Integer.parseInt(String.valueOf(number.charAt(index)));
                    int next = Integer.parseInt(String.valueOf(number.charAt(index + 1)));
                    if (index == number.length() - 1) {
                        number.substring(0, number.length() - 1);
                        count--;
                        break;
                    }else if (is > next) {
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
