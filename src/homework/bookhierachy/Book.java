package homework.bookhierachy;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

public class Book extends Product {
	
	public enum BookStyle {
		CHILDREN, GUIDE, CRIME, COOK, OTHER;
	}
    private String title;
    private String author;
    private final int yearOfPublication;
    private int pages;
    private static int number = 0;
    private BookStyle style;

    public Book(String author, String title, int price, int pages, String style) {
    	super("book", Math.max(price, 0), 5);
        this.author = author;
        this.title = title;
        this.yearOfPublication = LocalDate.now().getYear();
        this.pages = Math.max(pages, 0);
        setStyle(style);
        
        number++;
    }
    
    public Book(String author, String title, String style) {
        this(author, title, 2500, 100, style);
    }
    
    @Override
    public void decreasePrice(int percent) {	
    	if(style == BookStyle.CHILDREN) {
    		super.decreasePrice(percent + 7);
    	}
    	
    	else if (style == BookStyle.GUIDE) {
    		super.decreasePrice(percent + 5);
    	}
    	
    	else {
    		super.decreasePrice(percent);
    	}
    }
     
    public boolean hasEvenPages() {
    	return pages % 2 == 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
    
    @Override
    public void setPrice(int price) {
        if (price <= 0) {
            super.setPrice(0);
        }
        else if (price < 1000) {
            super.setPrice(1000);
        }
        else {
            super.setPrice(price);
        }
    }

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		if(pages < 0) {
			return;
		}
		this.pages = pages;
	}

	public String getStyle() {
		return style.toString();
	}

	public void setStyle(String style) {
        BookStyle[] bookStyles = BookStyle.values();
        for (BookStyle bookStyle : bookStyles) {
            if (style.equalsIgnoreCase(bookStyle.toString())) {
                this.style = bookStyle;
                break;
            } else
                this.style = BookStyle.OTHER;
        }
    }
	
	@Override
	public int getUnitPrice( ) {
		return (int)Math.round(getTaxedValue() / pages);
	}
	
	public static int getNumber() {
		return number;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		number--;
    }

	@Override
    	public String toString() {
    		return title + " " + author + " " + yearOfPublication + " " + getPrice() + " " + pages + " " + style + " " + getUnitPrice();
	}

	public static int comparePublicationDate(Book first, Book second) {
		if(first.getYearOfPublication() > second.getYearOfPublication())
			return 1;
		else if(first.getYearOfPublication() < second.getYearOfPublication())
			return 2;
		else 
			return 0;
	}
	
	public static Book getLonger(Book first, Book second) {
		if(first.pages < second.pages) {
			return second;
		}
		else {
			return first;
		}
	}
	
	public static void listBookArray(Book[] books) {
        for(int i=0; i<books.length; i++)
        System.out.println(books[i]);
	}

	
	public static Book getLongestBook(Book[] books) {
		Book maxBook = null;
		for(Book book : books) {
			if(maxBook == null || maxBook.pages < book.pages) {
				maxBook = book;
			}
		}
		return maxBook;
	}
	
	public static Book getLongestEvenPagesBook(Book[] book) {
        Book maxBook = null;
        for (int i = 0; i < book.length; i++) {
            if(book[i].hasEvenPages()){
                maxBook = book[i];
                break;
            }
        }
        for (int i = 0; i < book.length; i++) {
            if(book[i].hasEvenPages() && book[i].getPages() > maxBook.getPages()){
                maxBook = book[i];
            }
        }
        return maxBook;
    }
	
	public static void authorStatistics(Book[] book) {
        for (int i = 1; i < book.length; i++) {
            int counter = 0;
            for (int j = i-1; j < book.length; j++) {
                if(book[i].getAuthor().equalsIgnoreCase(book[j].getAuthor())) {
                    counter+=1;
                }
            }
            System.out.println(book[i].getAuthor() + " author " + counter + " times occured");
            counter=0;
        }
    }
	
	public static int countStyles(Book[] books) {
        int count = 1;
        for (int i = 1; i < books.length; i++) {
            boolean found = false;
            for (int j = i - 1; j >= 0; j--) {
                if (books[i].getStyle().equalsIgnoreCase(books[j].getStyle())) {
                    found = true;
                    break;
                } else
                    continue;
            }
            if (!found) {
                count++;
            }
        }
        return count;
    }
	
	public static void discountBooks(Book[] books, String style) {
		for(Book book : books) {
			if(book.style.name().equals(style)) {
				book.decreasePrice(10);
			}
		}
	}
	
	
	public static int listBooksWithStyle(Book[] books, String style) {
		int count = 0;
		for(Book book : books) {
			if(book.style.name().equals(style)) {
				System.out.println(book);
				count++;
			}
		}
		return count;
	}
	
	
	public static int avgPrice(Book[] books, String style) {
		int count = 0;
		int sum =  0;
		for(Book book : books) {
			if(book.style.name().equals(style)) {
				count++;
				sum += book.getPrice();
			}
		}
		if(count == 0) {
			return 0;
		};
		return sum / count;
	}
	
	public static String[] selectAuthors(Book[] books, int unitPrice) {
		Set<String> authors = new HashSet<>();
		for(Book book : books) {
			if(book.getUnitPrice() > unitPrice) {
				authors.add(book.author);
			}
		}
		String[] authorsArray = new String[authors.size()];
		authors.toArray(authorsArray);
		return authorsArray;
	}
	
	public static int sumGrossPrice(Book[] books) {
		int sum = 0;
		for(Book book : books) {
			sum += book.getTaxedValue();
		}
		return sum;
		}
}
