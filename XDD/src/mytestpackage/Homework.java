package mytestpackage;

import java.util.Scanner;

import homework.Book;

public class Homework {
	
	public static void main(String[] args)  {
		int n = 0;

		n = readInt();
		
		Book[] konyvek = new Book[n];
	
		System.out.println("A k�nyvek sz�ma: " + n);
		
		for(int i = 0; i < konyvek.length; i++)
		{		 
			Scanner scan = new Scanner(System .in);

			System.out.println("Adja meg az" + (i+1) + ".k�nyv szerz�j�t: ");
			String szerzo = scan.nextLine();
			System.out.println("Adja meg az" + (i+1) + ".k�nyv c�m�t: ");
			String cim = scan.nextLine();
			System.out.println("Adja meg az" + (i+1) + ".k�nyv �r�t: ");
			int ar = scan.nextInt();
			System.out.println("Adja meg az" + (i+1) + ".k�nyv oldal�nak sz�m�t: ");
			int oldalak = scan.nextInt();
			
			konyvek[i] = new Book(szerzo, cim, ar, oldalak, cim);
			if(i == n - 1)
				scan.close();
		}

		
		
	}
	
	private static int readInt() {
		int n = 0;
		do {
			Scanner be = new Scanner(System.in);
			System.out.println("Adja meg a k�nyvek sz�m�t");
			try {
			n = be.nextInt();
			}
			catch(Exception e){
				continue;
			}
			
			if(n < 1 || n > 10)
				be.close();
			
		}while(n < 1 || n > 10);
		
		return n;
	}
	
}