package workitout.workitout

class EmployeeDetails(employeeID: String? = null,
                      fName: String? = null,
                      lName: String? = null,
                      password: String? = null,
                      mondayAvail: String? = null,
                      tuesdayAvail: String? = null,
                      wednesdayAvail: String? = null,
                      thursdayAvail: String? = null,
                      fridayAvail: String? = null,
                      saturdayAvail: String? = null,
                      sundayAvail: String? = null,
                      homePhone: String? = null,
                      mobilePhone: String? = null,
                      homeAddress: String? = null,
                      emailAddress: String? = null,
                      role: Role? = null) {

    val employeeID = employeeID
    val fName = fName
    val lName = lName
    val password = password
    val mondayAvail = mondayAvail
    val tuesdayAvail = tuesdayAvail
    val wednesdayAvail = wednesdayAvail
    val thursdayAvail = thursdayAvail
    val fridayAvail = fridayAvail
    val saturdayAvail = saturdayAvail
    val sundayAvail = sundayAvail
    val homePhone = homePhone
    val mobilePhone = mobilePhone
    val homeAddress = homeAddress
    val emailAddress = emailAddress
    val role = role

    override fun toString(): String {
        return "EmployeeDetails(employeeID=$employeeID, fName=$fName, lName=$lName, password=$password, " +
                "mondayAvail=$mondayAvail, tuesdayAvail=$tuesdayAvail, wednesdayAvail=$wednesdayAvail, " +
                "thursdayAvail=$thursdayAvail, fridayAvail=$fridayAvail, saturdayAvail=$saturdayAvail, " +
                "sundayAvail=$sundayAvail, homePhone=$homePhone, mobilePhone=$mobilePhone, homeAddress=$homeAddress, " +
                "emailAddress=$emailAddress, role=$role)"
    }


}