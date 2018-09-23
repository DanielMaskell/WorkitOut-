package workitout.workitout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    //static id and password
    private val id="id"
    private val password="psw"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Login button
        buttonLogin.setOnClickListener {
            val inputLogin = textViewID.text.trim().toString()
            val inputPassword = textViewPassword.text.trim().toString()
            if(inputLogin==id && inputPassword==password) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Login Succeed", Toast.LENGTH_SHORT).show()
            }
            else {
                if (inputLogin.isNullOrEmpty() && inputPassword.isNullOrEmpty()) {
                    Toast.makeText(this, "Please enter the USER ID and PASSWORD", Toast.LENGTH_SHORT).show()
                }
                else if (inputLogin != id) {
                    Toast.makeText(this, "Wrong USER ID", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this, "Wrong PASSWORD", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
