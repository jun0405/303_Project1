import java.time.LocalDate;

public class Project1 {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Create two books
        Book seBook = new Book("Software Engineering");
        Book eeBook = new Book("Electrical Engineering");

        // Add books to the library
        library.addBook(seBook);
        library.addBook(eeBook);

        // Create three employees
        Employee ann = new Employee("Ann");
        Employee sam = new Employee("Sam");
        Employee adam = new Employee("Adam");

        // Add employees to the library
        library.addEmployee(adam);
        library.addEmployee(ann);
        library.addEmployee(sam);

        // Print the stats
        System.out.println(library);

        // Start circulate book 'Software Engineering' at '2019-02-01'
        library.circulateBook(seBook, LocalDate.parse("2019-02-01"));
        // Print the stats (to show the book got moved from archived to circulated list)
        System.out.println(library);
        // Pass the book 'Software Engineering' after 3 days
        library.passOn(seBook, LocalDate.parse("2019-02-04"));
        // Pass the book 'Software Engineering' after 1 days
        library.passOn(seBook, LocalDate.parse("2019-02-05"));
        // Pass the book 'Software Engineering' after 5 days
        library.passOn(seBook, LocalDate.parse("2019-02-10"));

        // Print the stats
        System.out.println(library);

        // Start circulate book 'Electrical Engineering' at '2019-03-05'
        library.circulateBook(eeBook, LocalDate.parse("2019-03-05"));
        // Print the stats (to show the book got moved from archived to circulated list)
        System.out.println(library);
        // Pass the book 'Electrical Engineering' after 5 days
        library.passOn(eeBook, LocalDate.parse("2019-03-10"));
        // Pass the book 'Electrical Engineering' after 5 days
        library.passOn(eeBook, LocalDate.parse("2019-03-15"));
        // Pass the book 'Electrical Engineering' after 5 days
        library.passOn(eeBook, LocalDate.parse("2019-03-20"));

        // Print the stats
        System.out.println(library);
    }
}
