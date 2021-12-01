package com.mihir.dictionaryapp.featureDict.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.mihir.dictionaryapp.featureDict.data.local.Converters
import com.mihir.dictionaryapp.featureDict.data.local.WordInfoDao
import com.mihir.dictionaryapp.featureDict.data.local.WordInfoDatabase
import com.mihir.dictionaryapp.featureDict.data.remote.DictionaryApi
import com.mihir.dictionaryapp.featureDict.data.repository.WordInfoRepositoryImpl
import com.mihir.dictionaryapp.featureDict.data.util.GsonParser
import com.mihir.dictionaryapp.featureDict.domain.repo.WordInfoRepository
import com.mihir.dictionaryapp.featureDict.domain.use_cases.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun providesGetWordInfoUseCase(repository:WordInfoRepository):GetWordInfo{
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun providesWordInfoRepository(
        db:WordInfoDatabase,
        api:DictionaryApi
    ):WordInfoRepository{
        return WordInfoRepositoryImpl(api,db.dao)
    }

    @Provides
    @Singleton
    fun providesWordInfoDatabse(app:Application):WordInfoDatabase{
        return Room.databaseBuilder(app,WordInfoDatabase::class.java,"word_db")
            .addTypeConverter(Converters(GsonParser(Gson()))).build()
    }

    @Provides
    @Singleton
    fun providesDictApi():DictionaryApi{
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)

    }
}