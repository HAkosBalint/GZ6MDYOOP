package mytestpackage;

import java.util.Scanner;

import homework.Book;
import homework.EBook;

public class Homework {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Number of ebooks: ");
            n = scanner.nextInt();
        }
        while(n < 1 || n > 10);

        EBook[] ebooks = new EBook[n];

        for(int i = 0; i< n; i++) {
            System.out.printf("%d. ebook:\n", i+1);

            System.out.print(" Author: ");
            String author = scanner.next();

            System.out.print(" Title: ");
            String title = scanner.next();

            System.out.print(" Price: ");
            int price = scanner.nextInt();

            System.out.print(" Pages: ");
            int pages = scanner.nextInt();

            System.out.print(" Style: ");
            String style = scanner.next();

            System.out.print(" URL: ");
            String url = scanner.next();

            ebooks[i] = new EBook(author, title, price, pages, style, url);
        }

        scanner.close();

        int styleCount = EBook.countStyles(ebooks);
        System.out.println(styleCount);
        int childrensBooks = EBook.listBooksWithStyle(ebooks, "children");
        System.out.println(childrensBooks);
        int avgPrice = EBook.avgPrice(ebooks, "children");
        System.out.println(avgPrice);
        EBook.discountBooks(ebooks, "children");
        for(Book book : ebooks) {
            System.out.println(book);
        }
        avgPrice = EBook.avgPrice(ebooks, "children");
        System.out.println(avgPrice);
    }
}