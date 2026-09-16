package com.codeshod.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codeshod.room.wallet.WalletDao
import com.codeshod.room.wallet.WalletEntity

const val DB_NAME = "track-it"

@Database(
    entities = [
        WalletEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTodoDao(): WalletDao

    companion object {
        private var DB_INSTANCE: AppDatabase? = null

        fun getAppDb(context: Context): AppDatabase {
            if (DB_INSTANCE == null) {
                DB_INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
            }
            return DB_INSTANCE!!
        }
    }
}