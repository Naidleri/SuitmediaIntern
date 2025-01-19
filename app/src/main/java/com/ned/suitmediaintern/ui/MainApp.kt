package com.ned.suitmediaintern.ui

import android.app.Application
import com.ned.core.data.injection.repositoryModule
import com.ned.suitmediaintern.injection.useCaseModule
import com.ned.suitmediaintern.injection.viewModelModule
import org.koin.android.ext.koin.androidLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@MainApp)
            modules(
                listOf(
                    useCaseModule,
                    viewModelModule,
                    repositoryModule
                )
            )
        }
    }
}