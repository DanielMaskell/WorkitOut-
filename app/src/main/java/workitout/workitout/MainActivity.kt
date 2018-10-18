package workitout.workitout

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*


/**
 * This is the main page of the app. MainActivity handles the navigation between
 * the home page and the pages corresponding to each day of the week. Additionally,
 * this houses a navigation drawer for quick and easy navigation around different
 * parts of the app.
 * @author Full Team
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(android.R.color.background_light));


        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        //Change activity reference for these onClickListeners to the day activity. Has not been created yet.
        monday.setOnClickListener { View ->
            val intent = Intent( this, AvailabilityActivity::class.java)
            startActivity(intent)
        }

        tuesday.setOnClickListener { View ->
            val intent = Intent( this, FilterTuesdayActivity::class.java)
            startActivity(intent)
        }

        wednesday.setOnClickListener { View ->
            val intent = Intent( this, FilterTuesdayActivity::class.java)
            startActivity(intent)
        }

        thursday.setOnClickListener { View ->
            val intent = Intent( this, FilterTuesdayActivity::class.java)
            startActivity(intent)
        }

        friday.setOnClickListener { View ->
            val intent = Intent( this, FilterTuesdayActivity::class.java)
            startActivity(intent)
        }

        saturday.setOnClickListener { View ->
            val intent = Intent( this, FilterTuesdayActivity::class.java)
            startActivity(intent)
        }

        sunday.setOnClickListener { View ->
            val intent = Intent( this, FilterTuesdayActivity::class.java)
            startActivity(intent)
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            /*R.id.nav_detail_activity -> {
                val intent = Intent(this, DetailsActivity::class.java)
                startActivity(intent)
            }*/
            R.id.nav_availability_activity -> {
                val intent = Intent(this, AvailabilityActivity::class.java)
                startActivity(intent)

            }
            /*R.id.nav_calendar_activity -> {
                val intent = Intent(this, CalendarActivity::class.java)
                startActivity(intent)
            }*/
            R.id.nav_filter_my_work_activity -> {
                val intent = Intent(this, FilterMyWorkActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_manager_add_arrangement -> {
                val intent = Intent(this, manager_add_arrangement::class.java)
                startActivity(intent)
            }
            R.id.nav_list_of_users -> {
                val intent = Intent(this, UsersListActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_add_users-> {
//                var intent= Intent(this,AddUserActivity::class.java)
//                startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
