public class Employee {
    // The name of the employee
    private String name;
    // The current waiting days
    private long waitingDays;
    // The current retaining days
    private long retainingDays;

    /**
     * Constructor
     *
     * @param name the name of the employee
     */
    public Employee(String name) {
        this.name = name;
        this.waitingDays = 0;
        this.retainingDays = 0;
    }

    /**
     * Get the name of the employee
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Get the waiting days
     *
     * @return the waiting days
     */
    public long getWaitingDays() {
        return waitingDays;
    }

    /**
     * Set the waiting days
     *
     * @param waitingDays the value of the waiting days
     */
    public void setWaitingDays(long waitingDays) {
        this.waitingDays = waitingDays;
    }

    /**
     * Get the retaining days
     *
     * @return the retaining days
     */
    public long getRetainingDays() {
        return retainingDays;
    }

    /**
     * Set the retaining days
     *
     * @param retainingDays the value of the retaining days
     */
    public void setRetainingDays(long retainingDays) {
        this.retainingDays = retainingDays;
    }

    @Override
    public String toString() {
        return this.getName() + "," + this.getRetainingDays() + "," + this.getWaitingDays();
    }
}
