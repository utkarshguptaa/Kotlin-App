package com.guppi.bookhub.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.guppi.bookhub.BookDao

@Database(entities = [BookEntity::class], version = 1)
abstract class BookDatabase() {

    abstract fun bookDao():BookDao
}