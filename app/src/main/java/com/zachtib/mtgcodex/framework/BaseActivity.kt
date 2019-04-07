package com.zachtib.mtgcodex.framework

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.airbnb.mvrx.BaseMvRxActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity(@LayoutRes private val layout: Int) : BaseMvRxActivity(), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}