package homework.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import homework.bookhierachy.Book;
import homework.tax.Taxable;

public class BookStore {
	private final List<Book> stock = new ArrayList<>();
	private final List<Taxable> staff = new ArrayList<>();
	
	public void addToStock(Book book) {
		stock.add(book);
	}
	
	public void addToStaff(Taxable employee) {
		staff.add(employee);
	}
	
	public int listStock() {
		int count = 0;
		for(Book book : stock) {
			System.out.println(book);
			count++;
		}
		return count;
	}
	
	public int listStaff() {
		int count = 0;
		for(Taxable employee : staff) {
			System.out.println(employee);
			count++;
		}
		return count;
	}
	
	public int sumVAT() {
		int sum = 0;
		
		for(Book book :stock) {
			sum += book.getTax();
		}
		
		return sum;
	}
	
	public int sumIncomTax() {
		int sum = 0;
		
		for(Taxable employee :staff) {
			sum += employee.getTax();
		}
		
		return sum;
	}
	
	
	public void sortByTitle() {
		Collections.sort(stock, Comparator.comparing(Book::getTitle));
	}
	
	public void reverseSortByPrice() {
		Collections.sort(stock, Comparator.comparing(Book::getPrice).reversed());
	}
	
	public List<Book> getStock() {
		return stock;
	}
	public List<Taxable> getStaff() {
		return staff;
	}
}