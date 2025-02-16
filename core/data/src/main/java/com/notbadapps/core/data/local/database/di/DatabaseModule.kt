package com.notbadapps.core.data.local.database.di

import android.content.Context
import androidx.room.Room
import com.notbadapps.core.data.local.database.AppDatabase
import com.notbadapps.core.data.local.database.DatabaseDataSource
import com.notbadapps.core.data.local.database.DatabaseDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideInkDatabase(
        @ApplicationContext applicationContext: Context,
    ): AppDatabase {
        return Room.databaseBuilder(
            context = applicationContext,
            klass = AppDatabase::class.java,
            name = AppDatabase.DATABASE_NAME,
        ).build()
    }

    @Provides
    @Singleton
    fun provideDatabaseDataSource(
        database: AppDatabase,
    ): DatabaseDataSource {
        return DatabaseDataSourceImpl(database)
    }
}