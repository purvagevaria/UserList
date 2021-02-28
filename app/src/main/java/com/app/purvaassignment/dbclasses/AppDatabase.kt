package com.app.purvaassignment.dbclasses

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.app.assignment.dbclasses.daoclasses.DAOUser
import com.app.purvaassignment.dbclasses.enitity.UserEntity


@Database(
    entities = arrayOf(
        UserEntity::class
    ),
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun daoUser(): DAOUser

    companion object {
        private const val DB_NAME = "purvaapp.db"

        @Volatile
        var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context?): AppDatabase? {
            if (instance == null) {
                instance = create(context)
            }
            return instance
        }

        fun create(context: Context?): AppDatabase? {
            return Room.databaseBuilder<AppDatabase>(context!!, AppDatabase::class.java, DB_NAME)
                .allowMainThreadQueries().build()
        }
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearAllTables() {

    }
}