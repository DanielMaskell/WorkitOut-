package workitout.workitout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_daily_roster.*
import kotlinx.android.synthetic.main.app_bar_main.*

/**
 * This class contains the code for setting up the roster.
 * XML: activity_daily_roster
 */

class DailyRosterActivity : AppCompatActivity(){

    private val employeesList: ArrayList<String> = ArrayList()
    private var day = ""


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_roster)
        setSupportActionBar(toolbar)

        day = intent.getStringExtra("Day")

        val dayText: TextView = findViewById(R.id.text_day)
        dayText.text = day
        addEmployees()

        employee_rc_view.layoutManager = LinearLayoutManager(this)
        employee_rc_view.adapter = DailyRosterAdapter(employeesList, this)
        println("Hello")
        println(this.day)

    }

    fun addEmployees(){

        employeesList.add("Daniel")
        employeesList.add("Daniel")
        employeesList.add("Daniel")
        employeesList.add("Daniel")
        employeesList.add("Daniel")
        employeesList.add("Daniel")
        employeesList.add("Daniel")
        employeesList.add("Daniel")
        employeesList.add("Daniel")
        employeesList.add("Daniel")


    }


}