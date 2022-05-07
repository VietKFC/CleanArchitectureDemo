package com.example.presentations

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule @Inject constructor(
    val application: Application
) {

    @Provides
    @Singleton
    fun provideApplication() = application
}
