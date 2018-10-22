package workitout.workitout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_daily_roster.*
import kotlinx.android.synthetic.main.app_bar_main.*

/**
 * This class contains the code for setting up the roster.
 * XML: activity_daily_roster
 */

class DailyRosterActivity : AppCompatActivity(){

    val employeesList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_roster)
        setSupportActionBar(toolbar)

        employee_rc_view.layoutManager = LinearLayoutManager(this)
        employee_rc_view.adapter = DailyRosterAdapter(employeesList, this)
    }




}