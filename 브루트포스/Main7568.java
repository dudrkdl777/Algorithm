package day1008;

import java.util.LinkedList;
import java.util.Scanner;

//백준 덩치 , 브루트포스 
public class Main7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		LinkedList<Person> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			list.add(new Person(sc.nextInt(), sc.nextInt()));
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(list.get(i).height < list.get(j).height &&
						list.get(i).weight < list.get(j).weight) {
					list.get(i).rank++;
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).rank + " ");
		}
	}

	static class Person {
		int weight;
		int height;
		int rank = 1;

		public Person(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}

		public Person(int weight, int height, int rank) {
			super();
			this.weight = weight;
			this.height = height;
			this.rank = rank;
		}

	}
}
