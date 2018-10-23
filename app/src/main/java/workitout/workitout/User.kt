package workitout.workitout

/**
 * This class is the foundation of the information present in the app. It defines
 * the User type and its respective variables, defining each and every piece of
 * information we wished to attach to each user. This is a simple data class,
 * essentially only used to initialize the variables, which will later be filled
 * by inputted information.
 * @author Chris
 */
data class User (val id: Int = -1, val fName: String, val lName: String, val userName: String,
                 val password: String, val userType: String, val employeeNumber: String,
                 val homePhone: String, val mobilePhone: String, val emailAddress: String,
                 val homeAddress: String, val contractType: String, val loggedIn: Boolean,
                 val monAvail: Boolean, val tueAvail: Boolean, val wedAvail: Boolean, val thuAvail: Boolean,
                 val friAvail: Boolean, val satAvail: Boolean, val sunAvail: Boolean)
