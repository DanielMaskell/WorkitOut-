package workitout.workitout

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.content.ContentValues
import android.database.sqlite.SQLiteQueryBuilder
import java.util.ArrayList

class DatabaseHandler : SQLiteOpenHelper {

    companion object {
        val Tag = "DatabaseHandler"
        val DBName = "EmployeeDB"
        val DBVersion = 1
        val tableName = "employeeTable"

        val employeeID = "employee_id"
        val fName = "f_name"
        val lName = "l_name"
        val password = "password"
        val mondayAvail = "monday_avail"
        val tuesdayAvail = "tuesday_avail"
        val wednesdayAvail = "wednesday_avail"
        val thursdayAvail = "thursday_avail"
        val fridayAvail = "friday_avail"
        val saturdayAvail = "saturday_avail"
        val sundayAvail = "sunday_avail"
        val homePhone = "home_phone"
        val mobilePhone = "mobile_phone"
        val homeAddress = "home_address"
        val emailAddress = "email_address"
        //val role = "role"
    }

    var context: Context? = null
    var sqlObj: SQLiteDatabase

    constructor(context: Context) : super(context, DBName, null, DBVersion) {
        this.context = context
        sqlObj = this.writableDatabase
    }

    override fun onCreate(p0: SQLiteDatabase?) {
//SQL for creating table
        var createSQL: String = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(" + employeeID + " INTEGER PRIMARY KEY," +
                fName + " TEXT, " + lName + " TEXT, " + password +
                " TEXT," + mondayAvail + " TEXT, " + tuesdayAvail + " TEXT, " + wednesdayAvail +
                " TEXT," + thursdayAvail + " TEXT, " + fridayAvail + " TEXT, " + saturdayAvail +
                " TEXT," + sundayAvail + " TEXT, " + homePhone + " TEXT, " + mobilePhone +
                " TEXT," + homeAddress + " TEXT, " + emailAddress + " TEXT );" // role +
        p0!!.execSQL(createSQL)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("Drop table IF EXISTS " + tableName)
        onCreate(p0)
    }

    fun Add(values: ContentValues): String {
        var msg: String = "error";
        val id = sqlObj!!.insert(tableName, "", values)
        if (id > 0) {
            msg = "ok"
        }
        return msg
    }

    fun Fetch(keyword: String): ArrayList<EmployeeDetails> {
        var arraylist = ArrayList<EmployeeDetails>()
        val sqb = SQLiteQueryBuilder()
        sqb.tables = tableName
        val cols = arrayOf("employee_id", "f_name", "l_name",
                "password", "monday_avail", "tuesday_avail", "wednesday_avail"
                , "thursday_avail", "friday_avail", "saturday_avail",
                "sunday_avail", "home_phone", "mobile_phone", "home_address", "email_address") //"role")
        val rowSelArg = arrayOf(keyword)
        val cur = sqb.query(sqlObj, cols, "f_name like ?", rowSelArg, null, null, "f_name")
        if (cur.moveToFirst()) {
            do {
                val employeeIDCursor = cur.getString(cur.getColumnIndex("employee_id"))
                val fNameCursor = cur.getString(cur.getColumnIndex("f_name"))
                val lNameCursor = cur.getString(cur.getColumnIndex("l_name"))
                val passwordCursor = cur.getString(cur.getColumnIndex("password"))
                val mondayAvailCursor = cur.getString(cur.getColumnIndex("monday_avail"))
                val tuesdayAvailCursor = cur.getString(cur.getColumnIndex("tuesday_avail"))
                val wednesdayAvailCursor = cur.getString(cur.getColumnIndex("wednesday_avail"))
                val thursdayAvailCursor = cur.getString(cur.getColumnIndex("thursday_avail"))
                val fridayAvailCursor = cur.getString(cur.getColumnIndex("friday_avail"))
                val saturdayAvailCursor = cur.getString(cur.getColumnIndex("saturday_avail"))
                val sundayAvailCursor = cur.getString(cur.getColumnIndex("sunday_avail"))
                val homePhoneCursor = cur.getString(cur.getColumnIndex("home_phone"))
                val mobilePhoneCursor = cur.getString(cur.getColumnIndex("mobile_phone"))
                val homeAddressCursor = cur.getString(cur.getColumnIndex("home_address"))
                val emailAddressCursor = cur.getString(cur.getColumnIndex("email_address"))
                //val roleCursor = Role.valueOf(cur.getString(cur.getColumnIndex("role")))
                arraylist.add(EmployeeDetails(employeeIDCursor, fNameCursor, lNameCursor, passwordCursor, mondayAvailCursor,
                        tuesdayAvailCursor, wednesdayAvailCursor, thursdayAvailCursor, fridayAvailCursor, saturdayAvailCursor,
                        sundayAvailCursor, homePhoneCursor, mobilePhoneCursor, homeAddressCursor, emailAddressCursor))
            } while (cur.moveToNext())
        }
        var count: Int = arraylist.size
        return arraylist
    }

    fun Update(values: ContentValues, id: Int): String {
        var selectionArs = arrayOf(id.toString())
        val i = sqlObj!!.update(tableName, values, "employee_id=?", selectionArs)
        if (i > 0) {
            return "ok"
        } else {
            return "error"
        }
    }

    fun Remove(id: Int): String {
        var selectionArs = arrayOf(id.toString())
        val i = sqlObj!!.delete(tableName, "employee_id=?", selectionArs)
        if (i > 0) {
            return "ok"
        } else {
            return "error"
        }
    }

    /**
     * Check user with a certain ID exists or not
     * @param ID
     * @return True or False
     */
    fun checkUser(id: String): Boolean {
        val columns = arrayOf(employeeID)
        val db = this.readableDatabase

        val selection = "$employeeID = ?"

        val selectionArgs = arrayOf(id)

        val cursor = db.query(tableName, columns, selection, selectionArgs, null, null, null)

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }

        return false
    }

    /**
     * method checking user exist or not
     *
     * @param ID
     * @param password
     * @return true or false
     */
    fun checkUser(id: String, psw: String): Boolean {
        val columns = arrayOf(employeeID)
        val db = this.readableDatabase

        val selection = "$employeeID = ? AND $password = ?"

        val selectionArgs = arrayOf(id, psw)

        val cursor = db.query(tableName, columns, selection, selectionArgs, null, null, null)

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }

        return false
    }
}