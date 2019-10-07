package day0816.proj;

import java.util.LinkedList;
import java.util.List;

//순열 만들기2
public class Permutation2 {
	static String[] arr = {"1","2","3","4"};
	static boolean[] used = new boolean[arr.length];
	static List<String>	result = new LinkedList<>();
	
	static int total = 0;
	public static void main(String[] args) {
		perm(0,4);
		System.out.println(total);
	}
	static void perm(int cnt , int r) {			//cnt 현재 뽑은 갯수,r 총 뽑아야하는 카드 수
		if(cnt == r) {
			total++;
			System.out.println(result);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!used[i]) {						//i번이 (사용가능상태라면)
				result.add(arr[i]);				//result에 추가한다.			//i번 카드를 내가 사용할게
				used[i] = true;
				perm(cnt+1,r);					//다음재귀한테 다음거 뽑아봐~햇다.
				used[i] = false;
				result.remove(arr[i]);
			}
		}
	}
}
