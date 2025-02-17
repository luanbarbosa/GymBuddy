package com.notbadapps.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.notbadapps.core.data.local.database.dao.RoutineDao
import com.notbadapps.core.data.local.database.model.ExerciseDto
import com.notbadapps.core.data.local.database.model.RoutineDto

@Database(
    entities = [RoutineDto::class,  ExerciseDto::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun routineDao(): RoutineDao

    companion object {
        const val DATABASE_NAME = "app-database.db"
    }
}