class Solution {
    static class Node{
        int point,cost;
        Node(int point, int cost){
            this.point = point;
            this.cost = cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        boolean[] visited = new boolean[n];
        pq.offer(new Node(0,0));
        int totalCost = 0;
        int pointsConnected = 0;
        while(!pq.isEmpty() && pointsConnected<n){
            Node current = pq.poll();
            int u = current.point;
            int cost = current.cost;
            if(visited[u]){
                continue;
            }
            visited[u] = true;
            totalCost+=cost;
            pointsConnected++;
            for(int v=0;v<n;v++){
                if(!visited[v]){
                    int dis = Math.abs(points[u][0]-points[v][0])+Math.abs(points[u][1]-points[v][1]);
                    pq.offer(new Node(v,dis));
                }
            }
        }
        return totalCost;
    }
}