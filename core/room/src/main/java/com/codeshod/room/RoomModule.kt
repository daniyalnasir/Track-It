package com.codeshod.room

import android.content.Context
import com.codeshod.room.wallet.WalletDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase{
        return AppDatabase.getAppDb(context)
    }

    @Singleton
    @Provides
    fun provideTodoDao(db: AppDatabase): WalletDao {
        return db.getTodoDao()
    }
}