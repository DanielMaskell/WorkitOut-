package workitout.workitout

/**
 * This class is a basic enumeration class that defines the ContractType field for the database.
 * @author Donna
 */

enum class ContractType (val contractType: String) {
    FullTime("FullTime"), PartTime("PartTime"), Casual("Casual"), Employer("Employer")
}
