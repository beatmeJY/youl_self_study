public class 순위 {

    static int[][] resultList;

    public static void main(String[] args) {
        int solution = solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
//        int solution = solution(9, new int[][]{{1,2},{1,3},{1,4},{1,5},{6,1},{7,1},{8,1},{9,1}});
        System.out.println("solution = " + solution);
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        resultList = new int[n+1][n+1];
        for (int i = 0; i < results.length; i++) {
            resultList[results[i][0]][results[i][1]] = 1;
            resultList[results[i][1]][results[i][0]] = -1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (i != k && k != j && i != j && resultList[i][j] == resultList[j][k] && resultList[i][j] != 0 && resultList[j][k] != 0) {
                        resultList[i][k] = resultList[i][j];
                        resultList[k][i] = resultList[i][j] == 1 ? -1 : 1;
                    }
                }
            }
        }
        for (int i = 0; i < resultList.length; i++) {
            boolean assuranceResult = true;
            for (int j = 1; j < resultList[i].length; j++) {
                if (i != j && resultList[i][j] == 0) {
                    assuranceResult = false;
                    break;
                }
            }
            if (assuranceResult) answer++;
        }
        return answer;
    }
}
