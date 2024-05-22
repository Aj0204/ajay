package wiprotraining;
public class UnionFind {
	  private int[] parents;
	  private int[] rank;

	  public UnionFind(int n) {
	    parents = new int[n];
	    rank = new int[n];
	    for (int i = 0; i < n; i++) {
	      parents[i] = i;
	    }
	  }
	  public int find(int x) {
	    if (x != parents[x]) {
	      parents[x] = find(parents[x]);
	    }
	    return parents[x];
	  }

	  public boolean union(int x, int y) {
	    int rootX = find(x);
	    int rootY = find(y);
	    if (rootX == rootY) {
	      return false;
	    }
	    if (rank[rootX] < rank[rootY]) {
	      parents[rootX] = rootY;
	    } else if (rank[rootX] > rank[rootY]) {
	      parents[rootY] = rootX;
	    } else {
	      parents[rootY] = rootX;
	      rank[rootX]++;
	    }
	    return true;
	  }
	
	  public static boolean hasCycle(int[][] edges) {
	    int n = edges.length;
	    UnionFind uf = new UnionFind(n);

	    for (int[] edge : edges) {
	      int u = edge[0];
	      int v = edge[1];
	      if (!uf.union(u, v)) {
	        return true;
	      }
	    }
	    return false;
	  }

	  public static void main(String[] args) {
	    int[][] edges = {{0, 1}, {1, 2}, {2, 0}};

	    if (hasCycle(edges)) {
	      System.out.println("Graph contains a cycle");
	    } else {
	      System.out.println("Graph does not contain a cycle");
	    }
	  }
	}
