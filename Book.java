import java.util.Scanner;

class Book {
    String name;
    String author;
    double price;
    int num_pages;

    Book(String name, String author, double price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book Name " + name + " Author " + author + " Price " + price;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, author, choice;
        double price;
        int num_pages;
        int n;

        System.out.print("Enter the number of books : ");
        n = sc.nextInt();
        sc.nextLine();

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nBook " + (i + 1) + ":" );
            System.out.print("Name : ");
            name = sc.nextLine();
            System.out.print("Author : ");
            author = sc.nextLine();
            System.out.print("Price : ");
            price = sc.nextDouble();
            System.out.print("Number of pages : ");
            num_pages = sc.nextInt();
            sc.nextLine();

            books[i] = new Book(name, author, price, num_pages);
        }

        {
            System.out.print("Enter name of book to search :");
            choice = sc.nextLine();

            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (books[i].getName().equalsIgnoreCase(choice)) {
                    System.out.println(books[i].toString());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Book not found!");
            }
        }
    }
}