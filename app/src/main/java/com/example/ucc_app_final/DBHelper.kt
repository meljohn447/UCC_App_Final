package com.example.ucc_app_final

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // below is a sqlite query, where column names
        // along with their data types is given
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CCODE_COl + " TEXT, " +
                CNAME_COl + " TEXT, " +
                CREDITS_COL + " TEXT, " +
                PREREC_COL + " TEXT, " +
                DESCR_COL + " TEXT " + " ) ")

        // we are calling sqlite
        // method for executing our query
        db.execSQL(query)
// db.execSQL("INSERT INTO TABLT_NAME(CCODE_COl, CNAME_COl, CREDITS_COL,PREREC_COL,DESCR_COL ) VALUES('ITTO203', 'Data Structure', '3', 'Math, English', 'Good It course')")

    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // This method is for adding data in our database
    fun addName(ccode : String, cname : String, credits : String, prerec : String, description : String){
        // below we are creating
        // a content values variable
        val values = ContentValues()
        // we are inserting our values
        // in the form of key-value pair
        values.put(CCODE_COl, ccode)
        values.put(CNAME_COl, cname)
        values.put(CREDITS_COL, credits)
        values.put(PREREC_COL, prerec)
        values.put(DESCR_COL, description)

        // here we are creating a
        // writable variable of
        // our database as we want to
        // insert value in our database
        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(TABLE_NAME, null, values)

        // at last we are
        // closing our database
        db.close()
    }

    // below method is to get
    // all data from our database
//    fun getName(): Cursor? {
//
//        // here we are creating a readable
//        // variable of our database
//        // as we want to read value from it
//        val db = this.readableDatabase
//
//        // below code returns a cursor to
//        // read data from the database
//        return db?.rawQuery("SELECT * FROM $TABLE_NAME", null)
//    }

    fun getName(): MutableList<CoursesCon> {
        val list : MutableList<CoursesCon> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_NAME"
        val result = db.rawQuery(query, null)
        if (result.moveToNext()){
            do {
                val courses = CoursesCon()
                courses.id = result.getString(0).toInt()
                courses.ccode = result.getString(1)
                courses.cname = result.getString(2)
                courses.credits = result.getString(3)
                courses.prerec = result.getString(4)
                courses.descreption = result.getString(5)
                list.add(courses)

            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    companion object{
        // here we have defined variables for our database

        // below is variable for database name
        private const val DATABASE_NAME = "GEEKS_FOR_GEEKS"

        // below is the variable for database version
        private const val DATABASE_VERSION = 1

        // below is the variable for table name
        const val TABLE_NAME = "courses_table"

        // below is the variable for id column
        const val ID_COL = "id"
        const val CCODE_COl = "ccode"
        const val CNAME_COl = "cname"
        const val CREDITS_COL = "credits"
        const val PREREC_COL = "prerec"
        const val DESCR_COL = "description"
    }
}
