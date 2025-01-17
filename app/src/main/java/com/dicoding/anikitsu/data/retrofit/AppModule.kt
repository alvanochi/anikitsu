package com.dicoding.anikitsu.data.retrofit

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.dicoding.anikitsu.data.AnimeRepository
import com.dicoding.anikitsu.data.AnimeRepositoryImpl
import com.dicoding.anikitsu.data.room.AnimeDao
import com.dicoding.anikitsu.data.room.AnimeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://kitsu.io/api/edge/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService, animeDao: AnimeDao): AnimeRepository {
        return AnimeRepositoryImpl(apiService, animeDao)
    }

    @Provides
    @Singleton
    fun provideAnimeDatabase(@ApplicationContext context: Context): AnimeDatabase {
        return Room.databaseBuilder(context, AnimeDatabase::class.java, "Anime.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideAnimeDao(database: AnimeDatabase): AnimeDao {
        return database.animeDao()
    }

}
