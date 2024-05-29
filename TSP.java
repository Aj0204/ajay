package wiprotraining;

public class TSP {

	    public static int FindMinCost(int[][] graph) {
	        int n = graph.length;
	        int N = 1 << n;  // 2^n, total number of subsets
	        int[][] dp = new int[N][n];

	        // Initialize dp array with infinity
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < n; j++) {
	                dp[i][j] = Integer.MAX_VALUE;
	            }
	        }

	        // Starting point, only city 0 is visited
	        dp[1][0] = 0;

	        // Iterate over all subsets of nodes
	        for (int mask = 1; mask < N; mask++) {
	            for (int i = 0; i < n; i++) {
	                // If i is in the subset represented by mask
	                if ((mask & (1 << i)) != 0) {
	                    for (int j = 0; j < n; j++) {
	                        // If j is not in the subset and there's a path from i to j
	                        if ((mask & (1 << j)) == 0 && graph[i][j] != 0) {
	                            int nextMask = mask | (1 << j);
	                            dp[nextMask][j] = Math.min(dp[nextMask][j], dp[mask][i] + graph[i][j]);
	                        }
	                    }
	                }
	            }
	        }

	        // Find the minimum cost to return to the starting city
	        int result = Integer.MAX_VALUE;
	        for (int i = 1; i < n; i++) {
	            if (graph[i][0] != 0) {
	                result = Math.min(result, dp[(1 << n) - 1][i] + graph[i][0]);
	            }
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        int[][] graph = {
	            { 0, 10, 15, 20 },
	            { 10, 0, 35, 25 },
	            { 15, 35, 0, 30 },
	            { 20, 25, 30, 0 }
	        };

	        int result = FindMinCost(graph);
	        System.out.println("The minimum cost to visit all cities and return to the starting city is: " + result);
	    }
	}
