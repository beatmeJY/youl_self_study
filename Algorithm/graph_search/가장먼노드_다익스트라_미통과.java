import java.util.*;

public class 가장먼노드_다익스트라_미통과 {

	static int[][] map;

	static Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
	static boolean[] visits;
	static final int MAX_DISTANCE = 1999999999;

	public static void main(String[] args) {
		int solution = solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
		System.out.println("solution = " + solution);
	}

	public static int solution(int n, int[][] edge) {
		int answer = 0;
		init(n, edge);
		queue.add(new int[]{0, 1});
		dijkstra(n, edge);
		Arrays.sort(map, Comparator.comparing((int[] node) -> node[0]));
		int maxDistance = 0;
		for (int i = n; i >= 1; i--) {
			if (maxDistance == 0) maxDistance = map[i][0];
			if (map[i][0] < maxDistance) {
				break;
			}
			answer++;
		}
		return answer;
	}

	private static void dijkstra(int n, int[][] edges) {
		while (true) {
			int[] task = queue.poll();
			if (task == null) break;
			int thisNode = task[1];
			visits[thisNode - 1] = true;
			if (task[0] < map[thisNode][0]) {
				map[thisNode][0] = task[0];
			}
			for (int i = 1; i <= n; i++) {
				if (map[thisNode][i] == MAX_DISTANCE || map[thisNode][i] == 0 || visits[i - 1]) {
					continue;
				}
				queue.add(new int[]{map[thisNode][0] + 1, i});
			}
		}
	}

	private static void init(int size, int[][] edge) {
		map = new int[size + 1][size + 1];
		for (int i = 1; i <= size; i++) {
			for (int j = 0; j <= size; j++) {
				if (i == j) {
					map[i][j] = 0;
				}
				map[i][j] = MAX_DISTANCE;
			}
		}
		visits = new boolean[size];
		for (int i = 0; i < edge.length; i++) {
			map[edge[i][0]][edge[i][1]] = 1;
			map[edge[i][1]][edge[i][0]] = 1;
		}
	}
}
