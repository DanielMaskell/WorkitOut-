package workitout.workitout

import android.app.Activity
import android.content.Context
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

class LoginInputValidationActivity

/**
 * Constructor
 */
(private val context: Context) {

    /**
     * method checking if InputEditText filled
     * @param textInputEditText
     * @param textInputEditLayout
     * @param message
     * @return
     */

    fun isInputEditTextFilled(textInputEditText: TextInputEditText, textInputLayout: TextInputLayout, message: String): Boolean {
        val value = textInputEditText.text.toString().trim()
        if (value.isEmpty()) {
            textInputLayout.error = message
            hideKeyboardFrom(textInputEditText)
            return false
        } else {
            textInputLayout.isErrorEnabled = false
        }

        return true
    }

    /**
     * method checking InputEditText value matches
     * @param textInputEditText1
     * @param textInputEditText2
     * @param textInputLayout
     * @param message
     * @return
     */
    fun isInputEditTextMatches(textInputEditText1: TextInputEditText, textInputEditText2: TextInputEditText, textInputLayout: TextInputLayout, message: String): Boolean {
        val value1 = textInputEditText1.text.toString().trim()
        val value2 = textInputEditText2.text.toString().trim()
        if (!value1.contentEquals(value2)) {
            textInputLayout.error = message
            hideKeyboardFrom(textInputEditText2)
            return false
        } else {
            textInputLayout.isErrorEnabled = false
        }
        return false
    }

    private fun hideKeyboardFrom(view: View) {
        val i = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        i.hideSoftInputFromWindow(view.windowToken, WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}
