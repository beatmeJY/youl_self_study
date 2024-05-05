import java.util.ArrayList;
import java.util.List;

public class 큰수만들기 {

    public String solution(String number, int k) {
        int count = k;
        List<Integer> deleteList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int first = Integer.parseInt(String.valueOf(number.charAt(i)));
            int second = Integer.parseInt(String.valueOf(number.charAt(i + 1)));
            if (first < second) {
                deleteList.add(i);
            }
        }

        // deleteList 로 삭제하는 로직
        return null;
    }
}
