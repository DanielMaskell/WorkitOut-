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

        var record_id = intent.getIntExtra("id", 0)

        if (record_id == 0) { //Add Record

            save_btn.text = "Add Contact"

        } else { //Update Record

            save_btn.text = "Update Contact"
            var _fname = intent.getStringExtra("fname")
            var _lname = intent.getStringExtra("lname")
            var _email = intent.getStringExtra("email")
            var _phone = intent.getStringExtra("phone")

            fnametxt.setText(_fname)
            lnametxt.setText(_lname)
            emailtxt.setText(_email)
            mobile_phone.setText(_phone)

        }

        save_btn.setOnClickListener() {

            var a = fnametxt.text.toString();
            var b = lnametxt.text.toString();
            var c = emailtxt.text.toString();
            var d = mobile_phone.text.toString();

            if (a == "") {

                Toast.makeText(this, "Enter FirstName",
                        Toast.LENGTH_SHORT).show()

            } else if (d == "") {

                Toast.makeText(this, "Enter Phone Number",
                        Toast.LENGTH_SHORT).show()

            } else {

                var values = ContentValues()
                values.put("fname", a)
                values.put("lname", b)
                values.put("email", c)
                values.put("number", d)

                if (record_id == 0) {

                    var DB = DatabaseHandler(this);


                    var response = DB.Add(values);
                    if (response == "ok") {

                        Toast.makeText(this, "Contact Added",
                                Toast.LENGTH_SHORT).show()

                        var intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this, "Not Added..Try again",
                                Toast.LENGTH_SHORT).show()
                    }
                } else {

                    var DB = DatabaseHandler(this);
                    var res: String = DB.Update(values, record_id)

                    if (res == "ok") {
                        Toast.makeText(this, "Contact Updated",
                                Toast.LENGTH_SHORT).show()
                        var intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Error..Try Again",
                                Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        delete_btn.setOnClickListener() {

            var DB = DatabaseHandler(this);
            var res: String = DB.Remove(record_id)

            if (res == "ok") {

                Toast.makeText(this, "Contact Deleted",
                        Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(this, "Error..Try Again",
                        Toast.LENGTH_SHORT).show()
            }

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}
