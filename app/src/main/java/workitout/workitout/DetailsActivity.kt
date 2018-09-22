package workitout.workitout

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_the_menu.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        details.setOnClickListener {
            val detailsActivity = Intent(this@DetailsActivity, DetailsActivity::class.java)
            startActivity(detailsActivity)
        }
    }
}