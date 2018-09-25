package workitout.workitout

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.AppCompatButton
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.exposed.sql.Database
import org.w3c.dom.Text
import kotlin.properties.Delegates

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val activity = this@LoginActivity

    private lateinit var nestedScrollView: NestedScrollView

    private lateinit var textInputLayoutID: TextInputLayout
    private lateinit var textInputLayoutPassword: TextInputLayout

    private lateinit var textInputEditTextID : TextInputEditText
    private lateinit var textInputEditTextPassword : TextInputEditText

    private lateinit var appCompatButtonLogin: AppCompatButton

    private var dbHandler: DatabaseHandler by Delegates.notNull()
    private var db: SQLiteDatabase by Delegates.notNull()
    private lateinit var inputValidation : LoginInputValidationActivity


//    //static id and password
//    private val id = "id"
//    private val password = "psw"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dbHandler = DatabaseHandler(this)
        db = dbHandler.writableDatabase
//        db = DatabaseHandler(null)
        dbHandler.addUser("admin", "admin", "admin")
//        db.Add(EmployeeAdapter)
        initViews()

        initListeners()

        initObjects()

//        //Login button
//        appCompatButtonLogin.setOnClickListener {
//            val inputLogin = textInputEditTextID.text!!.trim().toString()
//            val inputPassword = textInputEditTextPassword.text!!.trim().toString()
//            if (inputLogin == id && inputPassword == password) {
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                Toast.makeText(this, "Login Succeed", Toast.LENGTH_SHORT).show()
//            } else {
//                if (inputLogin.isNullOrEmpty() && inputPassword.isNullOrEmpty()) {
//                    Toast.makeText(this, "Please enter the USER ID and PASSWORD", Toast.LENGTH_SHORT).show()
//                } else if (inputLogin != id) {
//                    Toast.makeText(this, "Wrong USER ID", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this, "Wrong PASSWORD", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }

    private fun initViews() {
        nestedScrollView = findViewById<View>(R.id.nestedScrollView) as NestedScrollView

        textInputLayoutID =findViewById<View>(R.id.textInputLayoutID) as TextInputLayout
        textInputLayoutPassword =findViewById<View>(R.id.textInputLayoutPassword) as TextInputLayout

        textInputEditTextID =findViewById<View>(R.id.textInputEditTextID) as TextInputEditText
        textInputEditTextPassword = findViewById<View>(R.id.textInputEditTextPassword) as TextInputEditText

        appCompatButtonLogin =findViewById<View>(R.id.appCompatButtonLogin) as AppCompatButton
    }

    private fun initListeners() {

        appCompatButtonLogin!!.setOnClickListener(this)
    }

    private fun initObjects() {
        dbHandler = DatabaseHandler(activity)
        inputValidation = LoginInputValidationActivity(activity)
    }

    override fun onClick(v: View) {
        when (v.id) {

            //For Testing ONLY
//            R.id.appCompatButtonLogin -> postDataToSQLite()




            R.id.appCompatButtonLogin -> verifyFromSQLite()
        }
    }

    private fun verifyFromSQLite() {
        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextID!!, textInputLayoutID!!, getString(R.string.loginErrorMessage))){
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextPassword!!, textInputLayoutPassword!!, getString(R.string.loginErrorMessage))){
            return
        }

        if (dbHandler!!.checkUser(textInputEditTextID!!.text.toString().trim { it <= ' '}, textInputEditTextPassword!!.text.toString().trim { it <= ' ' })){
            val accountsIntent = Intent(activity, MainActivity::class.java)
            accountsIntent.putExtra("ID", textInputEditTextID!!.text.toString().trim { it <= ' ' })
            emptyInputEditText()
            startActivity(accountsIntent)
        }
        else {
            Snackbar.make(nestedScrollView!!, getString(R.string.loginErrorMessage), Snackbar.LENGTH_LONG).show()
        }
    }

    private fun emptyInputEditText() {
        textInputEditTextID!!.text = null
        textInputEditTextPassword!!.text = null
    }

//    /**
//     * For login testing only
//     *
//     */
//    private fun postDataToSQLite(){
//        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextID!!, textInputLayoutID!!, getString(R.string.loginErrorMessage))){
//            return
//        }
//        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextPassword!!, textInputLayoutPassword!!, getString(R.string.loginErrorMessage))){
//            return
//        }
//
//        if(!db!!.checkUser(textInputEditTextID!!.text.toString().trim())) {
//            var user = EmployeeDetails(employeeID = "Donna")
//        }
//    }
}