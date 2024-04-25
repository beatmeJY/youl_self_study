package sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        List<String> sorted =
                Arrays
                .stream(phone_book)
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < sorted.size(); i++) {
            for (int j = 0; j < sorted.get(i).length(); j++) {
                if (i == sorted.size() - 1) {
                    return true;
                }
                if (j > sorted.get(i + 1).length()) {
                    return false;
                }
                if (sorted.get(i).charAt(j) == sorted.get(i + 1).charAt(j)) {
                    if (sorted.get(i).length() - 1 == j) {
                        return false;
                    }
                } else {
                    break;
                }
            }
        }
        return true;
    }
}
