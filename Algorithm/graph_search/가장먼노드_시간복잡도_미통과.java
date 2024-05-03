import java.util.*;

public class 가장먼노드_시간복잡도_미통과 {

	static ArrayList<Integer> visitList = new ArrayList<>();
	static HashMap<Integer, PointEdge> pointMap = new HashMap<>();
	static Queue<PointEdge> queue = new ArrayDeque<>();
	static int destination = 2;
	static int maxDistance = 0;
	static int answer = 0;

	public static void main(String[] args) {
		int solution = solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
		System.out.println("solution = " + solution);
	}

	public static int solution(int n, int[][] edge) {
		createMap(edge);
		while (destination <= n) {
			PointEdge pointEdge = pointMap.get(1);
			visitList.add(1);
			pointEdge.start();
			while (true) {
				PointEdge poll = queue.poll();
				if (poll == null) {
					break;
				}
				poll.start();
			}
		}
		return answer;
	}

	private static void createMap(int[][] edge) {
		for (int i = 0; i < edge.length; i++) {
			PointEdge firstPointEdge = pointMap.get(edge[i][0]);
			if (firstPointEdge == null) {
				firstPointEdge = new PointEdge(edge[i][0]);
				pointMap.put(edge[i][0], firstPointEdge);
			}
			PointEdge secondPointEdge = pointMap.get(edge[i][1]);
			if (secondPointEdge == null) {
				secondPointEdge = new PointEdge(edge[i][1]);
				pointMap.put(edge[i][1], secondPointEdge);
			}
			firstPointEdge.add(secondPointEdge.point);
			secondPointEdge.add(firstPointEdge.point);
		}
	}

	static void init() {
		visitList.forEach(f-> pointMap.get(f).initDistance());
		queue.clear();
		visitList.clear();
		destination++;
	}

	static class PointEdge {
		int point;
		List<Integer> linkList = new ArrayList<>();
		int distance = 0;

		PointEdge(int point) {
			this.point = point;
		}

		void add(int linkPoint) {
			linkList.add(linkPoint);
		}

		void initDistance() {
			distance = 0;
		}
		void start() {
			distance++;
			for (int i = 0; i < linkList.size(); i++) {
				PointEdge nextPoint = pointMap.get(linkList.get(i));
				if (visitList.contains(nextPoint.point)) {
					continue;
				}
				if (nextPoint.point == destination) {
					if (maxDistance < distance) {
						maxDistance = distance;
						answer = 1;
					} else if (maxDistance == distance) {
						maxDistance = distance;
						answer++;
					}
					init();
					break;
				}
				nextPoint.distance = distance;
				visitList.add(nextPoint.point);
				queue.add(nextPoint);
			}
		}
	}
}
