package day0906;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main15654 {
	static int [] arr ;
	static boolean [] visit;
	static int N, M;
	static LinkedList<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		N = sc.nextInt();			//입력받을 자연수
		M = sc.nextInt();			//길이
		
		arr = new int[N];
		visit = new boolean[N];
		list = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			arr[i]= sc.nextInt();
		}
		Arrays.sort(arr);
		perm(0,0);
	}
	static void perm(int cnt,int k) {
		if(cnt == M) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
		
		for (int i = k; i < arr.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				list.add(arr[i]);
				perm(cnt+1,i);
				visit[i]= false;
				list.remove(list.size()-1);
			}
		}
	}
}
