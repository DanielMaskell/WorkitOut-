package workitout.workitout


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_the_menu.*
import kotlinx.android.synthetic.main.filter_my_work.*
import kotlinx.android.synthetic.main.mymondaywork.*


class FilterMyWorkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filter_my_work)

        btMonday_work.setOnClickListener {
            val Intent = Intent(this@FilterMyWorkActivity, FilterMondayActivity::class.java)
            startActivity(Intent)
        }

        btTuesday_Work.setOnClickListener {
            val Intent = Intent(this@FilterMyWorkActivity, FilterMondayActivity::class.java)
            startActivity(Intent)
        }

        btWednesday_Work.setOnClickListener {
            val Intent = Intent(this@FilterMyWorkActivity, FilterMondayActivity::class.java)
            startActivity(Intent)
        }

        btThursday_Work.setOnClickListener {
            val Intent = Intent(this@FilterMyWorkActivity, FilterMondayActivity::class.java)
            startActivity(Intent)
        }

        btFriday_Work.setOnClickListener {
            val Intent = Intent(this@FilterMyWorkActivity, FilterMondayActivity::class.java)
            startActivity(Intent)
        }

        btExtra_Work.setOnClickListener {
            val Intent = Intent(this@FilterMyWorkActivity, FilterMondayActivity::class.java)
            startActivity(Intent)
        }
    }
}


