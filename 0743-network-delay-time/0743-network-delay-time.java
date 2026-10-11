
import java.util.*;

class Solution {
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node {
        int router, time;

        Node(int router, int time) {
            this.router = router;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.get(u).add(new Edge(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a.time, b.time));

        dist[k] = 0;
        pq.offer(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int u = current.router;
            int time = current.time;

            if (time != dist[u]) {
                continue;
            }

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int newTime = time + edge.weight;

                if (newTime < dist[v]) {
                    dist[v] = newTime;
                    pq.offer(new Node(v, newTime));
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}
