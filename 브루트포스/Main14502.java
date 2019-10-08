package day1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 연구소, BFS, 완탐
public class Main14502 {
	static int N, M ;
	static int [][] arr ;
	static Queue<Pointer> queue;
	int sum = 0;
//	static boolean [][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] tmp = br.readLine().trim().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		
		arr = new int [N][M];
//		visited = new boolean[N][M];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String [] line = br.readLine().trim().split(" ");
			for (int j = 0; j < line.length; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
				if(arr[i][j] == 2) {
					queue.add(new Pointer(i, j));
				}
			}
		}
//		int virusNum = queue.size();			//바이러스 숫자.
		print();
		// 1.브루트 포스로 세울수있는 기둥 세가지를 모두 찾은다음에 
		//	1-1. 기둥을 세울수있는 영역은 x,y 좌표로 이루어져있고
		// 	1-2. 반드시 0으로만 이루어진 곳에 기둥을 세울수 있다.
		// 2.bfs를 돌려서 바이러스를 퍼뜨린다
		// 3.바이러스가 퍼지지않은 안전영역의 숫자를구한다.
		// 4.원래상태로 되돌린다. (3과 4는 동시에 진행할수 있겠다!)
		
		//1. 기둥박기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {  
					arr[i][j] = 1;
					for (int m = i; m < N; m++) {
						for (int k = j; k < M; k++) {
							if(arr[m][k] == 0) {
								arr[m][k] =1;
								for (int l = m; l < N; l++) {
									for (int o = k; o < M; o++) {
										if(arr[l][o] == 0) {
											arr[l][o] = 1;
											//2.바이러스 터뜨리기
											bfs();
											// 4.원래상태로 되돌리기
											arr[l][o] = 0;
										}
									}
								}
								arr[m][k] = 0;
							}
						}
					}
					arr[i][j]= 0;
				}
			}
		}
	}
	static void bfs() {
		//바이러스를 퍼뜨리고 안전영역 갯수세기
		
	}
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			} 
			System.out.println();
		}
	}
	static class Pointer{
		int i;
		int j;
		public Pointer(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
