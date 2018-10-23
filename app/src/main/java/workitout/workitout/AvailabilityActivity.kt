package workitout.workitout

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.availability.*
import kotlin.properties.Delegates

import workitout.workitout.R.layout.availability
/**
 * This class, connected with availability.xml, takes the values from the toggle buttons and adds
 * these to the database (to the corresponding user).
 * @author Danica
 */
class AvailabilityActivity : AppCompatActivity() {

    private var databaseHelper: DatabaseHandler by Delegates.notNull()
    private var monday = 0
    private var tuesday = 0
    private var wednesday = 0
    private var thursday = 0
    private var friday = 0
    private var saturday = 0
    private var sunday = 0


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


        appCompatUpdateButton.setOnClickListener { View ->

            val input = EnterUsername.toString()
            val checker = databaseHelper.checkUser(input)

            if (input.isEmpty()) {
                Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show()
            } else {
                if (checker) {
                    val msg = input + "'s availability is updated"
                    databaseHelper.updateAvailability(EnterUsername.text.toString(), monday, tuesday, wednesday, thursday, friday, saturday, sunday)
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                } else {
                    val msg = "User not found"
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                }

            }


        }
    }
}
