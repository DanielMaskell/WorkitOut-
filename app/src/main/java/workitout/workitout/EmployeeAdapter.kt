package workitout.workitout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_block.view.*

class EmployeeAdapter(con:Context, arrList:ArrayList<EmployeeDetails>): BaseAdapter() {

    var arrayList = ArrayList<EmployeeDetails>()
    var context: Context? = null
    var myInflater: LayoutInflater? = null

    init {

        this.context    = con
        this.myInflater = LayoutInflater.from(context)
        this.arrayList  = arrList
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var myView = myInflater!!.inflate(R.layout.list_block,null)
        var conObj = arrayList[p0]

        var full_name : String = conObj.fName.toString() +" "+ conObj.lName.toString()
        myView.contact_name.text = full_name
        return myView
    }

    override fun getItem(p0: Int): Any {
        return arrayList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }
}