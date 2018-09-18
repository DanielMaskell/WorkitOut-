package workitout.workitout

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_the_menu.*

class detailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        details.setOnClickListener{
            val detailsActivity = Intent(this@detailsActivity, detailsActivity::class.java)
            startActivity (detailsActivity)
        }
    }
}