package day1010.ws;

import java.util.Scanner;

//dfs,재귀,expert키순서
public class Solution5643 {
	static int N, M;
	static int[][] arr;
	static boolean [] visited;
	static int except;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		for (int tc = 1; tc <= Tc; tc++) {

			N = sc.nextInt();
			M = sc.nextInt();
			
			arr = new int[N+1][N+1]; // i보다 j가 더 큰놈
			
			int ans = 0;
			for (int i = 0; i < M; i++) {
				int tmpi = sc.nextInt();
				int tmpj = sc.nextInt();

				arr[tmpi][tmpj] = 1;

			}
			for (int j = 1; j <= N; j++) {
				visited = new boolean[N+1];
				except = 0;
				dfs(j);			//나보다 큰 사람과 나보다 작은사람을 찾는다
				dfs2(j);		//나보다 작은사람을 찾는다.
				if(except == (N-1)) {		//나보다 큰애들과 작은애들의 합이 확실하게 나보다 1 작다면 내키가 몇번째인지 안다는 것이다.
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}//tc end
	}
	
	static void dfs(int person) {			//기준이 되는 숫자
		visited[person] = true;
		for (int i = 1; i <= N; i++) {
			if(arr[person][i] == 1 && !visited[i]) {
				except++;
				dfs(i);
			}
		}
		return;
	}
	static void dfs2(int person) {			//기준이 되는 숫자
		visited[person] = true;
		for (int i = 1; i <= N; i++) {
			if(arr[i][person] == 1 && !visited[i]) {
				except++;
				dfs2(i);
			}
		}
		return;
	}

}
