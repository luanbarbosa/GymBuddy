package com.notbadapps.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.notbadapps.core.data.local.database.dao.ExerciseDao
import com.notbadapps.core.data.local.database.dao.RoutineDao
import com.notbadapps.core.data.local.database.dao.RoutineWithExerciseDao
import com.notbadapps.core.data.local.database.model.ExerciseDto
import com.notbadapps.core.data.local.database.model.RoutineDto
import com.notbadapps.core.data.local.database.model.RoutineWithExerciseDto

@Database(
    entities = [ExerciseDto::class,  RoutineDto::class, RoutineWithExerciseDto::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
    abstract fun routineDao(): RoutineDao
    abstract fun routineWithExerciseDao(): RoutineWithExerciseDao

    companion object {
        const val DATABASE_NAME = "app-database.db"
    }
}