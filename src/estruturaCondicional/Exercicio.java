package estruturaCondicional;

import java.util.Scanner;

public class Exercicio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		if(x % 2 == 0)
			System.out.println("x é par: "+x);
		else
			System.out.println("x é impar: "+x);
		sc.close();
	}
}
