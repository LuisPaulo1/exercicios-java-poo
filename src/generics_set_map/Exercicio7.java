package generics_set_map;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercicio7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Set<Integer> students = new HashSet<>();		
		
		System.out.print("How many students for course A? ");		
		Integer A = sc.nextInt();		
		for (int i = 0; i < A; i++) {
			students.add(sc.nextInt());
		}
		
		System.out.print("How many students for course B? ");		
		Integer B = sc.nextInt();		
		for (int i = 0; i < B; i++) {
			students.add(sc.nextInt());
		}
		
		System.out.print("How many students for course C? ");		
		Integer C = sc.nextInt();		
		for (int i = 0; i < C; i++) {
			students.add(sc.nextInt());
		}
		System.out.print("Total students: "+students.size());		
		sc.close();		
	}

}
