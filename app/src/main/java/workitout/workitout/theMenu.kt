package workitout.workitout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_the_menu.*

class theMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_menu)

        details.setOnClickListener{
            val detailsActivity = Intent(this@theMenu, detailsActivity::class.java)
            startActivity (detailsActivity)
        }

        Calendar.setOnClickListener{
            val calendarActivity = Intent(this@theMenu, calendarActivity::class.java)
            startActivity(calendarActivity)
        }
    }
}
