package workitout.workitout

/**
 * This class is a basic enurmeration class that defines the Role field for
 * the Database.
 * @author Chris
 */

enum class Role(val role: String) {
    MANAGER("Manager"),
    EMPLOYEE("Employee"),
    SENIOR_EMPLOYEE("Senior Employee"),
    EMPLOYER("Employer"),
    TRAINEE("Trainee")


}