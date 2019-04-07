package com.zachtib.mtgcodex.ui

import android.os.Bundle
import com.zachtib.mtgcodex.R
import com.zachtib.mtgcodex.framework.BaseActivity
import com.zachtib.mtgcodex.ui.search.SearchView

class MainActivity : BaseActivity(R.layout.main_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchView())
                .commitNow()
        }
    }
}