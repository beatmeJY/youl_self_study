public class 큰수만들기 {

    public static void main(String[] args) {
//        String solution = solution("87549496413", 6);
        String solution = solution("1231234", 3);
        System.out.println("solution = " + solution);
    }

    public static String solution(String number, int k) {
        int count = k;
        StringBuilder builder = new StringBuilder();
        while (count > 0) {
            if (count > 1) {
                int max = 0;
                for (int i = 0; i <= count; i++) {
                    int find = Integer.parseInt(String.valueOf(number.charAt(i)));
                    if (max < find) {
                        max = find;
                    }
                }
                int maxPoint = number.indexOf(""+max);
                builder.append(max);
                count = count - maxPoint;
                number = number.substring(maxPoint + 1);
            }
            if (count == 1) {
                int index = 0;
                while (true) {
                    int is = Integer.parseInt(String.valueOf(number.charAt(index)));
                    int next = Integer.parseInt(String.valueOf(number.charAt(index + 1)));
                    if (index == number.length() - 1) {
                        builder.append(number.substring(0, number.length() - 1));
                        count--;
                        break;
                    } else if (is >= next) {
                        index++;
                    } else {
                        builder.append(number.substring(0, index)).append(index + 1);
                        count--;
                        break;
                    }
                }
            }
        }
        return builder.toString();
    }
}
