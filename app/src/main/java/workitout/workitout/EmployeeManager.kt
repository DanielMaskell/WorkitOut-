package workitout.workitout

import android.content.ContentValues
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_employee_manager.*

class EmployeeManager : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_manager)

        val recordID = intent.getIntExtra("id", 0)

        if (recordID == 0) { //Add Record

            save_btn.text = "Add Employee"

        } else { //Update Record

            save_btn.text = "Update Employee"
            val fName = intent.getStringExtra("user_f_name")
            val lName = intent.getStringExtra("user_l_name")
            val password = intent.getStringExtra("user_password")
            val email = intent.getStringExtra("user_email_address")
            val homeAddress = intent.getStringExtra("user_home_address")
            val homePhone = intent.getStringExtra("user_home_phone")
            val mobilePhone = intent.getStringExtra("user_mobile_phone")
            val userType = intent.getStringExtra("user_type")
            val employeeNumber = intent.getStringExtra("employee_number")

            fNameEditText.setText(fName)
            lNameEditText.setText(lName)
            passwordEditText.setText(password)
            emailEditText.setText(email)
            homeAddressEditText.setText(homeAddress)
            homePhoneEditText.setText(homePhone)
            mobilePhoneEditText.setText(mobilePhone)
            userTypeEditText.setText(userType)
            employeeNumberEditText.setText(employeeNumber)
        }

        save_btn.setOnClickListener {

            val fNameToSave = fNameEditText.text.toString()
            val lNameToSave = lNameEditText.text.toString()
            val passwordToSave = passwordEditText.text.toString()
            val emailToSave = emailEditText.text.toString()
            val homeAddressToSave = homeAddressEditText.text.toString()
            val homePhoneToSave = homePhoneEditText.text.toString()
            val mobilePhoneToSave = mobilePhoneEditText.text.toString()
            val userTypeToSave = userTypeEditText.text.toString()
            val employeeNumberToSave = employeeNumberEditText.text.toString()

            if (fNameToSave == "") {

                Toast.makeText(this, "Enter First Name",
                        Toast.LENGTH_SHORT).show()

            } else if (lNameToSave == "") {

                Toast.makeText(this, "Enter Last Name",
                        Toast.LENGTH_SHORT).show()

            } else if (passwordToSave == "") {

                Toast.makeText(this, "Enter Password",
                        Toast.LENGTH_SHORT).show()

            } else if (emailToSave == "") {

                Toast.makeText(this, "Enter Email",
                        Toast.LENGTH_SHORT).show()

            } else if (homeAddressToSave == "") {

                Toast.makeText(this, "Enter Home Address",
                        Toast.LENGTH_SHORT).show()

            } else if (homePhoneToSave == "") {

                Toast.makeText(this, "Enter Home Phone",
                        Toast.LENGTH_SHORT).show()

            } else if (mobilePhoneToSave == "") {

                Toast.makeText(this, "Enter Mobile Phone",
                        Toast.LENGTH_SHORT).show()

            } else if (userTypeToSave == "") {

                Toast.makeText(this, "Enter User Type",
                        Toast.LENGTH_SHORT).show()

            } else if (employeeNumberToSave == "") {

                Toast.makeText(this, "Enter Employee Number",
                        Toast.LENGTH_SHORT).show()

            } else {

                val values = ContentValues()
                values.put("user_f_name", fNameToSave)
                values.put("user_l_name", lNameToSave)
                values.put("user_password", passwordToSave)
                values.put("user_email_address", emailToSave)
                values.put("user_home_address", homeAddressToSave)
                values.put("user_home_phone", homePhoneToSave)
                values.put("user_mobile_phone", mobilePhoneToSave)
                values.put("user_type", userTypeToSave)
                values.put("employee_number", employeeNumberToSave)

                if (recordID == 0) {

                    val databaseHandler = DatabaseHandler(this)

                    val response = databaseHandler.addUser(values)
//                    if (response == "ok") {
//
//                        Toast.makeText(this, "Employee Added",
//                                Toast.LENGTH_SHORT).show()
//
//                        val intent = Intent(this, MainActivity::class.java)
//                        startActivity(intent)
//                        finish()
//
//                    } else {
//                        Toast.makeText(this, "Not Added... Try again",
//                                Toast.LENGTH_SHORT).show()
//                    }
                } else {

                    val databaseHandler = DatabaseHandler(this)
//                    val res: String = databaseHandler.updateUser(values, recordID)

//                    if (res == "ok") {
//                        Toast.makeText(this, "Employee Updated",
//                                Toast.LENGTH_SHORT).show()
//                        val intent = Intent(this, MainActivity::class.java)
//                        startActivity(intent)
//                        finish()
//                    } else {
//                        Toast.makeText(this, "Error... Try Again",
//                                Toast.LENGTH_SHORT).show()
//                    }
                }
            }
        }

        delete_btn.setOnClickListener {

            val recordID = intent.getIntExtra("id", 0)

            val DB = DatabaseHandler(this)
//            val res: String = DB.deleteUser(recordID)

//            if (res == "ok") {
//
//                Toast.makeText(this, "Employee Deleted",
//                        Toast.LENGTH_SHORT).show()
//            } else {
//
//                Toast.makeText(this, "Error... Try Again",
//                        Toast.LENGTH_SHORT).show()
//            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}
