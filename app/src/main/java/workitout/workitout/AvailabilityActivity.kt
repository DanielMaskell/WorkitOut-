package workitout.workitout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.ToggleButton

/**
 * This class, connected with availability.xml, takes the values from the toggle buttons and adds
 * these to the database (to the corresponding user).
 * @author Danica
 */
class AvailabilityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.availability)

        val toggleButton1 = findViewById<ToggleButton>(R.id.toggleButton1)
        toggleButton1?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Monday is " + if (isChecked) "Available" else "Not Available"
            Toast.makeText(this@AvailabilityActivity, msg, Toast.LENGTH_SHORT).show()
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
}
