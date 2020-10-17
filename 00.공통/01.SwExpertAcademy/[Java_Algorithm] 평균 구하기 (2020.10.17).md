# [Java_Algorithm] 평균 구하기 (2020.10.17)

## 😎문제

**SwExpertAcademy > (D1)2071.중간값구하기**

> 10개의 정수를 입력받아 중간값(평균) 구하기

- 소수점 일의자리에서 반올림

## 💡알고리즘

입력받은 숫자를 더해서, 입력받은 길이만큼 나누고 반올림해주기.

## 🔑코드

```java
/**
 * @author gayeongLee
 * @date 2020. 10. 17.
 * @projectNm SwExpert
 */
package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SEA 2071.중간값 구하기
public class Code01_medium {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int Tc = Integer.parseInt(br.readLine()); // 테스트케이스 입력

		for (int tc = 1; tc <= Tc; tc++) {
			int[] arr = new int[10]; // 한 테스트케이스에서 가지는 숫자의 개수는 10개
			String line = br.readLine(); // 라인입력받음
			StringTokenizer st = new StringTokenizer(line, " "); // 공백단위로 값을 끊기위함

			// arr 안에 입력값 저장
			float num = 0; 

			for (int k = 0; st.hasMoreTokens(); k++) {
				num += Integer.parseInt(st.nextToken());
			}

			int result = Math.round(num / 10);

			System.out.println("#" + tc + " " + result);
		}
	}
}

```

## 📝리뷰

매우X10 간단한 문제였으나 입출력 하는 부분에서부터 막혀버렸다.🤣

var로 퉁쳐버리는 자바스크립트에 익숙해지는 바람에 int , float 등 변수 타입 선언이 너무너무 낯설었다.

- BufferedReader 사용법

- Math 함수

- 변수 타입 선언 및 개념