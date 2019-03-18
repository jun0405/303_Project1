import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    /**
     * Custom compare function that will determine the priority of the employee
     *
     * @param left  left employee
     * @param right right employee
     * @return return -1 if the priority of left is higher than right
     *         return 1 if the priority of left is lower than right
     *         return 0 if the priority of left is same as right
     */
    public int compare(Employee left, Employee right) {
        // Calculate priority for the left
        long leftPriority = left.getWaitingDays() - left.getRetainingDays();
        // Calculate priority for the right
        long rightPriority = right.getWaitingDays() - right.getRetainingDays();
        // Perform compare
        if (leftPriority < rightPriority)
            return 1;
        else if (leftPriority > rightPriority)
            return -1;
        return 0;
    }
}