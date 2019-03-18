import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Library {
    // A list of circulate books
    private ArrayList<Book> circulatedBooks;
    // A list of archive books
    private ArrayList<Book> archivedBooks;
    // Priority queue for employee
    private PriorityQueue<Employee> pq;
    // A list of employees
    private ArrayList<Employee> employees;

    /**
     * Constructor
     */
    public Library() {
        this.circulatedBooks = new ArrayList<Book>();
        this.archivedBooks = new ArrayList<Book>();
        this.pq = new PriorityQueue<Employee>(new EmployeeComparator());
        this.employees = new ArrayList<Employee>();
    }

    /**
     * Add a book to the library (archived list)
     *
     * @param book the book to be added to the library
     */
    public void addBook(Book book) {
        archivedBooks.add(book);
    }

    /**
     * Start circulate the book with a start date
     *
     * @param book the book that will be circulate
     * @param startDate the start date of the circulation
     */
    public void circulateBook(Book book, LocalDate startDate) {
        // Check if the book is not in the archive list
        if (!archivedBooks.contains(book)) {
            System.out.println("The request book is not on the archive list.");
        } else {
            // Remove book from archive list and add it to the circulate list
            book.setArchived(false);
            book.setStartDate(startDate);
            archivedBooks.remove(book);
            circulatedBooks.add(book);
        }
    }

    /**
     * Add employee to the library
     *
     * @param employee the employee to be add
     */
    public void addEmployee(Employee employee) {
        // Add employee to the priority queue
        this.pq.add(employee);
        // Add employee to the array list (to keep track all employees)
        this.employees.add(employee);
    }

    /**
     * Add all employees back to the priority queue
     */
    private void addEmployees() {
        pq.addAll(this.employees);
    }

    /**
     * Pass the book among employees with end date
     *
     * @param book    the book to be pass on
     * @param endDate the end date of the circulation
     */
    public void passOn(Book book, LocalDate endDate) {
        // If the book doesn't have an end date, set it to the value of the parameter
        if (book.getEndDate() == null) {
            book.setEndDate(endDate);
        } else {
            // If the book does have an end date, set start date to current's end data and
            // set the end date to to the value of the parameter
            book.setStartDate(book.getEndDate());
            book.setEndDate(endDate);
        }
        // Pass on the book if the priority queue is not empty
        if (!pq.isEmpty()) {
            // Get next employee in the priority queue
            Employee employee = pq.poll();
            // Get the current owner of the book
            Employee currentOwner = book.getOwnBy();
            // Calculate retaining days
            long diff = ChronoUnit.DAYS.between(book.getStartDate(), book.getEndDate());
            // Set retaining days
            employee.setRetainingDays(diff);
            // Set hte waiting days
            if (currentOwner == null) {
                employee.setWaitingDays(0);
            } else {
                employee.setWaitingDays(currentOwner.getWaitingDays() + currentOwner.getRetainingDays());
            }
            // Update the owner of the book
            book.setOwnBy(employee);
            // If the priority queue is empty, update the book's info and add it back to the archived list
            if (pq.isEmpty()) {
                book.setArchived(true);
                book.setStartDate(null);
                book.setEndDate(null);
                book.setOwnBy(null);
                archivedBooks.add(book);
                circulatedBooks.remove(book);
                addEmployees();
            }
        } else {
            System.out.println("Empty employee queue");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        // Print circulated books
        str.append("[Circulated Books]");
        str.append(System.lineSeparator());
        for (Book book : circulatedBooks) {
            str.append(book.getName());
            str.append(System.lineSeparator());
        }
        // Print archived books
        str.append(System.lineSeparator());
        str.append("[Archived Books]");
        str.append(System.lineSeparator());
        for (Book book : archivedBooks) {
            str.append(book.getName());
            str.append(System.lineSeparator());
        }
        // Print employees info
        str.append(System.lineSeparator());
        str.append("[Employees]");
        str.append(System.lineSeparator());
        str.append("Employee, RetainingDays, WaitingDays");
        str.append(System.lineSeparator());
        for (Employee employee : employees) {
            str.append(employee.getName());
            str.append(", ");
            str.append(employee.getRetainingDays());
            str.append(", ");
            str.append(employee.getWaitingDays());
            str.append(System.lineSeparator());
        }
        str.append("=========================================");
        return str.toString();
    }
}
