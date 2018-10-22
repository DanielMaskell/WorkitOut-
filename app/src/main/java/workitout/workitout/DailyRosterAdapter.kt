package workitout.workitout

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_block.view.*

/**
 * This class is the adapter for the recycler view in DailyRosterActivity
 * Referenced in DailyRosterActivity
 */

class DailyRosterAdapter(val users : ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder>(){
    override fun onBindViewHolder(p0: ViewHolder, p1: Int){
        p0?.viewItem?.text = users.get(p1)
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_block, p0, false))
    }

    override fun getItemCount(): Int{
        return users.size
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val viewItem = view.contact_name
}