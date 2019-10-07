package day0816.proj;

import java.util.Arrays;

//순열 만들기
public class Permutation {
	static int[] arr = {1,2,3,4};
	
	public static void main(String[] args) {
		perm(0);
	}
	
	static void perm(int k) {
		if(k== arr.length) {
			System.out.println(Arrays.toString(arr));
			return ;
		}
		for (int i = k; i < arr.length; i++) {
			swap(i,k);
			perm(k+1);
			swap(i,k);							//백트래킹
		}
	}
	
	static void swap(int i ,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
