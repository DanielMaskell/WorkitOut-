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
 *
 * @Author: Daniel
 */

class DailyRosterActivity : AppCompatActivity(){

    private val employeesList: ArrayList<String> = ArrayList()
    private var day = ""
    private lateinit var db: DatabaseHandler
    private var userList: List<User> = ArrayList()

    /**
     * This function initialises the database object, updates the userList, sets
     * the text in the TextView and sets up the dailyRosterAdapter.
     */
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_roster)
        setSupportActionBar(toolbar)

        db = DatabaseHandler(this)

        this.userList = db.getAllUser()

        this.day = intent.getStringExtra("Day")

        val dayText: TextView = findViewById(R.id.text_day)

        dayText.text = day

        addEmployees()

        employee_rc_view.layoutManager = LinearLayoutManager(this)
        employee_rc_view.adapter = DailyRosterAdapter(employeesList, this)
    }

    /**
     * This function adds users to the list by checking the availability of
     * each user.
     */
    private fun addEmployees(){

        var i = 0

        //This for loop cycles through each user to check availability.
        for(i in 1 until this.userList.size)

            if(day == "Monday"){
                println("Monday available test: "+userList[i].monAvail)
                if(!userList[i].monAvail){
                    employeesList.add(userList[i].userName)
                }
            }else if(day == "Tuesday"){
                if(!userList[i].tueAvail){
                    employeesList.add(userList[i].userName)
                }
            }else if(day == "Wednesday"){
                if(!userList[i].wedAvail){
                    employeesList.add(userList[i].userName)
                }
            }else if(day == "Thursday"){
                if(!userList[i].thuAvail){
                    employeesList.add(userList[i].userName)
                }
            }else if(day == "Friday"){
                if(!userList[i].friAvail){
                    employeesList.add(userList[i].userName)
                }
            }else if(day == "Saturday"){
                if(!userList[i].satAvail){
                    employeesList.add(userList[i].userName)
                }
            }else if(day == "Sunday"){
                if(!userList[i].sunAvail){
                    employeesList.add(userList[i].userName)
                }
            }
    }
}