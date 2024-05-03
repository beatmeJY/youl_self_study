import java.util.*;

public class 가장먼노드 {

    public int solution(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distances[neighbor] = distances[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        Arrays.sort(distances);
        int maxDistance = 0;
        int count = 0;
        for (int i = distances.length - 1; i >= 0; i--) {
            if (maxDistance == 0) {
                maxDistance = distances[i];
            }
            if (maxDistance != distances[i]) {
                break;
            }
            count++;
        }
        return count;
    }
}
