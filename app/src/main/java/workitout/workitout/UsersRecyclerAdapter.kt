package workitout.workitout

import android.content.Context
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
class UsersRecyclerAdapter(private val listUsers: List<User>, val context: Context) : RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // inflating recycler item view
        val itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_user_recycler, parent, false)

        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.textViewFName.text = listUsers[position].fName
        holder.textViewLName.text = listUsers[position].lName
        holder.textViewPassword.text = listUsers[position].password
    }

    override fun getItemCount(): Int {
        return listUsers.size
    }


    /**
     * ViewHolder class
     */
    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewFName: AppCompatTextView
        var textViewLName: AppCompatTextView
        var textViewPassword: AppCompatTextView

        init {
            textViewFName = view.findViewById<View>(R.id.textViewFName) as AppCompatTextView
            textViewLName = view.findViewById<View>(R.id.textViewLName) as AppCompatTextView
            textViewPassword = view.findViewById<View>(R.id.textViewPassword) as AppCompatTextView
        }
    }


}