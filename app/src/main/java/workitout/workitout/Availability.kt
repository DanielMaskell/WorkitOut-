package workitout.workitout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import android.widget.ToggleButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_the_menu.*

class Availability : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_menu)

        val toggleButton1 = findViewById<ToggleButton>(R.id.toggleButton1)
        toggleButton1?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Toggle Button is " + if (isChecked) "ON" else "OFF"
            Toast.makeText(this@Availability, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton2 = findViewById<ToggleButton>(R.id.toggleButton2)
        toggleButton2?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Toggle Button is " + if (isChecked) "ON" else "OFF"
            Toast.makeText(this@Availability, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton3 = findViewById<ToggleButton>(R.id.toggleButton3)
        toggleButton3?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Toggle Button is " + if (isChecked) "ON" else "OFF"
            Toast.makeText(this@Availability, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton4 = findViewById<ToggleButton>(R.id.toggleButton4)
        toggleButton4?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Toggle Button is " + if (isChecked) "ON" else "OFF"
            Toast.makeText(this@Availability, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton5 = findViewById<ToggleButton>(R.id.toggleButton5)
        toggleButton5?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Toggle Button is " + if (isChecked) "ON" else "OFF"
            Toast.makeText(this@Availability, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton6 = findViewById<ToggleButton>(R.id.toggleButton6)
        toggleButton6?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Toggle Button is " + if (isChecked) "ON" else "OFF"
            Toast.makeText(this@Availability, msg, Toast.LENGTH_SHORT).show()
        }
        val toggleButton7 = findViewById<ToggleButton>(R.id.toggleButton7)
        toggleButton7?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Toggle Button is " + if (isChecked) "ON" else "OFF"
            Toast.makeText(this@Availability, msg, Toast.LENGTH_SHORT).show()
        }

    }
}
