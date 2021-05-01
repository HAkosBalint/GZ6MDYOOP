package runnable;

import homework.bookhierachy.Book;
import homework.shop.BookStore;

public class StoreTest {

	public static void main(String[] args) {
		BookStore bookStore = new BookStore();
		
		Book book1 = new Book("Romy Hausmann", "Drága Gyerek", 3600, 400, "CHILDREN");
		Book book2 = new Book("Alan Moore", "V mint vérbosszú", 2500, 150, "OTHER");
		Book book3 = new Book("Suzanne Collins", "Hunger Games", 3000, 700, "OTHER");
		
		bookStore.addToStock(book1);
		bookStore.addToStock(book2);
		bookStore.addToStock(book3);
		
		System.out.println("Stock: ");
		bookStore.listStock();
		
		System.out.println("\nStock, sorted by title: ");
		bookStore.sortByTitle();
		bookStore.listStock();
		
		System.out.println("\nStock, sorted by price (decreasing): ");
		bookStore.reverseSortByPrice();
		bookStore.listStock();
		
		System.out.printf("\nTotal VAT: %d%n", bookStore.sumVAT());
		System.out.printf("Total income tax: %d%n", bookStore.sumIncomTax());
	}
}
