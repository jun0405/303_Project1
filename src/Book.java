import java.time.LocalDate;

public class Book {
    // Name of the book
    private String name;
    // Start time of the circulation
    private LocalDate startDate;
    // End time of the circulation
    private LocalDate endDate;
    // Status for archive
    private boolean isArchived;
    // Current owner
    private Employee ownBy;

    /**
     * Constructor
     *
     * @param name the name of the book
     */
    public Book(String name) {
        this.name = name;
        this.startDate = null;
        this.endDate = null;
        this.isArchived = true;
        this.ownBy = null;
    }

    /**
     * Get the name of the book
     *
     * @return the name of the book
     */
    public String getName() {
        return name;
    }

    /**
     * Get the start date of the book
     *
     * @return the start date of the book
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Set the start date of the book
     *
     * @param startDate the start date of the book
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    /**
     * Get the end date of the book
     *
     * @return the end date of the book
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Set the end date of the book
     *
     * @param endDate the end date of the book
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Check if the book is archived
     *
     * @return true if the book is archived else false
     */
    public boolean isArchived() {
        return isArchived;
    }

    /**
     * Set the value for archived
     *
     * @param archived the value for archived
     */
    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    /**
     * Get the current owner of the book
     *
     * @return the current owner of the book
     */
    public Employee getOwnBy() {
        return ownBy;
    }

    /**
     * Set the current owner of the book
     *
     * @param ownBy owner of the book
     */
    public void setOwnBy(Employee ownBy) {
        this.ownBy = ownBy;
    }
}
