package dfs_bfs;

public class 네트워크 {

		public int solution(int n, int[][] computers) {
			int answer = 0;

			for (int i = 0; i < n; i++) {
				if (computers[i][i] == 0) {
					continue;
				}
				check(n, computers, i);
				answer++;
			}
			return answer;
		}

		private void check(int n, int[][] linkComputer, int i) {
			for (int j = 0; j < n; j++) {
				if (linkComputer[i][j] == 0) {
					continue;
				}
				linkComputer[i][j] = 0;
				check(n, linkComputer, j);
			}
		}
}
