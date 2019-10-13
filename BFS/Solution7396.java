package day1013.ja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//SWEA 종구의 딸이름짓기, Comparable, PriorityQueue
public class Solution7396 {
	static char[][] map;
	static boolean[][] visited;
	static int N, M;
	static int[] di = { 0, 1 }; // 아래 ,오른쪽만 본다.
	static int[] dj = { 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int Tc = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Tc; tc++) {
			String[] line = br.readLine().trim().split(" ");
			N = Integer.parseInt(line[0]);
			M = Integer.parseInt(line[1]);

			map = new char[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					map[i][j] = tmp[j];
				}
			}
			// bfs탐색을 위한 pq1
			PriorityQueue<Pointer> pq1 = new PriorityQueue<>();
			PriorityQueue<Pointer> pq2 = new PriorityQueue<>();

			pq1.add(new Pointer(0, 0, map[0][0])); // 시작점 저장
			visited[0][0] = true;

			bw.write("#" + tc + " ");
			while (!pq1.isEmpty()) {
				int chance = pq1.size();
				Pointer min = pq1.peek(); // pq1에 있는 글자중에 앞쪽에 위치한 글자 하나를 꺼낸다.
				for (int i = 0; i < chance; i++) {
					Pointer now = pq1.poll(); // 맨처음의 경우에는 무조건 오른,아래를 확인할거고 그 이후부터는 글자가 같을때만 확인할거다.
					if (min.ch == now.ch) { // pq에서 제일 빠른 알파벳 객체를 대상으로 하나씩 확인할건데 글자가 같으면 한칸씩 더 가보고
						for (int k = 0; k < 2; k++) {
							int nexti = now.i + di[k];
							int nextj = now.j + dj[k];
							if (nexti >= 0 && nextj >= 0 && nexti < N && nextj < M && !visited[nexti][nextj]) {
								pq2.add(new Pointer(nexti, nextj, map[nexti][nextj])); // 한칸씩 더본놈들을 임시 pq2에 저장한다.
//								System.out.println(pq2);
								visited[nexti][nextj] = true;
							}
						}
					} else
						break; // 글자가 다르면 볼필요없이 그냥 pq 맨 앞에놈만 쓰면 되니까 더이상 확인하지않는다
				}
				pq1.clear();
				pq1.addAll(pq2); // 다음놈들중에 빠른애들 보기위해서 pq2에 임시로 저장해논것을 pq1에 옮겨쓴다.
				pq2.clear();
				bw.write(min.ch); // 중복이든 아니든 어짜피 이번 턴에서 젤 빠른숫자출력할꺼고
			} // BFS end
			bw.write("\n");
		} // tc end
		br.close();
		bw.flush();
		bw.close();
	}

	static class Pointer implements Comparable<Pointer> {
		int i, j;
		char ch;

		Pointer(int i, int j, char ch) {
			this.i = i;
			this.j = j;
			this.ch = ch;
		}

		@Override
		public String toString() {
			return "Pointer [i=" + i + ", j=" + j + ", ch=" + ch + "]";
		}

		@Override
		public int compareTo(Pointer o) {
			// TODO Auto-generated method stub
			return this.ch - o.ch;
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
