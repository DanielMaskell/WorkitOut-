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
            val detailsActivity = Intent(this@MenuActivity, DetailsActivity::class.java)
            startActivity(detailsActivity)
        }

    }
}
