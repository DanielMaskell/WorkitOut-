package workitout.workitout

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * This class is built around assisting the displaying of users. Its main
 * purpose is to take User objects and translate the information to the
 * required state to be displayed in the RecyclerView on UsersListActivity.
 * @author Donna
 * @author Chris
 */
class EmployeeAdapter(private val listUsers: List<User>) : RecyclerView.Adapter<EmployeeAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // inflating recycler item view
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user_recycler, parent, false)

        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.textViewName.text = listUsers[position].userName
        holder.textViewPassword.text = listUsers[position].password
    }

    override fun getItemCount(): Int {
        return listUsers.size
    }


    /**
     * ViewHolder class
     */
    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewName: AppCompatTextView
        var textViewPassword: AppCompatTextView

        init {
            textViewName = view.findViewById<View>(R.id.textViewName) as AppCompatTextView
            textViewPassword = view.findViewById<View>(R.id.textViewPassword) as AppCompatTextView
        }
    }


}