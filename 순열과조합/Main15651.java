package day0906;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

//N과 M (3) , permutation, 조합
//1부터 N까지 자연수 중에서 M개를 고른 수열
//같은 수를 여러 번 골라도 된다.
public class Main15651 {
	static int[] arr;
	static boolean[] visited;
	static int N, M;
	static ArrayList<Integer> list = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		
		arr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i]= sc.nextInt();
		}
		sc.close();
		perm(0, 0);
		bw.flush();
	}

	static int tmp = 0;

	static void perm(int cnt, int k) throws IOException {
		if (cnt == M) {
			visited[k] = true;
			// 출력하기
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i)+" ");
			}
			bw.newLine();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				list.add(arr[i]);
				perm(cnt + 1, i);
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
}