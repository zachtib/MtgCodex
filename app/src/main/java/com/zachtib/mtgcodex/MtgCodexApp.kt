package com.zachtib.mtgcodex

import android.app.Application
import timber.log.Timber

class MtgCodexApp : Application() {
    val component: CodexComponent = DaggerCodexComponent.create()

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
