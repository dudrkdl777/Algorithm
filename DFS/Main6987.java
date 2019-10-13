package day1010.review;

import java.io.BufferedReader;
import java.util.Scanner;

//DFS,브루트포스,백준 월드컵
public class Main6987 {
	// 총게임은 15번 일어나고 대결하는 국가의 인덱스를 2차원배열에 넣어놓았다.
	static int[][] game = { { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 },
			{ 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 } };
	static int[][] input; // 입력으로 들어오는 점수표. 가능한 점수표인지 계산해 볼 예쩡
	static int[][] make; // 내가 위 의 15번의 경기마다 승무패를 기록해보면서 input이 만들어지나 볼거다.
	static boolean ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[6][3];
		make = new int[6][3];

		for (int tc = 0; tc < 4; tc++) {

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					input[i][j] = sc.nextInt();
				}
			}

			ans = false;
			dfs(0); // 0번 게임부터 14번 게임까지 (총 15게임)모든 경우의 경기결과를 만든다.(완전히 만드는건 아니고 검사!)
			
			if(ans) {
				System.out.print("1 ");
			}else {
				System.out.print("0 ");
			}
		}
		System.out.println();
	}

	static void dfs(int gameNum) {
		if(gameNum >14) {		
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if(input[i][j] != make[i][j])
						return;
				}
			}
			//다 똑같으면 입력점수표는 가능한 점수표다.
			ans = true;
			return;
		}
		
		int team1 = game[0][gameNum];
		int team2 = game[1][gameNum];
		
		//team1이 이기는 경우를 기록해보자.
		//team1의 승리카운트 team2의 패배카운트가 원래의 input값을 넘어서지 않으면 
		if(make[team1][0]+1 <= input[team1][0] && make[team2][2]+1 <= input[team2][2]) {
			make[team1][0]++;		//승카운트
			make[team2][2]++;		//패카운트
			dfs(gameNum+1);			//다음경기에대한 경우의 수는 다음재귀한테 보내기
			make[team1][0]--;		//백트래킹(지거나 무승부의 경우에도 확인하기위해서)
			make[team2][2]--;		
		}
		
		if(make[team1][2]+1 <= input[team1][2] && make[team2][0]+1 <= input[team2][0]) {
			make[team1][2]++;
			make[team2][0]++;
			dfs(gameNum+1);			//다음경기에대한 경우의 수는 다음재귀한테 보내기
			make[team1][2]--;		//백트래킹(지거나 무승부의 경우에도 확인하기위해서)
			make[team2][0]--;		
		}
		
		if(make[team1][1]+1 <= input[team1][1] && make[team2][1]+1 <= input[team2][1]) {
			make[team1][1]++;
			make[team2][1]++;
			dfs(gameNum+1);			//다음경기에대한 경우의 수는 다음재귀한테 보내기
			make[team1][1]--;		//백트래킹(지거나 무승부의 경우에도 확인하기위해서)
			make[team2][1]--;			
		}
		
	}
}
