package workitout.workitout

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

/**
 * This class manages the Database aspects of the program. It has methods to add users,
 * update user information, check for duplicate users, and to fetch the total list of
 * users present in the database. This runs off of an extension to SQLiteOpenHelper to manage
 * creation and version management.
 * @author Donna
 * @author Chris
 */
class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {

        private val DATABASE_VERSION = 1

        private val DATABASE_NAME = "WorkItOut.db"

        private val TABLE_USER = "user"

        private val COLUMN_USER_ID = "user_id"
        private val COLUMN_USER_F_NAME = "user_f_name"
        private val COLUMN_USER_L_NAME = "user_l_name"
        private val COLUMN_USER_NAME = "user_name"
        private val COLUMN_USER_PASSWORD = "user_password"
        private val COLUMN_USER_EMAIL_Address = "user_email_address"
        private val COLUMN_USER_HOME_Address = "user_home_address"
        private val COLUMN_USER_HOME_PHONE = "user_home_phone"
        private val COLUMN_USER_MOBILE_PHONE = "user_mobile_phone"
        private val COLUMN_USER_TYPE = "user_type"
        private val COLUMN_EMPLOYEE_NUMBER = "employee_number"
        private val COLUMN_CONTRACT_TYPE = "contract_type"
        private val COLUMN_LOGGED_IN = "logged_in"
        private val COLUMN_MONDAY_AVAIL = "monday_avail"
        private val COLUMN_TUESDAY_AVAIL = "tuesday_avail"
        private val COLUMN_WEDNESDAY_AVAIL = "wednesday_avail"
        private val COLUMN_THURSDAY_AVAIL = "thursday_avail"
        private val COLUMN_FRIDAY_AVAIL = "friday_avail"
        private val COLUMN_SATURDAY_AVAIL = "saturday_avail"
        private val COLUMN_SUNDAY_AVAIL = "sunday_avail"

        private val TABLE_WORKINFO = "workInfo"

        private val WORKINFO_ID = "workinfo_id" //primary key
        private val WORKINFO_USER_ID = "workinfo_user_id" //foreign key
        private val WORKINFO_EMPLOYEE_NAME = "employeename"
        private val WORKINFO_COLUMN_MON = "monday"
        private val WORKINFO_COLUMN_TUE = "tuesday"
        private val WORKINFO_COLUMN_WED = "wednesday"
        private val WORKINFO_COLUMN_THU = "thurday"
        private val WORKINFO_COLUMN_FRI = "friday"
        private val WORKINFO_COLUMN_SAT = "saturday"
        private val WORKINFO_COLUMN_SUN = "sunday"
        private val WORKINFO_COLUMN_EXTRA = "extra"

        private val WORKINFO_COLUMN_START_TIME = "starttime"
        private val WORKINFO_COLUMN_END_TIME = "endtime"

