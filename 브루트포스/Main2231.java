package day1008;

import java.util.Scanner;

//백준 분해합 , 브루트포스 , 완탐
public class Main2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		
		for (long i = 1; i < N; i++) {
			long M = 0;
			String str = "";
			str += i; 		
			char [] tmp = str.toCharArray();
			M += i +0L;
			for (int j = 0; j < tmp.length; j++) {
				M+= tmp[j]-'0' +0L;
				if(M > N) break;
			}
			if(M == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
