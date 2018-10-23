package workitout.workitout

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import kotlinx.android.synthetic.main.availability.*
import android.widget.TextView
import kotlin.properties.Delegates

import workitout.workitout.R.layout.availability
/**
 * This class, connected with availability.xml, takes the values from the toggle buttons and adds
 * these to the database (to the corresponding user).
 * @author Danica
 */
class AvailabilityActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var inputValidation: LoginInputValidationActivity
    private var databaseHelper: DatabaseHandler by Delegates.notNull()
    private var db: SQLiteDatabase by Delegates.notNull()
    var monday = 0
    var tuesday = 0
    var wednesday = 0
    var thursday = 0
    var friday = 0
    var saturday = 0
    var sunday = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.availability)



        val toggleButton1 = findViewById<ToggleButton>(R.id.toggleButton1)
        toggleButton1?.setOnCheckedChangeListener { buttonView, isChecked ->
            monday = if (isChecked) 1 else 0
            val msg = "Monday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()


        }
        val toggleButton2 = findViewById<ToggleButton>(R.id.toggleButton2)
        toggleButton2?.setOnCheckedChangeListener { buttonView, isChecked ->
            tuesday = if (isChecked) 1 else 0
            val msg = "Tuesday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton3 = findViewById<ToggleButton>(R.id.toggleButton3)
        toggleButton3?.setOnCheckedChangeListener { buttonView, isChecked ->
            wednesday = if (isChecked) 1 else 0
            val msg = "Wednesday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton4 = findViewById<ToggleButton>(R.id.toggleButton4)
        toggleButton4?.setOnCheckedChangeListener { buttonView, isChecked ->
            thursday = if (isChecked) 1 else 0
            val msg = "Thursday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton5 = findViewById<ToggleButton>(R.id.toggleButton5)
        toggleButton5?.setOnCheckedChangeListener { buttonView, isChecked ->
            friday = if (isChecked) 1 else 0
            val msg = "Friday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton6 = findViewById<ToggleButton>(R.id.toggleButton6)
        toggleButton6?.setOnCheckedChangeListener { buttonView, isChecked ->
            saturday = if (isChecked) 1 else 0
            val msg = "Saturday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton7 = findViewById<ToggleButton>(R.id.toggleButton7)
        toggleButton7?.setOnCheckedChangeListener { buttonView, isChecked ->
            sunday = if (isChecked) 1 else 0
            val msg = "Sunday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }

        /*fun updateUserAvailability(){
            //  val result = databaseHelper.availabilityUpdateHandler(UserName.text.toString(), monday, tuesday, wednesday, thursday, friday, saturday, sunday)
            val input = enterUserName.text.toString()
             if(input == "a"){
                 Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
                 return;
             }
             else{
                 /*if (result) {
                     val msg = user + "'s availability is updated"
                     Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
                 } else
                     UserName.setText("No Match Found")*/
                 Toast.makeText(this@AvailabilityActivity, "yaaas", Toast.LENGTH_SHORT).show()
             }
            Toast.makeText(this@AvailabilityActivity, "yaaas", Toast.LENGTH_SHORT).show()

            val button = findViewById<>(R.id.button.UpdateButton)
            button.setOnClickListener(View.OnClickListener {
                // Code here executes on main thread after user presses button
            })
        }*/
        /**
         * This method is to validate the input text fields and verify login credentials from SQLite
         */



    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.appCompatUpdateButton -> updateUserAvailability()
        }
    }
    fun updateUserAvailability() {

        //for testing butto only Toast.makeText(this@AvailabilityActivity, "yaaas", Toast.LENGTH_SHORT).show()

        val input = EnterUsername.text.toString()
        val checker = databaseHelper.checkUser(input)

        if(input == ""){
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show()
        }
        if (checker == true){
            val msg = input+ "'s availability is updated"
            databaseHelper.updateAvailability(EnterUsername.text.toString(), monday, tuesday, wednesday, thursday, friday, saturday, sunday)
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }else{
            val msg = "User not found"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

    }



}
/*if(check== true){
    val msg = user + "'s availability is updated"
    Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
    databaseHelper.availabilityUpdateHandler(UserName.text.toString(),monday, tuesday, wednesday, thursday, friday, saturday, sunday)
}else{
    UserName.setText("No Match Found")



//here


/* private fun updateHandler(User_Name: String, Availability: Boolean): Boolean {
databaseHelper = DatabaseHandler(this)
db = databaseHelper.writableDatabase

val args = ContentValues()
/*args.put(DabaseHandler.COLUMN_USER_NAME, User_Name)
args.put(DatabaseHandler.COLUMN_MONDAY_AVAIL, Availability)
return db.update(DatabaseHandler.TABLE_USER, args, DatabaseHandler.COLUMN_MONDAY_AVAIL + " = " + User_Name, null) > 0
}*/