        private val WORKINFO_COLUMN_WORKINFORMATION = "workinformation"
    }

    private val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_F_NAME + " TEXT,"
            + COLUMN_USER_L_NAME + " TEXT," + COLUMN_USER_NAME + " TEXT," + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_TYPE + " TEXT,"
            + COLUMN_EMPLOYEE_NUMBER + " TEXT," + COLUMN_USER_HOME_PHONE + " TEXT," + COLUMN_USER_MOBILE_PHONE + " TEXT,"
            + COLUMN_USER_EMAIL_Address + " TEXT," + COLUMN_USER_HOME_Address + " TEXT," + COLUMN_CONTRACT_TYPE + " TEXT,"
            + COLUMN_LOGGED_IN + " INTEGER," + COLUMN_MONDAY_AVAIL + " INTEGER," + COLUMN_TUESDAY_AVAIL + " INTEGER," + COLUMN_WEDNESDAY_AVAIL + " INTEGER,"
            + COLUMN_THURSDAY_AVAIL + " INTEGER," + COLUMN_FRIDAY_AVAIL + " INTEGER," + COLUMN_SATURDAY_AVAIL + " INTEGER," + COLUMN_SUNDAY_AVAIL + " INTEGER" + ");")

    private val CREATE_USER_TABLE2 = ("CREATE TABLE" + TABLE_WORKINFO +" ("+ WORKINFO_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + WORKINFO_EMPLOYEE_NAME + " VARCHAR(256)"
            + WORKINFO_COLUMN_MON + " VARCHAR(256)"  + WORKINFO_COLUMN_START_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_END_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_WORKINFORMATION + "TEXT"
            + WORKINFO_COLUMN_TUE + " VARCHAR(256)"  + WORKINFO_COLUMN_START_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_END_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_WORKINFORMATION + "TEXT"
            + WORKINFO_COLUMN_WED + " VARCHAR(256)"  + WORKINFO_COLUMN_START_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_END_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_WORKINFORMATION + "TEXT"
            + WORKINFO_COLUMN_THU + " VARCHAR(256)"  + WORKINFO_COLUMN_START_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_END_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_WORKINFORMATION + "TEXT"
            + WORKINFO_COLUMN_FRI + " VARCHAR(256)"  + WORKINFO_COLUMN_START_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_END_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_WORKINFORMATION + "TEXT"
            + WORKINFO_COLUMN_SAT + " VARCHAR(256)"  + WORKINFO_COLUMN_START_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_END_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_WORKINFORMATION + "TEXT"
            + WORKINFO_COLUMN_SUN + " VARCHAR(256)"  + WORKINFO_COLUMN_START_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_END_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_WORKINFORMATION + "TEXT"
            + WORKINFO_COLUMN_EXTRA + " VARCHAR(256)"  + WORKINFO_COLUMN_START_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_END_TIME + " VARCHAR(256)" + WORKINFO_COLUMN_WORKINFORMATION + "TEXT"
            + ");")


    private val DROP_USER_TABLE = "DROP TABLE IF EXISTS $TABLE_USER"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_USER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_USER_TABLE)
        onCreate(db)
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    fun getAllUser(): List<User> {

        val columns = arrayOf( COLUMN_USER_ID, COLUMN_USER_F_NAME, COLUMN_USER_L_NAME, COLUMN_USER_NAME, COLUMN_USER_PASSWORD, COLUMN_USER_EMAIL_Address,
                COLUMN_USER_HOME_Address, COLUMN_USER_HOME_PHONE, COLUMN_USER_MOBILE_PHONE, COLUMN_USER_TYPE, COLUMN_EMPLOYEE_NUMBER, COLUMN_CONTRACT_TYPE, COLUMN_LOGGED_IN,
                COLUMN_MONDAY_AVAIL, COLUMN_TUESDAY_AVAIL, COLUMN_WEDNESDAY_AVAIL, COLUMN_THURSDAY_AVAIL, COLUMN_FRIDAY_AVAIL, COLUMN_SATURDAY_AVAIL, COLUMN_SUNDAY_AVAIL)

        val sortOrder = "$COLUMN_USER_NAME ASC"
        val userList = ArrayList<User>()

        val db = this.readableDatabase

        val cursor = db.query(TABLE_USER, columns,null,null,null,null,sortOrder)

        if (cursor.moveToFirst()) {
            do {
                val user = User(id = cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID)).toInt(),
                        fName = cursor.getString(cursor.getColumnIndex(COLUMN_USER_F_NAME)),
                        lName = cursor.getString(cursor.getColumnIndex(COLUMN_USER_L_NAME)),
                        userName = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)),
                        password = cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)),
                        emailAddress = cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL_Address)),
                        homeAddress = cursor.getString(cursor.getColumnIndex(COLUMN_USER_HOME_Address)),
                        homePhone = cursor.getString(cursor.getColumnIndex(COLUMN_USER_HOME_PHONE)),
                        mobilePhone = cursor.getString(cursor.getColumnIndex(COLUMN_USER_MOBILE_PHONE)),
                        userType = cursor.getString(cursor.getColumnIndex(COLUMN_USER_TYPE)),
                        employeeNumber = cursor.getString(cursor.getColumnIndex(COLUMN_EMPLOYEE_NUMBER)),
                        contractType = cursor.getString(cursor.getColumnIndex(COLUMN_CONTRACT_TYPE)),
                        loggedIn = cursor.getString(cursor.getColumnIndex(COLUMN_LOGGED_IN))!!.toBoolean(),
                        monAvail = cursor.getString(cursor.getColumnIndex(COLUMN_MONDAY_AVAIL))!!.toBoolean(),
                        tueAvail = cursor.getString(cursor.getColumnIndex(COLUMN_TUESDAY_AVAIL))!!.toBoolean(),
                        wedAvail = cursor.getString(cursor.getColumnIndex(COLUMN_WEDNESDAY_AVAIL))!!.toBoolean(),
                        thuAvail = cursor.getString(cursor.getColumnIndex(COLUMN_THURSDAY_AVAIL))!!.toBoolean(),
                        friAvail = cursor.getString(cursor.getColumnIndex(COLUMN_FRIDAY_AVAIL))!!.toBoolean(),
                        satAvail = cursor.getString(cursor.getColumnIndex(COLUMN_SATURDAY_AVAIL))!!.toBoolean(),
                        sunAvail = cursor.getString(cursor.getColumnIndex(COLUMN_SUNDAY_AVAIL))!!.toBoolean()
                )
                userList.add(user)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return userList
    }


    /**
     * This method is to create user record
     *
     * @param user
     */
    fun addUser(user: User) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_USER_F_NAME, user.fName)
        values.put(COLUMN_USER_L_NAME, user.lName)
        values.put(COLUMN_USER_NAME, user.fName + user.lName)
        values.put(COLUMN_USER_PASSWORD, user.password)
        values.put(COLUMN_USER_EMAIL_Address, user.emailAddress)
        values.put(COLUMN_USER_HOME_Address, user.homeAddress)
        values.put(COLUMN_USER_HOME_PHONE, user.homePhone)
        values.put(COLUMN_USER_MOBILE_PHONE, user.mobilePhone)
        values.put(COLUMN_USER_TYPE, user.userType)
        values.put(COLUMN_EMPLOYEE_NUMBER, user.employeeNumber)
        values.put(COLUMN_CONTRACT_TYPE, user.contractType)
        values.put(COLUMN_LOGGED_IN, user.loggedIn)
        values.put(COLUMN_MONDAY_AVAIL, user.monAvail)
        values.put(COLUMN_TUESDAY_AVAIL, user.tueAvail)
        values.put(COLUMN_WEDNESDAY_AVAIL, user.wedAvail)
        values.put(COLUMN_THURSDAY_AVAIL, user.thuAvail)
        values.put(COLUMN_FRIDAY_AVAIL, user.friAvail)
        values.put(COLUMN_SATURDAY_AVAIL, user.satAvail)
        values.put(COLUMN_SUNDAY_AVAIL, user.sunAvail)

        db.insert(TABLE_USER, null, values)
        db.close()
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    fun updateUser(user: User) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_USER_F_NAME, user.fName)
        values.put(COLUMN_USER_L_NAME, user.lName)
        values.put(COLUMN_USER_NAME, user.fName + user.lName)
        values.put(COLUMN_USER_PASSWORD, user.password)
        values.put(COLUMN_USER_EMAIL_Address, user.emailAddress)
        values.put(COLUMN_USER_HOME_Address, user.homeAddress)
        values.put(COLUMN_USER_HOME_PHONE, user.homePhone)
        values.put(COLUMN_USER_MOBILE_PHONE, user.mobilePhone)
        values.put(COLUMN_USER_TYPE, user.userType)
        values.put(COLUMN_EMPLOYEE_NUMBER, user.employeeNumber)
        values.put(COLUMN_CONTRACT_TYPE, user.contractType)
        values.put(COLUMN_LOGGED_IN, user.loggedIn)
        values.put(COLUMN_MONDAY_AVAIL, user.monAvail)
        values.put(COLUMN_TUESDAY_AVAIL, user.tueAvail)
        values.put(COLUMN_WEDNESDAY_AVAIL, user.wedAvail)
        values.put(COLUMN_THURSDAY_AVAIL, user.thuAvail)
        values.put(COLUMN_FRIDAY_AVAIL, user.friAvail)
        values.put(COLUMN_SATURDAY_AVAIL, user.satAvail)
        values.put(COLUMN_SUNDAY_AVAIL, user.sunAvail)

        db.update(TABLE_USER, values, "$COLUMN_USER_ID = ?",
                arrayOf(user.id.toString()))
        db.close()
    }

    /**
     * This method to update user availability
     *by taking in username and toggle buttons state
     */
    fun updateAvailability(username: String, monday: Int, tuesday: Int, wednesday: Int, thursday: Int, friday: Int, saturday: Int, sunday: Int) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_USER_NAME, username)
        values.put(COLUMN_MONDAY_AVAIL, monday)
        values.put(COLUMN_TUESDAY_AVAIL, tuesday)
        values.put(COLUMN_WEDNESDAY_AVAIL, wednesday)
        values.put(COLUMN_THURSDAY_AVAIL, thursday)
        values.put(COLUMN_FRIDAY_AVAIL, friday)
        values.put(COLUMN_SATURDAY_AVAIL, saturday)
        values.put(COLUMN_SUNDAY_AVAIL, sunday)


        db.update(TABLE_USER, values, "$COLUMN_USER_ID = ?",
                arrayOf(username.toString()))
        db.close()
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    fun deleteUser(user: User) {

        val db = this.writableDatabase

        db.delete(TABLE_USER, "$COLUMN_USER_ID = ?",
                arrayOf(user.id.toString()))
        db.close()
    }

    /**
     * This method to check user exist or not
     *
     * @param userName
     * @return true/false
     */
    fun checkUser(userName: String): Boolean {

        val columns = arrayOf(COLUMN_USER_NAME)
        val db = this.readableDatabase

        val selection = "$COLUMN_USER_NAME = ?"

        val selectionArgs = arrayOf(userName)

        val cursor = db.query(TABLE_USER, columns, selection, selectionArgs,null,null,null)


        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }

        return false
    }


    /**
     * This method to check user exist or not
     *
     * @param userNAme
     * @param password
     * @return true/false
     */
    fun checkUser(uName: String, password: String): Boolean {

        val columns = arrayOf(COLUMN_USER_NAME)

        val db = this.readableDatabase

        val selection = "$COLUMN_USER_NAME = ? AND $COLUMN_USER_PASSWORD = ?"

        val selectionArgs = arrayOf(uName, password)

        val cursor = db.query(TABLE_USER,columns,selection,selectionArgs,null,null,null)

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0)
            return true

        return false
    }

    /**
     * DefaultUserAdmin
     * Demo Method
     * Add user
     *
     */
    fun addUser(){
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(DatabaseHandler.COLUMN_USER_F_NAME, "Ad")
        values.put(DatabaseHandler.COLUMN_USER_L_NAME, "min")
        values.put(DatabaseHandler.COLUMN_USER_NAME, "Admin")
        values.put(DatabaseHandler.COLUMN_USER_PASSWORD, "password")
        values.put(DatabaseHandler.COLUMN_USER_EMAIL_Address, "abc@dfg.com")
        values.put(DatabaseHandler.COLUMN_USER_HOME_Address, "")
        values.put(DatabaseHandler.COLUMN_USER_HOME_PHONE, "01234567")
        values.put(DatabaseHandler.COLUMN_USER_MOBILE_PHONE, "")
        values.put(DatabaseHandler.COLUMN_USER_TYPE, Role.EMPLOYER.role)
        values.put(DatabaseHandler.COLUMN_EMPLOYEE_NUMBER, "")
        values.put(DatabaseHandler.COLUMN_CONTRACT_TYPE, ContractType.Employer.contractType)
        values.put(DatabaseHandler.COLUMN_LOGGED_IN, false)
        values.put(DatabaseHandler.COLUMN_MONDAY_AVAIL, true)
        values.put(DatabaseHandler.COLUMN_TUESDAY_AVAIL, true)
        values.put(DatabaseHandler.COLUMN_WEDNESDAY_AVAIL, true)
        values.put(DatabaseHandler.COLUMN_THURSDAY_AVAIL, true)
        values.put(DatabaseHandler.COLUMN_FRIDAY_AVAIL, true)
        values.put(DatabaseHandler.COLUMN_SATURDAY_AVAIL, true)
        values.put(DatabaseHandler.COLUMN_SUNDAY_AVAIL, true)

        println("Database add user test")

        db.insert(TABLE_USER, null, values)
        db.close()
    }

    fun insertWeekdayWork(user: User){

        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(DatabaseHandler.WORKINFO_EMPLOYEE_NAME, "employee_name")
        cv.put(DatabaseHandler.WORKINFO_COLUMN_MON, "monday")
        cv.put(DatabaseHandler.WORKINFO_COLUMN_WED, "tuesday")
        cv.put(DatabaseHandler.WORKINFO_COLUMN_WED, "wednesday")
        cv.put(DatabaseHandler.WORKINFO_COLUMN_THU, "thursday")
        cv.put(DatabaseHandler.WORKINFO_COLUMN_FRI, "friday")
        cv.put(DatabaseHandler.WORKINFO_COLUMN_SAT, "saturday")
        cv.put(DatabaseHandler.WORKINFO_COLUMN_SUN, "sunday")
        cv.put(DatabaseHandler.WORKINFO_COLUMN_EXTRA, "extra")
        cv.put(DatabaseHandler.WORKINFO_COLUMN_START_TIME, "starttime")
        cv.put(DatabaseHandler.WORKINFO_COLUMN_END_TIME, "endtime")
        cv.put(DatabaseHandler.WORKINFO_COLUMN_WORKINFORMATION, "workinformation")
        db.insert(TABLE_WORKINFO, null, cv)

        //val result = db.insert(TABLE_WORKINFO, nullColumnHack: null, cv)
        //if(result = -1.toLong())
            //Toast.makeText(context, text:"Failed", Toast.LENGTH_SHORT).show()
        //else
            //Toast.makeText(context, text:"Success", Toast.LENGTH_SHORT).show()
        db.close()
    }

}