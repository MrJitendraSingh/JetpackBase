package com.cis.baseapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.cis.baseapp.data.pref.AppPreferences
import com.cis.baseapp.data.service.MainService
import com.cis.baseapp.data.room.Dao
import com.cis.baseapp.data.room.DataBase
import com.cis.baseapp.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    internal fun bindContext(application: Application): Context = application

    @Singleton
    @Provides
    internal fun providePreferenceSource(context: Context): AppPreferences = AppPreferences(context)


    @Singleton
    @Provides
    internal fun provideRoomDatabase(application: Application): DataBase =
        Room.databaseBuilder(
            application,
            DataBase::class.java,
            "table"
        ).fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    internal fun provideDao(dataBase: DataBase): Dao = dataBase.getDao()

    @Singleton
    @Provides
    fun provideApiService(): MainService {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MainService::class.java)
    }

}