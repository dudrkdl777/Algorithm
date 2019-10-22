package day1021.proj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//스타트와 링크 ,조합,완탐 
public class Main1021 {
	static int N;
	static int [][] arr;
	static LinkedList<Integer> list;
	static boolean [] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 
		 arr = new int[N][N];
		 visited = new boolean[N];
		 list = new LinkedList<>();
		 
		 for (int i = 0; i < N; i++) {
			 String[] str = br.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		 }
		 min = Integer.MAX_VALUE;
		 perm(0,N/2,0);
		 System.out.println(min);
	}
	static int min;
	static void perm(int cnt, int target,int k) {
		if(cnt == target) {		//조합할 숫자의 갯수가 2/N이 되면 이제 출력하자
			int power = findpower();
			if(power<min) {
				min = power;
			}
		}
		for (int i = k; i < N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				list.add(i);
				perm(cnt+1,target,i);
				visited[i]=false;
				list.remove(list.size()-1);
			}
		}
	}
	static int findpower() {
		int startsum=0;
		int linksum=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i] && visited[j]) {
					startsum += arr[i][j]; 
				}else if(!visited[i] && !visited[j]) {
					linksum += arr[i][j];
				}
			}
		}
		return Math.abs(startsum-linksum);
	}
}
