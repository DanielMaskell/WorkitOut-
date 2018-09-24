package workitout.workitout

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ContentValues
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_employee_manager.*

class MainActivity : AppCompatActivity() {

    var employeeList = ArrayList<EmployeeDetails>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        menu.setOnClickListener {
            val menuActivity = Intent(this@MainActivity, MenuActivity::class.java)
            startActivity(menuActivity)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.Roster -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()

        var DB:DatabaseHandler = DatabaseHandler(this);
        employeeList = DB.Fetch("%");

        if(employeeList.size>0) {

            var employeeAdapterObj = EmployeeAdapter(this, employeeList)
            employee_list.adapter = employeeAdapterObj

            employee_list.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, position, id ->

                //EmployeeList holds EmployeeDetails object
                var fname = employeeList[position].fName;
                var lname = employeeList[position].lName;
                var email = employeeList[position].emailAddress;
                var phone = employeeList[position].mobilePhone;
                var id = employeeList[position].employeeID

                //Passing data to EmployeeManager activity.
                var intent = Intent(this, EmployeeManager::class.java)
                intent.putExtra("id", id)
                intent.putExtra("fname", fname)
                intent.putExtra("lname", lname)
                intent.putExtra("email", email)
                intent.putExtra("phone", phone)
                intent.putExtra("action", "edit")
                startActivity(intent)

            }
        } else {

            Toast.makeText(this, "No Contact Found", Toast.LENGTH_SHORT).show()
        }

        add_employee_btn.setOnClickListener(){
            var intent= Intent(this,EmployeeManager::class.java)
            startActivity(intent)
        }

    }
}
