package dfs_bfs;

import java.util.*;

public class 게임_맵_최단거리 {
	static int[][] map;
	static int answer = -1;
	static int maxMapX = 0;
	static int maxMapY = 0;
	static Queue<Point> queue = new LinkedList<Point>();

	public static void main(String[] args) {
//		int result = solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}); //예상 값 : 11
		int result = solution(new int[][]{{1, 1}, {1, 1}, {1, 1}});
		System.out.println("result = " + result);
	}

	public static int solution(int[][] maps) {
		init(maps);
		dfs(new Point(0, 0, 0));
		while (true) {
			Point poll = queue.poll();
			if (poll == null) break;
			dfs(poll);
		}
		return answer;
	}

	static void init(int[][] maps) {
		map = maps;
		maxMapX = maps.length;
		maxMapY = maps[0].length;
	}

	static void dfs(Point point) {
		if (point.x < 0 || point.x >= maxMapX || point.y < 0 || point.y >= maxMapY || map[point.x][point.y] == 0) {
			return;
		}
		point.walk++;
		map[point.x][point.y] = 0;
		if (point.x == maxMapX - 1 && point.y == maxMapY - 1) {
			answer = point.walk;
			return;
		}
		queue.add(new Point(point.walk, point.x, point.y + 1)); // 오른쪽
		queue.add(new Point(point.walk, point.x, point.y - 1)); // 왼쪽
		queue.add(new Point(point.walk, point.x + 1, point.y)); // 아래
		queue.add(new Point(point.walk, point.x - 1, point.y)); // 위
	}

	static class Point {
		int walk;
		int x;
		int y;

		public Point(int count, int x, int y) {
			this.walk = count;
			this.x = x;
			this.y = y;
		}
	}
}
