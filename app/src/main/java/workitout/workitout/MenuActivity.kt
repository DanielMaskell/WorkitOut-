package workitout.workitout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_the_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_menu)

        details.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }


        schedule.setOnClickListener {
            val intent = Intent(this, AvailabilityActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        Calendar.setOnClickListener{
            val calendarActivity = Intent(this@MenuActivity, calendarActivity::class.java)
            startActivity(calendarActivity)
        }
    }
}
