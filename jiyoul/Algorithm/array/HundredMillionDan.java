import java.util.Arrays;
import java.util.Comparator;

public class HundredMillionDan {

    static int e = 8;
    static int[] starts = {1,3,7};

    public static void main(String[] args) {
        int[] answer = new int[starts.length];

        int[][] multiplicationTable = new int[e+1][2];


        for (int beforeNum = 1; beforeNum <= e; beforeNum++) {
            for (int afterNum = beforeNum; afterNum <= e; afterNum = afterNum + beforeNum) {
                multiplicationTable[afterNum][0] = afterNum;
                multiplicationTable[afterNum][1]++;
            }
        }
        Arrays.sort(multiplicationTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] row1, int[] row2) {
                int result = Integer.compare(row2[1], row1[1]);
                if(result == 0) {
                    return Integer.compare(row1[0], row2[0]);
                }
                return result;
            }
        });
        int resultCount = 0;
        for (int startNum : starts) {
            for (int[] array : multiplicationTable) {
                if (array[0] >= startNum) {
                    answer[resultCount] = array[0];
                    break;
                }
            }
            resultCount++;
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }

}
