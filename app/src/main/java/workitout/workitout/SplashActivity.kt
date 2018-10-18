package workitout.workitout

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

/**
 * This actiity, connected to activity_splash.xml, creates a simple
 * login splash that displays when the app is initially launched. It
 * defines a specific length of time for the splash to fade in, hold,
 * and fade out.
 * @author Donna
 */
class SplashActivity : AppCompatActivity() {
    private var delayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 2000 //2 seconds

    internal val runnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Initialize the Handler
        delayHandler = Handler()

        //Navigate with delay
        delayHandler!!.postDelayed(runnable, SPLASH_DELAY)

    }

    public override fun onDestroy() {

        if (delayHandler != null) {
            delayHandler!!.removeCallbacks(runnable)
        }

        super.onDestroy()
    }

}