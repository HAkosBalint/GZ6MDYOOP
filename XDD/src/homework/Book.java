package homework;

import java.time.Year;
import homework.product.Product;

public class Book extends Product{
	private String author;
	private String title;
	final private int yearOfPublication = Year.now().getValue();
	private int price = super.getPrice();
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


	public int getPages() {
		return pages;
	}



	public void setPages(int pages) {
		if(pages > 0)
			this.pages = pages;
	}
	
	public int getPrice() {
		return price = (int) Math.round(price);
	}
	


	public void setPrice(int price) {
		if (price >= 1000)
			this.price = price;
		else
			this.price = 1000;
	}
	
	public String getStyle() {
		return style;
	}



	public void setStyle(String style) {
		this.style = style;
	}



	public Book(String name, int price, String author, String title, int price2, int pages, String style) {
		super(name, price);
		this.author = author;
		this.title = title;
		price = price2;
		this.style = style;
		this.pages = pages;
	}



	public Book(int pages, String author, String title, String style, int price) {
		super("book", price);
		this.author = author;
		this.title = title;
		
		this.style = style;
		if(pages < 0)
		{
			this.pages = 0;
		}
		else
		{
			this.pages = pages;
		}

	}
	
	public static Integer comparePublicationDate(Book bookA, Book bookB)
	{
		if(bookA.yearOfPublication > bookB.yearOfPublication)
		{
			return 1;
		}
		else if(bookA.yearOfPublication < bookB.yearOfPublication)
		{
			return 2;
		}
		else
		{
			return 0;
		}
		
	}
	
	public static Book getLonger(Book konyv1, Book konyv2) {
		if(konyv1.pages > konyv2.pages)
		{
			return konyv1;
		}
		else if(konyv1.pages < konyv2.pages)
		{
			return konyv2;
		}
		return konyv1;
	
	}
	

	public boolean hasEvenPages()
	{
		if(this.getPages()% 2 == 0)
		{
			return true;
		}
		else
		{ 
			return false;
		}
	}

	public static void listBookArray(Book book[]) {
		for (int i = 0; i < book.length; i++) 
		{
			System.out.println("Az " +(i+1) + ". könyv: " + book[i].toString());
		}
	}
 
	public static Book getLongestBook(Book book[]) {
		int whichbook = 0;
		int longestpages = book[0].getPages();
 
		for (int i = 1; i < book.length; i++)
		{
			if(book[i].getPages() > longestpages) 
			{
				longestpages = book[i].getPages();
				whichbook = i;
			}
		}
 
		return book[whichbook];
	}
 
	public static Book getLongestEvenPagesBook(Book book[]) 
	{
		Book maxBook = null;
 
		for (int i = 0; i < book.length; i++) 
		{
			if(book[i].hasEvenPages()) 
			{
				maxBook = book[i];
				break;
			}
		}
 
 
		for (int i = 0; i < book.length; i++) {
			if(book[i].hasEvenPages() && book[i].getPages() > maxBook.getPages()) 
			{
				maxBook = book[i];
			}
		}
 
		return maxBook;
	}
	
	
	
	@Override
    public String toString() {
        return "Book [author=" + author + ", title=" + title + ", yearOfPublication=" + yearOfPublication + ", pages="
                + pages + ", style=" + style + ", price=" + price + "]";
    }
	
	@Override
	public void decreasePrice(int percent) {
        if(style == "children") {
            this.decreasePrice2(percent + 7);
        } else if (style == "guide") {
            this.decreasePrice2(percent + 5);
        }
    }
	
	
	public static int countStyles(Book[] tomb) {
        int style[] = new int[tomb.length];
        int seged = 0;
 
        for (int i = 0; i < tomb.length; i++) {
            String tempstyle = tomb[i].getStyle();
            if(style[i] == 0) {
                seged++;
                style[i]++;
 
                for(int j = i + 1; j < tomb.length; j++) {
                    if(tempstyle.equalsIgnoreCase(tomb[j].getStyle())){
                        style[j] = -1;
                    }
                }
            }
        }
        return seged;
		
	}
	
	public static void discountBooks(Book[] tomb, String style) {
        for (int i = 0; i < tomb.length; i++) {
            if(tomb[i].getStyle() == style) {
                tomb[i].price = (int) Math.round(tomb[i].price * 0.90);
            }
        }
    }
 
    public static int listBooksWithStyle(Book[] tomb, String style) {
        int seged = 0;
 
        for (int i = 0; i < tomb.length; i++) {
            if(tomb[i].getStyle() == style) {
                seged++;
                System.out.println(tomb[i]);
            }
        }
 
        return seged;
    }
 
    public static int avgPrice(Book[] tomb, String style) {
        int sum = 0;
        int seged = 0;
 
 
        for (int i = 0; i < tomb.length; i++) {
            if(tomb[i].getStyle() == style) {
                sum += tomb[i].getPrice();
                seged++;
            }
        }
 
        if(sum == 0 && seged == 0) {
            return 0;
        }
        return sum / seged;
    }
	
}


