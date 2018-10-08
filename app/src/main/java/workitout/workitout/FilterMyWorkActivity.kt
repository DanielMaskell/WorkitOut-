package workitout.workitout


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_the_menu.*
import kotlinx.android.synthetic.main.filter_my_work.*


class FilterMyWorkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filter_my_work)

        btMonday_work.setOnClickListener {
            val intent = Intent(this, FilterMondayActivity::class.java)
            startActivity(intent)
        }

        btTuesday_Work.setOnClickListener {
            val intent = Intent(this, FilterTuesdayActivity::class.java)
            startActivity(intent)
        }

        btWednesday_Work.setOnClickListener {
            val intent = Intent(this, FilterMyWednesdayActivity::class.java)
            startActivity(intent)
        }

        btThursday_Work.setOnClickListener {
            val intent = Intent(this, FilterMyThursdayActivity::class.java)
            startActivity(intent)
        }

        btFriday_Work.setOnClickListener {
            val intent = Intent(this, FilterMyFridayActivity::class.java)
            startActivity(intent)
        }

        btExtra_Work.setOnClickListener {
            val intent = Intent(this, FilterMyExtraWorkActivity::class.java)
            startActivity(intent)
        }
    }
}


