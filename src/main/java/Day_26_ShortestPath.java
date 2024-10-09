import java.util.*;

public class Day_26_ShortestPath
{
    public static int bfsShortestPath(List<List<Integer>> adjList, int start, int end)
    {
        if (start == end)
        {
            return 0;
        }
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int level = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++)
            {
                int current = queue.poll();
                for (int neighbor : adjList.get(current))
                {
                    if (neighbor == end)
                    {
                        return level;
                    }
                    if (!visited[neighbor])
                    {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++)
        {
            adjList.add(new ArrayList<>());
        }
        System.out.println("Enter number of edges:");
        int E = sc.nextInt();
        System.out.println("Enter the edges (pair of vertices for each edge):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println("Enter start and end vertices:");
        int start = sc.nextInt();
        int end = sc.nextInt();
        int result = bfsShortestPath(adjList, start, end);
        if (result != -1)
        {
            System.out.println("Shortest path length: " + result);
        } else {
            System.out.println("No path exists between " + start + " and " + end);
        }
        sc.close();
    }
}