package day1010.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs,대각선 포함, 백준 섬의 개수
public class Main4963 {
	static int W,H,landCnt;
	static int [][] map;
	static boolean[][] visited;
	static Queue<Pointer> queue;
	static int [] di = {0,1,1,1,0,-1,-1,-1};
	static int [] dj = {1,1,0,-1,-1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String [] tmp = br.readLine().split(" ");
			H = Integer.parseInt(tmp[0]);
			W = Integer.parseInt(tmp[1]);
			if(W == 0 && H == 0) {
				break;
			}
//			System.out.println(W+" "+H);
			map = new int[W][H];
			queue = new LinkedList<>();
			visited = new boolean[W][H];
			
			for (int i = 0; i < W; i++) {
//				String [] line = br.readLine().split(" ");
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; st.hasMoreTokens(); j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]== 0) {
						visited[i][j] = true;
					}
				}
			}
//			print();
			landCnt = 0;
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < H; j++) {
					if(!visited[i][j]) {
						//일단 큐에 넣고
						queue.add(new Pointer(i, j));
						while(!queue.isEmpty()) {
							Pointer p = queue.poll();
							map[p.i][p.j] = 0;			//현재 방문한곳은 다시 방문하지않도록 0으로 바꾸고
//							print();
							for (int k = 0; k < 8; k++) {
								int nexti = p.i + di[k];
								int nextj = p.j + dj[k];
								
								if(nexti>=0 && nextj >=0 && nexti <W && nextj <H) {
									if(map[nexti][nextj] == 1 && !visited[nexti][nextj] ) {
										queue.add(new Pointer(nexti, nextj));
										//반드시!!!!!!!!!!!!!!!!!!!!!!!!!!!! 여기서 방문처리 해줄것!!안그럼 터진다!
										visited[nexti][nextj] = true;
									}
								}
							}//8방검색이 다 끝나면 더이상 갈 수 있는 땅이없으므로 섬 갯수 증가해주고 끝낸다. 
						}//큐 while
						landCnt++;
					}
				} 
			}
//			System.out.print("섬의갯수는: ");
			System.out.println(landCnt);
//			System.out.println("=================");
		}//Tc종료
	}
	static void print() {
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------");
	}
	static class Pointer{
		int i ;
		int j ;
		public Pointer(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
}
