package labs;

import java.util.HashSet;

public class CheckBlock {

	private int[][] graph = {
			{0, 0, 0, 1},
			{1, 0, 1, 0},
			{0, 1, 0, 1},
			{1, 0, 1, 0}
	};
	
	private int size = 4;
	
	private boolean[][] visit = new boolean[size][size];
	
	private HashSet<Integer> list = new HashSet<Integer>();
	
	public CheckBlock() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				visit[i][j] = false;
			}
		}
	}
	
	public boolean isBlock() {
		return dfs(0);
	}
	
	public boolean dfs(int n) {
		
		if (list.contains(n))
			return false;
		else list.add(n);
		
		for (int i = 0; i < graph[n].length; i++) {
			if (n != i && !visit[n][i] && graph[n][i] == 1) {
				visit[n][i] = true;
				visit[i][n] = true;
				if (!dfs(i)) {
					return false;
				}
			}
		}
		
		
		return true;
	}
}
