package workitout.workitout

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v4.view.GravityCompat
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatTextView
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

/**
    This class, connected with activity_add_user, first takes the username and password input
    and checks the password against the database. When the button is clicked, it will check
    the database for any duplicate entries. Additionally, it will ask for any missing
    information i.e. if a first name has not been input. If there are no duplicates in the database,
    all required information is present, and the password matches the database, the user will be added.
    @author Donna
 */

class AddUserActivity : AppCompatActivity(), View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private val activity = this@AddUserActivity

    private lateinit var nestedScrollView: NestedScrollView

    private lateinit var textInputLayoutUserFName: TextInputLayout
    private lateinit var textInputLayoutUserLName: TextInputLayout
    private lateinit var textInputLayoutPassword: TextInputLayout
    private lateinit var textInputLayoutConfirmPassword: TextInputLayout

    private lateinit var textInputEditTextUserFName: TextInputEditText
    private lateinit var textInputEditTextUserLName: TextInputEditText
    private lateinit var textInputEditTextPassword: TextInputEditText
    private lateinit var textInputEditTextConfirmPassword: TextInputEditText

    private lateinit var appCompatButtonAddUser: AppCompatButton

    private lateinit var inputValidation: LoginInputValidationActivity
    private lateinit var databaseHandler: DatabaseHandler

    private lateinit var user_name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_user)

        initViews()

        initListeners()

        initObjects()

        setSupportActionBar(toolbar)
//        this.supportActionBar!!.title = "Add User"

//        val toggle = ActionBarDrawerToggle(
//                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
//        drawer_layout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        nav_view.setNavigationItemSelectedListener(this)
    }

    /**
     * This method is to initialize views
     */
    private fun initViews() {
        nestedScrollView = findViewById<View>(R.id.nestedScrollView) as NestedScrollView

        textInputLayoutUserFName = findViewById<View>(R.id.textInputLayoutUserFName) as TextInputLayout
        textInputLayoutUserLName = findViewById<View>(R.id.textInputLayoutUserLName) as TextInputLayout
        textInputLayoutPassword = findViewById<View>(R.id.textInputLayoutPassword) as TextInputLayout
        textInputLayoutConfirmPassword = findViewById<View>(R.id.textInputLayoutConfirmPassword) as TextInputLayout

        textInputEditTextUserFName = findViewById<View>(R.id.textInputEditTextUserFName) as TextInputEditText
        textInputEditTextUserLName = findViewById<View>(R.id.textInputEditTextUserLName) as TextInputEditText
        textInputEditTextPassword = findViewById<View>(R.id.textInputEditTextPassword) as TextInputEditText
        textInputEditTextConfirmPassword = findViewById<View>(R.id.textInputEditTextConfirmPassword) as TextInputEditText

        appCompatButtonAddUser = findViewById<View>(R.id.appCompatButtonAddUser) as AppCompatButton

        user_name = textInputEditTextUserFName.toString() + textInputEditTextUserLName.toString()
    }

    /**
     * This method is to initialize listeners
     */
    private fun initListeners() {
        appCompatButtonAddUser!!.setOnClickListener(this)

    }

    /**
     * This method is to initialize objects to be used
     */
    private fun initObjects() {
        inputValidation = LoginInputValidationActivity(activity)
        databaseHandler = DatabaseHandler(activity)
    }


    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    override fun onClick(v: View) {
        when (v.id) {

            R.id.appCompatButtonAddUser -> postDataToSQLite()
        }
    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private fun postDataToSQLite() {
        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextUserFName, textInputLayoutUserFName, getString(R.string.error_message_name))) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextUserLName, textInputLayoutUserLName, getString(R.string.error_message_name))) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return
        }
        if (!inputValidation!!.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                        textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
            return
        }

        if (!databaseHandler!!.checkUser(user_name.trim())) {

            var user = User(fName = textInputEditTextUserFName!!.text.toString().trim(),
                    lName = textInputEditTextUserLName!!.text.toString().trim(),
                    userName =user_name.trim(),
                    password = textInputEditTextPassword!!.text.toString().trim(),
                    contractType = "", emailAddress = "", employeeNumber = "", id = -1, userType = "", mobilePhone = "", homeAddress = "",
                    loggedIn = false, monAvail = true, tueAvail = true, wedAvail = true, thuAvail = true, friAvail = true, satAvail = true, sunAvail = true,
                    homePhone = "")


            databaseHandler!!.addUser(user)

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView!!, getString(R.string.success_message), Snackbar.LENGTH_LONG).show()
            emptyInputEditText()


        }


    }

    /**
     * This method is to empty all input edit text
     */
    private fun emptyInputEditText() {
        textInputEditTextUserFName!!.text = null
        textInputEditTextUserLName!!.text = null
        textInputEditTextPassword!!.text = null
        textInputEditTextConfirmPassword!!.text = null
    }

    /**
     * Navigation menu
     */
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
                var intent= Intent(this,AddUserActivity::class.java)
                startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}