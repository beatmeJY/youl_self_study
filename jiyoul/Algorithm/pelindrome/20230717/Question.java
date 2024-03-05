import java.util.ArrayList;
import java.util.List;

public class Question {
    static StringBuilder builder = new StringBuilder(1000000);

    public static void main(String[] args) {
        System.out.println("result = " + palindrome(100000,5));
    }

    public static String palindrome(Integer length, Integer charNum) {
        int halfLength = Math.round((float) length / 2);
        if (halfLength < charNum) {
            throw new RuntimeException(charNum + "개의 문자가 포함 될 수 없습니다.");
        }
        char a = 97;
        List<String> alphabetList = new ArrayList<>();

        for (int i = 0; i < charNum; i++) {
            alphabetList.add(String.valueOf(a++));
        }
        setPalindrome(length % 2 == 0 ? halfLength : halfLength - 1, alphabetList);
        String halfResult = builder.toString();
        builder.reverse();
        if (length % 2 == 1) setPalindrome(1, alphabetList);
        return builder.append(halfResult).toString();
    }

    public static void setPalindrome(Integer halfLength, List<String> alphabetList) {
        if (halfLength == 0) return;
        halfLength--;

        if (alphabetList.size() != 0) {
            builder.append(alphabetList.remove(0));
        } else {
            builder.append(builder.substring(0,1));
        }
        setPalindrome(halfLength, alphabetList);
    }

}