package homework;
 
import java.time.Year;
 
import homework.product.Product;
 
public class Book extends Product{
	private String author;
	private String title;
	private final int yearOfPublication = Year.now().getValue();
	private int pages;
	private String style;
 
 
	public Book(String author, String title, int price, int pages, String style) {
		super("book", price);
		this.author = author;
		this.title = title;
		this.style = style;
 
		if(pages < 0) {
			this.pages = 0;
		} else {
			this.pages = pages;
		}
	}
 
 
	public Book(String author, String title, String style) {
		this(author, title, 2500, 100, style);
	}
 
 
	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", yearOfPublication=" + yearOfPublication + ", pages="
				+ pages + ", style=" + style + ", price=" + price + "]";
	}
 
	@Override
	public void decreasePrice(int percent) {
		if(style == "children") {
			this.decreasePriceMasodik(percent + 7);
		} else if (style == "guide") {
			this.decreasePriceMasodik(percent + 5);
		}
	}
 
 
	public String getAuthor() {
		return author;
	}
 
	public void setAuthor(String author) {
		this.author = author;
	}
 
	public String getTitle() {
		return title;
	}
 
	public void setTitle(String title) {
		this.title = title;
	}
 
	public int getYearOfPublication() {
		return yearOfPublication;
	}
 
	public int getPrice() {
		return price;
	}
 
	public void setPrice(int price) {
		if (price >= 1000)
			this.price = price;
		else
			this.price = 1000;
	}
 
	public int getPages() {
		return pages;
	}
 
	public void setPages(int pages) {
		if(pages < 0) {
		}else {
			this.pages = pages;
		}
	}
 
 
	public String getStyle() {
		return style;
	}
 
 
	public void setStyle(String style) {
		this.style = style;
	}
 
 
	public static int comparePublicationDate(Book book1, Book book2) {
		if(book1.getYearOfPublication() > book2.getYearOfPublication()) {
			return 1;
		} else if (book2.getYearOfPublication() > book1.getYearOfPublication()) {
			return 2;
		} else {
			return 0;
		}
	}
 
	public static Book getLonger(Book book1, Book book2) {
		if(book1.getPages() > book2.getPages()) {
			return book1;
		}else if (book1.getPages() < book2.getPages()) {
			return book2;
		}else {
			return book1;
		}
	}
 
	public Boolean hasEvenPages() {
		if(this.getPages() % 2 == 0) {
			return true;
		}else {
			return false;
		}
	}
 
	public static void listBookArray(Book book[]) {
		for (int i = 0; i < book.length; i++) {
			System.out.println("Az " +(i+1) + ". könyv adatai: " + book[i].toString());
		}
	}
 
	public static Book getLongestBook(Book book[]) {
		int whichbook = 0;
		int longestpages = book[0].getPages();
 
		for (int i = 1; i < book.length; i++) {
			if(book[i].getPages() > longestpages) {
				longestpages = book[i].getPages();
				whichbook = i;
			}
		}
 
		return book[whichbook];
	}
 
	public static Book getLongestEvenPagesBook(Book book[]) {
		Book maxBook = null;
 
		for (int i = 0; i < book.length; i++) {
			if(book[i].hasEvenPages()) {
				maxBook = book[i];
				break;
			}
		}
 
 
		for (int i = 0; i < book.length; i++) {
			if(book[i].hasEvenPages() && book[i].getPages() > maxBook.getPages()) {
				maxBook = book[i];
			}
		}
 
		return maxBook;
	}
 
	public static int countStyles(Book[] books) {
		int stilus[] = new int[books.length];
		int szamolas = 0;
 
		for (int i = 0; i < books.length; i++) {
			String tempstyle = books[i].getStyle();
			if(stilus[i] == 0) {
				szamolas++;
				stilus[i]++;
 
				for(int j = i + 1; j < books.length; j++) {
					if(tempstyle.equalsIgnoreCase(books[j].getStyle())){
						stilus[j] = -1;
					}
				}
			}
		}
		return szamolas;
 
	}
 
	public static void discountBooks(Book[] books, String style) {
		for (int i = 0; i < books.length; i++) {
			if(books[i].getStyle() == style) {
				books[i].price = (int) Math.round(books[i].price * 0.90);
			}
		}
	}
 
	public static int listBooksWithStyle(Book[] books, String style) {
		int szamolas = 0;
 
		for (int i = 0; i < books.length; i++) {
			if(books[i].getStyle() == style) {
				szamolas++;
				System.out.println(books[i]);
			}
		}
 
		return szamolas;
	}
 
	public static int avgPrice(Book[] books, String style) {
		int osszead = 0;
		int szamolas = 0;
 
 
		for (int i = 0; i < books.length; i++) {
			if(books[i].getStyle() == style) {
				osszead += books[i].getPrice();
				szamolas++;
			}
		}
 
		if(osszead == 0 && szamolas == 0) {
			return 0;
		}
		return osszead / szamolas;
	}
}