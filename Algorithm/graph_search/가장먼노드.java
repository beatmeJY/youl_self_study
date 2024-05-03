import java.util.*;

public class 가장먼노드 {

	static int[][] map;

	static Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
	static boolean[] visits;

	public static void main(String[] args) {
		int solution = solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
		System.out.println("solution = " + solution);
	}

	public static int solution(int n, int[][] edge) {
		int answer = 0;
		init(n, edge);
		int[] firstPoint = map[0];
		int[] startPoint = new int[firstPoint.size() + 1];
		startPoint[0] = 0;
		for (int i = 1; i <= firstPoint.size(); i++) {
			startPoint[i] = firstPoint.get(i);
		}
		queue.add(startPoint);
		while (true) {
			int[] next = queue.poll();
			if (next == null) {
				break;
			}
			dijkstra(next);
		}
		return answer;
	}

	private static void dijkstra(int[] edges) {

	}

	private static void init(int size, int[][] edge) {
		visits = new boolean[size];
		for (int i = 0; i < edge.length; i++) {
			map[edge[i][0]][edge[i][1]] = ;
			map[edge[i][1]][edge[i][0]] = ;
		}
	}



}
