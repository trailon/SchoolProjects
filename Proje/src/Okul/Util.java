package Okul;

import java.util.ArrayDeque;
import java.util.Queue;

public class Util {
	protected Util() {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 14; j++) {
				Ekran.mat[i][j] = Integer.parseInt(Ekran.harita[i][j]);
			}
		}
	}

	public static final int M = 11;
	public static final int N = 14;
	public static int path_length;
	public static final int row[] = { -1, 0, 0, 1 };
	public static final int col[] = { 0, -1, 1, 0 };

	public static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
		return (row >= 0) && (row < M) && (col >= 0) && (col < N) && mat[row][col] == 1 && !visited[row][col];
	}

	public static void BFS(int mat[][], int i, int j, int x, int y) {
		for (int t = 0; t < 11; t++) {
			for (int z = 0; z < 14; z++) {
				Ekran.mat[t][z] = Integer.parseInt(Ekran.harita[t][z]);
			}
		}
		boolean[][] visited = new boolean[M][N];
		Queue<Node> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.add(new Node(i, j, 0));

		int min_dist = Integer.MAX_VALUE;

		while (!q.isEmpty()) {

			Node node = q.poll();

			i = node.x;
			j = node.y;
			int dist = node.dist;

			if (i == x && j == y) {
				min_dist = dist;
				break;
			}

			for (int k = 0; k < 4; k++) {

				if (isValid(mat, visited, i + row[k], j + col[k])) {

					visited[i + row[k]][j + col[k]] = true;
					q.add(new Node(i + row[k], j + col[k], dist + 1));
				}
			}
		}

		if (min_dist != Integer.MAX_VALUE) {
			path_length = min_dist;
			System.out.println("Düþmandan Bize "+path_length+" Adým Kaldý");
		} else {

		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 14; j++) {
				Ekran.mat[i][j] = Integer.parseInt(Ekran.harita[i][j]);
			}
		}
	}

}
