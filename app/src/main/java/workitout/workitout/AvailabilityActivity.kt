package workitout.workitout

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.ToggleButton
import kotlinx.android.synthetic.main.availability.*
import android.widget.TextView
import workitout.workitout.R.layout.availability
import kotlin.properties.Delegates


/**
 * This class, connected with availability.xml, takes the values from the toggle buttons and adds
 * these to the database (to the corresponding user).
 * @author Danica
 */
class AvailabilityActivity : AppCompatActivity() {

    private lateinit var inputValidation: LoginInputValidationActivity
    private var databaseHelper: DatabaseHandler by Delegates.notNull()
    private var db: SQLiteDatabase by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.availability)



        val toggleButton1 = findViewById<ToggleButton>(R.id.toggleButton1)
        toggleButton1?.setOnCheckedChangeListener { buttonView, isChecked ->
            val availability = if (isChecked) true else false
            //val tv1 = findViewById(R.id.test) as TextView
            //tv1.text = if (isChecked) "1" else "0"

            //val msg = "Monday is " + if (isChecked) "Available" else "Not Available"
            //Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
         //here //  updateHandler("Admin", availability)

        }
        val toggleButton2 = findViewById<ToggleButton>(R.id.toggleButton2)
        toggleButton2?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Tuesday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton3 = findViewById<ToggleButton>(R.id.toggleButton3)
        toggleButton3?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Wednesday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton4 = findViewById<ToggleButton>(R.id.toggleButton4)
        toggleButton4?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Thursday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton5 = findViewById<ToggleButton>(R.id.toggleButton5)
        toggleButton5?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Friday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton6 = findViewById<ToggleButton>(R.id.toggleButton6)
        toggleButton6?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Saturday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton7 = findViewById<ToggleButton>(R.id.toggleButton7)
        toggleButton7?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Sunday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
        }

    }

    //here


}/* private fun updateHandler(User_Name: String, Availability: Boolean): Boolean {
     databaseHelper = DatabaseHandler(this)
     db = databaseHelper.writableDatabase

     val args = ContentValues()
     /*args.put(DabaseHandler.COLUMN_USER_NAME, User_Name)
     args.put(DatabaseHandler.COLUMN_MONDAY_AVAIL, Availability)
     return db.update(DatabaseHandler.TABLE_USER, args, DatabaseHandler.COLUMN_MONDAY_AVAIL + " = " + User_Name, null) > 0
 }*/