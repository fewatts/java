package aula_3;

import java.util.Scanner;

public class LoopsJava {
	
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		int x = 0;
		boolean ok = false;
		String ok_ = "";
		do {
			
			System.out.println("Digite um número para obter a tabuada: \n<<<:  ");
			x = leia.nextInt();
			
			if(x > 10 || x < 1) 
				System.out.println("De zero a dez apenas...");
			else {
				for(int i = 1; i < 11; i++) {
					System.out.printf("%d x %d = %d\n", i, x, i * x);
				}
				
				System.out.println("Deseja continuar? [S/N] ");
				leia.skip("\\R?");
				ok_ = leia.nextLine();
				
				if(ok_.equalsIgnoreCase("N")) 
					ok = true;
			      }
			
		    }while(ok == false);
     }

}
