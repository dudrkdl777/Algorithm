package day1013.ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//SWEA 나는 개구리로소이다
public class Solution5550 {
	static char[] croak = {'c','r','o','a','k'};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int Tc = Integer.parseInt(br.readLine()); 
		for (int tc = 1; tc <= Tc; tc++) {
			char [] input = br.readLine().toCharArray();
			boolean [] visit = new boolean[input.length];
			int ans = 0;
			for (int i = 0; i < input.length; i++) {
				if(allVisit(visit)) {		//전체 다 방문했다면
					break;
				}else if(check(input,visit,i)) {
					ans++;
				}else {
					ans = -1;
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}//tc
	}
	static boolean check(char [] input, boolean [] visit,int now) {
		int idx = 0;		//0~4
		boolean isRun = false;
		
		for (int i = now; i < input.length ; i++) {
			if(input[i] == croak[idx] && !visit[i]) {
				idx++;
				idx %= 5;
				visit[i]= true;
				isRun = true;
			}
		}
		
		if(idx!= 0 || isRun == false)
			return false;
		
		return true;
	}
	static boolean allVisit(boolean [] visit) {
		for (int i = 0; i < visit.length; i++) {
			if(!visit[i]) {
				return false;
			}
		}
		return true;
	}
}
