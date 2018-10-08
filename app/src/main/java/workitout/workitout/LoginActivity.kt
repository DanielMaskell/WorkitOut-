package workitout.workitout
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.view.View
import kotlinx.android.synthetic.main.activity_login.view.*
import org.jetbrains.exposed.sql.Database
import workitout.workitout.R.id.appCompatButtonLogin
import kotlin.properties.Delegates


class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val activity = this@LoginActivity

    private lateinit var nestedScrollView: NestedScrollView

    private lateinit var textInputLayoutUserName: TextInputLayout
    private lateinit var textInputLayoutPassword: TextInputLayout

    private lateinit var textInputEditTextUserName: TextInputEditText
    private lateinit var textInputEditTextPassword: TextInputEditText

    private lateinit var appCompatButtonLogin: AppCompatButton

    private lateinit var inputValidation: LoginInputValidationActivity
    private var databaseHelper: DatabaseHandler by Delegates.notNull()
    private var db: SQLiteDatabase by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        databaseHelper = DatabaseHandler(this)
        db = databaseHelper.writableDatabase
        databaseHelper.addUser()

        initViews()

        initListeners()

        initObjects()
    }

    /**
     * This method is to initialize views
     */
    private fun initViews() {

        nestedScrollView = findViewById<View>(R.id.nestedScrollView) as NestedScrollView

        textInputLayoutUserName = findViewById<View>(R.id.textInputLayoutUserName) as TextInputLayout
        textInputLayoutPassword = findViewById<View>(R.id.textInputLayoutPassword) as TextInputLayout

        textInputEditTextUserName = findViewById<View>(R.id.textInputEditTextUserName) as TextInputEditText
        textInputEditTextPassword = findViewById<View>(R.id.textInputEditTextPassword) as TextInputEditText

        appCompatButtonLogin = findViewById<View>(R.id.appCompatButtonLogin) as AppCompatButton
    }

    /**
     * This method is to initialize listeners
     */
    private fun initListeners() {

        appCompatButtonLogin!!.setOnClickListener(this)
    }

    /**
     * This method is to initialize objects to be used
     */
    private fun initObjects() {

        databaseHelper = DatabaseHandler(activity)
        inputValidation = LoginInputValidationActivity(activity)

    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    override fun onClick(v: View) {
        when (v.id) {
            R.id.appCompatButtonLogin -> verifyFromSQLite()
        }
    }

    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    private fun verifyFromSQLite() {

        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextUserName!!, textInputLayoutUserName!!, getString(R.string.error_message_name))) {
            return
        }

        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextPassword!!, textInputLayoutPassword!!, getString(R.string.error_message_password))) {
            return
        }

        if (databaseHelper!!.checkUser(textInputEditTextUserName!!.text.toString().trim { it <= ' ' }, textInputEditTextPassword!!.text.toString().trim { it <= ' ' })) {


            val accountsIntent = Intent(activity, MainActivity::class.java)
            accountsIntent.putExtra("UserName", textInputEditTextUserName!!.text.toString().trim { it <= ' ' })
            emptyInputEditText()
            startActivity(accountsIntent)


        } else {

            // Snack Bar to show success message that record is wrong
            Snackbar.make(nestedScrollView!!, getString(R.string.error_valid_username_password), Snackbar.LENGTH_LONG).show()
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private fun emptyInputEditText() {
        textInputEditTextUserName!!.text = null
        textInputEditTextPassword!!.text = null
    }
}