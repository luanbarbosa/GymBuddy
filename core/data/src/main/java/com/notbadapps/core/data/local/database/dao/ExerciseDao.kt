package com.notbadapps.core.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.notbadapps.core.data.local.database.model.ExerciseDto

@Dao
interface ExerciseDao {

    @Transaction
    @Query("SELECT * FROM exercise")
    suspend fun getAll(): List<ExerciseDto>

    @Transaction
    @Insert
    suspend fun insert(exercise: ExerciseDto)
}