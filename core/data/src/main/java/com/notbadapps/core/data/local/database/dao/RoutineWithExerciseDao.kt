package com.notbadapps.core.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.notbadapps.core.data.local.database.model.RoutineDto
import com.notbadapps.core.data.local.database.model.RoutineWithExerciseDto

@Dao
interface RoutineWithExerciseDao {

    @Transaction
    @Query("SELECT * FROM routine_with_exercise")
    suspend fun getAll(): List<RoutineWithExerciseDto>

    @Transaction
    @Insert
    suspend fun insert(routine: RoutineWithExerciseDto)
}