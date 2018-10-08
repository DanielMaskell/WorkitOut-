package workitout.workitout

data class User (val id: Int = -1, val fName: String, val lName: String, val userName: String,
                 val password: String, val userType: String, val employeeNumber: String,
                 val homePhone: String, val mobilePhone: String, val emailAddress: String,
                 val homeAddress: String, val contractType: String, val loggedIn: Boolean,
                 val monAvail: Boolean, val tueAvail: Boolean, val wedAvail: Boolean, val thuAvail: Boolean,
                 val friAvail: Boolean, val satAvail: Boolean, val sunAvail: Boolean)